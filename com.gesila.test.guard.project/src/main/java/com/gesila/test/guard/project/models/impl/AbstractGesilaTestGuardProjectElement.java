package com.gesila.test.guard.project.models.impl;

import org.eclipse.core.runtime.IPath;

import com.gesila.test.guard.project.models.IGesilaTestGuardProject;
import com.gesila.test.guard.project.models.IPostGuardProjectContainerElement;
import com.gesila.test.guard.project.models.IPostGuardProjectElement;

/**
 * 
 * @author robin
 *
 */
public abstract class AbstractGesilaTestGuardProjectElement implements IPostGuardProjectElement{

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
		}else if(this instanceof IPostGuardProjectElement){
			object=((IPostGuardProjectElement)this).getParent().getAdapter(IPath.class);
			if(object!=null){
				object=((IPath)object).append(getName());
			}
		}
		return object;
	}

	public abstract IPostGuardProjectContainerElement getParent();
}
