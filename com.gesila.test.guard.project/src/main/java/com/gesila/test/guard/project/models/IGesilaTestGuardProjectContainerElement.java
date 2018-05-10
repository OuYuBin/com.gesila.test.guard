package com.gesila.test.guard.project.models;

import java.util.List;

/**
 * 
 * @author robin
 *
 */
public interface IGesilaTestGuardProjectContainerElement extends IGesilaTestGuardProjectElement {

	public List<IGesilaTestGuardProjectElement> getElements();
}
