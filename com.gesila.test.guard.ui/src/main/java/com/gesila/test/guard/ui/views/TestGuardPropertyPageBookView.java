package com.gesila.test.guard.ui.views;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.IPage;
import org.eclipse.ui.part.PageBook;
import org.eclipse.ui.part.PageBookView;

/**
 * 
 * @author robin
 *
 */
public class TestGuardPropertyPageBookView extends PageBookView implements ISelectionListener{

	public TestGuardPropertyPageBookView() {
		
	}
	
	

	@Override
	public void init(IViewSite site) throws PartInitException {
		super.init(site);
		site.getPage().addSelectionListener(this);
	}



	@Override
	protected IPage createDefaultPage(PageBook book) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected PageRec doCreatePage(IWorkbenchPart part) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void doDestroyPage(IWorkbenchPart part, PageRec pageRecord) {
		// TODO Auto-generated method stub

	}

	@Override
	protected IWorkbenchPart getBootstrapPart() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected boolean isImportant(IWorkbenchPart part) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		// TODO Auto-generated method stub
		System.out.println(part);
	}

}
