package com.test.model_11.proxy;

public class Test {
	
	public static void main(String[] args) {
		 
		DistI d = new Proxy(new Dist());
		d.test();
	}

}
