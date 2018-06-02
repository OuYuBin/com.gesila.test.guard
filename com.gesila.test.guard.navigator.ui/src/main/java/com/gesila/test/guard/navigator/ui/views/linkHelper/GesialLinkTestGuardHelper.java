package com.gesila.test.guard.navigator.ui.views.linkHelper;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.core.filesystem.URIUtil;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.ide.FileStoreEditorInput;
import org.eclipse.ui.navigator.ILinkHelper;
import org.eclipse.ui.part.FileEditorInput;

import com.gesila.test.guard.navigator.ui.views.manager.GesilaTestGuardModelElementManager;
import com.gesila.test.guard.navigator.ui.views.manager.IGesilaTestGuardModelElementChangeListener;
import com.gesila.test.guard.navigator.ui.views.providers.GesilaTestGuardTreeContentProvider;
import com.gesila.test.guard.project.models.IGesilaTestGuardProject;
import com.gesila.test.guard.project.models.IGesilaTestGuardProjectElement;

/**
 * 
 * @author robin
 *
 */
public class GesialLinkTestGuardHelper implements ILinkHelper {
	
	StructuredSelection selection=null;

	@Override
	public IStructuredSelection findSelection(IEditorInput anInput) {
		URI uri = ((FileEditorInput) anInput).getURI();
		IPath path = URIUtil.toPath(uri);
		IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
		IFile file = workspaceRoot.getFileForLocation(path);
		IProject project = file.getProject();

		List<IGesilaTestGuardModelElementChangeListener> listeners = GesilaTestGuardModelElementManager.getInstance()
				.getGesilaTestGuardModelElementChangeListeners().stream()
				.filter(listener -> listener instanceof GesilaTestGuardTreeContentProvider)
				.collect(Collectors.toList());

		for (IGesilaTestGuardModelElementChangeListener listener : listeners) {
			Object[] objects = ((GesilaTestGuardTreeContentProvider) listener).getElements(workspaceRoot);
			for (Object object : objects) {
				if (object instanceof IGesilaTestGuardProject) {
					if (((IGesilaTestGuardProject) object).getProject() == project) {
						IStructuredSelection selection= getStructuredSelection((GesilaTestGuardTreeContentProvider) listener, object, file);
						return selection;
					}
				}
			}
		}

		return null;
	}

	private IStructuredSelection getStructuredSelection(GesilaTestGuardTreeContentProvider listener, Object object,
			IFile file) {
		Object[] objects = listener.getElements(object);
		for (Object currObject : objects) {
			if (currObject instanceof IGesilaTestGuardProjectElement) {
				IPath path = ((IGesilaTestGuardProjectElement) currObject).getAdapter(IPath.class);
				if (file.getLocation().toFile().getAbsolutePath().equals(ResourcesPlugin.getWorkspace().getRoot().getFile(path).getLocation().toFile().getAbsolutePath())) {
					selection= new StructuredSelection(currObject);
					break;
				}
				getStructuredSelection(listener, currObject, file);
			}
		}
		return selection;
	}

	@Override
	public void activateEditor(IWorkbenchPage aPage, IStructuredSelection aSelection) {

	}

}
