package com.test;

import net.sf.ehcache.CacheManager;

public class TestPush {

	public static void main(String[] args) {
		  CacheManager cacheManager = new CacheManager();  
		   //�����ǰcacheManager����ʹ�õ����ö�Ӧ��Xml��ʽ�ı�  
		   System.out.println(cacheManager.getActiveConfigurationText()); 
	}
}
