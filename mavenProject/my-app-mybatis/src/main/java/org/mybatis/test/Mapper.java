package org.mybatis.test;

import org.apache.ibatis.annotations.MapKey;

//@Alias("Mapper")
public class Mapper {
	String id;
	String name;
	int sex;
	
	int city;
	String sign;
	int experience;
	int score;
	String classify;
	String wealth;
	int count;
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
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public int getCity() {
		return city;
	}
	@MapKey("t_b_city_I")
	public void setCity(int city) {
		this.city = city;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getClassify() {
		return classify;
	}
	public void setClassify(String classify) {
		this.classify = classify;
	}
	public String getWealth() {
		return wealth;
	}
	public void setWealth(String wealth) {
		this.wealth = wealth;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	

}
