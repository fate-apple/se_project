package com.se;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.se.Domain.Business.Room;
import com.se.Repository.Jpa.RoomRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoomTest {

	@Autowired
	private RoomRepository roomRepository;
	
	@Test
	public void RoomTest(){
		roomRepository.save(new Room(1,"dongshangyuan","303",100,"classroom"));
		roomRepository.save(new Room(2,"dongxiayuan","201",200,"meetingroom"));
		roomRepository.save(new Room(3,"dongzhongyuan","101",20,"restroom"));
		assertEquals(3,roomRepository.findAll().size());
		
		assertEquals("meetingroom",roomRepository.findOne(2).getType());
		
		roomRepository.delete(3);
		assertEquals(false,roomRepository.exists(3));
	}
}
