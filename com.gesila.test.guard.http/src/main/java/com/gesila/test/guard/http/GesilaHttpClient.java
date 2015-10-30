package com.gesila.test.guard.http;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import com.gesila.test.guard.model.testGuard.RequestMethod;

/**
 * 
 * 
 * @author robin
 *
 */
public class GesilaHttpClient implements IGesilaHttpClient {

	// private HttpClient httpClient;

	private Object url;

	private RequestMethod requestMethod;

	private String requestJSON;

	private CloseableHttpClient httpClient = HttpClients.createDefault();

	public GesilaHttpClient(Object url) {
		this(url, RequestMethod.POST);
	}

	public GesilaHttpClient(Object url, RequestMethod requestMethod) {
		this.url = url;
		this.requestMethod = requestMethod;
	}

	public HttpClient getHttpClient() {
		return httpClient;
	}

	public Object getUrl() {
		return url;
	}

	public void setUrl(Object url) {
		this.url = url;
	}

	public RequestMethod getRequestMethod() {
		return requestMethod;
	}

	public void setRequestMethod(RequestMethod requestMethod) {
		this.requestMethod = requestMethod;
	}

	public String getRequestJSON() {
		return requestJSON;
	}

	public void setRequestJSON(String requestJSON) {
		this.requestJSON = requestJSON;
	}

}
