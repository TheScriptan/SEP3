package com.bl.utils;


public class Response {
	private String responseCode;
	private String[] arguments;
	
	public Response(String responseCode, String[] arguments) {
		this.responseCode = responseCode;
		this.arguments = arguments;
	}

	public String getResponseCode() {
		return responseCode;
	}

	public String[] getArguments() {
		return arguments;
	}
}
