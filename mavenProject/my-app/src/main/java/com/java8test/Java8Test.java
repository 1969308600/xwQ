package com.java8test;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Base64.Encoder;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Java8Test {
	
	public static void main(String[] args) throws ScriptException, FileNotFoundException {
		List<String> testl = new ArrayList<String>();
		testl.add("A");
		testl.add("a");
		testl.add("ABC");
		testl.add("Acd");
		testl.add("ACD");
		testl.add("ba");
		testl.add("ab");
		
		testl.stream().sorted((a,b)->{
			return a.compareTo(b);
			});
		
		testl.forEach((k)->{
			System.out.println(k);
		});
		
//		java7sort(testl);
//		
//		System.out.println("-----排序后----");
//		testl.forEach((k)->{
//			System.out.println(k);
//		});
//		
//		
//		
//		java8sort(testl);
//		
//		System.out.println("-----java8排序后----");
//		testl.forEach((k)->{
//			System.out.println(k);
//		});
//		
		
//		java8sort<String> sort = (l)->{
//			java8sort1(l);
//		};
//		java8sort<String> sort2 = (l)->{
//			java8sort2(l);
//		};
//		sort.sort(testl);
//		System.out.println("-----java8排序后----");
//		testl.forEach((k)->{
//			System.out.println(k);
//		});
//		
//		sort2.sort(testl);
//		System.out.println("-----java8排序后 倒序----");
//		testl.forEach((k)->{
//			System.out.println(k);
//		});
		
		
		// 获取当前的日期时间
		System.out.println("-----java8日期时间----");
//		Java 8 在 java.time 包下提供了很多新的 API。以下为两个比较重要的 API：
//		Local(本地) − 简化了日期时间的处理，没有时区的问题。
//		Zoned(时区) − 通过制定的时区处理日期时间。
	      LocalDateTime currentTime = LocalDateTime.now();
	      System.out.println("当前时间: " + currentTime);
	      System.out.println("当前时间2: " + currentTime.toLocalDate());
	      System.out.println("当前时间2: " + currentTime.toLocalTime());
	      System.out.println("当前时间2: " + currentTime.toLocalTime());
	      
	      ZonedDateTime date1 = ZonedDateTime.parse("2015-12-03T10:15:30+05:30[Asia/Shanghai]");
	      System.out.println("date1: " + date1);
	        
	      ZoneId id = ZoneId.of("Europe/Paris");
	      System.out.println("ZoneId: " + id);
	        
	      ZoneId currentZone = ZoneId.systemDefault();
	      System.out.println("当期时区: " + currentZone);
	      
	      Encoder e = Base64.getEncoder();
	      Encoder e2 = Base64.getMimeEncoder();
	      
	      try {
			System.out.println("URl编码：" + e.encodeToString( "麻痹wocailei32".getBytes("UTF-8")));
			System.out.println("mime编码：" + e2.encodeToString( "麻痹wocailei32".getBytes("UTF-8")));
	    	
			} catch (UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	      
	      ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
	      ScriptEngine nashorn = scriptEngineManager.getEngineByName("nashorn");
	     // nashorn.eval(new FileReader("script.js"));
	      nashorn.eval("print('Hello World!');");
	      
	      
	      
	      Random random = new Random();
	      random.ints().limit(10).sorted().forEach(System.out::println);
	}
	
	@SuppressWarnings("unused")
	private static void java7sort(List<String> list) {
		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
			
		});
	}
	private static void java8sort1(List<String> list) {
		Collections.sort(list, (t,t2)->{ return t.compareTo(t2); });
	}
	private static void java8sort2(List<String> list) {
		Collections.sort(list,  (t,t2)->{ return t2.compareTo(t); });
	}
	
	interface java8sort<T>{
		void sort(List<T> l);
	}
}
