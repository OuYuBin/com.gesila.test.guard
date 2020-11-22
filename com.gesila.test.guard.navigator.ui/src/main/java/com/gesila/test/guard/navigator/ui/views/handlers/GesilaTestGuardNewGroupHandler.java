package com.gesila.test.guard.navigator.ui.views.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;

import com.gesila.test.guard.navigator.ui.wizards.GesilaTestGuardNewGroupWizard;

/**
 * 
 * @author robin
 *
 */
public class GesilaTestGuardNewGroupHandler extends AbstractHandler implements IHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getActiveMenuSelection(event);
		GesilaTestGuardNewGroupWizard gesilaTestGuardNewGroupWizard = new GesilaTestGuardNewGroupWizard();
		gesilaTestGuardNewGroupWizard.init(PlatformUI.getWorkbench(), (IStructuredSelection) selection);
		gesilaTestGuardNewGroupWizard.setNeedsProgressMonitor(true);
		WizardDialog wizardDialog = new WizardDialog(Display.getCurrent().getActiveShell(),
				gesilaTestGuardNewGroupWizard);
		wizardDialog.create();
		wizardDialog.open();
		return null;
	}


}
