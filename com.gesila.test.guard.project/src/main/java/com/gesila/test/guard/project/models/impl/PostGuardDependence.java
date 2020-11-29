package com.gesila.test.guard.project.models.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;

import com.gesila.test.guard.project.models.IPostGuardProjectContainerElement;
import com.gesila.test.guard.project.models.IPostGuardProjectElement;

/**
 * 
 * @author robin
 *
 */
public class PostGuardDependence extends GesilaTestGuardProjectElementImpl implements IPostGuardProjectContainerElement{

	
	private List<IPostGuardProjectElement> elements = new ArrayList<IPostGuardProjectElement>();
	
	public PostGuardDependence(IPostGuardProjectContainerElement parent) {
		super(parent);
	}

	private String name;
	
	private String labelName;
	

	public String getLabelName() {
		return labelName;
	}

	public void setLabelName(String labelName) {
		this.labelName = labelName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public List<IPostGuardProjectElement> getElements(){
		if (elements.isEmpty()) {
			createElements();
		}
		syncElements();
		return elements;
	}
	
	private void syncElements() {
		File parentFile = getResource().getLocation().toFile();

		List<IPostGuardProjectElement> removeElements = new ArrayList<IPostGuardProjectElement>();
		for (IPostGuardProjectElement element : elements) {
			boolean removeElement = true;
			String name = element.getName();
			for (File file : parentFile.listFiles()) {
				if (name.equals(file.getName())) {
					removeElement = false;
					break;
				}
			}
			if (removeElement) {
				removeElements.add(element);
			}
		}
		elements.removeAll(removeElements);

		List<IPostGuardProjectElement> addElements = new ArrayList<IPostGuardProjectElement>();
		for (File file : parentFile.listFiles()) {
			boolean addElement = true;
			String name = file.getName();
			if (file.isFile() && !file.isHidden() && !name.equals(".project")) {
				for (IPostGuardProjectElement element : elements) {
					if (name.equals(element.getName())) {
						addElement = false;
						break;
					}
				}
				if (addElement) {
					PostGuardLibrary postGuradLibrary = new PostGuardLibrary(this);
					postGuradLibrary.setName(name);
					addElements.add(postGuradLibrary);
				}
			}
		}
		elements.addAll(addElements);
	}

	private void createElements() {
		File parentFile = getResource().getLocation().toFile();
		for (File file : parentFile.listFiles()) {
			String name = file.getName();
			if (file.isFile() && !file.isHidden()) {
				PostGuardLibrary postGuardLibrary = new PostGuardLibrary(this);
				postGuardLibrary.setName(name);
				elements.add(postGuardLibrary);
			}
		}

	}

	@Override
	public IResource getResource() {
		IPath path = getAdapter(IPath.class);
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		return root.getFile(path);
	}
}
