package com.gesila.test.guard.project.models.impl;

import java.util.List;

import com.gesila.test.guard.project.models.ITestGuardProjectContainerElement;
import com.gesila.test.guard.project.models.ITestGuardProjectElement;

/**
 * 
 * @author robin
 *
 */
public class TestGuardProject extends AbstractTestGuardProjectElement implements ITestGuardProjectContainerElement {

	public TestGuardProject() {

	}

	@Override
	public List<ITestGuardProjectElement> getElements() {
		return null;
	}

}
