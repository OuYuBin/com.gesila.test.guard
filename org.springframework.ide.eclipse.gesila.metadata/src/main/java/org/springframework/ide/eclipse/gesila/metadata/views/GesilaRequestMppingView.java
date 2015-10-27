package org.springframework.ide.eclipse.gesila.metadata.views;

import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IActionBars;
import org.springframework.ide.eclipse.gesila.metadata.actions.GesilaExportTestGuardModelAction;
import org.springframework.ide.eclipse.metadata.actions.ToggleOrientationAction;
import org.springframework.ide.eclipse.metadata.ui.RequestMappingView;

/**
 * @author robin
 *
 */
public class GesilaRequestMppingView extends RequestMappingView {

	public static final String ID = "org.springframework.ide.eclipse.gesila.metadata.views.GesilaRequestMppingView";

	public void createPartControl(Composite parent) {
		super.createPartControl(parent);
		SashForm sashForm = (SashForm) parent.getChildren()[1];
		sashForm.setSashWidth(0);
		sashForm.setWeights(new int[] { 100, 0 });
		fillActionBars();
	}

	public void fillActionBars() {
		IActionBars actionBars = getViewSite().getActionBars();
		IToolBarManager toolBar = actionBars.getToolBarManager();
		toolBar.add(new Separator());
		toolBar.add(new GesilaExportTestGuardModelAction(this.getSite().getWorkbenchWindow(), this));
		for (IContributionItem item : toolBar.getItems()) {
			if (item instanceof ActionContributionItem) {
				if (((ActionContributionItem) item).getAction() instanceof ToggleOrientationAction) {
					toolBar.remove(item);
				}
			}
		}
		toolBar.update(true);
	}

	public void setFocus() {
		super.setFocus();
	}
}
