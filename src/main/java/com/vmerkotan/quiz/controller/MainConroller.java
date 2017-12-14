package com.vmerkotan.quiz.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.vmerkotan.quiz.entity.User;
import com.vmerkotan.quiz.repositories.QuestionRepository;

@Controller
@SessionAttributes("user")
public class MainConroller {

	@Autowired
	QuestionRepository repository;
	
	@ModelAttribute("user")
	public User addStuffToRequestScope() {		
		User user = new User();
		return user;
	}
	
	@RequestMapping(value = "/questions", method = RequestMethod.GET)
	public String questions(Model model,@ModelAttribute("user") User user){
		model.addAttribute("user", user);
		model.addAttribute("questions", repository.findAll());
		return "questions";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(){
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginSubmit(@Valid User user, BindingResult bindingResult){
		
		if(bindingResult.hasErrors()) {
			return "login";
		}
		
		if(user != null && user.getUserName() != null && user.getUserName().length() >= 5) {
			return "redirect:/questions";
		} else {
			return "login";
		}
		
	}
	
	
}
