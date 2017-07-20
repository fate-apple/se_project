package com.se.Repository.Jpa;

import com.se.Domain.Business.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by clevo on 2017/7/20.
 */
public interface SubjectRepository extends JpaRepository<Subject,Integer> {
}
