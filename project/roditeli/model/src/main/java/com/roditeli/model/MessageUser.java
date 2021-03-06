package com.roditeli.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "Message_User")
public class MessageUser extends BaseModel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8600327939375025641L;
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	@Column
	@Temporal(TemporalType.DATE)
	private Date date;
	@Column
	private boolean status;
	@Column
	private String text;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "author_fk") 
	@JsonManagedReference
	private User author;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "recipient_fk")
	@JsonManagedReference
	private User recipient;
	
	public MessageUser() {
	}

	public MessageUser(Date date, boolean status, String text, User author, User recipient) {
		this.date = date;
		this.status = status;
		this.text = text;
		this.author = author;
		this.recipient = recipient;
	
	}
	
	@Override
	public int getId() {
		return this.id;
	}

	@Override
	public void setId(int id) {
		this.id = id;
		
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public User getRecipient() {
		return recipient;
	}

	public void setRecipient(User recipient) {
		this.recipient = recipient;
	}
	
}
