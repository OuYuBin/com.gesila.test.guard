package com.gesila.test.guard.navigator.ui.wizards;

import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardDialog;

import com.gesila.test.guard.navigator.ui.wizards.pages.GesilaTestGuardNewRequestWizardPage;

/**
 * 
 * @author robin
 *
 */
public class GesilaTestGuardNewRequestWizard extends Wizard implements IWizard {

	GesilaTestGuardNewRequestWizardPage gesilaTestGuardNewRequestWizardPage;
	
	
	@Override
	public void addPages() {
		super.addPages();
		gesilaTestGuardNewRequestWizardPage=new GesilaTestGuardNewRequestWizardPage("newRequestWizardPage");
		addPage(gesilaTestGuardNewRequestWizardPage);
	}
	
	
	@Override
	public boolean performFinish() {
		return false;
	}

}
