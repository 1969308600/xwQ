package com.test;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;

public class TestGet {

	public static void main(String[] args) {
	CacheManager ctr  = CacheManager.create("./src/main/resources/ehcache.xml");
		
		Cache ca = ctr.getCache("hello");
		System.out.println(ca.get("key1").getObjectValue());
	}
}
