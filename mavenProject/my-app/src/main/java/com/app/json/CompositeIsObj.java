package com.app.json;
 
/***
 * 核心实现层
 * 假设对象字段有对象类型
 * 其他的如类型为 map。list。set。的请自行派生CompositeI进行扩展 ，扩展类用法与此类类似
 * @author xwQ
 * 
 */

public class CompositeIsObj implements CompositeI{//字段处理
	/***
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	@Override
	public String FieldParse() throws IllegalArgumentException, IllegalAccessException {
		
		 
		return null;
	} 
} 