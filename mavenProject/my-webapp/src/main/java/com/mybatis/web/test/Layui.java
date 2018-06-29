package com.mybatis.web.test;

import java.util.List;

public class Layui<T> {
	
	 String count;
	 String  code="";
	 String msg=""  ; 
	 List<T> data;
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public  List<T>  getData() {
		return data;
	}
	public void setData( List<T>  data) {
		this.data = data;
	}

}
