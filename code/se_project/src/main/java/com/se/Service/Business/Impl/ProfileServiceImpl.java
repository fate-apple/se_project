package com.se.Service.Business.Impl;

import com.se.Domain.Business.Profile;
import com.se.Repository.Jpa.ProfileRepository;
import com.se.Service.Business.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ProfileServiceImpl implements ProfileService {
    @Autowired
    ProfileRepository profileRepository;
    @Value("${pictureDir}")
    String pictureDir;
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


}
