package com.se.Repository.Jpa;

import com.se.Domain.Business.Display;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisplayRepository  extends JpaRepository<Display,Integer> {
    Display findByRoomId(int roomId);
}
