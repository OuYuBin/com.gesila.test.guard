package com.gesila.test.guard.navigator.ui.wizards.pages;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;


/**
 * 
 * @author robin
 *
 */
public class GesilaTestGuardNewRequestWizardPage extends WizardPage {

	public GesilaTestGuardNewRequestWizardPage(String pageName) {
		super(pageName);
	}

	@Override
	public void createControl(Composite parent) {
		Composite composite=new Composite(parent, SWT.NONE);
		GridLayout gridLayout = new GridLayout(2, false);
		gridLayout.marginWidth = 5;
		gridLayout.marginHeight = 5;
		gridLayout.verticalSpacing = 5;
		gridLayout.horizontalSpacing = 5;
		composite.setLayout(gridLayout);
		Label label=new Label(composite,SWT.NONE);
		label.setText("Name:");
		label.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false));
		Text text=new Text(composite,SWT.BORDER);
		text.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
		setControl(parent);
	}

}
