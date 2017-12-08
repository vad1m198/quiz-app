package com.vmerkotan.quiz.repositories;

import com.vmerkotan.quiz.model.Question;
import org.springframework.data.repository.CrudRepository;

public interface QuestionRepository extends CrudRepository<Question, Long> {

}
