package com.test.api;

import java.io.IOException;
import java.io.InputStream;

public class TestSecurityManager extends SecurityManager {
	String password;
	TestSecurityManager(String password) {
	    super();
	    this.password = password;
	}
	public boolean accessOK(String p) {
//		InputStream pass = System.in ;
//		String pa="";
		 
//			byte[] bt = new byte[1012];
//			int k=0;
//			while((k=pass.read())!=-1) {
//				pa = new String(bt,0,k);
//			}
//			System.out.println(pa);
			if(p!=password) {
				return false;
			} 
			
		 
		return true;	
	}
}
