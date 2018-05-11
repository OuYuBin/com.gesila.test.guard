package com.gesila.test.guard.navigator.ui.views.providers;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.navigator.CommonActionProvider;
import org.eclipse.ui.navigator.CommonViewer;
import org.eclipse.ui.navigator.ICommonActionConstants;
import org.eclipse.ui.navigator.ICommonActionExtensionSite;
import org.eclipse.ui.navigator.ICommonViewerWorkbenchSite;

import com.gesila.test.guard.navigator.ui.views.actions.GesilaTestGuardOpenAction;

/**
 * 
 * @author robin
 *
 */
public class GesilaTestGuardOpenActionProvider extends CommonActionProvider {

	GesilaTestGuardOpenAction gesilaTestGuardOpenAction;

	public GesilaTestGuardOpenActionProvider() {

	}

	@Override
	public void init(ICommonActionExtensionSite aSite) {
		super.init(aSite);
		if (getActionSite().getViewSite() instanceof ICommonViewerWorkbenchSite) {
			IWorkbenchWindow workbenchWindow = ((ICommonViewerWorkbenchSite) getActionSite().getViewSite())
					.getWorkbenchWindow();
			gesilaTestGuardOpenAction = new GesilaTestGuardOpenAction("Open", workbenchWindow);
			CommonViewer commonViewer = (CommonViewer) aSite.getStructuredViewer();
			commonViewer.addSelectionChangedListener(gesilaTestGuardOpenAction);
		}
	}

	@Override
	public void fillActionBars(IActionBars actionBars) {
		super.fillActionBars(actionBars);
		actionBars.setGlobalActionHandler(ICommonActionConstants.OPEN, gesilaTestGuardOpenAction);
		updateActionBars();
	}

	@Override
	public void updateActionBars() {
		super.updateActionBars();
		IStructuredSelection selection = (IStructuredSelection) getContext().getSelection();
		gesilaTestGuardOpenAction.selectionChanged(selection);
	}

	@Override
	public void fillContextMenu(IMenuManager menu) {
		super.fillContextMenu(menu);
		menu.add(new Separator());
		menu.appendToGroup("group.new", gesilaTestGuardOpenAction);
	}

}
