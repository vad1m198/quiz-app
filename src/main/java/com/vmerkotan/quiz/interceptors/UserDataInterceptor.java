package com.vmerkotan.quiz.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.vmerkotan.quiz.entity.User;

@Component
public class UserDataInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		HttpSession session = request.getSession();
		User u = (User)session.getAttribute("user");
		
		if(u == null || u.getUserName() == null || u.getUserName().length() < 5) {
			response.sendRedirect("/login");
		}
		return super.preHandle(request, response, handler);
	}

}
