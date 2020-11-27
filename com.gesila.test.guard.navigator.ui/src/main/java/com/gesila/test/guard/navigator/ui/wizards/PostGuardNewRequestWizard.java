package com.gesila.test.guard.navigator.ui.wizards;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.internal.ide.DialogUtil;
import org.eclipse.ui.internal.wizards.newresource.ResourceMessages;
import org.eclipse.ui.part.FileEditorInput;

import com.gesila.test.guard.navigator.ui.wizards.models.PostGuardRequest;
import com.gesila.test.guard.navigator.ui.wizards.pages.PostGuardNewRequestWizardPage;

/**
 * 
 * @author robin
 *
 */
public class PostGuardNewRequestWizard extends Wizard implements IWizard {

	private PostGuardNewRequestWizardPage gesilaTestGuardNewRequestWizardPage;

	private PostGuardRequest gesilaTestGuardRequest = new PostGuardRequest();

	private IStructuredSelection selection;

	private IWorkbench workbench;

	public PostGuardNewRequestWizard() {
	}

	@Override
	public void addPages() {
		gesilaTestGuardNewRequestWizardPage = new PostGuardNewRequestWizardPage("newRequestWizardPage",
				selection);
		addPage(gesilaTestGuardNewRequestWizardPage);
	}

	public void init(IWorkbench aWorkbench, IStructuredSelection currentSelection) {
		this.workbench = aWorkbench;
		this.selection = currentSelection;

	}

	@Override
	public boolean performFinish() {
		IFile file = gesilaTestGuardNewRequestWizardPage.createNewRequest();

		IWorkbenchWindow workbenchWindow = getWorkbench().getActiveWorkbenchWindow();
		try {
			if (workbenchWindow != null) {
				IWorkbenchPage page = workbenchWindow.getActivePage();
				if (page != null) {
					IEditorDescriptor editorDesc;
					try {
						editorDesc = IDE.getEditorDescriptor(file, true, true);
					} catch (OperationCanceledException ex) {
						return false;
					}
					
					page.openEditor(new FileEditorInput(file), editorDesc.getId(), true);
					// IDE.openEditor(page, file, true);
				}
			}
		} catch (PartInitException e) {
			DialogUtil.openError(workbenchWindow.getShell(), ResourceMessages.FileResource_errorMessage, e.getMessage(),
					e);
		}

		return true;
	}

	public PostGuardRequest getGesilaTestGuardRequest() {
		return gesilaTestGuardRequest;
	}

	public void setGesilaTestGuardRequest(PostGuardRequest gesilaTestGuardRequest) {
		this.gesilaTestGuardRequest = gesilaTestGuardRequest;
	}

	public IWorkbench getWorkbench() {
		return workbench;
	}
}
