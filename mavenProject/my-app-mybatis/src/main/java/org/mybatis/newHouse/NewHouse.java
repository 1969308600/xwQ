package org.mybatis.newHouse;

import java.io.Serializable;

public class NewHouse implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String uptownName;
	private String cityArea;
	private String avgPrice;
	private String developer;
	private String saleStatus;
	private String transferDate;
	private String allHolds;
	private String commission;
	private String optStatus;
	private String rebateName;
	private String forb;
	private String manager;
	private String managerPhone;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUptwonName() {
		return uptownName;
	}
	public void setUptwonName(String uptwonName) {
		this.uptownName = uptwonName;
	}
	public String getCityArea() {
		return cityArea;
	}
	public void setCityArea(String cityArea) {
		this.cityArea = cityArea;
	}
	public String getAvgPrice() {
		return avgPrice;
	}
	public void setAvgPrice(String avgPrice) {
		this.avgPrice = avgPrice;
	}
	public String getDeveloper() {
		return developer;
	}
	public void setDeveloper(String developer) {
		this.developer = developer;
	}
	public String getSaleStatus() {
		return saleStatus;
	}
	public void setSaleStatus(String saleStatus) {
		this.saleStatus = saleStatus;
	}
	public String getTransferDate() {
		return transferDate;
	}
	public void setTransferDate(String transferDate) {
		this.transferDate = transferDate;
	}
	public String getAllHolds() {
		return allHolds;
	}
	public void setAllHolds(String allHolds) {
		this.allHolds = allHolds;
	}
	public String getCommission() {
		return commission;
	}
	public void setCommission(String commission) {
		this.commission = commission;
	}
	public String getOptStatus() {
		return optStatus;
	}
	public void setOptStatus(String optStatus) {
		this.optStatus = optStatus;
	}
	public String getRebateName() {
		return rebateName;
	}
	public void setRebateName(String rebateName) {
		this.rebateName = rebateName;
	}
	public String getForb() {
		return forb;
	}
	public void setForb(String forb) {
		this.forb = forb;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public String getManagerPhone() {
		return managerPhone;
	}
	public void setManagerPhone(String managerPhone) {
		this.managerPhone = managerPhone;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
