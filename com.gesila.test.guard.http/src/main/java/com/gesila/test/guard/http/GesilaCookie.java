package com.gesila.test.guard.http;

import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.cookie.BasicClientCookie;

/**
 * 
 * @author robin
 *
 */
public class GesilaCookie {

	public static GesilaCookie INSTANCE = new GesilaCookie();

	public static BasicCookieStore cookieStore = new BasicCookieStore();

	public static GesilaHttpClientContext gesilaHttpClientContext;

	private GesilaCookie() {

	}

	public static GesilaCookie getInstance() {
		return INSTANCE;
	}

	public synchronized void createCookie(GesilaHttpClientContext gesilaHttpClientContext) {
		if (this.gesilaHttpClientContext == null) {
			this.gesilaHttpClientContext = gesilaHttpClientContext;
		}
	}

	public static BasicCookieStore getCookieStore() {
		return cookieStore;
	}

}
