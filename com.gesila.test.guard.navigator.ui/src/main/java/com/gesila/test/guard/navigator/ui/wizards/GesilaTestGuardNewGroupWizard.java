package com.gesila.test.guard.navigator.ui.wizards;

import org.eclipse.core.resources.IFolder;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IWorkbench;

import com.gesila.test.guard.navigator.ui.wizards.models.PostGuardRequest;
import com.gesila.test.guard.navigator.ui.wizards.pages.GesilaTestGuardNewGroupWizardPage;

/**
 * 
 * @author robin
 *
 */
public class GesilaTestGuardNewGroupWizard extends Wizard implements IWizard {

	private GesilaTestGuardNewGroupWizardPage gesilaTestGuardNewGroupWizardPage;

	private PostGuardRequest gesilaTestGuardRequest = new PostGuardRequest();

	private IStructuredSelection selection;

	private IWorkbench workbench;

	public GesilaTestGuardNewGroupWizard() {
	}

	@Override
	public void addPages() {
		gesilaTestGuardNewGroupWizardPage = new GesilaTestGuardNewGroupWizardPage("newRequestWizardPage",
				selection);
		addPage(gesilaTestGuardNewGroupWizardPage);
	}

	public void init(IWorkbench aWorkbench, IStructuredSelection currentSelection) {
		this.workbench = aWorkbench;
		this.selection = currentSelection;

	}

	@Override
	public boolean performFinish() {
		IFolder folder = gesilaTestGuardNewGroupWizardPage.createNewFolder();

//		IWorkbenchWindow workbenchWindow = getWorkbench().getActiveWorkbenchWindow();
//		try {
//			if (workbenchWindow != null) {
//				IWorkbenchPage page = workbenchWindow.getActivePage();
//				if (page != null) {
//					IEditorDescriptor editorDesc;
//					try {
//						editorDesc = IDE.getEditorDescriptor(file, true, true);
//					} catch (OperationCanceledException ex) {
//						return false;
//					}
//					
//					page.openEditor(new FileEditorInput(file), editorDesc.getId(), true);
//					// IDE.openEditor(page, file, true);
//				}
//			}
//		} catch (PartInitException e) {
//			DialogUtil.openError(workbenchWindow.getShell(), ResourceMessages.FileResource_errorMessage, e.getMessage(),
//					e);
//		}

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
