package com.se.Service.Business.Impl;

import com.se.Domain.Business.AdminClass;
import com.se.Domain.Business.Display;
import com.se.Domain.Business.Profile;
import com.se.Domain.Business.User;
import com.se.Repository.Jpa.AdminClassRepository;
import com.se.Repository.Jpa.DisplayRepository;
import com.se.Repository.Jpa.UserRepository;
import com.se.Repository.Mongo.ProfileRepository;
import com.se.Service.Business.DisplayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;

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
    @Value("${staticPath}")
    String staticPath;
    @Value("@{pictureDir}")
    String pictureDir;
String INTRODUCTION = "please add introduction here";
    String TITLE  = "please add title here";
    String CONTENT = "please add content here";
    int LIMIT = 9;
    @Override
    public Display findDisplay(){
        try{
            AdminClass adminClass= adminClassRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
            Display display = displayRepository.findByRoomId(adminClass.getRoom().getRoomId());
            if (display==null) return findDefaultDisplay();
            return display;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Profile UploadPictures(MultipartFile file,int id) throws IllegalStateException, IOException {
        String contentType = file.getContentType();
        String username =SecurityContextHolder.getContext().getAuthentication().getName();
        String fileName = file.getOriginalFilename()+username+String.valueOf(id);
//        String filePath = request.getSession().getServletContext().getRealPath("/imgupload/");
//		ClassLoader loader = Thread.currentThread().getContextClassLoader();
        String resourcePath = staticPath+pictureDir;
        String filePath=System.getProperty("user.dir")+resourcePath;
//        String filePath = "./src/main/resources/static/imgupload";
        File targetFile = new File(filePath);
        boolean flag1 = targetFile.exists();
        boolean flag2;
        if(!flag1){
            flag2 = targetFile.mkdirs();
        }
        file.transferTo(new File(filePath+"\\"+fileName));
        String resource = "\\"+pictureDir+"\\"+fileName;
        Profile picture = new Profile(userRepository.findByUsername(username),
                Profile.TYPE_IMAGE,resource, new Date(System.currentTimeMillis()), findDisplay());
        profileRepository.save(picture);
        return picture;
    }
    @Override
    public Display findDefaultDisplay(){
        Display display = displayRepository.findOne(0);
        if(display==null){

            display = new Display(0,INTRODUCTION,TITLE,CONTENT,TITLE,CONTENT,TITLE,CONTENT);
            try{
            for (int i =0;i<LIMIT;i++){
            display.getPictures().add(profileRepository.findByResource("\\"+pictureDir+"\\default"+String.valueOf(i+1)));
            }}catch (Exception e){e.printStackTrace();}
            displayRepository.save(display);
        }
        return display;
    }


}
