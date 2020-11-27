package com.gesila.test.guard.http;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.entity.StringEntity;

/**
 * 
 * @author robin
 *
 */
public class PostGuardDeleteHttpExecute extends AbstractPostGuardHttpExecute {

	public PostGuardDeleteHttpExecute(IPostGuardHttpClient commonHttpClient) {
		super(commonHttpClient);
	}

	@Override
	public HttpResponse execute() throws IOException, ClientProtocolException {
		String url = (String) commonHttpClient.getUrl();
		PostGuardHttpDeleteWithBody httpDelete = new PostGuardHttpDeleteWithBody(url);
//		httpDelete.addHeader(HTTP.CONTENT_TYPE, "application/json");
		Map<String, String> headerMap = commonHttpClient.getHeaderMap();
		for (Iterator<Map.Entry<String, String>> iter = headerMap.entrySet().iterator(); iter.hasNext();) {
			Map.Entry<String, String> entry = iter.next();
			httpDelete.addHeader(entry.getKey(), entry.getValue());
		}
		// --设定请求链接超时时间和传输超时时间
		RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(30000).setConnectTimeout(20000).build();
		httpDelete.setConfig(requestConfig);
		PostGuardHttpClientContext ediHttpClientContext;
		if (PostGuardCookie.getInstance().getEdiHttpClientContext() != null) {
			ediHttpClientContext = PostGuardCookie.getInstance().getEdiHttpClientContext();
		} else {
			ediHttpClientContext = new PostGuardHttpClientContext();
		}
		HttpEntity entity = commonHttpClient.getHttpEntity();
		if(entity != null) {
			httpDelete.setEntity(entity);
		}
		String requestJSON = commonHttpClient.getRequestJSON();
		if (requestJSON != null) {
			StringEntity stringEntity = new StringEntity(requestJSON);
			httpDelete.setEntity(stringEntity);
		}
		HttpResponse response = commonHttpClient.getHttpClient().execute(httpDelete, ediHttpClientContext);
		return response;
	}
}
