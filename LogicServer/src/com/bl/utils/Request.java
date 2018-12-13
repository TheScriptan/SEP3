package com.bl.utils;


public class Request {
	private String requestCode;
	private String[] arguments;
	
	public Request(String requestCode, String[] arguments) {
		this.requestCode = requestCode;
		this.arguments = arguments;
	}

	public String getRequestCode() {
		return requestCode;
	}

	public String[] getArguments() {
		return arguments;
	}
}
