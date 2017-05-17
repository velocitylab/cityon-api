package com.velo.cityon.api.vo.rest;

import com.velo.cityon.api.vo.CityVO;

public class CityResponse extends Response {
	private CityVO city;

	public CityVO getCity() {
		return city;
	}
	public void setCity(CityVO city) {
		this.city = city;
	}
}
