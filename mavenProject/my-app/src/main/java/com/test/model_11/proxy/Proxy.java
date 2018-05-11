package com.test.model_11.proxy;

public class Proxy implements DistI{//´úÀí
	
	Dist dist;
	
	public Proxy(Dist dist) {
		this.dist = dist;
	}
	
	private void after() {
		System.out.println("after");
	}
	
	private void before() {
		System.out.println("before");
	} 
	@Override
	public void test() {
		before();
		System.out.println("method"); 
		dist.test();
		after() ;
		
	}

}
