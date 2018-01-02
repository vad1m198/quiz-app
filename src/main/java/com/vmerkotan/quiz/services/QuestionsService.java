package com.vmerkotan.quiz.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vmerkotan.quiz.model.Question;
import com.vmerkotan.quiz.repositories.QuestionRepository;

@Service
public class QuestionsService {
	
	@Autowired
	QuestionRepository repository;
	
	private Iterator<Long> it;
	
	public QuestionsService(QuestionRepository repository) {
		it = ((ArrayList<Question>) repository.findAll()).stream().map(q -> q.getId()).collect(Collectors.toList()).iterator();		
	}
	
	public Long getNextQuestionId() {				
		if(it.hasNext()) {				
			return it.next();
		} else {
			return null;
		}
	}
	
	public Question findById(Long id) {				
		return repository.findOne(id);
	}
}
