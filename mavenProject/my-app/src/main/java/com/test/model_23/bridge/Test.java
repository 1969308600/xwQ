package com.test.model_23.bridge;

public class Test {
	public static void main(String[] args) {
		BridgeDist dist = new BridgeDist();
		Bridge.setSuorce(dist); 
		Bridge.doSome();
	}

} 
//interface BridgeI {
//	void test();
//}
//class Bridge {//ге╫с
//	static BridgeI dist; 
//	public static  void setSuorce(BridgeI d) {
//		 dist=d;
//	}
//	public static void  doSome() {
//		dist.test();
//	}
//}
//class BridgeDist implements BridgeI{
//	public void test() {
//		System.out.println("some");
//	}
//}
//class BridgeDist2 implements BridgeI {
//	@Override
//	public void test() {
//		System.out.println("some 2");
//		
//	}
//}