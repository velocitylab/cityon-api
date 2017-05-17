package com.velo.cityon.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.velo.cityon.api.service.CityService;
import com.velo.cityon.api.vo.CityVO;
import com.velo.cityon.api.vo.rest.CitiesResponse;
import com.velo.cityon.api.vo.rest.CityResponse;

@RestController
@RequestMapping("/v1/city")
public class CityController {
	
	@Autowired
	private CityService cityService;
	
	@RequestMapping(value="/_hottest", method=RequestMethod.GET, produces={"application/json; charset=UTF-8"})
	@ResponseBody
    public CitiesResponse getHottestCities(
    		@RequestParam(value="lang", required=false) String lang,
    		@RequestParam(value="limit", required=false, defaultValue="10") Integer limit
    		) throws Exception {

		List<CityVO> cities = cityService.getHottestCities(lang, limit);

		CitiesResponse resp = new CitiesResponse();
		resp.setCities(cities);
		return resp;
    }
	
	@RequestMapping(value="/{cityId}", method=RequestMethod.GET, produces={"application/json; charset=UTF-8"})
	@ResponseBody
    public CityResponse getCity(@PathVariable(required=true) String cityId) throws Exception {

		CityVO city = cityService.getCity(cityId);

		CityResponse resp = new CityResponse();
		resp.setCity(city);
		return resp;
    }

}
