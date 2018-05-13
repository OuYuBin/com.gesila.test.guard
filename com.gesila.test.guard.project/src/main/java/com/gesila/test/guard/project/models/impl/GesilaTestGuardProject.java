package com.gesila.test.guard.project.models.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.eclipse.core.resources.IProject;

import com.gesila.test.guard.project.models.IGesilaTestGuardProject;
import com.gesila.test.guard.project.models.IGesilaTestGuardProjectContainerElement;
import com.gesila.test.guard.project.models.IGesilaTestGuardProjectElement;

/**
 * 
 * @author robin
 *
 */
public class GesilaTestGuardProject extends AbstractGesilaTestGuardProjectElement implements IGesilaTestGuardProject {

	private IProject project;

	private List<IGesilaTestGuardProjectElement> elements = new ArrayList<IGesilaTestGuardProjectElement>();

	public GesilaTestGuardProject(IProject project) {
		this.project = project;
	}

	public String getName() {
		return project.getName();
	}

	@Override
	public List<IGesilaTestGuardProjectElement> getElements() {
		if (elements.isEmpty()) {
			createElements();
		}
		syncElements();
		return elements;
	}

	private void syncElements() {
		File parentFile = project.getLocation().toFile();

		// List<IGesilaTestGuardProjectElement> removeElements=new
		// ArrayList<IGesilaTestGuardProjectElement>();
		// for(File file:parentFile.listFiles()){
		// boolean removeElement=true;
		// String name = file.getName();
		// if (file.isFile() && !name.equals(".project")) {
		// for (IGesilaTestGuardProjectElement element : elements) {
		// if (name.equals(element.getName())) {
		// removeElement = false;
		// break;
		// }
		// }
		// if (removeElement) {
		// GesilaTestGuard gesilaTestGuard = new GesilaTestGuard(this);
		// gesilaTestGuard.setName(name);
		// removeElements.add(gesilaTestGuard);
		// }
		// }
		// }
		// elements.removeAll(removeElements);

		List<IGesilaTestGuardProjectElement> addElements = new ArrayList<IGesilaTestGuardProjectElement>();
		for (File file : parentFile.listFiles()) {
			boolean addElement = true;
			String fileName = file.getName();
			int i = fileName.lastIndexOf('.');
			if (i > 0 && i < fileName.length() - 1) {
				String desiredExtension = fileName.substring(i + 1).toLowerCase(Locale.ENGLISH);
				if (file.isFile() && desiredExtension.equals("gtg")) {
					for (IGesilaTestGuardProjectElement element : elements) {
						if (fileName.equals(element.getName())) {
							addElement = false;
							break;
						}
					}
					if (addElement) {
						GesilaTestGuard gesilaTestGuard = new GesilaTestGuard(this);
						gesilaTestGuard.setName(fileName);
						addElements.add(gesilaTestGuard);
					}
				}
			}
		}
		elements.addAll(addElements);
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
			String fileName = file.getName();
			int i = fileName.lastIndexOf('.');
			if (i > 0 && i < fileName.length() - 1) {
				String desiredExtension = fileName.substring(i + 1).toLowerCase(Locale.ENGLISH);
				if (file.isFile() && desiredExtension.equals("gtg")) {
					GesilaTestGuard gesilaTestGuard = new GesilaTestGuard(this);
					gesilaTestGuard.setName(fileName);
					elements.add(gesilaTestGuard);
				}
			}
		}

	}

	@Override
	public IGesilaTestGuardProjectContainerElement getParent() {
		return null;
	}

}
