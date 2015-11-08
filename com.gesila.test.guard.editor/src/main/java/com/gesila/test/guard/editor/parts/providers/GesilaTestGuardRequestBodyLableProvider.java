package com.gesila.test.guard.editor.parts.providers;

import org.eclipse.emf.edit.EMFEditPlugin;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.graphics.Image;

import com.gesila.test.guard.editor.parts.ResponseObject;
import com.gesila.test.guard.json.model.GesilaJSONObject;

/**
 * 
 * @author robin
 *
 */
public class GesilaTestGuardRequestBodyLableProvider implements ITableLabelProvider {

	@Override
	public void addListener(ILabelProviderListener listener) {

	}

	@Override
	public void dispose() {

	}

	@Override
	public boolean isLabelProperty(Object element, String property) {
		return false;
	}

	@Override
	public void removeListener(ILabelProviderListener listener) {

	}

	@Override
	public Image getColumnImage(Object element, int columnIndex) {
		switch (columnIndex) {
		case 1:
			String image = "full/obj16/GenericValue";
			String name = ((GesilaJSONObject) element).getName();
			if (name.equals("_ApplicationId") || name.equals("_ApplicationKey")) {
				image = "full/obj16/IntegralValue.gif";
			}
			return ExtendedImageRegistry.getInstance().getImage(EMFEditPlugin.INSTANCE.getImage(image));
		}
		return null;
	}

	@Override
	public String getColumnText(Object element, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return ((GesilaJSONObject) element).getName() == null ? "" : ((GesilaJSONObject) element).getName();
		case 1:
			return ((GesilaJSONObject) element).getValue() == null ? "" : ((GesilaJSONObject) element).getValue();
		}
		return null;
	}

}
