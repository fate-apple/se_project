package com.se.Repository.Jpa;

import com.se.Domain.Business.AdminClass;
import com.se.Domain.Business.Course;
import com.se.Domain.Business.Period;
import com.se.Domain.Business.Teacher;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

/**
 * Created by clevo on 2017/7/20.
 */
public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByAdminClass(AdminClass one);

    List<Course> findByAdminClassAndWeekdayAndPeriod(AdminClass adminClass, int weekday, Period period);

	List<Course> findByTeacher(Teacher teacher);
}
