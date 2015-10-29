package com.gesila.test.guard.editor.parts;

import javax.annotation.PostConstruct;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class GesilaTestGuardStatusPart {

	@PostConstruct
	public void createComposite(Composite parent){
		GridLayout layout=new GridLayout();
		parent.setLayout(layout);
		Label label=new Label(parent,SWT.NONE);
		label.setText("demo test");
		label.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
	}
}
