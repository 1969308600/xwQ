package com.app.json;
/***
 * 控制层
 * 尽量遵循下边：
 * 单一职责原则   里氏替换原则
 * 依赖倒转原则   接口隔离原则
 * 最少知道原则    合成复用原则
 * @author xwQ
 * 
 */
public class JsonObj  {
 
	static Object obj;           //目标对象
	static String Str="";     //不能为null  组合str
	static String StrField="";//不能为null  字段str
	static String StrMap="";//不能为null  map str
	static String StrList="";//不能为null  list str
	static String StrObj="";//不能为null  obj str
	CompositeI Composite;    //低耦合    组件
	/***
	 * 初始化    传入要处理的对象和组件
	 * @param o 对象
	 * @param c 组件
	 */
	public JsonObj init(Object o,CompositeI c) {   
		 Composite = c;
		 obj = o; 
		 return this;
	}
	/***
	 * 利用组合形式  处理其他的字段类型
	 * @param  c 组件
	 * @return 对象本身
	 */
	public JsonObj Composite(CompositeI c) {
		 Composite = c;
		 PaeseObj();
		 return this;
	}
	/***
	 * 调用组件
	 */
	private void PaeseObj()  { 
		try {
			Composite.FieldParse();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} 
	}  
	/***
	 * @return 处理好的json字符串
	 */
	public  String getStr() {
		PaeseObj();
		FinallyStr();
		removeATTABStr();
		return Str;
	}   
	/**
	 * 利用特殊字符  @tab 格式成我需要的字符串
	 * @return
	 */

	public  String removeATTABStr() {
		String[] temp = Str.split("@tab");
		int len = temp.length ;
		for(int i=0;i<len-2;i++) {
			Str = Str.replaceFirst("@tab", ",");
		}
		Str = Str.replaceFirst("@tab", "");
		return Str;
	} 
	/***
	 * 最后的Str  这个才是真正的转化成的json   
	 * 每个组件完成的都是一部分json  最后调用此方法完成所有的 json组装
	 * @return
	 */
	public String FinallyStr(){
		//StrObj StrList StrField StrMap
		//JsonObj.Str = "{"+JsonObj.Str+"}";
		//JsonObj.Str =   "{\""+	 c.getSimpleName().toLowerCase() +"\":"+ JsonObj.Str+"}" ;
		return null;
	}
}
