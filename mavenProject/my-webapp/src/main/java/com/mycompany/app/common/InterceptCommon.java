package com.mycompany.app.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.mycompany.app.service.impl.systemService;

@Component
public class InterceptCommon implements HandlerInterceptor {

	
	@Autowired
	CacheRedisCommon redisCommon;
	@Autowired
	systemService systems;
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		String token = request.getParameter("token");//令牌  实际上是要验签加密的，这里直接用的session
		
		if(null==token||null==redisCommon.get(token)) {
			request.getRequestDispatcher("/mapper/login.html").forward(request, response);
			// sso帮忙跳转不了，使用post或者ajax是没法让springmvc给你返回视图
			return false;
		}else {
			
			return HandlerInterceptor.super.preHandle(request, response, handler);
			
		}
	}

}
