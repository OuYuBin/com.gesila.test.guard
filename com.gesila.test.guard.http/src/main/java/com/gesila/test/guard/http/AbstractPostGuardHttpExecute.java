package com.gesila.test.guard.http;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;

/**
 * 
 * @author robin
 *
 */
public abstract class AbstractPostGuardHttpExecute implements IPostGuardHttpExecute {

	protected IPostGuardHttpClient commonHttpClient;
	

	public AbstractPostGuardHttpExecute(IPostGuardHttpClient commonHttpClient) {
		this.commonHttpClient = commonHttpClient;
	}

	public abstract HttpResponse execute() throws IOException, ClientProtocolException;

	protected void createCookieStore(PostGuardHttpClientContext clientContext) {
		PostGuardCookie.getInstance().createCookie(clientContext);
	}

	
}
