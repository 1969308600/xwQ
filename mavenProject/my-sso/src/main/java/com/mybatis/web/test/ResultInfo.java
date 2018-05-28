package com.mybatis.web.test;

import java.util.List;

public class ResultInfo <T>{
	
	boolean success;
	
	List<T> listData;
	
	T objData;
	
	String info;
	
	public ResultInfo(boolean boo,String info) {
		 this.success = boo;
		 this.info = info;
		 
	}
	public ResultInfo(boolean boo) {
		this.success = boo;
		
	}
	public ResultInfo(boolean boo,List<T> listData) {
		this.listData = listData;
		this.success = boo;
		
	}
	public ResultInfo(boolean boo,T obj) {
		this.objData = obj;
		this.success = boo;
		
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public List<T> getListData() {
		return listData;
	}

	public void setListData(List<T> listData) {
		this.listData = listData;
	}

	public T getObjData() {
		return objData;
	}

	public void setObjData(T objData) {
		this.objData = objData;
	}

	public String getErrorInfo() {
		return info;
	}

	public void setErrorInfo(String errorInfo) {
		this.info = errorInfo;
	}
	
	

}
