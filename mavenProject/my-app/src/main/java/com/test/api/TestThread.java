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
//			temp.sleep(10000); //sleep��������ǰ�̡߳�
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
	public void run() {//thread�ṩ�Ķ��ⷽ�� �����������д�Լ���ҵ���߼���
		synchronized(staticVar.count) {
			staticVar.count=this.getName();
			 
			System.out.println(staticVar.count+Thread.currentThread().getName());
		}
		
		
//		

		
		//wait()��notify()��notifyAll()������ڷ�ͬ�����Ʒ����������Щ������������ͨ�����룬�����е�ʱ�򣬽��õ�IllegalMonitorStateException�쳣
		
		
		super.run();
	}
}
class staticVar {
	static String count ="1";
	
}