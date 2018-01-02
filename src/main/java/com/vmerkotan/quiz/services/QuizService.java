package com.vmerkotan.quiz.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;
import com.vmerkotan.quiz.entity.QuestionForm;

@Service
public class QuizService {
	
	private HashMap<Long,QuestionForm> answers = new HashMap<Long,QuestionForm>();

	public List<QuestionForm> getAnswers() {
		return new ArrayList<QuestionForm>(answers.values());
	}

	public void addQuestionForm(QuestionForm form) {
		answers.put(form.getQuestionId(),form);
	}

}
