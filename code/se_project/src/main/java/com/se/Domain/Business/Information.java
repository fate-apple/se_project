package com.se.Domain.Business;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Table(name = "information")
@Entity
public class Information {

	private int information_id;
	@OrderBy
	private Date date;
	private String title;
	private String content;

	private User informer;
//	@ManyToMany(fetch = FetchType.EAGER)
//@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY,targetEntity = AdminClass.class)

//@ManyToMany(mappedBy = "information",targetEntity = AdminClass.class)
	private   Set<AdminClass> receivers;

	public Information() {
	}

	public Information(Date date, String title, String content, User informer, Set<AdminClass> receivers) {
		this.date = date;
		this.title = title;
		this.content = content;
		this.informer = informer;
		this.receivers = receivers;
	}

//	public Information(int id, Date date, String title, String content, User informer, Set<AdminClass> receivers) {
//		this.id = id;
//		this.date = date;
//		this.title = title;
//		this.content = content;
//		this.informer = informer;
//		this.receivers = receivers;
//	}


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getInformation_id() {
		return information_id;
	}

	public void setInformation_id(int information_id) {
		this.information_id = information_id;
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
	@ManyToOne
	@JoinColumn(name="user_id")
	public User getInformer() {
		return informer;
	}

	public void setInformer(User informer) {
		this.informer = informer;
	}
	@ManyToMany( cascade=CascadeType.MERGE,fetch = FetchType.EAGER)
	@JoinTable(name = "information_receivers",
			joinColumns = {@JoinColumn(name = "information_id", referencedColumnName = "information_id")},
			inverseJoinColumns = {@JoinColumn(name = "class_id", referencedColumnName ="class_id")}
	)
	public Set<AdminClass> getReceivers() {
		return receivers;
	}

	public void setReceivers(Set<AdminClass> receivers) {
		this.receivers = receivers;
	}
}
