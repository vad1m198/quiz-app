package com.vmerkotan.quiz.entity;

import java.util.List;

public class QuestionForm {

	private long questionId;
	private String questionString;
	private List<AnswerForm> options;
	private String selectedOption;
	private String[] selectedOptions;
	private int correctAnswersNum;
	
	public int getCorrectAnswersNum() {
		return correctAnswersNum;
	}
	public void setCorrectAnswersNum(int correctAnswersNum) {
		this.correctAnswersNum = correctAnswersNum;
	}
	public long getQuestionId() {
		return questionId;
	}
	public void setQuestionId(long questionId) {
		this.questionId = questionId;
	}
	public String getQuestionString() {
		return questionString;
	}
	public void setQuestionString(String questionString) {
		this.questionString = questionString;
	}
	public List<AnswerForm> getOptions() {
		return options;
	}
	public void setOptions(List<AnswerForm> options) {
		this.options = options;
	}
	public String getSelectedOption() {
		return selectedOption;
	}
	public void setSelectedOption(String selectedOption) {
		this.selectedOption = selectedOption;
	}
	public String[] getSelectedOptions() {
		return selectedOptions;
	}
	public void setSelectedOptions(String[] selectedOptions) {
		this.selectedOptions = selectedOptions;
	}
	
	@Override
	public String toString() {
		String selectedOptionsStr = "";		
		if(selectedOptions != null) selectedOptionsStr = String.join(",", selectedOptions);
		return String.format("Question[id=%d, text='%s', selectedOptions='%s']", 
				questionId, questionString, selectedOptionsStr);		
	}
	
	
	
}
