package com.superpowersblog.flashcards.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.superpowersblog.flashcards.service.Card;
import com.superpowersblog.flashcards.service.CardsService;

@Controller
public class CardController {
	EntityManagerFactory factory = Persistence
			.createEntityManagerFactory("flashcards");
	EntityManager em = factory.createEntityManager();

	// @PersistenceContext()
	// EntityManager em;

	@Resource
	CardsService service;

	@RequestMapping(value = "/addCard", method = RequestMethod.POST)
	public ModelAndView addCard(@RequestParam("seeking") String seeking,
			@RequestParam("details") String details,
			@RequestParam("answer") String answer,
			@RequestParam("contextCue") String contextCue) {

		if (!em.getTransaction().isActive()) {
			em.getTransaction().begin();
		}
		long id = service.createCard(seeking, details, answer, contextCue, em);
		em.getTransaction().commit();

		ModelAndView mav = new ModelAndView("addCard");
		mav.addObject("id", String.valueOf(id));

		return mav;
	}

	@RequestMapping(value = "addCardPage", method = RequestMethod.GET)
	public ModelAndView getAddCardPage(@RequestParam("id") String previousCard) {
		ModelAndView mav = new ModelAndView("addCard");
		mav.addObject("id", previousCard);
		return mav;
	}

	@RequestMapping(value = "/getAllCards", method = RequestMethod.GET)
	public ModelAndView getCards() {
		List<Card> cards = service.getCards(em);

		if (!em.getTransaction().isActive()) {
			em.getTransaction().begin();
		}
		ModelAndView mav = new ModelAndView("browseCardsPage");
		mav.addObject("cards", cards);
		
		em.getTransaction().commit();

		return mav;
	}

	@RequestMapping(value = "/getAllCardsWithPreviousCard", method = RequestMethod.GET)
	public ModelAndView getCards(@RequestParam("inputById") String inputById,
			@RequestParam("inputByFront") String inputByFront,
			@RequestParam("inputByAnswer") String inputByBack) {

		String previousIdAsString = null;
		// create one ID from the three parameters sent in.
		// TODO I know there is a better way to do this. Find out how to set one parameter from the three HTML fields then fix this code
		if (!inputById.isEmpty()) {
			previousIdAsString = inputById;
		} else if (!inputByFront.isEmpty()) {
			previousIdAsString = inputByFront;
		} else if (!inputByBack.isEmpty()) {
			previousIdAsString = inputByBack;
		} else {
			throw new IllegalArgumentException("no previous id was received");
		}
		long previousCardId = Long.valueOf(previousIdAsString);
		

		if (!em.getTransaction().isActive()) {
			em.getTransaction().begin();
		}
		
		Card card = service.getCard(em, previousCardId);
		String previousFront = card.getFront();
		String previousBack = card.getAnswer();

		ModelAndView mav = getCards();

		mav.addObject("id", previousCardId);
		mav.addObject("front", previousFront);
		mav.addObject("answer", previousBack);

		return mav;

	}

}
