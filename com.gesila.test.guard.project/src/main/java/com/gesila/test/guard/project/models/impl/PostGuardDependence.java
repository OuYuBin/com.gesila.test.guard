package com.gesila.test.guard.project.models.impl;

import com.gesila.test.guard.project.models.IPostGuardProjectContainerElement;

/**
 * 
 * @author robin
 *
 */
public class PostGuardDependence extends GesilaTestGuardProjectElementImpl{

	public PostGuardDependence(IPostGuardProjectContainerElement parent) {
		super(parent);
	}

	private String name;
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


}
