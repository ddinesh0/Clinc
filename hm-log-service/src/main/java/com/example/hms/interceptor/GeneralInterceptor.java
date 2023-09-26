package com.example.hms.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import org.slf4j.Logger;

@Component
public class GeneralInterceptor implements HandlerInterceptor {
	
	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		 System.out.println("Pre-handle logic");
	         return HandlerInterceptor.super.preHandle(request, response, handler);
		
	}
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			 ModelAndView modelAndView) throws Exception {
		 System.out.println("Post-handle logic");
		 HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	        
	}
@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable Exception ex) throws Exception {
	 System.out.println("AfterCompletion logic");
	 HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
  
	
	}

}
