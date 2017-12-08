package com.vmerkotan.quiz.repositories;

import org.springframework.data.repository.CrudRepository;

import com.vmerkotan.quiz.model.Answer;

public interface AnswerRepository  extends CrudRepository<Answer, Long> {

}
