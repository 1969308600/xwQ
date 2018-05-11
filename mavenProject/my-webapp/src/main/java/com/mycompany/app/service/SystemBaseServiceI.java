package com.mycompany.app.service;

import java.util.List;

public interface  SystemBaseServiceI <T >{
	
	T getEntity();
	List<T> getEntityList();
	
	
	T findEntityByOneArg(String arg);
	
	
	void updateEntity(T t);
	void InsertEntity(T t);
	

}
