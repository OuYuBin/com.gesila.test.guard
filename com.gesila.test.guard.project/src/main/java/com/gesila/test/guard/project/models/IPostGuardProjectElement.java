package com.gesila.test.guard.project.models;

import org.eclipse.core.runtime.IAdaptable;

/**
 * 
 * @author robin
 *
 */
public interface IPostGuardProjectElement extends IAdaptable{

	public IPostGuardProjectContainerElement getParent();
	
	public String getName();
	
}
