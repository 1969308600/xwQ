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
 * 字符  reader  write
 * 字节  inputStream   outputStream
 * @author worker
 *
 */

public class StreamTest {
	
	public static void main(String[] args) {
		//file类定义文件属性
		File file = new File("D:\\rmp/temp.txt");
		
		System.out.println("文件存在："+file.exists());
		System.out.println("是文件："+file.isFile());
		System.out.println("文件存在子目录："+file.mkdirs());
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
