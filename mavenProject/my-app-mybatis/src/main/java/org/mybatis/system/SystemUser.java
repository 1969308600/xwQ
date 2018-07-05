package org.mybatis.system;

import java.io.Serializable;

public class SystemUser implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String safeKey;//sessionidµÄ¼ÓÃÜ
	private String name;
	private String code;
	private String loginName;
	private String phone;
	private String email;
	private String password;
	private SystemDept dpt;
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
	 
	

}
