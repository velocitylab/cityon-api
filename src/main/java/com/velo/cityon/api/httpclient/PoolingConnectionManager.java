package com.velo.cityon.api.httpclient;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

public class PoolingConnectionManager {

	PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();

	public PoolingConnectionManager(){
		
		// Increase max total connection to 200
		cm.setMaxTotal(200);
		// Increase default max connection per route to 20
		cm.setDefaultMaxPerRoute(20);
		// Increase max connections for localhost:80 to 50
	}
	
	public CloseableHttpClient getHttpClient(){
		CloseableHttpClient httpClient = HttpClients.custom()
		        .setConnectionManager(cm)
		        .build();
		return httpClient;
	}
	
}
