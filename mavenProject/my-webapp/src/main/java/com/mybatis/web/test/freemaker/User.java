package com.mybatis.web.test.freemaker;

public class User {
	String name;
	String info;
	int age;
	String address;
	//"tom", "kkkkk", 29, "±±¾©"
	public User(String string, String string2, int i, String string3) {
		name=string;
		info=string2;
		age =i;
		address=string3;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	 

}
