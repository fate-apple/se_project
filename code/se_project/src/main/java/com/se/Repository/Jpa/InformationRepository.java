package com.se.Repository.Jpa;

import com.se.Domain.Business.Display;
import com.se.Domain.Business.Information;
import com.se.Domain.Business.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InformationRepository extends JpaRepository<Information,Integer> {
    List<Information> findAll();

    List<Information> findByInformer(User informer);
}
