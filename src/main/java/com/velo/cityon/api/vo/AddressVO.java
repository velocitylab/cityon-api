package com.velo.cityon.api.vo;

public class AddressVO {

	public String country;
	public String city;
	public String country_code;
	public String getCountry() {
		return country;
	}
	public String getCountry_code() {
		return country_code;
	}
	public void setCountry_code(String country_code) {
		this.country_code = country_code;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
}
