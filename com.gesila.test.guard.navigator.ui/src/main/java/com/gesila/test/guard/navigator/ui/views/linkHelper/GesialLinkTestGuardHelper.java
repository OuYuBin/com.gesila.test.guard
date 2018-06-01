package com.gesila.test.guard.navigator.ui.views.linkHelper;

import java.net.URI;
import java.util.List;

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

/**
 * 
 * @author robin
 *
 */
public class GesialLinkTestGuardHelper implements ILinkHelper {

	@Override
	public IStructuredSelection findSelection(IEditorInput anInput) {
		URI uri = ((FileEditorInput) anInput).getURI();
		IPath path = URIUtil.toPath(uri);
		IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
		IFile file=workspaceRoot.getFileForLocation(path);
		IProject project=file.getProject();

		List<IGesilaTestGuardModelElementChangeListener> listeners = GesilaTestGuardModelElementManager.getInstance()
				.getGesilaTestGuardModelElementChangeListeners();
		listeners.stream().filter(listener -> listener instanceof GesilaTestGuardTreeContentProvider)
				.forEachOrdered(listener -> {
					Object[] objects = ((GesilaTestGuardTreeContentProvider) listener).getElements(workspaceRoot);
					for(Object object:objects){
						if(object instanceof IGesilaTestGuardProject){
							if(((IGesilaTestGuardProject)object).getProject()==project){
								return getStructuredSelection(listener,object,file);
							}
						}
					}
				});

		return null;
	}

	private IStructuredSelection getStructuredSelection(IGesilaTestGuardModelElementChangeListener listener,
			Object object, IFile file) {
		return null;
	}

	@Override
	public void activateEditor(IWorkbenchPage aPage, IStructuredSelection aSelection) {

	}

}
