package com.gesila.test.guard.ui.views;

import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.part.ViewPart;

/**
 * 
 * @author robin
 *
 */
public class GsilaTestGuardResponseViewPart extends ViewPart {
	
	public static final String ID="com.gesila.test.guard.ui.views.GsilaTestGuardResponseViewPart";

	public GsilaTestGuardResponseViewPart() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createPartControl(Composite parent) {
//		GridLayout gridLayout = new GridLayout(1, false);
//		gridLayout.marginWidth = 0;
//		gridLayout.marginHeight = 0;
//		gridLayout.verticalSpacing = 1;
//		gridLayout.horizontalSpacing = 0;
//		parent.setLayout(gridLayout);
		
		FormToolkit formToolkit=new FormToolkit(Display.getCurrent());
		Form form=formToolkit.createForm(parent);
		form.setText("Response");
		formToolkit.decorateFormHeading(form);
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

}
