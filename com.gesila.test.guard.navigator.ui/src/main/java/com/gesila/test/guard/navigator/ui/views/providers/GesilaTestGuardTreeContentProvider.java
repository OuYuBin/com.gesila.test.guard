package com.gesila.test.guard.navigator.ui.views.providers;

import java.util.ArrayList;
import java.util.List;

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
import com.gesila.test.guard.project.models.impl.TestGuardProject;
import com.gesila.test.guard.project.nature.GesilaTestGuardProjectNature;

/**
 * 
 * @author robin
 *
 */
public class GesilaTestGuardTreeContentProvider
		implements ITreeContentProvider, IGesilaTestGuardModelElementChangeListener {

	private Viewer viewer;

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
			return createGesilaTestGuardProjects(parentElement).toArray(new Object[0]);
		}
		return new Object[0];
	}

	private List<TestGuardProject> createGesilaTestGuardProjects(Object parentElement) {
		IProject[] projects = ((IWorkspaceRoot) parentElement).getProjects();
		List<TestGuardProject> gesilaTestGuardProjects = new ArrayList<TestGuardProject>();
		for (IProject project : projects) {
			try {
				if (project.getNature(GesilaTestGuardProjectNature.ID) != null) {
					gesilaTestGuardProjects.add(new TestGuardProject(project));
				}
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
		return gesilaTestGuardProjects;
	}

	@Override
	public Object getParent(Object element) {
		return null;
	}

	@Override
	public boolean hasChildren(Object element) {
		return getChildren(element).length>0;
	}

	@Override
	public void testGuardModelElementChange() {
		Display.getDefault().asyncExec(new Runnable() {

			@Override
			public void run() {
				TreePath[] treePaths = ((TreeViewer) viewer).getExpandedTreePaths();
				viewer.refresh();
				((TreeViewer) viewer).setExpandedElements(treePaths);
			}
		});

	}

}
