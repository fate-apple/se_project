package com.se.Service.Business;

import com.se.Domain.Business.Display;
import com.se.Domain.Business.Profile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface DisplayService {
    Display findDisplay();


    Profile UploadPictures(MultipartFile file, int id) throws IllegalStateException, IOException;


    Display findDefaultDisplay(int roomId);
}
