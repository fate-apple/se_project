package com.se.Domain.Business;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Table(name = "display")
@Entity
public class Display {
	private int roomId;

	//富文本
//	private Profile rtf;
	//班级介绍
	private String Introduction;
	//班级公告
	//保存在adminclass里
//	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
//	@JoinTable(name = "adminclass_information",
//			joinColumns = {@JoinColumn(name = "class_id", referencedColumnName = "class_id")},
//			inverseJoinColumns = {@JoinColumn(name = "information_id", referencedColumnName ="information_id")}
//	)
//	private List<Information> informationList;
	private String title1;
	private String content1;
	private String title2;
	private String content2;
	private String title3;
	private String content3;
//	@Value("@{pictureDir}")
//	String pictureDir;

	//首页图片7张
	private transient  List<Profile>pictures = new ArrayList<>();

//	public Profile getRtf() {
//		return rtf;
//	}

//	public void setRtf(Profile rtf) {
//		this.rtf = rtf;
//	}
@OneToMany(fetch = FetchType.LAZY, mappedBy = "display")
@JsonIgnore
	public List<Profile> getPictures() {
		return pictures;
	}

	public void setPictures(List<Profile> pictures) {
		this.pictures = pictures;
	}
	//班级相册图片9张
	@Id
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

//	public List<Information> getInformationList() {
//		return informationList;
//	}
//
//	public void setInformationList(List<Information> informationList) {
//		this.informationList = informationList;
//	}

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

	public Display(int roomId, String introduction, String title1, String content1, String title2, String content2, String title3, String content3) {
		this.roomId = roomId;
		Introduction = introduction;
		this.title1 = title1;
		this.content1 = content1;
		this.title2 = title2;
		this.content2 = content2;
		this.title3 = title3;
		this.content3 = content3;
//		this.pictures.add(new Profile(null,Profile.TYPE_IMAGE,"\\"+pictureDir+"\\"+"g0c0_"+toString(),new Date(System.currentTimeMillis()),this));
	}

	public Display() {
	}
}
