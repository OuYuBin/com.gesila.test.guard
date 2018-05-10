package com.gesila.test.guard.project.models.impl;

import org.eclipse.core.runtime.IPath;

import com.gesila.test.guard.project.models.IGesilaTestGuardProject;
import com.gesila.test.guard.project.models.IGesilaTestGuardProjectContainerElement;
import com.gesila.test.guard.project.models.IGesilaTestGuardProjectElement;

/**
 * 
 * @author robin
 *
 */
public abstract class AbstractGesilaTestGuardProjectElement implements IGesilaTestGuardProjectElement{

	@Override
	public <T> T getAdapter(Class<T> adapter) {
		if(adapter==IPath.class){
			return (T) createResourcePath();
		}
		return null;
	}
	
	private Object createResourcePath(){
		Object object=null;
		if(this instanceof IGesilaTestGuardProject){
			object=((IGesilaTestGuardProject)this).getProject().getFullPath();
		}
		return object;
	}

	public abstract IGesilaTestGuardProjectContainerElement getParent();
}
