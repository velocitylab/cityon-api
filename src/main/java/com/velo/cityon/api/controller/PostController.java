package com.velo.cityon.api.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.velo.cityon.api.service.PostService;
import com.velo.cityon.api.vo.AddressVO;
import com.velo.cityon.api.vo.GeoVO;

@RestController
@RequestMapping("/v1/post")
public class PostController {
	
	@Autowired
	private PostService postService;
	

	@RequestMapping("/hello")
    public String hello() {
        return "Hello World!";
    }

	@ResponseBody
    @RequestMapping(value="/geo", method = RequestMethod.GET, produces={"application/json; charset=UTF-8"})
    public AddressVO openstreet(
    		@RequestParam(value = "lat", required = true) String lat,
    		@RequestParam(value = "lng", required = true) String lng, 
    		HttpServletRequest request, HttpServletResponse response) throws Exception {
    		
		AddressVO address = postService.getOpenGeoInformation(lat, lng);
    	return address;
    }

}
