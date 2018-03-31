package com.gesila.test.guard.project.models;

import java.util.List;

/**
 * 
 * @author robin
 *
 */
public interface ITestGuardProjectContainerElement extends ITestGuardProjectElement {

	public List<ITestGuardProjectElement> getElements();
}
