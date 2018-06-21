package com.mycompany.app.service.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.system.SystemMapper;
import org.mybatis.system.SystemUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mybatis.web.test.Page;
import com.mycompany.app.service.SystemBaseServiceI;

@Service("systemService")
public class SystemService implements SystemBaseServiceI<SystemMapper>{
	
	@Autowired 
	public SqlSessionTemplate sqlSessionTemplate;
	
	@Cacheable(value="userCache",key="#cacheKey",condition="1==1")
	public List<Object> getMenuListByPage(Page pages,String cacheKey){
		 return sqlSessionTemplate.selectList("getMenuList",pages);
	}
	
	@Cacheable(value="userCache",key="#rcacheKey",condition="1==1")
	public List<Object> getMenu( String rcacheKey){
		return sqlSessionTemplate.selectList("getMenu");
	}
	@Cacheable(value="userCache",key="#rcacheKey",condition="1==1")
	public List<Object> getDeptList( String rcacheKey){
		return sqlSessionTemplate.selectList("getDept");
	}
	
	public  Object getUserByNameAndCode(SystemUser u){
		return sqlSessionTemplate.selectOne("getUserByNameAndCode",u);
	}
	
	/**
	 * ����sessionId
	 * @param u
	 * @return
	 */
	@Transactional
	public  Object setUserSessionIdByUser(SystemUser u){
		return sqlSessionTemplate.selectOne("setUserSessionId",u);
	}
	
 
	public int getMenuCountForList() {
		return  sqlSessionTemplate.selectOne("getMenuCountForList");
	}
	@Override
	public SystemMapper getEntity() {
		return null;
	}

	@Override
	public List<SystemMapper> getEntityList() {
		return null;
	}

	@Override
	public SystemMapper findEntityByOneArg(String arg) {
		return null;
	}

	@Override
	public void updateEntity(SystemMapper t) {
		
	}


	@Override
	public void InsertEntity(SystemMapper t) {
		 sqlSessionTemplate.insert("insertMapper",t);
		
	}

	@Override
	public List<Object> test2() {
		 return sqlSessionTemplate.selectList("test2");
	}

 


	public void setUserSessionIdByUser(SystemMapper t) {
		// TODO Auto-generated method stub
		
	}

}
