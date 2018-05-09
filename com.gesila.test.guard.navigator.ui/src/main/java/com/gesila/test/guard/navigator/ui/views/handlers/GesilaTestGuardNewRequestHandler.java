package com.gesila.test.guard.navigator.ui.views.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.handlers.HandlerUtil;

import com.gesila.test.guard.navigator.ui.wizards.GesilaTestGuardNewRequestWizard;

/**
 * 
 * @author robin
 *
 */
public class GesilaTestGuardNewRequestHandler extends AbstractHandler implements IHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection=HandlerUtil.getActiveMenuSelection(event);
		GesilaTestGuardNewRequestWizard gesilaTestGuardNewRequestWizard=new GesilaTestGuardNewRequestWizard();
		WizardDialog wizardDialog=new WizardDialog(Display.getCurrent().getActiveShell(),gesilaTestGuardNewRequestWizard);
		if(wizardDialog.open()==Window.OK){
			
		}
		
		return null;
	}

}
