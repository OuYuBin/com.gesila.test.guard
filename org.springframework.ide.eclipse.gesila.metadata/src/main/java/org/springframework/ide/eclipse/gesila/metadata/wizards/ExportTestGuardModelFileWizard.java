package org.springframework.ide.eclipse.gesila.metadata.wizards;

import org.eclipse.jface.wizard.Wizard;
import org.springframework.ide.eclipse.metadata.ui.RequestMappingView;

/**
 * 
 * @author robin
 *
 */
public class ExportTestGuardModelFileWizard extends Wizard {

	RequestMappingView requestMappingView;

	ExportTestGuardModelFileWizardPage exportTestGuardModelFileWizardPage;

	public ExportTestGuardModelFileWizard(RequestMappingView requestMappingView) {
		this.requestMappingView = requestMappingView;
	}

	@Override
	public void addPages() {
		exportTestGuardModelFileWizardPage = new ExportTestGuardModelFileWizardPage("Gesila Export",
				requestMappingView.getInput());
		addPage(exportTestGuardModelFileWizardPage);
	}

	@Override
	public boolean performFinish() {
		return true;
	}

	public ExportTestGuardModelFileWizardPage getExportTestGuardModelFileWizardPage() {
		return exportTestGuardModelFileWizardPage;
	}
	
	

}
