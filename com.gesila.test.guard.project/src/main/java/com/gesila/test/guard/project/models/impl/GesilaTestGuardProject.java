package com.gesila.test.guard.project.models.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;

import com.gesila.test.guard.project.models.IGesilaTestGuardProject;
import com.gesila.test.guard.project.models.IPostGuardProjectContainerElement;
import com.gesila.test.guard.project.models.IPostGuardProjectElement;

/**
 * 
 * @author robin
 *
 */
public class GesilaTestGuardProject extends AbstractGesilaTestGuardProjectElement implements IGesilaTestGuardProject {

	private IProject project;

	private List<IPostGuardProjectElement> elements = new ArrayList<IPostGuardProjectElement>();

	public GesilaTestGuardProject(IProject project) {
		this.project = project;
	}

	public String getName() {
		return project.getName();
	}

	@Override
	public List<IPostGuardProjectElement> getElements() {
		if (elements.isEmpty()) {
			createElements();
		}
		try {
			syncElements();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return elements;
	}

	private void syncElements() throws IOException {
		File parentFile = project.getLocation().toFile();

		List<IPostGuardProjectElement> removeElements = new ArrayList<IPostGuardProjectElement>();
		for (File file : parentFile.listFiles()) {
			boolean removeElement = true;
			String name = file.getName();
			if (file.isFile() && !file.isHidden() && !name.equals(".project")) {
				for (IPostGuardProjectElement element : elements) {
					if (name.equals(element.getName())) {
						removeElement = false;
						break;
					}
				}
				if (removeElement) {
					GesilaTestGuard gesilaTestGuard = new GesilaTestGuard(this);
					gesilaTestGuard.setName(name);
					removeElements.add(gesilaTestGuard);
				}
			} else if (file.isDirectory()) {
				if (!StringUtils.equals(name, "dependence")) {
					for (IPostGuardProjectElement element : elements) {
						if (name.equals(element.getName())) {
							removeElement = false;
							break;
						}
					}
					if (removeElement) {
						PostGuardGroup gesilaTestGuardGroup = new PostGuardGroup(this);
						gesilaTestGuardGroup.setName(name);
						removeElements.add(gesilaTestGuardGroup);
					}
				}
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
					GesilaTestGuard gesilaTestGuard = new GesilaTestGuard(this);
					gesilaTestGuard.setName(name);
					addElements.add(gesilaTestGuard);
				}
			} else if (file.isDirectory()) {
				if (!StringUtils.equals(name, "dependence")) {
					for (IPostGuardProjectElement element : elements) {
						if (name.equals(element.getName())) {
							addElement = false;
							break;
						}
					}
					if (addElement) {
						PostGuardGroup gesilaTestGuardGroup = new PostGuardGroup(this);
						IPath path = new Path(file.getCanonicalPath());
						IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
						// IFile file=root.getFile(path);
						gesilaTestGuardGroup.setName(name);
						addElements.add(gesilaTestGuardGroup);
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

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void createElements() {
		File parentFile = project.getLocation().toFile();
		for (File file : parentFile.listFiles()) {
			String name = file.getName();
			if (file.isFile() && !file.isHidden() && !name.equals(".project")) {
				GesilaTestGuard gesilaTestGuard = new GesilaTestGuard(this);
				gesilaTestGuard.setName(name);
				elements.add(gesilaTestGuard);
			} else if (file.isDirectory()) {
				if (StringUtils.equals(file.getName(), "dependence")) {
					PostGuardDependence postGuardDependence = new PostGuardDependence(this);
					postGuardDependence.setName("依赖项");
					elements.add(postGuardDependence);
				} else {
					PostGuardGroup gesilaTestGuardGroup = new PostGuardGroup(this);
					gesilaTestGuardGroup.setName(name);
					elements.add(gesilaTestGuardGroup);
				}
			}
		}
	}

	@Override
	public IResource getResource() {
		return project;
	}

	@Override
	public IPostGuardProjectContainerElement getParent() {
		return null;
	}

}
