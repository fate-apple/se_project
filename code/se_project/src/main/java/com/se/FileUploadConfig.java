//package com.se;
//
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//
//@Configuration
//public class FileUploadConfig  extends WebMvcConfigurerAdapter {
//
//    @Value("${se.imagesPath}")
//    private String mImagesPath;
//    
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        if(mImagesPath.equals("") || mImagesPath.equals("${cbs.imagesPath}")){
//               String imagesPath = FileUploadConfig.class.getClassLoader().getResource("").getPath();
//               if(imagesPath.indexOf(".jar")>0){
//                imagesPath = imagesPath.substring(0, imagesPath.indexOf(".jar"));
//               }else if(imagesPath.indexOf("classes")>0){
//                imagesPath = "file:"+imagesPath.substring(0, imagesPath.indexOf("classes"));
//               }
//               imagesPath = imagesPath.substring(0, imagesPath.lastIndexOf("/"))+"/images/";
//               mImagesPath = imagesPath;
//              }
//              LoggerFactory.getLogger(FileUploadConfig.class).info("imagesPath="+mImagesPath);
//              registry.addResourceHandler("/images/**").addResourceLocations(mImagesPath);
//        // TODO Auto-generated method stub
//        super.addResourceHandlers(registry);
//    }
//}
