package com.se.Service.Business;

import com.se.Domain.Business.Course;

/**
 * Created by clevo on 2017/7/20.
 */
public interface CourseSerivce {
    Course create(int roomId, Long adminClassId, Long virtualClassId,
                  Long teacherId, int periodId, int subjectId, int weekday);

    Course update(Long courseId, int roomId, Long adminClassId, Long virtualClassId,
                  Long teacherId, int periodId, int subjectId, int weekday);

    void delete(Long courseId);
}
