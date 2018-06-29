package com.mycompany.app.service;

import java.util.List;

import com.mybatis.web.test.Page;

public interface  SystemBaseServiceI <T >{
	
	T getEntity();
	List<T> getEntityList(Page page);
	
	
	T findEntityByOneArg(String arg);
	
	
	void updateEntity(T t);
	void InsertEntity(T t);
	

}
