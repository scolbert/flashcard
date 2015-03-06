package com.superpowersblog.flashcards.service;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

@Entity
public class Card {
	@Id
	@TableGenerator(name="cardNumberGenerator", table="ID_GEN", pkColumnName="GEN_NAME", valueColumnName="GEN_VAL")
	@GeneratedValue(generator="cardNumberGenerator")
	private long id;
	private String front;
	private String back;
	private String contextCue;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFront() {
		return front;
	}
	public void setFront(String front) {
		this.front = front;
	}
	public String getBack() {
		return back;
	}
	public void setBack(String back) {
		this.back = back;
	}
	public String getContextCue() {
		return contextCue;
	}
	public void setContextCue(String contextCue) {
		this.contextCue = contextCue;
	}
	
	
	
}
