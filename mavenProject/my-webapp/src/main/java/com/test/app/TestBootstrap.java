package com.test.app;

import org.apache.catalina.startup.Bootstrap;

public class TestBootstrap {
	public static void main(String[] args) {
		Bootstrap boot = getBoot();
		try {
			boot.init();
		} catch (Exception e) { 
			e.printStackTrace();
			return;
		}
		 
		try {
			boot.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	static Bootstrap boot;
	public static Bootstrap getBoot() {
		if(boot==null) {
			 boot = new Bootstrap();
		}
		
		return boot;
	}

}
