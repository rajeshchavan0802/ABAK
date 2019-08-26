package com.abak.utility;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.abak.entity.UserEntity;


public class AuthenticationInterceptor extends HandlerInterceptorAdapter {

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		 
		System.out.println(arg0.getRequestURI());
		
		 if(	 arg0.getRequestURI().equals("/erpAbak/") 				 || 
				 arg0.getRequestURI().equals("/erpAbak/css/style.css")   ||
				 arg0.getRequestURI().equals("/erpAbak/images/logo.png") ||
				 arg0.getRequestURI().equals("/erpAbak/images/1511.png") || 
				 arg0.getRequestURI().equals("/erpAbak/loginCheck") ) {
			 
			 return true;
			 
		 }else if(arg0.getSession().getAttribute("USERENTITY") == null){
			 
			 arg1.sendRedirect("/erpAbak/");
			 return false;
		 }
		
		return true;
	}
	
	
}
