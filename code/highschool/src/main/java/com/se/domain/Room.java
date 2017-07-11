package com.se.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="room")
@Entity
public class Room {

	public String buildingName;
	public String roomNum;
	public int capacity;
	public String type;
	
	
	public Room(){
	}
	
	public Room(String buildingName, String roomNum, int capacity, String type) {
		this.buildingName = buildingName;
		this.roomNum = roomNum;
		this.capacity = capacity;
		this.type = type;
	}
	
	
	@Id  
	@GeneratedValue(strategy = GenerationType.AUTO) 
	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}
	
	public String getRoomNum() {
		return roomNum;
	}
	
	public void setRoomNum(String roomNum) {
		this.roomNum = roomNum;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

}
