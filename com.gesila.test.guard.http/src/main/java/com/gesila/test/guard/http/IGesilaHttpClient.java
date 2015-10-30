package com.gesila.test.guard.http;

import org.apache.http.client.HttpClient;

import com.gesila.test.guard.model.testGuard.RequestMethod;

/**
 * 
 * @author robin
 *
 */
public interface IGesilaHttpClient {

	public Object getUrl();

	public HttpClient getHttpClient();
	
	public RequestMethod getRequestMethod();
	
	public String getRequestJSON();

}
