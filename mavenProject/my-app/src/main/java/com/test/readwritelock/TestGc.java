package com.test.readwritelock;

import java.util.HashMap;
import java.util.Map;
/**
 * 	gc代码的体现很少，主要是arguments的设置
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
