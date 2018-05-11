package com.app.json;

import java.lang.reflect.Field;
import java.text.MessageFormat;

/***
 * ����ʵ�ֲ�
 * ��������ǻ������ͣ�������򵥵Ĵ������
 * ������������Ϊ map��list��set�����������������CompositeI������չ ����չ���÷����������
 * @author xwQ
 * 
 */

public class CompositeIsFiled implements CompositeI{//�ֶδ���
	/***
	 * �ֶ�����Ϊ�˴��������
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException *
	 */
	@Override
	public String FieldParse() throws IllegalArgumentException, IllegalAccessException {
		
		Class<? extends Object> c =  JsonObj.obj.getClass();
		Field[] f =  c.getDeclaredFields();
//		for (Field field : f) {
//			CompositeI method = StaticField.map.get(field.getType());
//			method.FieldParse();
//			if(StaticField.map.get(field.getType())) {
//				
//				field.setAccessible(true);   
//				JsonObj.StrField += MessageFormat.format("\"{0}\":\"{1}\"@tab", field.getName().toLowerCase() ,field.get(JsonObj.obj));
//			} 
		for (Field field : f) {
			if(field.getType()==String.class||field.getType()==char.class
					||field.getType()==int.class||field.getType()==double.class
					||field.getType()==short.class||field.getType()==byte.class
					||field.getType()==long.class||field.getType()==float.class) {
				
				field.setAccessible(true);   
				JsonObj.Str+= MessageFormat.format("\"{0}\":\"{1}\"@tab", field.getName().toLowerCase() ,field.get(JsonObj.obj));
			} 
		}  
		JsonObj.Str = "{"+JsonObj.Str+"}";
		JsonObj.Str =   "{\""+	 c.getSimpleName().toLowerCase() +"\":"+ JsonObj.Str+"}" ;
		return null;
	} 
} 