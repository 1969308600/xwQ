package com.test.api;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

 

public class TestSocket {
	
	public static void main(String[] args) {
		bio();
	}
	
	public static  void  bio() 
	{
		try {
			ServerSocket ser = new ServerSocket( 8881);
			Socket s =null;
		 
			s= ser.accept();  
				
			OutputStream out = s.getOutputStream();
			out.write(new String("�Ҳ���").getBytes());
			System.out.println(1);
			
			DataOutputStream pw = new DataOutputStream (out);
			pw.writeUTF("��ӭ����");
			 
			s.close();
			
	 
		} catch (IOException e) {
			e.printStackTrace(); 
		}
		
	}
	

}
