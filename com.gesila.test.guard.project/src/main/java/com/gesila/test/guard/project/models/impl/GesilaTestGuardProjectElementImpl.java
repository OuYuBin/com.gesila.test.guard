package com.gesila.test.guard.project.models.impl;

import com.gesila.test.guard.project.models.IGesilaTestGuardProjectContainerElement;

/**
 * 
 * @author robin
 *
 */
public class GesilaTestGuardProjectElementImpl extends AbstractGesilaTestGuardProjectElement{

	private IGesilaTestGuardProjectContainerElement parent;
	
	public GesilaTestGuardProjectElementImpl(IGesilaTestGuardProjectContainerElement parent){
		this.parent=parent;
	}

	public IGesilaTestGuardProjectContainerElement getParent() {
		return parent;
	}

	public void setParent(IGesilaTestGuardProjectContainerElement parent) {
		this.parent = parent;
	}

	@Override
	public String getName() {
		return null;
	}
}
