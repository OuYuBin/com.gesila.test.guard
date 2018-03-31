package com.gesila.test.guard.navigator.ui.wizards;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;

import com.gesila.test.guard.navigator.ui.wizards.pages.GesilaTestGuardNewProjectWizardPage;

/**
 * 
 * @author robin
 *
 */
public class GesilaTestGuardNewProjectWizard extends Wizard implements INewWizard {

	GesilaTestGuardNewProjectWizardPage gesilaTestGuardNewProjectWizardPage;

	public GesilaTestGuardNewProjectWizard() {

	}

	@Override
	public void addPages() {
		super.addPages();
		gesilaTestGuardNewProjectWizardPage = new GesilaTestGuardNewProjectWizardPage("gesilaTestGuardNewProjectPage");
		addPage(gesilaTestGuardNewProjectWizardPage);
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
	}

	@Override
	public boolean performFinish() {
		return true;
	}

}
