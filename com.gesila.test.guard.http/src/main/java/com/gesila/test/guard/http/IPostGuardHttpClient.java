package com.gesila.test.guard.http;

import java.io.Closeable;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;

/**
 * 
 * @author robin
 *
 */
public interface IPostGuardHttpClient extends Closeable {

	public static String GET_METHOD = "GET";

	public static String POST_METHOD = "POST";

	public static String METHOD_PUT = "PUT";

	public static String METHOD_DELETE = "DELETE";

	public Object getUrl();

	public HttpClient getHttpClient();

	public HttpEntity getHttpEntity();

	public String getRequestJSON();

	public String getRequestMethod();

	public Map<String, String> getHeaderMap();
	
	public boolean isClientVersionCheckEnabled();
}
