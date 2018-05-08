package com.gesila.test.guard.navigator.ui.views;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.navigator.CommonNavigator;

/**
 * 
 * @author robin
 *
 */
public class GesilaTestGuardCommonNavigator extends CommonNavigator {
	
	
	public GesilaTestGuardCommonNavigator(){
		super();
	}
	

	@Override
	public void createPartControl(Composite parent) {
		FormToolkit formToolkit=new FormToolkit(Display.getDefault());
		Form form=formToolkit.createForm(parent);
		form.setText("Gesila TestGuard Navigator");
		formToolkit.decorateFormHeading(form);
		super.createPartControl(form.getBody());
	}

	@Override
	public void setFocus() {
		super.setFocus();
	}

}
