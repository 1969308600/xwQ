package com.stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.net.HttpURLConnection;


/**
 * �ַ�  reader  write
 * �ֽ�  inputStream   outputStream
 * @author worker
 *
 */

public class StreamTest {
	
	public static void main(String[] args) {
		//file�ඨ���ļ�����
		File file = new File("D:\\rmp/temp.txt");
		
		System.out.println("�ļ����ڣ�"+file.exists());
		System.out.println("���ļ���"+file.isFile());
		System.out.println("�ļ�������Ŀ¼��"+file.mkdirs());
		System.out.println(file);
		 
		try {
			FileInputStream fis = new FileInputStream(file);
			
			FileOutputStream fos = new FileOutputStream( new File("D:\\rmp/temp2.txt"));
			try {
				int len=0;
				byte[] b = new byte[1024];
				for(;(len=fis.read(b))!=-1;) { 
					fos.write(b, 0, len);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				try {
					fis.close();
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
