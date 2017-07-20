package com.se.Repository.Jpa;

import org.springframework.data.jpa.repository.JpaRepository;


import com.se.Domain.Business.VirtualClass;


public interface VirtualClassRepository extends JpaRepository<VirtualClass,Long>
{
}