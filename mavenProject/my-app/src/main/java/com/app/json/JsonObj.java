package com.app.json;
/***
 * ���Ʋ�
 * ������ѭ�±ߣ�
 * ��һְ��ԭ��   �����滻ԭ��
 * ������תԭ��   �ӿڸ���ԭ��
 * ����֪��ԭ��    �ϳɸ���ԭ��
 * @author xwQ
 * 
 */
public class JsonObj  {
 
	static Object obj;           //Ŀ�����
	static String Str="";     //����Ϊnull  ���str
	static String StrField="";//����Ϊnull  �ֶ�str
	static String StrMap="";//����Ϊnull  map str
	static String StrList="";//����Ϊnull  list str
	static String StrObj="";//����Ϊnull  obj str
	CompositeI Composite;    //�����    ���
	/***
	 * ��ʼ��    ����Ҫ����Ķ�������
	 * @param o ����
	 * @param c ���
	 */
	public JsonObj init(Object o,CompositeI c) {   
		 Composite = c;
		 obj = o; 
		 return this;
	}
	/***
	 * ���������ʽ  �����������ֶ�����
	 * @param  c ���
	 * @return ������
	 */
	public JsonObj Composite(CompositeI c) {
		 Composite = c;
		 PaeseObj();
		 return this;
	}
	/***
	 * �������
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
	 * @return ����õ�json�ַ���
	 */
	public  String getStr() {
		PaeseObj();
		FinallyStr();
		removeATTABStr();
		return Str;
	}   
	/**
	 * ���������ַ�  @tab ��ʽ������Ҫ���ַ���
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
	 * ����Str  �������������ת���ɵ�json   
	 * ÿ�������ɵĶ���һ����json  �����ô˷���������е� json��װ
	 * @return
	 */
	public String FinallyStr(){
		//StrObj StrList StrField StrMap
		//JsonObj.Str = "{"+JsonObj.Str+"}";
		//JsonObj.Str =   "{\""+	 c.getSimpleName().toLowerCase() +"\":"+ JsonObj.Str+"}" ;
		return null;
	}
}
