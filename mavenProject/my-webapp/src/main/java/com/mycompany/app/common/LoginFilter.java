package com.mycompany.app.common;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.context.support.XmlWebApplicationContext;

/**
 * 通过查询共享的session来 判断是否登录
 * 1查询session登录状态  
 * 2查询redis中的session登录状态
 * @author worker
 *
 */
 
public class LoginFilter implements Filter{
 
	CacheRedisCommon   redisCommon;//无须使用线程安全保护，这儿可以共享使用

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
	
		
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse resp =(HttpServletResponse) response;
        HttpSession session = req.getSession(); 
        
        Object token = session.getAttribute("token");//sso中心的令牌
        
    	if(null==redisCommon) {//只需注入一次
    		//filter 中无法注入bean哇。
    		ServletContext sc = req.getSession().getServletContext();
    		XmlWebApplicationContext cxt = (XmlWebApplicationContext)WebApplicationContextUtils.getWebApplicationContext(sc);
    		if(cxt != null) {
    			redisCommon = (CacheRedisCommon) cxt.getBean("cacheRedisCommon");
    		}
    	} 
    	if(null==token||redisCommon==null||null==redisCommon.get(token.toString())) {
    		
    		 String requestType = req.getHeader("X-Requested-With");//识别ajax的响应头   
    		 if (requestType != null && requestType.equals("XMLHttpRequest")) {//如果是ajax类型，
    			 PrintWriter out = resp.getWriter();//线程不安全，除非你定义threadlocal变量。
    			 resp.setStatus(900);
    			 out.write("无效登录！"); 
             }else{   
                 request.getRequestDispatcher("/ftl/login.html").forward(request, response);
             }  
    	}else {
    		if(null!=redisCommon.get(token.toString()))//不等于null 说明已经缓存，无须做其他判断
    			chain.doFilter(request, response);
    	}
        
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
