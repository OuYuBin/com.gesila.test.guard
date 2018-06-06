package com.gesila.test.guard.ui.views;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.IPage;
import org.eclipse.ui.part.MessagePage;
import org.eclipse.ui.part.Page;
import org.eclipse.ui.part.PageBook;
import org.eclipse.ui.part.PageBookView;

import com.gesila.test.guard.ui.views.viewPage.GesilaTestGuardPage;
import com.gesila.test.guard.ui.views.viewPage.IGesilaTestGuardPage;

/**
 * 
 * @author robin
 *
 */
public class TestGuardPropertyPageBookView extends PageBookView implements ISelectionListener {

	public TestGuardPropertyPageBookView() {

	}

	@Override
	public void init(IViewSite site) throws PartInitException {
		super.init(site);
		site.getPage().addSelectionListener(this);
	}

	@Override
	protected IPage createDefaultPage(PageBook book) {
		MessagePage messagePage = new MessagePage();
		initPage(messagePage);
		messagePage.createControl(book);
		return messagePage;
	}

	@Override
	protected PageRec doCreatePage(IWorkbenchPart part) {
		if (part != null) {
			Object object = part.getAdapter(IGesilaTestGuardPage.class);
			if (object instanceof GesilaTestGuardPage) {
				Page page = ((GesilaTestGuardPage) object);
				initPage(page);
				page.createControl(getPageBook());
				return new PageRec(part, page);
			}
		}
		return null;
	}

	@Override
	protected void doDestroyPage(IWorkbenchPart part, PageRec pageRecord) {
		// TODO Auto-generated method stub

	}

	@Override
	protected IWorkbenchPart getBootstrapPart() {
		IWorkbenchPage page = getSite().getPage();
		if (page != null) {
			return page.getActiveEditor();
		}
		return null;
	}

	@Override
	protected boolean isImportant(IWorkbenchPart part) {
		return part instanceof IEditorPart;
	}

	@Override
	public void createPartControl(Composite parent) {
		super.createPartControl(parent);
	}

	@Override
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		System.out.println(part);
		if (part == this && selection != null) {
			return;
		}
		if (getCurrentPage() instanceof IGesilaTestGuardPage) {
			((IGesilaTestGuardPage) getCurrentPage()).selectionChanged(part, selection);
		}
	}

}
