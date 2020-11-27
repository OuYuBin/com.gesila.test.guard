package com.gesila.test.guard.common.editor.models;

import com.gesila.test.guard.model.testGuard.TestGuard;

/**
 * 
 * @author robin
 *
 */
public class GesilaTestGuard {

	private String method;

	private String http;

	private String url;
	
	public GesilaTestGuard(TestGuard testGuard) {
		super();
		this.method=testGuard.getMethod();
		this.url=testGuard.getUrl();
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getHttp() {
		return http;
	}

	public void setHttp(String http) {
		this.http = http;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
