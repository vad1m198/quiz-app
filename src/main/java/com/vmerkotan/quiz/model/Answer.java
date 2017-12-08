package com.vmerkotan.quiz.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="answers")
public class Answer implements Serializable {
	
	private static final long serialVersionUID = 6615812210335788415L;

	@Id	
	private long id;
	
	@Column(name = "answer_string")
	private String answerString;

	@Column(name = "is_correct")
	private Boolean isCorrect;
	
	@Column(name = "question_id")
	private Long questionId;
	
	@Override
	public String toString() {
		return String.format("Answer[id=%d, text='%s', isCorrect='%s']", id, answerString, isCorrect);		
	}
	
}
