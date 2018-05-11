package com.test;

import net.sf.ehcache.CacheManager;

public class TestPush {

	public static void main(String[] args) {
		  CacheManager cacheManager = new CacheManager();  
		   //输出当前cacheManager正在使用的配置对应的Xml格式文本  
		   System.out.println(cacheManager.getActiveConfigurationText()); 
	}
}
