package com.se.Repository.Jpa;

<<<<<<< HEAD
import org.springframework.data.jpa.repository.JpaRepository;


import com.se.Domain.Business.VirtualClass;


public interface VirtualClassRepository extends JpaRepository<VirtualClass,Long>
{
}
=======
import com.se.Domain.Business.VirtualClass;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by clevo on 2017/7/20.
 */
public interface VirtualClassRepository  extends JpaRepository<VirtualClass,Long>{

}
>>>>>>> origin/csy
