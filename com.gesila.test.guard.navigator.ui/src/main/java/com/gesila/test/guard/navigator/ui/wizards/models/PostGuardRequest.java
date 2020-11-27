package com.gesila.test.guard.navigator.ui.wizards.models;

/**
 * 
 * @author robin
 *
 */
public class PostGuardRequest {

	private String name;
	
	private String url;
	
	private String desc;
	
	private String method;
	
	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getDesc() {
		return desc;
	}
	
	public void setDesc(String desc) {
		this.desc=desc;
	}
}
