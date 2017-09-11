package com.se.Repository.Jpa;

import com.se.Domain.Business.Courseware;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoursewareRepository extends JpaRepository<Courseware,Integer> {
}
