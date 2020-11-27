package com.gesila.test.guard.project.models.impl;

import com.gesila.test.guard.project.models.IPostGuardProjectContainerElement;

/**
 * 
 * @author robin
 *
 */
public class GesilaTestGuardProjectElementImpl extends AbstractGesilaTestGuardProjectElement{

	private IPostGuardProjectContainerElement parent;
	
	public GesilaTestGuardProjectElementImpl(IPostGuardProjectContainerElement parent){
		this.parent=parent;
	}

	public IPostGuardProjectContainerElement getParent() {
		return parent;
	}

	public void setParent(IPostGuardProjectContainerElement parent) {
		this.parent = parent;
	}

	@Override
	public String getName() {
		return null;
	}
}
