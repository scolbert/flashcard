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
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("flashcards");
	EntityManager em = factory.createEntityManager();
	
//	@PersistenceContext()
//	EntityManager em;
	
	@Resource
	CardsService service;
	
	@RequestMapping(value="/addCard", method = RequestMethod.POST)
	public ModelAndView addCard(
			@RequestParam("seeking") String seeking,
			@RequestParam("details") String details,
			@RequestParam("answer") String answer,
			@RequestParam("contextCue") String contextCue
			) 
	{
		
		em.getTransaction().begin();
		long id = service.createCard(seeking, details, answer, contextCue, em);
		em.getTransaction().commit();
		
		ModelAndView mav = new ModelAndView("addCard");
		mav.addObject("id", String.valueOf(id));
//		em.close();
		return mav;
	}
	
	@RequestMapping(value="addCardPage", method = RequestMethod.GET)
	public ModelAndView getAddCardPage(
			@RequestParam("id") String previousCard
			) {
		ModelAndView mav = new ModelAndView("addCard");
		mav.addObject("id", previousCard);
		return mav;
	}
	
	@RequestMapping(value="/getAllCards", method = RequestMethod.GET)
	public ModelAndView getCards(){
		em.getTransaction().begin();
		List<Card> cards = service.getCards(em);
		
		ModelAndView mav = new ModelAndView("browseCardsPage");
			
		mav.addObject("cards", cards);
		return mav;
	}
	
}
