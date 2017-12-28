package com.vmerkotan.quiz.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.vmerkotan.quiz.entity.AnswerForm;
import com.vmerkotan.quiz.entity.QuestionForm;
import com.vmerkotan.quiz.entity.User;
import com.vmerkotan.quiz.model.Answer;
import com.vmerkotan.quiz.model.Question;
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
	public String questions(Model model){
		model.addAttribute("questions", repository.findAll());
		return "questions";
	}
	
	@RequestMapping(value = "/question/{questionId}", method = RequestMethod.GET)
	public String question(Model model,@PathVariable long questionId){
		QuestionForm questionForm = new QuestionForm();
		Question q = repository.findOne(questionId);
		questionForm.setQuestionId(q.getId());
		questionForm.setQuestionString(q.getQuestionString());		
		List<AnswerForm> options = new ArrayList<AnswerForm>();
		for(Answer a: q.getAnswers()) {
			AnswerForm answerForm = new AnswerForm();
			answerForm.setAnswerId(a.getId());
			answerForm.setAnswerString(a.getAnswerString());
			answerForm.setCorrect(a.getIsCorrect());
			options.add(answerForm);
		}
		questionForm.setOptions(options);		
		model.addAttribute("questionForm", questionForm);
		return "question";
	}
	
	@RequestMapping(value = "/question/{questionId}", method = RequestMethod.POST)
	public String questionPost(Model model,@PathVariable long questionId, QuestionForm questionForm) {		
		return "redirect:/question/" + (questionId + 1);
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
		List<Question> questions = (ArrayList<Question>) repository.findAll();
		return "redirect:/question/" + questions.get(0).getId();
	}
	
	
}
