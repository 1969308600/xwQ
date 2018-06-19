package com.mycompany.app.service;

import java.util.List;

import com.mycompany.app.common.DataSourcer;

public interface  SystemBaseServiceI <T >{
	
	T getEntity();
	List<T> getEntityList();
	
	
	T findEntityByOneArg(String arg);
	
	
	void updateEntity(T t);
	void InsertEntity(T t);
	
	@DataSourcer(value="dataSource2")
	Object test2();
	

}
