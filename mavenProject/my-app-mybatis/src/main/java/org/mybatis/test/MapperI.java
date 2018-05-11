package org.mybatis.test;

import java.util.List;

public interface MapperI {
	 
	Mapper selectBlog();
	void insertBlog();
	List<Mapper> selectMapperList();
	void insertMapper();
}
