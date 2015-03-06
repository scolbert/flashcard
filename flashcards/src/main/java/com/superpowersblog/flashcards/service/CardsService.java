package com.superpowersblog.flashcards.service;

import javax.persistence.EntityManager;

public class CardsService {
	public long createCard(String seeking, String details, String answer, String contextCue, EntityManager em) {
		if(details.isEmpty()) {
			throw new IllegalArgumentException("card details cannot be empty");
		}
		if(answer.isEmpty()) {
			throw new IllegalArgumentException("card answer cannot be empty");
		}
		
		Card card = new Card();
		card.setSeeking(seeking);
		card.setDetails(details);
		card.setAnswer(answer);
		card.setContextCue(contextCue);
		em.persist(card);
		return card.getId();
	}
}
