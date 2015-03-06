package com.superpowersblog.flashcards.service;

import javax.persistence.EntityManager;

public class CardsService {
	public long createCard(String front, String back, String contextCue, EntityManager em) {
		if(front.isEmpty()) {
			throw new IllegalArgumentException("card front cannot be empty");
		}
		if(back.isEmpty()) {
			throw new IllegalArgumentException("card back cannot be empty");
		}
		
		Card card = new Card();
		card.setFront(front);
		card.setBack(back);
		card.setContextCue(contextCue);
		em.persist(card);
		return card.getId();
	}
}
