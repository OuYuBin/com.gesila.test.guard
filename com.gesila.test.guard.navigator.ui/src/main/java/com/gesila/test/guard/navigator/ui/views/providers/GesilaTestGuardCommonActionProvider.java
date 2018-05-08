package com.gesila.test.guard.navigator.ui.views.providers;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.NewWizardAction;
import org.eclipse.ui.navigator.CommonActionProvider;
import org.eclipse.ui.navigator.ICommonActionExtensionSite;
import org.eclipse.ui.navigator.ICommonMenuConstants;
import org.eclipse.ui.navigator.ICommonViewerWorkbenchSite;
import org.eclipse.ui.navigator.WizardActionGroup;

/**
 * 
 * @author robin
 *
 */
public class GesilaTestGuardCommonActionProvider extends CommonActionProvider {

	WizardActionGroup newWizardActionGroup;
	
	ActionFactory.IWorkbenchAction showDlgAction;
	
	private static final String NEW_MENU_NAME="test.guard.new.menu";

	public GesilaTestGuardCommonActionProvider() {
		super();
	}

	@Override
	public void init(ICommonActionExtensionSite aSite) {
		super.init(aSite);
		if (getActionSite().getViewSite() instanceof ICommonViewerWorkbenchSite) {
			IWorkbenchWindow window = ((ICommonViewerWorkbenchSite) getActionSite().getViewSite()).getWorkbenchWindow();
			newWizardActionGroup = new WizardActionGroup(window, PlatformUI.getWorkbench().getNewWizardRegistry(),
					WizardActionGroup.TYPE_NEW,getActionSite().getContentService());
			showDlgAction=ActionFactory.NEW.create(window);
		}
	}

	@Override
	public void fillContextMenu(IMenuManager menu) {
		super.fillContextMenu(menu);
		IMenuManager subMenu = new MenuManager("New", NEW_MENU_NAME);
		newWizardActionGroup.setContext(getContext());
		newWizardActionGroup.fillContextMenu(subMenu);
		subMenu.add(new Separator(ICommonMenuConstants.GROUP_ADDITIONS));
		subMenu.add(new Separator());
		subMenu.add(showDlgAction);
		menu.insertAfter(ICommonMenuConstants.GROUP_NEW, subMenu);
	}

}
