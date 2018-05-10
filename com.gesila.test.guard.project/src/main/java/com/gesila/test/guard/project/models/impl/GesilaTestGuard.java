package com.gesila.test.guard.project.models.impl;

import com.gesila.test.guard.project.models.IGesilaTestGuardProjectElement;

/**
 * 
 * @author robin
 *
 */
public class GesilaTestGuard extends GesilaTestGuardProjectElementImpl implements IGesilaTestGuardProjectElement {

	private String name;

	private String url;

	public GesilaTestGuard() {
		super();
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

}
