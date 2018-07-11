package org.mybatis.system;

import java.io.Serializable;
import java.util.List;

public class SystemMenu implements  Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	private List<SystemBtn> btns;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<SystemBtn> getBtns() {
		return btns;
	}
	public void setBtns(List<SystemBtn> btns) {
		this.btns = btns;
	}
	
	
	
	
}
