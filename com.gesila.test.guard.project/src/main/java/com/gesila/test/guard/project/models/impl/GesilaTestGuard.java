package com.gesila.test.guard.project.models.impl;

import com.gesila.test.guard.project.models.IGesilaTestGuardProjectContainerElement;

/**
 * 
 * @author robin
 *
 */
public class GesilaTestGuard extends GesilaTestGuardProjectElementImpl {

	private String name;

	private String url;

	public GesilaTestGuard(IGesilaTestGuardProjectContainerElement parent) {
		super(parent);
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

	@Override
	public <T> T getAdapter(Class<T> adapter) {
		return super.getAdapter(adapter);
	}
	
	

}
