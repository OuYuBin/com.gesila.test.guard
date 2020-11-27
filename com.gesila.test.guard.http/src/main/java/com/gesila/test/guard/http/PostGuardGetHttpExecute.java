package com.gesila.test.guard.http;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;

/**
 * 
 * @author robin
 *
 */
public class PostGuardGetHttpExecute extends AbstractPostGuardHttpExecute {

	public PostGuardGetHttpExecute(IPostGuardHttpClient commonHttpClient) {
		super(commonHttpClient);
	}

	public HttpResponse execute() throws IOException, ClientProtocolException {
		String url = (String) commonHttpClient.getUrl();
		HttpGet httpGet = new HttpGet(url);
		RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(30000).setConnectTimeout(20000).build();
		httpGet.setConfig(requestConfig);

		httpGet.addHeader("User-Agent",
				"Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:50.0) Gecko/20100101 Firefox/50.0");
		Map<String, String> headerMap = commonHttpClient.getHeaderMap();
		for (Iterator<Map.Entry<String, String>> iter = headerMap.entrySet().iterator(); iter.hasNext();) {
			Map.Entry<String, String> entry = iter.next();
			httpGet.addHeader(entry.getKey(), entry.getValue());
		}
		PostGuardHttpClientContext ediHttpClientContext;
		if (PostGuardCookie.getInstance().getEdiHttpClientContext() != null) {
			ediHttpClientContext = PostGuardCookie.getInstance().getEdiHttpClientContext();
		} else {
			ediHttpClientContext = new PostGuardHttpClientContext();
		}
		HttpResponse response = commonHttpClient.getHttpClient().execute(httpGet, ediHttpClientContext);
		return response;
	}
}
