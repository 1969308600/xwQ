package com.test.model_23.bridge;

public class Bridge {//�Ž�
	static BridgeI dist;
	
	
	public static  void setSuorce(BridgeI d) {
		 dist=d;
	}
	
	public static void  doSome() {
		dist.test();
	}

}
