package org.mybatis.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test {
	
	public static void main(String[] args) {
		test();
		 
	} 
	private static void test() {
		String config = "mybatis.config.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(config);
		} catch (IOException e) {
			e.printStackTrace();
		}
		SqlSessionFactoryBuilder s = new SqlSessionFactoryBuilder();
		SqlSessionFactory  f = s.build(inputStream);
		
		SqlSession ss = f.openSession();
		
		 
		
		Mapper o = ss.selectOne("selectBlog",1);
		MapperMap1 o2 = ss.selectOne("selectBlogById",1);
		
		Mapper insert = new Mapper();
		insert.setName("insert");
		//insert.setId("2");
		try {
			ss.insert ("insertBlog",insert);
			ss.commit();
		}catch(Exception e) {
			return;
		}finally {
			
		}
	 
		 
		
		System.out.println(o.getName());
		System.out.println(o2.getName());
	}
}
