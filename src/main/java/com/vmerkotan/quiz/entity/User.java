package com.vmerkotan.quiz.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User {
	@NotNull
    @Size(min=5, max=20)
	private String userName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Override
	public String toString() { 
	    return "[User. userName: " + this.userName + "]";
	} 

	
}
