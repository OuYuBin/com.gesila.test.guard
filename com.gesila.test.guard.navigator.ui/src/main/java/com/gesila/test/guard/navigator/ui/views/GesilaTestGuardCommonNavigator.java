package com.gesila.test.guard.navigator.ui.views;

import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
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
		GridLayout gridLayout = new GridLayout(1, false);
		gridLayout.marginWidth = 0;
		gridLayout.marginHeight = 0;
		gridLayout.verticalSpacing = 1;
		gridLayout.horizontalSpacing = 0;
		parent.setLayout(gridLayout);
		
		
		FormToolkit formToolkit=new FormToolkit(Display.getCurrent());
		Form form=formToolkit.createForm(parent);
		form.setText("导航");
		IToolBarManager toolBarManager=form.getToolBarManager();
		//toolBarManager.add
		formToolkit.decorateFormHeading(form);
		
		form.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		Composite body=form.getBody();
		body.setBackground(new Color(Display.getDefault(), 185, 214, 238));
		body.setLayout(new FillLayout());
		
		super.createPartControl(body);
	}

	@Override
	public void setFocus() {
		super.setFocus();
	}

}
