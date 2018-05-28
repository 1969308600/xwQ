package com.mycompany.app.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

public class InterceptCommon implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		if (null != session.getAttribute(session.getId()) && (boolean) session.getAttribute(session.getId())) {
			// 这个状态是在sso认证中心处理的  ，redis实现session共享！
			// return true;
			return HandlerInterceptor.super.preHandle(request, response, handler);
		} else {
			request.getRequestDispatcher("/ftl/login.html").forward(request, response);
			// sso帮忙跳转不了，使用post或者ajax是没法让springmvc给你返回视图
			return false;
		}

	}

}
