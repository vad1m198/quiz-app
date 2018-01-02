package com.vmerkotan.quiz.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.vmerkotan.quiz.entity.QuestionForm;

@Service
public class QuizService {
	
	private List<QuestionForm> answers = new ArrayList<QuestionForm>();

	public List<QuestionForm> getAnswers() {
		return answers;
	}

	public void addQuestionForm(QuestionForm form) {
		answers.add(form);
	}

}
