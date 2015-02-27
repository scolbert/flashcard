package com.superpowersblog.flashcards.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

@Controller
public class HomeController{

	@RequestMapping(value="/welcome")
	public ModelAndView test(HttpServletResponse response) throws IOException{
		ModelAndView mav = new ModelAndView("home");
		mav.addObject("attribute", "This is a test");
		return mav;
	}
}

