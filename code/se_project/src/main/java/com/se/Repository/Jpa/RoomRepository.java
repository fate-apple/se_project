package com.se.Repository.Jpa;

import com.se.Domain.Business.Room;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by clevo on 2017/7/18.
 */

public interface RoomRepository extends JpaRepository<Room, Integer> {
    Room findByRoomId(int roomId);
}
