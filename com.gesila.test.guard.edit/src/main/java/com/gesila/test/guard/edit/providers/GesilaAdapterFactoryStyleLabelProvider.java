package com.gesila.test.guard.edit.providers;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider.StyledLabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.Viewer;

/**
 * 
 * @author robin
 *
 */
public class GesilaAdapterFactoryStyleLabelProvider extends StyledLabelProvider {

	public GesilaAdapterFactoryStyleLabelProvider(AdapterFactory adapterFactory, Viewer viewer) {
		super(adapterFactory, viewer);
	}

	@Override
	public StyledString getStyledText(Object object) {
		return super.getStyledText(object);
	}
	
}
