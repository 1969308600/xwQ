package org.mybatis.system;


public class SystemMapper       {
	/**
	 * 
	 */ 
	
	int id;
	String name;
	String urlKey;
	String urlHtml;
	String urlCtrl;
	String ctrlKey;
	String code;
	int level;
	int parent;
	String key; 
	
	
	public String getCtrlKey() {
		return ctrlKey;
	}
	public void setCtrlKey(String ctrlKey) {
		this.ctrlKey = ctrlKey;
	}
	public int getParent() {
		return parent;
	}
	public void setParent(int parent) {
		this.parent = parent;
	}
	public int getLevel() {
		 
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
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
	 
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getUrlKey() {
		return urlKey;
	}
	public void setUrlKey(String urlKey) {
		this.urlKey = urlKey;
	}
	public String getUrlHtml() {
		return urlHtml;
	}
	public void setUrlHtml(String urlHtml) {
		this.urlHtml = urlHtml;
	}
	public String getUrlCtrl() {
		return urlCtrl;
	}
	public void setUrlCtrl(String urlCtrl) {
		this.urlCtrl = urlCtrl;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	
	

}
