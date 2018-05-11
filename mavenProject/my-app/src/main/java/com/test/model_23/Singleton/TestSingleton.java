package com.test.model_23.Singleton;

public class TestSingleton {
	//��򵥵� �����Ǿ�̬����   ��չ�Բ��ã�����̫��        ע��  ������Ӱ����Ӵ
	static Singleton  singleton;
	
	
	private TestSingleton() {
		
	}
	
	public static Singleton getSingleton() {
		if(singleton==null)
			setSingleton();
		return singleton;
	}

	private synchronized static void  setSingleton() {
		 singleton = singleton==null?new Singleton():singleton;
		
	}
	

}
