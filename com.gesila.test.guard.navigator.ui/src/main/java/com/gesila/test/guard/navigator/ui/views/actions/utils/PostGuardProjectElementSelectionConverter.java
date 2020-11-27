package com.gesila.test.guard.navigator.ui.views.actions.utils;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;

/**
 * 
 * @author robin
 *
 */
public class PostGuardProjectElementSelectionConverter {

	public static IStructuredSelection convertSelectionToResources(ISelection s) {
		List<Object> converted = new ArrayList<Object>();
		if (s instanceof StructuredSelection) {
			Object[] elements = ((StructuredSelection) s).toArray();
			for (int i = 0; i < elements.length; i++) {
				Object e = elements[i];
				if (e instanceof IResource) {
					converted.add(e);
				} else if (e instanceof IAdaptable) {
					IPath path = (IPath) ((IAdaptable) e).getAdapter(IPath.class);
					IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
					IResource resource = root.getFile(path);
					if (resource.exists()) {
						converted.add(resource);
					}
				}
			}
		}
		return new StructuredSelection(converted.toArray());
	}
}
