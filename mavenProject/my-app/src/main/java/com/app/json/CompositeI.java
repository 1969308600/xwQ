/**
 * 
 */
package com.app.json;

/**
 * 模板接口层
 * 组件接口类
 * @author xwQ
 *
 */
public interface CompositeI {
	/**
	 * 转化字段  
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 *
	 */
	String FieldParse() throws IllegalArgumentException, IllegalAccessException;
}
