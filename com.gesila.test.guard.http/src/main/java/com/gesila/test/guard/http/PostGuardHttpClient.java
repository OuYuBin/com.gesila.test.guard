package com.gesila.test.guard.http;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultRedirectStrategy;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;

/**
 * 
 * 
 * @author robin
 *
 */
public class PostGuardHttpClient implements IPostGuardHttpClient {


	private Object url;

	private String requestJSON;

	private String requestMethod;

	private HttpEntity httpEntity;

	private Map<String, String> headerMap = new HashMap<String, String>();

	private CloseableHttpClient httpClient;

	private boolean redirectEnabled = true;
	private boolean clientVersionCheckEnabled = true;

	class EdiRedirectStrategy extends DefaultRedirectStrategy {
		private String[] REDIRECT_METHODS = new String[] { HttpGet.METHOD_NAME, HttpPost.METHOD_NAME,
				HttpHead.METHOD_NAME };

		@Override
		protected boolean isRedirectable(String method) {
			for (String m : REDIRECT_METHODS) {
				if (m.equalsIgnoreCase(method)) {
					return true;
				}
			}
			return false;
		}
	}

	public PostGuardHttpClient() {
		this(null);
	}

	public PostGuardHttpClient(Object url) {
		this(url, "GET");
	}

	public PostGuardHttpClient(Object url, String requestMethod) {
		this.url = url;
		this.requestMethod = requestMethod;
		setRedirectEnabled(false);
	}

	/**
	 * 带URL重组参数的请求,处理参数中包含特殊字符的情况,比如商家名称为C&M
	 * 
	 * @param requestMethod
	 * @param baseUrl
	 * @param parameters
	 */
	public PostGuardHttpClient(String baseUrl, String requestMethod, String... parameters) {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append(baseUrl);
		stringBuffer.append("?");
		if (parameters != null) {
			int i = 0;
			for (String parameter : parameters) {
				if (i % 2 != 0) {
					stringBuffer.append(encodeParameter(parameter));
					stringBuffer.append("&");
				} else {
					stringBuffer.append(parameter);
					stringBuffer.append("=");
				}
				i++;
			}
		}
		this.url = stringBuffer.toString().substring(0, stringBuffer.toString().length() - 1);
		this.requestMethod = requestMethod;
	}

	private String encodeParameter(String parameter) {
		try {
			return URLEncoder.encode(parameter, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;

	}

	public HttpClient getHttpClient() {
		if (httpClient == null) {
			HttpClientBuilder builder = HttpClients.custom();
//			if (redirectEnabled) {
//				builder.setRedirectStrategy(new EdiRedirectStrategy());
//			} else {
//				builder.disableRedirectHandling();
//			}
			httpClient = builder.build();
		}
		return httpClient;
	}

	public Object getUrl() {
		return url;
	}

	public void setUrl(Object url) {
		this.url = url;
	}

	public String getRequestJSON() {
		return requestJSON;
	}

	public void setRequestJSON(String requestJSON) {
		this.requestJSON = requestJSON;
	}

	public String getRequestMethod() {
		return requestMethod;
	}

	public void setRequestMethod(String requestMethod) {
		this.requestMethod = requestMethod;
	}

	public HttpEntity getHttpEntity() {
		return httpEntity;
	}

	public void setHttpEntity(HttpEntity httpEntity) {
		this.httpEntity = httpEntity;
	}

	public Map<String, String> getHeaderMap() {
		if (headerMap == null) {
			headerMap = new HashMap<String, String>();
		}
		if (clientVersionCheckEnabled) {
			// headerMap.put("clientType", clientType);
			// headerMap.put("clientVersion", clientVersion);
		}
		return headerMap;
	}

	public void setHeaderMap(Map<String, String> headerMap) {
		this.headerMap = headerMap;
	}

	public void setRedirectEnabled(boolean enabled) {
		if (this.redirectEnabled == enabled) {
			return;
		}
		this.redirectEnabled = enabled;
		this.httpClient = null;
	}

	public void setClientVersionCheckEnabled(boolean enabled) {
		if (this.clientVersionCheckEnabled == enabled) {
			return;
		}
		this.clientVersionCheckEnabled = enabled;
	}

	@Override
	public boolean isClientVersionCheckEnabled() {
		return clientVersionCheckEnabled;
	}

	public void close() throws IOException {
		if (httpClient != null) {
			httpClient.close();
		}
	}
}
