package com.gesila.test.guard.navigator.ui.views.providers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.progress.WorkbenchJob;

import com.gesila.test.guard.navigator.ui.views.listeners.IGesilaTestGuardModelElementChangeListener;
import com.gesila.test.guard.navigator.ui.views.listeners.manager.PostGuardModelElementManager;
import com.gesila.test.guard.project.models.IPostGuardProjectContainerElement;
import com.gesila.test.guard.project.models.IPostGuardProjectElement;
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

	private WorkbenchJob updateJob;
	
	private Map<String, GesilaTestGuardProject> gesilaTestGuardProjects = new HashMap<String, GesilaTestGuardProject>();

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		this.viewer = viewer;
		if (oldInput == null && newInput != null) {
			PostGuardModelElementManager.getInstance().addGesilaTestGuardModelElementListener(this);
		} else if (oldInput != null && newInput == null) {
			PostGuardModelElementManager.getInstance().removeGesilaTestGuardModelElementListener(this);
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
		} else if (parentElement instanceof IPostGuardProjectContainerElement) {
			return ((IPostGuardProjectContainerElement) parentElement).getElements().toArray();
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
						objects.add(gesilaTestGuardProject);
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
			return ((IPostGuardProjectElement) element).getParent();
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

	@Override
	public void resourceChanged(IResourceChangeEvent event) {
		if (event.getType() == IResourceChangeEvent.POST_CHANGE) {
			if(updateJob == null) {
				updateJob = new WorkbenchJob(PlatformUI.getWorkbench().getDisplay(), "Refreshing navigator") {
					
					@Override
					public IStatus runInUIThread(IProgressMonitor monitor) {
						TreePath[] treePaths = ((TreeViewer) viewer).getExpandedTreePaths();
						viewer.refresh();
						((TreeViewer) viewer).setExpandedTreePaths(treePaths);
//						if (CommonViewer.class.isInstance(viewer)) {
//							CommonNavigator commonNavigator = ((CommonViewer) viewer).getCommonNavigator();
//							if (IEDICommonNavigator.class.isInstance(commonNavigator)) {
//								if (((CommonViewer) viewer).getTree().getItemCount() == 0)
//									((IEDICommonNavigator) commonNavigator).togglePage();
//							}
//						}
						return Status.OK_STATUS;
					}
				};
			}else {
				updateJob.cancel();
			}
			updateJob.setPriority(WorkbenchJob.DECORATE);
			updateJob.schedule(100);
		}
		
	}

}
