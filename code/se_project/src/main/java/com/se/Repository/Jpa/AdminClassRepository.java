package com.se.Repository.Jpa;

import com.se.Domain.Business.AdminClass;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

/**
 * Created by clevo on 2017/7/18.
 */
public interface AdminClassRepository extends JpaRepository<AdminClass,Long>
{
    List<AdminClass> findByGrade(int grade);






    List<AdminClass> findByGradeInOrderByGradeAscFullnameAsc(Set<Integer> gradesInt);
}
