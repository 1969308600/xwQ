package org.mybatis.system;

import java.io.Serializable;
import java.util.List;

public class SystemRole implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private String meo;
	private List<SystemMenu> menus;
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
	public String getMeo() {
		return meo;
	}
	public void setMeo(String meo) {
		this.meo = meo;
	}
	public List<SystemMenu> getMenuId() {
		return menus;
	}
	public void setMenuId(List<SystemMenu> menuId) {
		this.menus = menuId;
	}
	 
	 
	

}
