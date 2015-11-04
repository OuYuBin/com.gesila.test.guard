package com.gesila.test.guard.edit.providers;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider.StyledLabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider;

import com.gesila.test.guard.model.testGuard.RequestMethod;
import com.gesila.test.guard.model.testGuard.TestGuardUnit;

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
		RequestMethod requestMethod = ((TestGuardUnit) object).getRequestMethod();
		String url = ((TestGuardUnit) object).getUrl();
		org.eclipse.jface.viewers.StyledString styledString = new org.eclipse.jface.viewers.StyledString("test");
		//styledString.append(requestMethod.getLiteral(), org.eclipse.jface.viewers.StyledString.DECORATIONS_STYLER);
		styledString.append(" - " + url, org.eclipse.jface.viewers.StyledString.DECORATIONS_STYLER);
		return styledString;
	}
	
}
