package com.mycompany.app.service.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.system.SystemUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mybatis.web.test.Page;
import com.mycompany.app.service.SystemBaseServiceI;

@Component
public class SystemUserService implements SystemBaseServiceI<SystemUser> {
	
	@Autowired
	SqlSessionTemplate sql;
	
	@Override
	public SystemUser getEntity() {
		return null;
	}
	
	@Override
	public List<SystemUser> getEntityList(Page page) {
		return sql.selectList("getUserList",page);
	}

	@Override
	public SystemUser findEntityByOneArg(String arg) {
		return null;
	}

	@Override
	public int updateEntity(SystemUser t) {
		return sql.update("updateUser",t);
	}

	@Override
	public int InsertEntity(SystemUser t) {
		return sql.insert("inserUser",t);
		
	}

}
