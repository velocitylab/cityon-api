package com.velo.cityon.api.vo.rest;

import java.util.List;

import com.velo.cityon.api.vo.CityVO;

public class CitiesResponse extends Response {
	private List<CityVO> cities;

	public List<CityVO> getCities() {
		return cities;
	}
	public void setCities(List<CityVO> cities) {
		this.cities = cities;
	}
}
