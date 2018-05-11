package com.test.api;

import java.lang.ref.Reference;
import java.lang.reflect.Array;
import java.util.concurrent.Executors;

import javax.security.auth.callback.Callback;

public class TestThread  {
	int count=0;
	public static void main(String[] args) {
		myThread temp = new myThread();   
//		System.out.println(temp.getContextClassLoader());
//		System.out.println(temp.getContextClassLoader().getParent());
 		myThread temp2 = new myThread(); 
 		
 		System.out.println("test!");   
 		
//		myThread temp3 = new myThread();
		
//		try {
//			temp.sleep(10000); //sleep会阻塞当前线程。
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			temp.wait();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		temp.start();
//		temp2.start();	
//		temp3.start();
//		System.out.println("heloo");
	
//		System.out.println(temp.getState());
//		System.out.println(temp2.getState());
//		System.out.println(temp3.getState());
//		System.out.println("--1->"+staticVar.count);
//		staticVar.count="2";
//		 
// 
//		TestSecurityManager s =new TestSecurityManager("123");
//		System.out.println(s.accessOK("123"));
		test(); 
//		System.out.println("--2->"+staticVar.count);
		
	}
	

	private static void test() {
		Thread t = Thread.currentThread() ;
		
		System.out.println(t.getName());
	}
 

}

class myThread extends Thread{
	
	@Override
	public void run() {//thread提供的对外方法 ，在这里可以写自己的业务逻辑。
		synchronized(staticVar.count) {
			staticVar.count=this.getName();
			 
			System.out.println(staticVar.count+Thread.currentThread().getName());
		}
		
		
//		

		
		//wait()，notify()和notifyAll()。如果在非同步控制方法里调用这些方法，程序能通过编译，但运行的时候，将得到IllegalMonitorStateException异常
		
		
		super.run();
	}
}
class staticVar {
	static String count ="1";
	
}