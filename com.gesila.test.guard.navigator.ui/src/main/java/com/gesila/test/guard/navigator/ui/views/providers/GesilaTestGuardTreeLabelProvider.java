package com.gesila.test.guard.navigator.ui.views.providers;

/**
 * @author robin
 */
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;

import com.gesila.test.guard.navigator.ui.Activator;
import com.gesila.test.guard.project.models.impl.GesilaTestGuard;
import com.gesila.test.guard.project.models.impl.GesilaTestGuardGroup;
import com.gesila.test.guard.project.models.impl.GesilaTestGuardProject;

/**
 * 
 * @author robin
 *
 */
public class GesilaTestGuardTreeLabelProvider implements ILabelProvider {

	@Override
	public void addListener(ILabelProviderListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isLabelProperty(Object element, String property) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeListener(ILabelProviderListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public Image getImage(Object element) {
		if (element instanceof GesilaTestGuardProject) {
			return Activator.getDefault().getImageRegistry().get("project");
		} else if (element instanceof GesilaTestGuard) {
			return Activator.getDefault().getImageRegistry().get("testGuard");
		}else if(element instanceof GesilaTestGuardGroup){
			return Activator.getDefault().getImageRegistry().get("testGuard");
		}
		return null;
	}

	@Override
	public String getText(Object element) {
		if (GesilaTestGuardProject.class.isInstance(element)) {
			return ((GesilaTestGuardProject) element).getName();
		} else if (GesilaTestGuard.class.isInstance(element)) {
			int i = ((GesilaTestGuard) element).getName().lastIndexOf('.');
			return ((GesilaTestGuard) element).getName().substring(0, i);
		}
		return element.toString();
	}

}
