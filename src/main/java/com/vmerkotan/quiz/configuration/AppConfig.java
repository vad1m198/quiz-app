package com.vmerkotan.quiz.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.vmerkotan.quiz.interceptors.UserDataInterceptor;

@Configuration
public class AppConfig extends WebMvcConfigurerAdapter {
	
	@Autowired
	UserDataInterceptor userDataInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(userDataInterceptor).addPathPatterns("/question/**").addPathPatterns("/results/**");
	}

}
