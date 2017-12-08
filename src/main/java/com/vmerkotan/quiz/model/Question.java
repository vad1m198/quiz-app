package com.vmerkotan.quiz.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="questions")
public class Question implements Serializable {
	
	private static final long serialVersionUID = -7985996092530054494L;

	@Id	
	private long id;
	
	@Column(name = "question_string")
	private String questionString;
	
	@Column(name = "author")
	private String author;


	@Column(name = "created_date")
	private Timestamp createdDate;
	
	@Column(name = "question_type")
	private String questionType;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy="questionId",cascade = CascadeType.ALL)
	private List<Answer> answers = new ArrayList<>();
	
	public List<Answer> getAnswers() {
		return answers;
	}

	@Override
	public String toString() {
		return String.format("Question[id=%d, text='%s', author='%s', createdDate='%s', questionType='%s', answers='%d']", 
				id, questionString, author, createdDate, questionType, answers.size());		
	}

}
