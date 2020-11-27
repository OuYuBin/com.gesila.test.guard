package com.gesila.test.guard.http.models;

/**
 * 
 * @author robin
 *
 */
public class PostResponseInfo {

	int statusCode;

	String responseInfo;

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getResponseInfo() {
		return responseInfo;
	}

	public void setResponseInfo(String responseInfo) {
		this.responseInfo = responseInfo;
	}

}
