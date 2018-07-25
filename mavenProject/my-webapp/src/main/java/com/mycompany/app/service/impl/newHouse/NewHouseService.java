package com.mycompany.app.service.impl.newHouse;

import java.util.List;

import org.mybatis.newHouse.NewHouse;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.mybatis.web.test.Page;
import com.mycompany.app.common.DataSourcer;
import com.mycompany.app.service.SystemBaseServiceI;

@Component
public class NewHouseService implements SystemBaseServiceI<NewHouse> {
	
	@Autowired
	private SqlSessionTemplate sql;

	@Override
	public NewHouse getEntity() {
		// TODO Auto-generated method stub
		return null;
	}
	@DataSourcer(value="dataSource_ruili") 
	public List<NewHouse> getEntityList(Page page) {
		return sql.selectList("getNewHouseList",page);
	}
	@DataSourcer(value="dataSource_ruili")
	@Override
	public NewHouse findEntityByOneArg(String arg) {
		// TODO Auto-generated method stub
		return null;
	}
	@DataSourcer(value="dataSource_ruili")
	@Override
	public int updateEntity(NewHouse t) {
		return sql.update("updateNewHouse",t);
		
	}
	@DataSourcer(value="dataSource_ruili")
	@Override
	@Transactional
	public int InsertEntity(NewHouse t) {
		return sql.insert("insertNewHouse",t);
		
	}
 
	
	 

}
