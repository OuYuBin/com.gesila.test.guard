package com.gesila.test.guard.navigator.ui.views.providers;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.actions.ActionContext;
import org.eclipse.ui.navigator.CommonActionProvider;
import org.eclipse.ui.navigator.ICommonActionExtensionSite;
import org.eclipse.ui.navigator.ICommonViewerWorkbenchSite;

import com.gesila.test.guard.navigator.ui.views.actions.groups.PostGuardNavigatorEditActionGoup;
import com.gesila.test.guard.navigator.ui.views.actions.utils.PostGuardProjectElementSelectionConverter;

/**
 * 
 * @author robin
 *
 */
public class PostGuardEditCommonActionProvider extends CommonActionProvider {

	private PostGuardNavigatorEditActionGoup editGroup;

	public PostGuardEditCommonActionProvider() {
		super();
	}

	@Override
	public void init(ICommonActionExtensionSite anActionSite) {
		super.init(anActionSite);

		editGroup = new PostGuardNavigatorEditActionGoup(anActionSite.getViewSite().getShell());

		ICommonViewerWorkbenchSite workbenchSite = null;
		if (anActionSite.getViewSite() instanceof ICommonViewerWorkbenchSite) {
			workbenchSite = (ICommonViewerWorkbenchSite) anActionSite.getViewSite();
		}
		if (workbenchSite != null) {
			if (workbenchSite.getPart() != null && workbenchSite.getPart() instanceof IViewPart) {
				IViewPart viewPart = (IViewPart) workbenchSite.getPart();

				// fGenerateGroup = new GenerateActionGroup(viewPart);
			}
		}
	}

	@Override
	public void dispose() {
		editGroup.dispose();
		// if (fGenerateGroup != null) {
		// fGenerateGroup.dispose();
		// }
	}

	@Override
	public void fillActionBars(IActionBars actionBars) {
		editGroup.fillActionBars(actionBars);
		// if (fGenerateGroup != null) {
		// fGenerateGroup.fillActionBars(actionBars);
		// }
	}

	@Override
	public void fillContextMenu(IMenuManager menu) {
		editGroup.fillContextMenu(menu);
		// if (fGenerateGroup != null) {
		// fGenerateGroup.fillContextMenu(menu);
		// }
	}

	@Override
	public void setContext(ActionContext context) {
		if (context != null) {
			ISelection selection = PostGuardProjectElementSelectionConverter
					.convertSelectionToResources(context.getSelection());
			editGroup.setContext(new ActionContext(selection));
		} else {
			editGroup.setContext(context);
		}
		// if (fGenerateGroup != null) {
		// fGenerateGroup.setContext(context);
		// }
	}

}
