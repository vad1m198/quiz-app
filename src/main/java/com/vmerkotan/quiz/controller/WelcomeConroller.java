package com.vmerkotan.quiz.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vmerkotan.quiz.repositories.QuestionRepository;

@Controller
public class WelcomeConroller {

	@Autowired
	QuestionRepository repository;
	
	@RequestMapping(value = "/questions", method = RequestMethod.GET)
	public String questions(HttpServletRequest request,Model model){		
		model.addAttribute("questions", repository.findAll());
		return "questions";
	}
}
