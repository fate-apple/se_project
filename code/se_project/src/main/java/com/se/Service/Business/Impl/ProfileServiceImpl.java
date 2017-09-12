package com.se.Service.Business.Impl;

import com.se.Domain.Business.AdminClass;
import com.se.Domain.Business.Courseware;
import com.se.Domain.Business.Profile;
import com.se.Repository.Jpa.CoursewareRepository;
import com.se.Repository.Jpa.ProfileRepository;
import com.se.Repository.Jpa.UserRepository;
import com.se.Service.Business.AdminClassService;
import com.se.Service.Business.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;
import java.util.Set;

@Service
public class ProfileServiceImpl implements ProfileService {
    @Autowired
    ProfileRepository profileRepository;
    @Autowired
    AdminClassService adminClassService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    CoursewareRepository coursewareRepository;
    @Value("${pictureDir}")
    String pictureDir;
    @Value("${staticPath}")
    String staticPath;
    @Value("${coursewareDir}")
            String coursewareDir;
    int LIMIT=9;

    @Override
    public void initPictureDir(){
        String resource = "\\"+pictureDir+"\\default";
        for (int i =0;i<LIMIT;i++){
            if(profileRepository.findByResource(resource+String.valueOf(i+1))==null){
                Profile profile =new Profile(null,Profile.TYPE_IMAGE,resource+String.valueOf(i+1),new Date(System.currentTimeMillis()),null);
                profileRepository.save(profile);
        }}
        return;
    }
    @Override
    public  void download(String fileName, String filePath,
                          HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        response.setCharacterEncoding("utf-8");
        response.setContentType("multipart/form-data");
        response.setHeader("Content-Disposition", "attachment;fileName=" + fileName);
        try {
            //打开本地文件流
            InputStream inputStream = new FileInputStream(filePath);
            OutputStream os = response.getOutputStream();

            //循环写入输出流
            byte[] b = new byte[2048];
            int length;
            while ((length = inputStream.read(b)) > 0) {
                os.write(b, 0, length);
            }
            // 这里主要关闭。
            os.close();
            inputStream.close();
        } catch (Exception e){
            throw e;
        }
    }

    @Override
    public Courseware UploadCourseware(MultipartFile file, String classes) throws IllegalStateException, IOException {
        Set<AdminClass> receivers = adminClassService.findByClasses(classes);
        String contentType = file.getContentType();
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
//        String fileName = username + "_" + file.getOriginalFilename()+ suffix;
        String fileName = username + "_" + file.getOriginalFilename();
//        String filePath = request.getSession().getServletContext().getRealPath("/imgupload/");
//		ClassLoader loader = Thread.currentThread().getContextClassLoader();
        String resourcePath = staticPath + coursewareDir;
        String filePath = System.getProperty("user.dir") + resourcePath+"\\"+username;
//        String filePath = "./src/main/resources/static/imgupload";
        File targetFile = new File(filePath);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        file.transferTo(new File(filePath + "\\" + fileName));
        String resource = "\\" + coursewareDir + "\\" +username+ "\\" + fileName;
        Courseware courseware= new Courseware(userRepository.findByUsername(username),
                Profile.TYPE_IMAGE, resource, new Date(System.currentTimeMillis()), null,fileName,receivers);
        //修改已存在图片
        return coursewareRepository.save(courseware);
    }



}
