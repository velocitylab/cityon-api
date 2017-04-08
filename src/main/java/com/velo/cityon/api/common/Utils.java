package com.velo.cityon.api.common;

import com.google.gson.Gson;

public class Utils {

	private static final Gson gson = new Gson();
	
	public static <T> T fromJson(String json, Class<T> classOfT){
		return gson.fromJson(json, classOfT);
	}

	public static String toJson(Object o){
		return gson.toJson(o);
	}

}
