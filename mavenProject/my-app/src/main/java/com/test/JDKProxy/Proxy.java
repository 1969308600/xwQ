package com.test.JDKProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Proxy implements InvocationHandler{
	Object target;
	public Proxy(Object target) {
		 super(); 
		this.target = target;     //   target就是要代理的类
	}
	
	private void before() {
		System.out.println("before");
	}
	private void after() {
		System.out.println("after");
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		before();
		method.invoke(target);     //   执行代理类
		after();
		return null;
	}

}
