package com.gesila.test.guard.navigator.ui.views.providers;

import java.util.Arrays;

import org.eclipse.core.internal.resources.Project;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.ITreeContentProvider;

import com.gesila.test.guard.project.nature.GesilaTestGuardProjectNature;

/**
 * 
 * @author robin
 *
 */
public class GesilaTestGuardTreeContentProvider implements ITreeContentProvider {

	@Override
	public Object[] getElements(Object inputElement) {
		return getChildren(inputElement);
	}

	@Override
	public Object[] getChildren(Object parentElement) {
		if(parentElement instanceof IWorkspaceRoot) {
			IProject[] projects=((IWorkspaceRoot)parentElement).getProjects();
			for(IProject project:projects) {
				try {
					if(project.getNature(GesilaTestGuardProjectNature.ID) != null) {
						
					}
				} catch (CoreException e) {
					e.printStackTrace();
				}
				
			}
		}
		return null;
//		if()
		//return null;
	}

	@Override
	public Object getParent(Object element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasChildren(Object element) {
		// TODO Auto-generated method stub
		return false;
	}

}
