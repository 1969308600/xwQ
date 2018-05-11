package com.test.api;

public class TestClassLoader {
	
	public static void main(String[] args) {
		test();
	}

	private static void test() {
		 ClassLoader c=TestIO.class.getClassLoader();
		 ClassLoader cp=TestIO.class.getClassLoader().getParent();
		 ClassLoader cpp=TestIO.class.getClassLoader().getParent().getParent(); //无法得到bootstrap classloader
		 ClassLoader s=String.class.getClassLoader();
		 ClassLoader i=int.class.getClassLoader();
		 System.out.println(c);
		 System.out.println(cp);
		 System.out.println(cpp); 
		 System.out.println(s);
		 System.out.println(i);
		 
		 
		
	}

}
