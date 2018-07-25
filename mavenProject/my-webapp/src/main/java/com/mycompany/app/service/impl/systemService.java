package com.mycompany.app.service.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.system.SystemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.mybatis.web.test.Page;
import com.mycompany.app.service.SystemBaseServiceI;

@Service("systemService")
public class systemService implements SystemBaseServiceI<SystemMapper>{
	
	@Autowired 
	public SqlSessionTemplate sqlSessionTemplate;
	
	//@Cacheable(value="userCache",key="#cacheKey",condition="1==1")
	public List<Object> getMenuListByPage(Page pages,String cacheKey){
		 return sqlSessionTemplate.selectList("getMenuList",pages);
	}
	
	//@Cacheable(value="userCache",key="#rcacheKey",condition="1==1")
	public List<Object> getMenu( String rcacheKey){
		return sqlSessionTemplate.selectList("getMenu");
	}
	//@Cacheable(value="userCache",key="#rcacheKey",condition="1==1")
	public List<Object> getDeptList( String rcacheKey){
		return sqlSessionTemplate.selectList("getDept");
	}
	
	public List<Object> getUserByNameAndCode(){
		return sqlSessionTemplate.selectList("getUserByNameAndCode");
	}
 
 
	public int getMenuCountForList() {
		return  sqlSessionTemplate.selectOne("getMenuCountForList");
	}
	@Override
	public SystemMapper getEntity() {
		return null;
	}

 
	@Override
	public SystemMapper findEntityByOneArg(String arg) {
		return null;
	}

	@Override
	public int updateEntity(SystemMapper t) {
		return 0;
	}


	@Override
	public int InsertEntity(SystemMapper t) {
		 return sqlSessionTemplate.insert("insertMapper",t);
		
	}

	@Override
	public List<SystemMapper> getEntityList(Page page) {
		// TODO Auto-generated method stub
		return null;
	} 
}
