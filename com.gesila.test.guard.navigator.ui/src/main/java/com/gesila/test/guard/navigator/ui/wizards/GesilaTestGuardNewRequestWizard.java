package com.gesila.test.guard.navigator.ui.wizards;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.ide.undo.CreateFileOperation;
import org.eclipse.ui.ide.undo.WorkspaceUndoUtil;
import org.eclipse.ui.internal.ide.IDEWorkbenchMessages;
import org.eclipse.ui.internal.ide.IDEWorkbenchPlugin;

import com.gesila.test.guard.navigator.ui.wizards.models.GesilaTestGuardRequest;
import com.gesila.test.guard.navigator.ui.wizards.pages.GesilaTestGuardNewRequestWizardPage;

/**
 * 
 * @author robin
 *
 */
public class GesilaTestGuardNewRequestWizard extends Wizard implements IWizard {

	private GesilaTestGuardNewRequestWizardPage gesilaTestGuardNewRequestWizardPage;

	private GesilaTestGuardRequest gesilaTestGuardRequest = new GesilaTestGuardRequest();

	private IStructuredSelection selection;

	private IWorkbench workbench;

	public GesilaTestGuardNewRequestWizard() {
	}

	@Override
	public void addPages() {
		gesilaTestGuardNewRequestWizardPage = new GesilaTestGuardNewRequestWizardPage("newRequestWizardPage",selection);
		addPage(gesilaTestGuardNewRequestWizardPage);
	}

	public void init(IWorkbench aWorkbench, IStructuredSelection currentSelection) {
		this.workbench = aWorkbench;
		this.selection = currentSelection;

	}

	@Override
	public boolean performFinish() {
		IFile file=gesilaTestGuardNewRequestWizardPage.createNewRequest();
		
		return true;
	}

	public GesilaTestGuardRequest getGesilaTestGuardRequest() {
		return gesilaTestGuardRequest;
	}

	public void setGesilaTestGuardRequest(GesilaTestGuardRequest gesilaTestGuardRequest) {
		this.gesilaTestGuardRequest = gesilaTestGuardRequest;
	}
}
