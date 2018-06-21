package com.mycompany.app.service;

import java.util.List;

import org.mybatis.system.SystemUser;

import com.mycompany.app.common.DataSourcer;

public interface  SystemBaseServiceI <T >{
	
	T getEntity();
	List<T> getEntityList();
	
	
	T findEntityByOneArg(String arg);
	
//	@DataSourcer(value="dataSource")
	
	
	void updateEntity(T t);
	void InsertEntity(T t);
	
	@DataSourcer(value="dataSource2")
	Object test2();
	
	Object getUserByNameAndCode(SystemUser u);
	Object setUserSessionIdByUser(SystemUser t);
}
