package com.vmerkotan.quiz.controller;

import java.util.ArrayList;
import java.util.Arrays;
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
import com.vmerkotan.quiz.entity.QuizResultsForm;
import com.vmerkotan.quiz.entity.User;
import com.vmerkotan.quiz.model.Answer;
import com.vmerkotan.quiz.model.Question;
import com.vmerkotan.quiz.services.QuestionsService;
import com.vmerkotan.quiz.services.QuizService;

@Controller
@SessionAttributes("user")
public class MainController {

	@Autowired
	QuestionsService questionsService;
	
	@Autowired
	QuizService quizService;
	
	@ModelAttribute("user")
	public User addStuffToRequestScope() {		
		User user = new User();
		return user;
	}
	
	@RequestMapping(value = "/results", method = RequestMethod.GET)
	public String getResults(Model model) {
		List<QuestionForm> answers = quizService.getAnswers();
		QuizResultsForm resultsForm = new QuizResultsForm();
		resultsForm.setTotalAnswers(answers.size());
		int correctAnswersCount = 0;
		for(QuestionForm q:answers) {
			Long id = q.getQuestionId();
			List<String> selectedAnswers = Arrays.asList(q.getSelectedOptions());
			Question question = questionsService.findById(id);
			int correctAnswers = q.getCorrectAnswersNum();
			int selectedCorrectAnswers = 0;
			if(selectedAnswers.size() != correctAnswers) continue;
			for(Answer a: question.getAnswers()) {
				if(a.getIsCorrect() && selectedAnswers.contains(String.valueOf(a.getId()))) {
					selectedCorrectAnswers++;
				}					
			}
			if(correctAnswers == selectedCorrectAnswers) {
				correctAnswersCount++;
			}
			
		}
		resultsForm.setCorrectAnswers(correctAnswersCount);
		model.addAttribute("resultForm", resultsForm);
		return "results";
	}
	
	@RequestMapping(value = "/question/{questionId}", method = RequestMethod.GET)
	public String question(Model model,@PathVariable long questionId) {
		QuestionForm questionForm = new QuestionForm();
		Question q = questionsService.findById(questionId);
		questionForm.setQuestionId(q.getId());
		questionForm.setQuestionString(q.getQuestionString());		
		List<AnswerForm> options = new ArrayList<AnswerForm>();
		int correctAnswersNum = 0;
		for(Answer a: q.getAnswers()) {
			AnswerForm answerForm = new AnswerForm();
			answerForm.setAnswerId(a.getId());
			answerForm.setAnswerString(a.getAnswerString());
			answerForm.setCorrect(a.getIsCorrect());
			if(a.getIsCorrect()) correctAnswersNum++;
			options.add(answerForm);
		}
		questionForm.setOptions(options);
		questionForm.setCorrectAnswersNum(correctAnswersNum);
		model.addAttribute("questionForm", questionForm);
		return "question";
	}
	
	@RequestMapping(value = "/question/{questionId}", method = RequestMethod.POST)
	public String questionPost(QuestionForm questionForm) {		
		quizService.addQuestionForm(questionForm);
		Long nextId = questionsService.getNextQuestionId();
		if(nextId != null) {
			return "redirect:/question/" + nextId;
		} else {
			return "redirect:/results";
		}
		
	}
	
	@RequestMapping(value = {"/","/login"}, method = RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginSubmit(@Valid User user, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			return "login";
		}
		return "redirect:/question/" + questionsService.getNextQuestionId();
	}
}
