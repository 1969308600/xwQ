package com.test.app;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
public class TestServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 System.err.println("post");
		 
		super.doPost(req, resp);
	}
	 
	 @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("get");
		super.doGet(req, resp);
	}
	 @Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
			System.out.println("service");super.service(req, res);
	}
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init");
		super.init(config);
	}
	@Override
	public void destroy() {
		System.out.println("destroy");
		super.destroy();
	}
}
