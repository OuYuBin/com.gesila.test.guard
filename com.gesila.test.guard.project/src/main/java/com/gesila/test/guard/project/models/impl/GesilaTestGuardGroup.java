package com.gesila.test.guard.project.models.impl;

import java.util.List;

/**
 * @author robin
 */

import com.gesila.test.guard.project.models.IGesilaTestGuardProjectContainerElement;
import com.gesila.test.guard.project.models.IGesilaTestGuardProjectElement;

public class GesilaTestGuardGroup implements IGesilaTestGuardProjectContainerElement {

	@Override
	public <T> T getAdapter(Class<T> adapter) {
		return null;
	}

	@Override
	public List<IGesilaTestGuardProjectElement> getElements() {
		return null;
	}

}
