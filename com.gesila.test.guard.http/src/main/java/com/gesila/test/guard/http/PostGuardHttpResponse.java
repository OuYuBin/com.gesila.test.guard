package com.gesila.test.guard.http;

import org.apache.http.HttpResponse;

/**
 * 
 * @author robin
 *
 */
public class PostGuardHttpResponse {

	private HttpResponse httpResponse;

	private String strResponse;

	public PostGuardHttpResponse(HttpResponse httpResponse) {
		this.httpResponse = httpResponse;
	}

	public HttpResponse getHttpResponse() {
		return httpResponse;
	}

	public void setHttpResponse(HttpResponse httpResponse) {
		this.httpResponse = httpResponse;
	}

	public String getStrResponse() {
		return strResponse;
	}

	public void setStrResponse(String strResponse) {
		this.strResponse = strResponse;
	}

}
