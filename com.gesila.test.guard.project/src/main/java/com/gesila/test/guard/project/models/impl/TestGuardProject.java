package com.gesila.test.guard.project.models.impl;

import java.util.List;

import org.eclipse.core.resources.IProject;

import com.gesila.test.guard.project.models.ITestGuardProjectContainerElement;
import com.gesila.test.guard.project.models.ITestGuardProjectElement;

/**
 * 
 * @author robin
 *
 */
public class TestGuardProject extends AbstractTestGuardProjectElement implements ITestGuardProjectContainerElement {

	IProject project;
	
	
	public TestGuardProject(IProject project) {
		this.project=project;	
	}
	
	public String getName() {
		return project.getName();
	}

	@Override
	public List<ITestGuardProjectElement> getElements() {
		return null;
	}

}
