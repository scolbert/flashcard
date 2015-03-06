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
	private String details;
	private String seeking;
	private String answer;
	private String contextCue;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public String getSeeking() {
		return seeking;
	}
	public void setSeeking(String seeking) {
		this.seeking = seeking;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getContextCue() {
		return contextCue;
	}
	public void setContextCue(String contextCue) {
		this.contextCue = contextCue;
	}

}
