package com.se.Domain.Business;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name="room")
@Entity
public class Room {

	private int roomId;
	private String buildingName;
	private String roomNum;
	private Integer capacity;
	private String type;
	private AdminClass adminClass;
	
	public Room() {
	}

	public Room(int roomId) {
		this.roomId = roomId;
	}

	public Room(int roomId, String buildingName, String roomNum,
			Integer capacity, String type) {
		this.roomId = roomId;
		this.buildingName = buildingName;
		this.roomNum = roomNum;
		this.capacity = capacity;
		this.type = type;

	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "room_id")
	public int getRoomId() {
		return this.roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	@Column(name = "building_name")
	public String getBuildingName() {
		return this.buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	@Column(name = "room_num")
	public String getRoomNum() {
		return this.roomNum;
	}

	public void setRoomNum(String roomNum) {
		this.roomNum = roomNum;
	}

	@Column(name = "capacity")
	public Integer getCapacity() {
		return this.capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	@Column(name = "type")
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	@OneToOne(mappedBy="room")	
	public AdminClass getAdminClass() {
		return adminClass;
	}

	public void setAdminClass(AdminClass adminClass) {
		this.adminClass = adminClass;
	}



}
