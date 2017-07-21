package com.se.Service.Business;

import com.se.Domain.Business.Teacher;

import java.util.List;

/**
 * Created by clevo on 2017/7/18.
 */
public interface TeacherService {
    List<Teacher> findAll();
<<<<<<< HEAD
=======

    Teacher create(String username, String password, String fullname, int room_id, Boolean gender);

    Teacher update(Long id, String username, String fullname, int roomId, Boolean gender);

    void delete(Long id);
>>>>>>> origin/csy
}
