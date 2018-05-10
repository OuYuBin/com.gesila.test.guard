package com.gesila.test.guard.project.models.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;

import com.gesila.test.guard.project.models.IGesilaTestGuardProject;
import com.gesila.test.guard.project.models.IGesilaTestGuardProjectElement;

/**
 * 
 * @author robin
 *
 */
public class GesilaTestGuardProject extends AbstractGesilaTestGuardProjectElement implements IGesilaTestGuardProject {

	IProject project;

	private List<IGesilaTestGuardProjectElement> elements = new ArrayList<IGesilaTestGuardProjectElement>();

	public GesilaTestGuardProject(IProject project) {
		this.project = project;
	}

	public String getName() {
		return project.getName();
	}

	@Override
	public List<IGesilaTestGuardProjectElement> getElements() {
		if (elements.isEmpty())
			createElements();

		return elements;
	}

	public <T> T getAdapter(Class<T> adapter) {
		return super.getAdapter(adapter);
	}

	@Override
	public IProject getProject() {
		return project;
	}

	private void createElements() {
		File parentFile = project.getLocation().toFile();
		for (File file : parentFile.listFiles()) {
			String name = file.getName();
			if (file.isFile() && !name.equals(".project")) {
				GesilaTestGuard gesilaTestGuard = new GesilaTestGuard();
				gesilaTestGuard.setName(name);
				elements.add(gesilaTestGuard);
			}
		}

	}

}
