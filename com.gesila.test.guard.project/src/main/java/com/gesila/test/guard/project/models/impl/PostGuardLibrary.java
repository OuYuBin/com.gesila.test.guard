package com.gesila.test.guard.project.models.impl;

import com.gesila.test.guard.project.models.IPostGuardProjectContainerElement;

/**
 * 
 * @author robin
 *
 */
public class PostGuardLibrary extends GesilaTestGuardProjectElementImpl{

	public PostGuardLibrary(IPostGuardProjectContainerElement parent) {
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
