package com.mybatis.web.test;

import java.util.List;

public class Layui<T> {
	
	 String count;
	 String  code="";
	 String msg=""  ; 
	 String result=""  ; 
	 int success;
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
	public int getSuccess() {
		return success;
	}
	public void setSuccess(int success) {
		this.success = success;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	 

}
