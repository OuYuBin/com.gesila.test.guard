package com.gesila.test.guard.project.models;

import org.eclipse.core.runtime.IAdaptable;

/**
 * 
 * @author robin
 *
 */
public interface ITestGuardProjectElement extends IAdaptable{

	@Override
	default <T> T getAdapter(Class<T> adapter) {
		// TODO Auto-generated method stub
		return null;
	}

}
