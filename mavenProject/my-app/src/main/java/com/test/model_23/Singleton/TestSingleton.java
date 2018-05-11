package com.test.model_23.Singleton;

public class TestSingleton {
	//最简单的 单列是静态单列   扩展性不好，束缚太大。        注意  这里是影子类哟
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
