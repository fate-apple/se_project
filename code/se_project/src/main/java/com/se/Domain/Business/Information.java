package com.se.Domain.Business;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Table(name = "information")
@Entity
@PrimaryKeyJoinColumn(name = "information_id")
public class Information {
	@Id
	private int id;
	@OrderBy
	private Date date;
	private String title;
	private String content;
	@ManyToOne
	@JoinColumn(name="user_id")
	private User informer;
//	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "informations")
	@ManyToMany
	private Set<AdminClass> receivers = new HashSet<AdminClass>();

	public Information(int id, Date date, String title, String content, User informer, Set<AdminClass> receivers) {
		this.id = id;
		this.date = date;
		this.title = title;
		this.content = content;
		this.informer = informer;
		this.receivers = receivers;
	}

	public int getId() {

		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public User getInformer() {
		return informer;
	}

	public void setInformer(User informer) {
		this.informer = informer;
	}

	public Set<AdminClass> getReceivers() {
		return receivers;
	}

	public void setReceivers(Set<AdminClass> receivers) {
		this.receivers = receivers;
	}
}
