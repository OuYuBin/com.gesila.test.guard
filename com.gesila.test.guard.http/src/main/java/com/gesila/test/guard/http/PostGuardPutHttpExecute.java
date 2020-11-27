package com.gesila.test.guard.http;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;

/**
 * 
 * @author robin
 *
 */
public class PostGuardPutHttpExecute extends AbstractPostGuardHttpExecute {

	public PostGuardPutHttpExecute(IPostGuardHttpClient commonHttpClient) {
		super(commonHttpClient);
	}

	@Override
	public HttpResponse execute() throws IOException, ClientProtocolException {
		String url = (String) commonHttpClient.getUrl();
		HttpPut httpPut = new HttpPut(url);
		// --设定请求链接超时时间和传输超时时间
		RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(30000).setConnectTimeout(20000).build();
		httpPut.setConfig(requestConfig);
		httpPut.addHeader("Content-Type", "application/json");
		Map<String, String> headerMap = commonHttpClient.getHeaderMap();
		for (Iterator<Map.Entry<String, String>> iter = headerMap.entrySet().iterator(); iter.hasNext();) {
			Map.Entry<String, String> entry = iter.next();
			httpPut.addHeader(entry.getKey(), entry.getValue());
		}
		PostGuardHttpClientContext ediHttpClientContext;
		if (PostGuardCookie.getInstance().getEdiHttpClientContext() != null) {
			ediHttpClientContext = PostGuardCookie.getInstance().getEdiHttpClientContext();
		} else {
			ediHttpClientContext = new PostGuardHttpClientContext();
		}
		HttpEntity httpEntity = commonHttpClient.getHttpEntity();
		if (httpEntity != null) {
			httpPut.setEntity(httpEntity);
		}
		String requestJSON = commonHttpClient.getRequestJSON();
		if (requestJSON != null) {
			StringEntity se = new StringEntity(requestJSON);
			httpPut.setEntity(se);
		}
		HttpResponse response = commonHttpClient.getHttpClient().execute(httpPut, ediHttpClientContext);
		return response;
	}
}
