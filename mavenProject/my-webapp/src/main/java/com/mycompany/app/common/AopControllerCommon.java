package com.mycompany.app.common;

import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
@Component  
@Aspect
public class AopControllerCommon {
	
//	@Pointcut("execution(* com.mycompany.app.controller.system.SystemController.*(..))")
//	public void pt() { }
//	
//	@Before(value = "pt()")
//	public void before() {
//		System.out.println("before");
//		
//	}
//	@Around(value = "pt()")
//	public void a(ProceedingJoinPoint  p,HttpSession session) {
//		try {
//			p.proceed();
//			System.out.println("around");
//		} catch (Throwable e) {
//			e.printStackTrace();
//		}
//	}
//	@After(value = "pt()")
//	public void after() {
//		System.out.println("after");
//	}
//	
	

}
