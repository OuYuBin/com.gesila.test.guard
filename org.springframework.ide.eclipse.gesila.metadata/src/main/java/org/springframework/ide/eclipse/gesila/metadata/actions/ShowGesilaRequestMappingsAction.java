package org.springframework.ide.eclipse.gesila.metadata.actions;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.springframework.ide.eclipse.beans.core.BeansCorePlugin;
import org.springframework.ide.eclipse.beans.core.model.IBeansConfig;
import org.springframework.ide.eclipse.beans.core.model.IBeansConfigSet;
import org.springframework.ide.eclipse.beans.core.model.IBeansModelElement;
import org.springframework.ide.eclipse.beans.core.model.IBeansProject;
import org.springframework.ide.eclipse.gesila.metadata.views.GesilaRequestMppingView;
import org.springframework.ide.eclipse.metadata.actions.ShowRequestMappingsAction;
import org.springframework.ide.eclipse.metadata.ui.RequestMappingBeanMetadataReference;

public class ShowGesilaRequestMappingsAction extends ShowRequestMappingsAction implements IActionDelegate {

	private IBeansModelElement element;

	public ShowGesilaRequestMappingsAction() {
	}

	@Override
	protected boolean isEnabled(IStructuredSelection selection) {
		Object treeElement = selection.getFirstElement();
		IBeansModelElement modelElement = null;
		if (treeElement instanceof IBeansProject) {
			modelElement = (IBeansProject) treeElement;
		} else if (treeElement instanceof IBeansConfig) {
			modelElement = (IBeansConfig) treeElement;
		} else if (treeElement instanceof IBeansConfigSet) {
			modelElement = (IBeansConfigSet) treeElement;
		} else if (treeElement instanceof IProject) {
			modelElement = BeansCorePlugin.getModel().getProject((IProject) treeElement);
		} else if (treeElement instanceof IFile) {
			modelElement = BeansCorePlugin.getModel().getConfig((IFile) treeElement);
		} else if (treeElement instanceof RequestMappingBeanMetadataReference) {
			modelElement = ((RequestMappingBeanMetadataReference) treeElement).getBeansProject();
		}
		if (modelElement != null) {
			element = modelElement;
			return true;
		}
		return false;
	}

	public void run(IAction action) {
		try {
			IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
			GesilaRequestMppingView gesilaRequestMppingView = (GesilaRequestMppingView) activePage
					.findView(GesilaRequestMppingView.ID);
			if (gesilaRequestMppingView != null)
				gesilaRequestMppingView.setInput(element);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}

	public void selectionChanged(IAction action, ISelection selection) {
		super.selectionChanged(action, selection);
	}

}
