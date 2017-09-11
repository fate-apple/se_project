package com.se.Service.Business;

import java.util.List;

import com.se.Domain.Business.Course;
import com.se.Domain.Business.ElectiveCourse;

public interface ElectiveCourseService {
    ElectiveCourse create(int roomId, Long adminClassId, Long virtualClassId,
                          Long teacherId, int periodId, int subjectId, int weekday, int capability);

    void delete(Long courseId);

    ElectiveCourse update(Long courseId, int roomId, Long adminClassId, Long virtualClassId,
                  Long teacherId, int periodId, int subjectId, int weekday, int capability, int number);
    
    List<ElectiveCourse> findAll();
}
