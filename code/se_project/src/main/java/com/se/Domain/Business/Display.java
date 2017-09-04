package com.se.Domain.Business;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Table(name = "display")
@Entity
public class Display {
	@Id
	private int roomId;

	//富文本
	private Profile rtf;
	//班级介绍
	private String Introduction;
	//班级公告
	private List<Information> informationList;
	private String title1;
	private String content1;
	private String title2;
	private String content2;
	private String title3;
	private String content3;

	//首页图片7张
	private List<Profile>pictures;

	public Profile getRtf() {
		return rtf;
	}

	public void setRtf(Profile rtf) {
		this.rtf = rtf;
	}

	public List<Profile> getPictures() {
		return pictures;
	}

	public void setPictures(List<Profile> pictures) {
		this.pictures = pictures;
	}
	//班级相册图片9张


	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public String getIntroduction() {
		return Introduction;
	}

	public void setIntroduction(String introduction) {
		Introduction = introduction;
	}

	public List<Information> getInformationList() {
		return informationList;
	}

	public void setInformationList(List<Information> informationList) {
		this.informationList = informationList;
	}

	public String getTitle1() {
		return title1;
	}

	public void setTitle1(String title1) {
		this.title1 = title1;
	}

	public String getContent1() {
		return content1;
	}

	public void setContent1(String content1) {
		this.content1 = content1;
	}

	public String getTitle2() {
		return title2;
	}

	public void setTitle2(String title2) {
		this.title2 = title2;
	}

	public String getContent2() {
		return content2;
	}

	public void setContent2(String content2) {
		this.content2 = content2;
	}

	public String getTitle3() {
		return title3;
	}

	public void setTitle3(String title3) {
		this.title3 = title3;
	}

	public String getContent3() {
		return content3;
	}

	public void setContent3(String content3) {
		this.content3 = content3;
	}
}
