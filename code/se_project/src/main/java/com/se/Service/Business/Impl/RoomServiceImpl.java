package com.se.Service.Business.Impl;

import com.se.Domain.Business.Room;
import com.se.Repository.Jpa.RoomRepository;
import com.se.Service.Business.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by clevo on 2017/7/18.
 */
@Service
public class RoomServiceImpl implements RoomService{
    @Autowired
    private RoomRepository roomRepository;

    @Override
    public List<Room> findAll(){
        return roomRepository.findAll();
    }
}
