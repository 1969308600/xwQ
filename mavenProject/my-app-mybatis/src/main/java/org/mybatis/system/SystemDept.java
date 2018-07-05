package org.mybatis.system;

import java.io.Serializable;

public class SystemDept implements Serializable  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	int id;
	String name;
	int sort;
	int status;
	int parent;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	 
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getParent() {
		return parent;
	}
	public void setParent(int parent) {
		this.parent = parent;
	}
	

}
