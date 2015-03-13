package com.superpowersblog.flashcards.controller;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController{
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("flashcards");
	EntityManager em = emf.createEntityManager();

	@RequestMapping(value="/welcome")
	public ModelAndView test(HttpServletResponse response) throws IOException{
		ModelAndView mav = new ModelAndView("home");
		return mav;
	}
}

