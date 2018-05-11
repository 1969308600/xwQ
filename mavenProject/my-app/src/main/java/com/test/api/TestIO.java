package com.test.api;

import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class TestIO {
	
	public static void main(String[] args) {
		test();
	}
	
	public static void test() 
	{
		long timbegin = System.nanoTime();
		FileInputStream in =null;
		try {
			in= new FileInputStream("d:/spring±Ê¼Ç.txt");
			byte[] b=new byte[1024];
			int t;
//			while(( t=in.read(b))!=-1) {
//				System.out.println(new String(b,0,t));
//			} 
			
			FileOutputStream out = new FileOutputStream("d:/copy.txt");
			
			 
//			FileDescriptor fd  = in.getFD();
//			fd.in.sync();
			
			while(( t=in.read(b))!=-1) {
//				System.out.println(new String(b,0,t));
				out.write(b);
				 
			}
			long timeend = System.nanoTime();
 			System.out.println(timbegin-timeend);
			
			out.flush();
			out.close();
			in.close();
			
			 
			
			  
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
