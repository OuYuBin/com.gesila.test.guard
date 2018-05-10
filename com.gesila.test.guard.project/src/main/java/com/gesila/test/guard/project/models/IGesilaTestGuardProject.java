package com.gesila.test.guard.project.models;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IAdaptable;

/**
 * 
 * @author robin
 *
 */
public interface IGesilaTestGuardProject extends IGesilaTestGuardProjectContainerElement{

	public IProject getProject();
}
