package com.test.api;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

public class TestCollection {

	public static void main(String[] args) {
		 
		ArrayList<String> a = new ArrayList<String>( );//�����б�϶���ҳ���ݲ�С��20������ָ����С������ݡ�
		a.ensureCapacity(9);
		for(int t=0;t<34;t++) {
			
			a.add(something.newStr);
		}
		 
		Class c=a.getClass();  
		Field f;  
        try {  
            f=c.getDeclaredField("elementData");  
            f.setAccessible(true);  
            Object[] o=(Object[])f.get(a);  
            System.out.println(o.length);  
        }catch(Exception e) {
        	
        }
		
		
		List<String> list = Collections.synchronizedList(a); //ʹ�÷�װ��ͬ����list ���첽ʱ�ǳ�����
		
		ArrayList<String> b = (ArrayList<String>) a.clone();
		
		System.out.println(a.get(0)==b.get(0));//ǳ���ƣ�������������Ķ������ò��䣬���ǻ�list���ò���ͬһ����
		
		
		System.out.println("\n");
		
		Vector<String> t = new Vector<>(); //��ΪCollections.synchronizedList(a);����vector�Ƚϼ���  
		
		t.add(something.newStr);
		t.forEach((k)->{
			System.out.println(k);
		});
		
		
		
		for(int t2=0;t2<21;t2++) {
			
			t.add(something.newStr);
		}
		System.out.println(t.capacity());
//		Class c2=t.getClass();  
//		Field f2;  
//        try {  
//            f2=c2.getDeclaredField("elementData");  
//            f2.setAccessible(true);  
//            Object[] o=(Object[])f2.get(t);  
//            System.out.println(o.length);  
//        }catch(Exception e) {
//        	
//        }
//		
		
		HashMap<String, Object> map = new HashMap<>(20,1);
		map.put(something.newStr, something.newStr);
	}
}

class   something{
	
	static String newStr = "test";
}