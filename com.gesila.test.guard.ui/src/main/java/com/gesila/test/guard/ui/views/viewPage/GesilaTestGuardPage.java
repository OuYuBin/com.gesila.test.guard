package com.gesila.test.guard.ui.views.viewPage;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.part.Page;

/**
 * 
 * @author robin
 *
 */
public class GesilaTestGuardPage extends Page implements IGesilaTestGuardPage {

	private Composite composite;
	
	private Text text;

	private IWorkbenchPart part;
	
	@Override
	public void createControl(Composite parent) {
		composite = new Composite(parent, SWT.NONE);
		GridLayout gridLayout=new GridLayout();
		gridLayout.marginHeight=0;
		gridLayout.marginWidth=0;
		composite.setLayout(gridLayout);
		text=new Text(composite,SWT.BORDER|SWT.READ_ONLY|SWT.WRAP);
		text.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
	}

	@Override
	public Control getControl() {
		return composite;
	}

	@Override
	public void setFocus() {

	}

	@Override
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		System.out.println(selection);
		this.part=part;
		if(part!=null){
			refresh();
		}
	}

	@Override
	public void refresh() {
		// TODO Auto-generated method stub
		System.out.println(part);
		if(part!=null)
		text.setText(part.toString());
	}

}
