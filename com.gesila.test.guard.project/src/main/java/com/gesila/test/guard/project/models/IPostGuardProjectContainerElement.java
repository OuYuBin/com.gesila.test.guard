package com.gesila.test.guard.project.models;

import java.util.List;

import org.eclipse.core.resources.IResource;

/**
 * 
 * @author robin
 *
 */
public interface IPostGuardProjectContainerElement extends IPostGuardProjectElement {

	public List<IPostGuardProjectElement> getElements();
	
	public IResource getResource();
	
	
}
