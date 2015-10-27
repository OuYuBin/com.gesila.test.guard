package com.gesila.test.guard.http;

import org.apache.http.client.HttpClient;

/**
 * 
 * @author robin
 *
 */
public interface IGesilaHttpClient {

	public Object getUrl();

	public HttpClient getHttpClient();
	
	public RequestType getRequestType();
	
	public String getRequestJSON();

}
