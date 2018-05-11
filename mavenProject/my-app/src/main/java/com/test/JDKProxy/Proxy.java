package com.test.JDKProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Proxy implements InvocationHandler{
	Object target;
	public Proxy(Object target) {
		 super(); 
		this.target = target;     //   target����Ҫ�������
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
		method.invoke(target);     //   ִ�д�����
		after();
		return null;
	}

}
