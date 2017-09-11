package com.se.Service.Business.Impl;

import com.se.Domain.Business.AdminClass;
import com.se.Domain.Business.Display;
import com.se.Domain.Business.Profile;
import com.se.Domain.Business.User;
import com.se.Repository.Jpa.AdminClassRepository;
import com.se.Repository.Jpa.DisplayRepository;
import com.se.Repository.Jpa.UserRepository;
import com.se.Repository.Jpa.ProfileRepository;
import com.se.Service.Business.DisplayService;
import com.se.Service.Business.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Service
public class DisplayServiceImpl implements DisplayService {
    @Autowired
    DisplayRepository displayRepository;
    @Autowired
    AdminClassRepository adminClassRepository;
    @Autowired
    ProfileRepository profileRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ProfileService profileService;
    @Value("${staticPath}")
    String staticPath;
    @Value("${pictureDir}")
    String pictureDir;
String INTRODUCTION = "please add introduction here";
    String TITLE  = "please add title here";
    String CONTENT = "please add content here";
    int LIMIT = 9;
    @Override
    public Display findDisplay(){
        try{
            AdminClass adminClass= adminClassRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
            int roomId = adminClass.getRoom().getRoomId();
            Display display = displayRepository.findByRoomId(roomId);
            if (display==null)display= findDefaultDisplay(roomId);
            return display;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Profile UploadPictures(MultipartFile file, int id) throws IllegalStateException, IOException {
        String contentType = file.getContentType();
        String username =SecurityContextHolder.getContext().getAuthentication().getName();
        String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        String fileName = username+"_"+String.valueOf(id)+suffix;
//        String filePath = request.getSession().getServletContext().getRealPath("/imgupload/");
//		ClassLoader loader = Thread.currentThread().getContextClassLoader();
        String resourcePath = staticPath+pictureDir;
        String filePath=System.getProperty("user.dir")+resourcePath;
//        String filePath = "./src/main/resources/static/imgupload";
        File targetFile = new File(filePath);
        if(!targetFile.exists()){
         targetFile.mkdirs();
        }
        file.transferTo(new File(filePath+"\\"+fileName));
        String resource = "\\"+pictureDir+"\\"+fileName;
        Profile picture = new Profile(userRepository.findByUsername(username),
                Profile.TYPE_IMAGE,resource, new Date(System.currentTimeMillis()), findDisplay());
        profileRepository.save(picture);
        return picture;
    }
    @Override
    public Display findDefaultDisplay(int roomId){
        Display display = displayRepository.findOne(0);
        if(display==null){

            display = new Display(roomId,INTRODUCTION,TITLE,CONTENT,TITLE,CONTENT,TITLE,CONTENT);
            displayRepository.save(display);
            profileService.initPictureDir();
            String username =SecurityContextHolder.getContext().getAuthentication().getName();
            try{
            for (int i =0;i<LIMIT;i++){
                Profile defaultProfile =profileRepository.findByResource("\\"+pictureDir+"\\default"+String.valueOf(i+1));
//                String resource  ="\\"+pictureDir+"\\"+username+"_"+String.valueOf(i+1)+defaultProfile.getResource().substring(defaultProfile.getResource().lastIndexOf("."));
                String resource  ="\\"+pictureDir+"\\"+username+"_"+String.valueOf(i+1);
                Profile profile = new Profile(null,Profile.TYPE_IMAGE,resource,new Date(System.currentTimeMillis()),display);
                profileRepository.save(profile);
                display.getPictures().add(profile);
            }

            }catch (Exception e){e.printStackTrace();}}
        return display;
    }


}
