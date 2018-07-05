package com.mycompany.app.service.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.test.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.mybatis.web.test.Page;
import com.mycompany.app.service.SystemBaseServiceI;

@Service("testService")
public class TestService implements SystemBaseServiceI<Mapper>{
	
	@Autowired 
	public SqlSessionTemplate sqlSessionTemplate;
	
	@Cacheable(value="userCache",key="#cacheKey",condition="1==1")
	public List<Object> getMappertListByPage(Page pages,String cacheKey){
		 return sqlSessionTemplate.selectList("selectMapperList",pages);
	}
	
 
	@Override
	public Mapper getEntity() {
		return null;
	}
 
	@Override
	public Mapper findEntityByOneArg(String arg) {
		return null;
	}

	@Override
	public int updateEntity(Mapper t) {
		return 0;
	}


	@Override
	public int InsertEntity(Mapper t) {
		 return sqlSessionTemplate.insert("insertMapper",t);
		
	}


	@Override
	public List<Mapper> getEntityList(Page page) {
		// TODO Auto-generated method stub
		return null;
	}


 
}
