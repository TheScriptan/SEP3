package com.bl.utils;

import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Utils {
	private static Utils utilsInstance = null;
	private GsonBuilder builder;
	private Gson gson;
	
	private Utils() {
		builder = new GsonBuilder();
		builder.setPrettyPrinting();
		gson = builder.create();
	}
	
	public static String serializeObject(Object object) {
		return getInstance().gson.toJson(object);
	}
	
	public static Object deserializeObject(String json, Class<?> classType) {
		Object object = (Object) getInstance().gson.fromJson(json, classType);
		return object;
	}
	
	public static <T> List<T> deserializeList(String json, Class<T[]> clazz){
		T[] arr = getInstance().gson.fromJson(json, clazz);
		return Arrays.asList(arr);
	}
	
	public static Utils getInstance() {
		if(utilsInstance == null) {
			utilsInstance = new Utils();
		}
		
		return utilsInstance;
	}
}