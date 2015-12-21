package com.gesila.test.guard.editor.dialog;

import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

/**
 * 
 * @author robin
 *
 */
public class GuardEditDialog extends TitleAreaDialog {

	private Text name;

	private String guardName;

	public GuardEditDialog(Shell parentShell) {
		super(parentShell);
	}
	
	

	@Override
	public void create() {
		super.create();
		setTitle("Test Guard");
	}



	@Override
	protected Control createDialogArea(Composite parent) {
		Composite area = (Composite) super.createDialogArea(parent);
		Composite container = new Composite(area, SWT.NONE);
		container.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		GridLayout layout = new GridLayout(2, false);
		container.setLayout(layout);

		createFirstName(container);

		return area;
	}

	private void createFirstName(Composite container) {
		Label lbtFirstName = new Label(container, SWT.NONE);
		lbtFirstName.setText("Guard Name");

		GridData dataFirstName = new GridData();
		dataFirstName.grabExcessHorizontalSpace = true;
		dataFirstName.horizontalAlignment = GridData.FILL;

		name = new Text(container, SWT.BORDER);
		name.setLayoutData(dataFirstName);
	}

	@Override
	protected boolean isResizable() {
		return true;
	}

	private void saveInput() {
		guardName = name.getText();

	}

	@Override
	protected void okPressed() {
		saveInput();
		super.okPressed();
	}

	public String getGuardName() {
		return guardName;
	}

}
