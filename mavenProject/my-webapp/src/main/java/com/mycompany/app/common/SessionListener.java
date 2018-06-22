package com.mycompany.app.common;
import javax.servlet.http.HttpSessionListener;  
import javax.servlet.http.HttpSessionEvent;  
public class SessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("session  begin :"+se.getSession().getId());
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("session  end :"+se.getSession().getId());
		
	}

}
