package com.gesila.test.guard.http;

import java.net.URI;

import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;

/**
 * 
 * @author ouyubin
 *
 */
public class PostGuardHttpDeleteWithBody extends HttpEntityEnclosingRequestBase {

	public static final String METHOD_NAME = "DELETE";

	public String getMethod() {
		return METHOD_NAME;
	}

	public PostGuardHttpDeleteWithBody(final String uri) {
		super();
		setURI(URI.create(uri));
	}

	public PostGuardHttpDeleteWithBody(final URI uri) {
		super();
		setURI(uri);
	}

	public PostGuardHttpDeleteWithBody() {
		super();
	}

}
