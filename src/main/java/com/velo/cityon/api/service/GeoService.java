package com.velo.cityon.api.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.springframework.stereotype.Service;

import com.velo.cityon.api.common.Constants;
import com.velo.cityon.api.common.Utils;
import com.velo.cityon.api.httpclient.PoolingConnectionManager;
import com.velo.cityon.api.vo.AddressVO;
import com.velo.cityon.api.vo.CityVO;
import com.velo.cityon.api.vo.GeoVO;

@Service
public class GeoService {
	
	public CityVO getOpenGeoInformation(String latString, String lngString, int type) throws Exception {
		float lat = 0l;
		float lng = 0l;
		try {
			lat = Float.parseFloat(latString);
			lng = Float.parseFloat(lngString);
		} catch (NumberFormatException e) {
			System.out.println("latlng '" + latString + ", " + lngString+ "' parsing failed.");
			return null;
		}
		
		PoolingConnectionManager cm = new PoolingConnectionManager();
		CloseableHttpClient client = cm.getHttpClient();

		String url = "";
		if(type==2){
			url = Constants.OpenStreetmapUri;
			url = url + "&lat=" + Float.toString(lat) + "&lon=" + Float.toString(lng);

		}else{
			url = Constants.GeonamesUri;
			url = url + "&lat=" + Float.toString(lat) + "&lng=" + Float.toString(lng);
		}
		HttpGet request = new HttpGet(url);
		HttpResponse response = client.execute(request);
		
		System.out.println("Response Code : " + response.getStatusLine().getStatusCode());

		BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent(),"UTF-8"));

		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}

		System.out.println("Response Body : " + result.toString());
		GeoVO geoVo = Utils.fromJson(result.toString(), GeoVO.class);
		CityVO cityVO = new CityVO();

		if(type==2){
			cityVO.setCountryCode(geoVo.getAddress().getCountry_code());
			cityVO.setName(geoVo.getAddress().getCity());
		}else{
			cityVO.setCountryCode(geoVo.getCountryCode());
			cityVO.setName(geoVo.getAdminName1());
		}
		return cityVO;
	}
}
