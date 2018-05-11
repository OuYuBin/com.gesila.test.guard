package com.gesila.test.guard.navigator.ui.views.actions;

import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.SelectionListenerAction;
import org.eclipse.ui.ide.FileStoreEditorInput;

import com.gesila.test.guard.project.models.impl.GesilaTestGuard;

/**
 * 
 * @author robin
 *
 */
public class GesilaTestGuardOpenAction extends SelectionListenerAction {

	IWorkbenchWindow workbenchWindow;

	public GesilaTestGuardOpenAction(String text, IWorkbenchWindow workbenchWindow) {
		super(text);
		this.workbenchWindow = workbenchWindow;
	}

	@Override
	public void run() {
		super.run();
		try {
			IStructuredSelection selection = getStructuredSelection();
			System.out.println("+++++++++++++++++++"+selection);
			Object object = selection.getFirstElement();
			if (object instanceof GesilaTestGuard) {
				IPath path = ((GesilaTestGuard) object).getAdapter(IPath.class);
				IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
				if (file.exists()) {
					IFileStore fileStore = EFS.getLocalFileSystem().getStore(path);
					IEditorInput editorInput = new FileStoreEditorInput(fileStore);
					workbenchWindow.getActivePage().openEditor(editorInput,
							"com.gesila.test.guard.editor.GesilaTestGuardEditor");
				}
			}
		} catch (PartInitException e) {
			e.printStackTrace();
		}
	}

}
