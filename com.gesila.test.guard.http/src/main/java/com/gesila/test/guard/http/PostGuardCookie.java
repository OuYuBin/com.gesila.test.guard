package com.gesila.test.guard.http;

import org.apache.http.impl.client.BasicCookieStore;

/**
 * 
 * @author ouyubin
 *
 */
public class PostGuardCookie {

	public static PostGuardCookie INSTANCE = new PostGuardCookie();

	public static BasicCookieStore cookieStore = new BasicCookieStore();

	private PostGuardHttpClientContext ediHttpClientContext;
	private String user;

	private PostGuardCookie() {

	}

	public static PostGuardCookie getInstance() {
		return INSTANCE;
	}

	public synchronized void createCookie(PostGuardHttpClientContext ediHttpClientContext) {
		if (this.ediHttpClientContext == null) {
			this.ediHttpClientContext = ediHttpClientContext;
		}
	}
	
	public String getUser() {
		return user;
	}
	
	public void setUser(String currentUser) {
		this.user = currentUser;
	}

	public static BasicCookieStore getCookieStore() {
		return cookieStore;
	}
	
	public void reset() {
		this.ediHttpClientContext=null;
	}

	public PostGuardHttpClientContext getEdiHttpClientContext() {
		return ediHttpClientContext;
	}

}
