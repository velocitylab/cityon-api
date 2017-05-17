package com.velo.cityon.api.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.velo.cityon.api.repository.CityRepository;
import com.velo.cityon.api.vo.CityVO;

@Service
public class CityService {

	@Autowired
	CityRepository cityRepository;

	public List<CityVO> getHottestCities(String lang, Integer limit) throws Exception {
		List<CityVO> cities = null;
		PageRequest pr = new PageRequest(0, limit, new Sort(Sort.Direction.DESC, "population"));
		if(lang == null) {
			cities = cityRepository.findWithoutAltname(pr).getContent();
		}
		else {
			cities = cityRepository.findAll(pr).getContent();
			for(CityVO city: cities) {
				Map<String, String> altname = new HashMap<String, String>();
				if(city.getAltname().get(lang) != null) {
					altname.put(lang, city.getAltname().get(lang));
				}
				city.setAltname(altname);
			}
		}
		return cities;
	}
	
	public CityVO getCity(String cityId) throws Exception {
		return cityRepository.findOne(cityId);
	}
}
