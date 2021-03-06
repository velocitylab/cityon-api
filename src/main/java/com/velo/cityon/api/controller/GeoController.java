package com.velo.cityon.api.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.velo.cityon.api.service.GeoService;
import com.velo.cityon.api.vo.CityVO;

@RestController
@RequestMapping("/v1/geo")
public class GeoController {
	
	@Autowired
	private GeoService geoService;
	
    @RequestMapping(value="/address", method = RequestMethod.GET, produces={"application/json; charset=UTF-8"})
    public CityVO openstreet(
    		@RequestParam(value = "lat", required = true) String lat,
    		@RequestParam(value = "lng", required = true) String lng,
    		@RequestParam(value = "type", required = false, defaultValue="1") Integer type,
    		HttpServletRequest request, HttpServletResponse response) throws Exception {
    		
		CityVO city = geoService.getOpenGeoInformation(lat, lng, type);
    	return city;
    }

}
