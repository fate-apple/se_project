package com.se.Service.Business;

import com.se.Domain.Business.Courseware;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Service
public interface CoursewareService {

    Courseware UploadCourseware(MultipartFile file, String classes) throws IllegalStateException, IOException;

    Courseware download(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, int id) throws Exception;

    List<Courseware> findAll();
}
