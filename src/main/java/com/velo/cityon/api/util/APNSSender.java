package com.velo.cityon.api.util;

import com.notnoop.apns.APNS;
import com.notnoop.apns.ApnsService;

public class APNSSender {


	private String devCert ="/path/to/cert/cert.p12";

	public void sendApnsChat(String token, String msg, String customMessage) {
		
		try{
			//Setup the connection
			ApnsService service =
				    APNS.newService()
				    .withCert(devCert, "cityon2017!")
				    .withSandboxDestination()		//dev
//				    .withProductionDestination()	//prd
				    .build();
			
			String payload = APNS.newPayload().alertBody(msg).customField("customMessage",customMessage)
					.customField("customMessage",customMessage)
					.customField("customMessage",customMessage)
					.sound("default")
					.build();
			service.push(token, payload);
		}catch(Exception e){
			throw e;
		}
	}
	
}
