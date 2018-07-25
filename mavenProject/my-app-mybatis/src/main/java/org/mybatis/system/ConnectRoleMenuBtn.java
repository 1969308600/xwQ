package org.mybatis.system;

import java.io.Serializable;

public class ConnectRoleMenuBtn implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String menuId;
	private String btnId;
	private String roleId;
	public String getId() {
		return id;
	}
	public ConnectRoleMenuBtn(String roleId,String menuId,String btnId) {
		this.menuId = menuId;
		this.btnId = btnId;
		this.roleId=roleId;
	}
	public ConnectRoleMenuBtn() {
		
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMenuId() {
		return menuId;
	}
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}
	public String getBtnId() {
		return btnId;
	}
	public void setBtnId(String btnId) {
		this.btnId = btnId;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	
	

}
