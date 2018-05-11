package com.test.JDKProxy;

public class Test {
	public static void main(String[] args) {
		 DistI dist=  new Dist();
		  
		 DistI proxy = (DistI)java.lang.reflect.Proxy.newProxyInstance(   
				dist.getClass().getClassLoader(),    
	                dist.getClass().getInterfaces(),    
	                new Proxy(dist));   
		 
		 proxy.test();
		
		// proxy.test2();  //局限于 接口 
	}

}
