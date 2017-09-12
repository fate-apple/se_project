package com.se.Service.Business;

import com.se.Domain.Business.Courseware;
import com.se.Domain.Business.Profile;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface ProfileService {
    void initPictureDir();

    void download(String fileName, String filePath,
                  HttpServletRequest request, HttpServletResponse response)
            throws Exception;

    Courseware UploadCourseware(MultipartFile file, String classes) throws IllegalStateException, IOException;
}
