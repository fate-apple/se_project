
package com.se.Domain.Business;

// Generated 2017-7-17 16:39:34 by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Subject generated by hbm2java
 */
@Entity
@Table(name = "subject")
public class Subject  {

	private Integer subjectId;
	private String title;
	private Set<Course> courses = new HashSet<Course>();

	public Subject() {
	}

	public Subject(String title) {
		this.title = title;
	}

	public Subject(String title, Set<Course> courses) {
		this.title = title;
		this.courses = courses;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "subject_id")
	public Integer getSubjectId() {
		return this.subjectId;
	}

	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}

	@Column(name = "title")
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "subject")
	public Set<Course> getCourses() {
		return this.courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

}
