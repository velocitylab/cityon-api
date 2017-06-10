package com.velo.cityon.api.vo;

public class GeoVO {
	
	public AddressVO address;
	
	public String adminCode1;
	public String distance;
	public String countryCode;
	public String countryName;
	public String adminName1;

	public AddressVO getAddress() {
		return address;
	}
	public void setAddress(AddressVO address) {
		this.address = address;
	}
	public String getAdminCode1() {
		return adminCode1;
	}
	public void setAdminCode1(String adminCode1) {
		this.adminCode1 = adminCode1;
	}
	public String getDistance() {
		return distance;
	}
	public void setDistance(String distance) {
		this.distance = distance;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public String getAdminName1() {
		return adminName1;
	}
	public void setAdminName1(String adminName1) {
		this.adminName1 = adminName1;
	}
}
