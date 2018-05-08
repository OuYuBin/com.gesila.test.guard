package com.gesila.test.guard.project.models.impl;

import java.util.List;

/**
 * @author robin
 */

import com.gesila.test.guard.project.models.ITestGuardProjectContainerElement;
import com.gesila.test.guard.project.models.ITestGuardProjectElement;

public class GesilaTestGuardGroup implements ITestGuardProjectContainerElement {

	@Override
	public <T> T getAdapter(Class<T> adapter) {
		return null;
	}

	@Override
	public List<ITestGuardProjectElement> getElements() {
		return null;
	}

}
