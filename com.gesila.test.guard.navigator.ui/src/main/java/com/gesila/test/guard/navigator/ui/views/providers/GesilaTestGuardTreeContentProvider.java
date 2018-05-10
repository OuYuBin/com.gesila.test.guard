package com.gesila.test.guard.navigator.ui.views.providers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.Display;

import com.gesila.test.guard.navigator.ui.views.manager.GesilaTestGuardModelElementManager;
import com.gesila.test.guard.navigator.ui.views.manager.IGesilaTestGuardModelElementChangeListener;
import com.gesila.test.guard.project.models.IGesilaTestGuardProjectContainerElement;
import com.gesila.test.guard.project.models.IGesilaTestGuardProjectElement;
import com.gesila.test.guard.project.models.impl.GesilaTestGuard;
import com.gesila.test.guard.project.models.impl.GesilaTestGuardProject;
import com.gesila.test.guard.project.nature.GesilaTestGuardProjectNature;

/**
 * 
 * @author robin
 *
 */
public class GesilaTestGuardTreeContentProvider
		implements ITreeContentProvider, IGesilaTestGuardModelElementChangeListener {

	private Viewer viewer;

	// private List<GesilaTestGuardProject> gesilaTestGuardProjects = new
	// ArrayList<GesilaTestGuardProject>();

	private Map<String, GesilaTestGuardProject> gesilaTestGuardProjects = new HashMap<String, GesilaTestGuardProject>();

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		this.viewer = viewer;
		if (oldInput == null && newInput != null) {
			GesilaTestGuardModelElementManager.getInstance().addGesilaTestGuardModelElementListener(this);
		} else if (oldInput != null && newInput == null) {
			GesilaTestGuardModelElementManager.getInstance().removeGesilaTestGuardModelElementListener(this);
		}

	}

	@Override
	public Object[] getElements(Object inputElement) {
		return getChildren(inputElement);
	}

	@Override
	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof IWorkspaceRoot) {
			return createGesilaTestGuardProjects(parentElement).toArray();
		} else if (parentElement instanceof IGesilaTestGuardProjectContainerElement) {
			return ((IGesilaTestGuardProjectContainerElement) parentElement).getElements().toArray();
		}
		return new Object[0];
	}

	private List<GesilaTestGuardProject> createGesilaTestGuardProjects(Object parentElement) {
		List<GesilaTestGuardProject> objects = new ArrayList<GesilaTestGuardProject>();
		IProject[] projects = ((IWorkspaceRoot) parentElement).getProjects();
		for (IProject project : projects) {
			GesilaTestGuardProject gesilaTestGuardProject = gesilaTestGuardProjects.get(project.getName());
			if (gesilaTestGuardProject == null) {
				try {
					if (project.getNature(GesilaTestGuardProjectNature.ID) != null) {
						gesilaTestGuardProject = new GesilaTestGuardProject(project);
						gesilaTestGuardProjects.put(project.getName(), gesilaTestGuardProject);
						objects.add(new GesilaTestGuardProject(project));
					}
				} catch (CoreException e) {
					e.printStackTrace();
				}
			} else {
				objects.add(gesilaTestGuardProject);
			}
		}
		return objects;
	}

	@Override
	public Object getParent(Object element) {
		if (element instanceof GesilaTestGuard) {
			return ((IGesilaTestGuardProjectElement) element).getParent();
		} else if (element instanceof GesilaTestGuardProject) {
			return ((GesilaTestGuardProject) element).getProject().getWorkspace().getRoot();
		}
		return null;
	}

	@Override
	public boolean hasChildren(Object element) {
		return getChildren(element).length > 0;
	}

	@Override
	public void testGuardModelElementChange() {
		Display.getDefault().asyncExec(new Runnable() {

			@Override
			public void run() {
				TreePath[] treePaths = ((TreeViewer) viewer).getExpandedTreePaths();
				viewer.refresh();
				((TreeViewer) viewer).setExpandedTreePaths(treePaths);
			}
		});

	}

}
