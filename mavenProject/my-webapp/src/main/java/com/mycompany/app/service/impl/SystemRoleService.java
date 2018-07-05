package com.mycompany.app.service.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.system.SystemRole;
import org.mybatis.system.SystemUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.mybatis.web.test.Page;
import com.mycompany.app.service.SystemBaseServiceI;

@Component
public class SystemRoleService implements SystemBaseServiceI<SystemRole> {
	
	@Autowired
	SqlSessionTemplate sql;

	@Override
	public SystemRole getEntity() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SystemRole> getEntityList(Page page) {
		return sql.selectList("getRoleList");
	}

	@Override
	public SystemRole findEntityByOneArg(String arg) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateEntity(SystemRole t) {
		// TODO Auto-generated method stub
		return 0;
		
	}
	@Override
	@Transactional
	public int InsertEntity(SystemRole t) {
		return sql.insert("insertRole",t);
		
	}
	
	 

}
