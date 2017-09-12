package com.se.Service.Business;

import com.se.Domain.Business.Courseware;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public interface CoursewareService {

    Courseware UploadCourseware(MultipartFile file, String classes) throws IllegalStateException, IOException;
}
