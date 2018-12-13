package com.bl.utils;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.bl.utils.Request;
import com.bl.utils.Response;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Utils {
	
	public enum Requests{
		//General requests
		LOGIN,
		
		//Employee requests
		ADD_SHIFT, EDIT_SHIFT, REMOVE_SHIFT, ASSIGN_SHIFT, RELEASE_SHIFT, FIND_SHIFT, FIND_ALL_SHIFTS,
		ADD_STUDENT, EDIT_STUDENT, REMOVE_STUDENT, FIND_STUDENT, FIND_ALL_STUDENTS,
		ADD_COMPANY, EDIT_COMPANY, REMOVE_COMPANY, FIND_COMPANY, FIND_ALL_COMPANIES, 
		ADD_EMPLOYEE, EDIT_EMPLOYEE, REMOVE_EMPLOYEE, FIND_EMPLOYEE, FIND_ALL_EMPLOYEES,
		
		//Student requests
		REGISTER, EDIT_INFO, TAKE_SHIFT,
		REPORT_SICKNESS, CHECK_WORKED_HOURS,
		CREATE_SCHEDULE
	}
	
	public enum Responses{
		LOGIN_VALID, LOGIN_INVALID,
		OBJECT_RETRIEVED, OBJECT_ADDED, OBJECT_EDITED, OBJECT_DELETED,
		OBJECT_NOT_RETRIEVED, OBJECT_NOT_ADDED, OBJECT_NOT_EDITED, OBJECT_NOT_DELETED,
		SHIFT_ASSIGNED, SHIFT_UNASSIGNED, SHIFT_RELEASED, SHIFT_UNRELEASED,
		REGISTER_VALID, REGISTER_INVALID, 
		INFO_EDITED, INFO_NOT_EDITED,
		SHIFT_TAKEN, SHIFT_NOT_TAKEN,
		SICKNESS_REPORTED, SICKNESS_NOT_REPORTED, 
		HOURS_CHECKED, HOURS_NOT_CHECKED,
		SCHEDULE_CREATED, SCHEDULE_NOT_CREATED
		
	}
	
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
	//out = for sending out a request; requestCode to determine what kind of action client requests, arguments = specific arguments for the system
	@SuppressWarnings("unchecked")
	public static void SendRequest(DataOutputStream dos, Requests requestCode, String ... arguments) {
		JSONObject obj = new JSONObject();
		obj.put("request-code", requestCode.toString());
		JSONArray list = new JSONArray();
		for(String arg : arguments) {
			list.add(arg);
		}
		obj.put("arguments", list);
		try {
			byte[] b = obj.toString().getBytes(StandardCharsets.UTF_8);
			dos.writeInt(b.length);
			dos.write(b);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//in = to read the request over the internet; requestCode = expected request code; returns array of arguments
	@SuppressWarnings("unchecked")
	public static Request AcceptRequest(DataInputStream dis) {
		try {
			JSONParser parser = new JSONParser();
			int byteSize = dis.readInt();
			byte[] b = new byte[byteSize];
			dis.readFully(b);
			String json = new String(b, StandardCharsets.UTF_8);
			Object obj = parser.parse(json);													//Reading JSONObject String and putting it to object
			JSONObject jsonObject = (JSONObject) obj;											//Converting obj to JSONObject
			String requestCode = (String) jsonObject.get("request-code");						//Acquiring request-code from JSONObject
			JSONArray msg = (JSONArray) jsonObject.get("arguments");							//Acquiring array of arguments from JSONObject
			String[] arguments = new String[msg.size()];										//Preparing arguments array for return;
			
			
				
			Iterator<String> iterator = msg.iterator();											//Iterating through JSONArray to fill arguments array
			int i = 0;
			while(iterator.hasNext()) {
				arguments[i] = iterator.next();
				i++;
			}
			
			return new Request(requestCode, arguments);											//Creating request object and returning it
		} catch(Exception e) {
			//e.printStackTrace();
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void SendResponse(DataOutputStream dos, Responses responseCode, String ... arguments) {
		try {
			JSONObject obj = new JSONObject();
			obj.put("request-code", responseCode.toString());
			JSONArray list = new JSONArray();
			for(String arg : arguments) {
				list.add(arg);
			}
			obj.put("arguments", list);
			try {
				byte[] b = obj.toString().getBytes(StandardCharsets.UTF_8);
				dos.writeInt(b.length);
				dos.write(b);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public static Response AcceptResponse(DataInputStream dis) {
		try {
			JSONParser parser = new JSONParser();
			int byteSize = dis.readInt();
			byte[] b = new byte[byteSize];
			dis.readFully(b);
			String json = new String(b, StandardCharsets.UTF_8);
			Object obj = parser.parse(json);																//Reading JSONObject String and putting it to object
			JSONObject jsonObject = (JSONObject) obj;											//Converting obj to JSONObject
			String requestCode = (String) jsonObject.get("request-code");						//Acquiring request-code from JSONObject
			JSONArray msg = (JSONArray) jsonObject.get("arguments");							//Acquiring array of arguments from JSONObject
			String[] arguments = new String[msg.size()];										//Preparing arguments array for return;
			
			
				
			Iterator<String> iterator = msg.iterator();											//Iterating through JSONArray to fill arguments array
			int i = 0;
			while(iterator.hasNext()) {
				arguments[i] = iterator.next();
				i++;
			}
			
			return new Response(requestCode, arguments);										//Creating request object and returning it
		} catch(Exception e) {
			//e.printStackTrace();
			return null;
		}
	}
}
