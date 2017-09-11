package com.se.Repository.Jpa;

import com.se.Domain.Business.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile,Integer> {
    Profile findByResource(String s);

    void deleteByResource(String s);
}
