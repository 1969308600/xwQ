package org.mybatis.system;

import java.io.Serializable;

public class SystemUser implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String safeKey;//sessionid的加密
	private String name;
	private String code;
	private String loginName;
	private String phone;
	private String email;
	private String password;
	private SystemDept dpt;//对应表来说  用户表是不该关联的，在中间表中关联，实体类只是表示关系而已 ,   这里在表里建了dpt字段就不得行。对应订单这种可以，
	private SystemRole role;//对应表来说  用户表是不该关联的，在中间表中关联，实体类只是表示关系而已
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
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSafeKey() {
		return safeKey;
	}
	public void setSafeKey(String safeKey) {
		this.safeKey = safeKey;
	}
 
	public SystemDept getDpt() {
		return dpt;
	}
	public void setDpt(SystemDept dpt) {
		this.dpt = dpt;
	}
	public SystemRole getRole() {
		return role;
	}
	public void setRole(SystemRole role) {
		this.role = role;
	}
	 
	

}
