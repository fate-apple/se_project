package com.se.Domain.Business;

import javax.persistence.*;

@Table(name = "course")
@Entity
public class Course {
	
	private Long courseId;
	private Room room;
	private Teacher teacher;
	private VirtualClass virtualClass;
	private Subject subject;
	private Period period;
	private AdminClass adminClass;
	private Integer weekday;

	public Course() {
	}

	public Course(Long courseId, Room room, Teacher teacher, VirtualClass virtualClass, Subject subject, Period period,
			AdminClass adminClass, Integer weekday) {
		super();
		this.courseId = courseId;
		this.room = room;
		this.teacher = teacher;
		this.virtualClass = virtualClass;
		this.subject = subject;
		this.period = period;
		this.adminClass = adminClass;
		this.weekday = weekday;
	}

	public Course(Room room, Teacher teacher, VirtualClass virtualClass, Subject subject, Period period, AdminClass adminClass, Integer weekday) {
		this.room = room;
		this.teacher = teacher;
		this.virtualClass = virtualClass;
		this.subject = subject;
		this.period = period;
		this.adminClass = adminClass;
		this.weekday = weekday;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "course_id")
	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "room_id")
	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "teacher_id")
	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "virtual_class_id")
	public VirtualClass getVirtualClass() {
		return virtualClass;
	}

	public void setVirtualClass(VirtualClass virtualClass) {
		this.virtualClass = virtualClass;
	}

	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "subject_id")
	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "period_id")
	public Period getPeriod() {
		return period;
	}

	public void setPeriod(Period period) {
		this.period = period;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "class_id")
	public AdminClass getAdminClass() {
		return adminClass;
	}

	public void setAdminClass(AdminClass adminClass) {
		this.adminClass = adminClass;
	}

	@Column(name = "weekday")
	public Integer getWeekday() {
		return weekday;
	}

	public void setWeekday(Integer weekday) {
		this.weekday = weekday;
	}


}
