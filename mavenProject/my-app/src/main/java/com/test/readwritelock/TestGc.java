package com.test.readwritelock;

import java.util.HashMap;
import java.util.Map;
/**
 * 	gc��������ֺ��٣���Ҫ��arguments������
 * @author worker
 *
 */
public class TestGc {
	 public static void main(String[] args)  { 
		   
		 Map<String, Object> map = new HashMap<>();
		 int count =0;
		 for(;;) {
			 if(count==100000) {
				 break;
			 }
			 map.put(""+count, new ThreadTest());
		 }
	 }
}
