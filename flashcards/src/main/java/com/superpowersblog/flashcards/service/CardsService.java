package com.superpowersblog.flashcards.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;

@Service
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
	
	public List<Card> getCards(EntityManager em) {
		if(em == null){
			throw new IllegalArgumentException("Received invalid EntityManager");
		}
		
		String queryString = "select c from Card c";
		TypedQuery<Card> query = em.createQuery(queryString, Card.class);
		return query.getResultList();
	}
}
