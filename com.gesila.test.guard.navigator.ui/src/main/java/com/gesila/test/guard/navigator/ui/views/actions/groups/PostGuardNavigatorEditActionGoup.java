package com.gesila.test.guard.navigator.ui.views.actions.groups;

import org.eclipse.core.resources.IResource;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.SameShellProvider;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchCommandConstants;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.ActionGroup;
import org.eclipse.ui.actions.TextActionHandler;
import org.eclipse.ui.ide.ResourceSelectionUtil;
import org.eclipse.ui.navigator.ICommonMenuConstants;

import com.gesila.test.guard.navigator.ui.views.actions.SimulabCopyAction;
import com.gesila.test.guard.navigator.ui.views.actions.SimulabPasteAction;
import com.gesila.test.guard.navigator.ui.views.actions.PostGuardProjectElementDeleteAction;


/**
 * 
 * @author robin
 *
 */
public class PostGuardNavigatorEditActionGoup extends ActionGroup {
	private Clipboard clipboard;

	private SimulabCopyAction copyAction;

	private PostGuardProjectElementDeleteAction deleteAction;

	private SimulabPasteAction pasteAction; 

	private TextActionHandler textActionHandler;

	private Shell shell;

	/**
	 * @param aShell
	 */
	public PostGuardNavigatorEditActionGoup(Shell aShell) {
		shell = aShell; 
		makeActions();
	}

	@Override
	public void dispose() {
		if (clipboard != null) {
			clipboard.dispose();
			clipboard = null;
		}
		super.dispose();
	}

	@Override
	public void fillContextMenu(IMenuManager menu) {
		IStructuredSelection selection = (IStructuredSelection) getContext().getSelection();

		boolean anyResourceSelected = !selection.isEmpty()
				&& ResourceSelectionUtil.allResourcesAreOfType(selection,
						IResource.PROJECT | IResource.FOLDER | IResource.FILE);

		copyAction.selectionChanged(selection);
		menu.appendToGroup(ICommonMenuConstants.GROUP_EDIT, copyAction);
		pasteAction.selectionChanged(selection);
		//menu.insertAfter(copyAction.getId(), pasteAction);
		menu.appendToGroup(ICommonMenuConstants.GROUP_EDIT, pasteAction);

		if (anyResourceSelected) {
			deleteAction.selectionChanged(selection);
			//menu.insertAfter(pasteAction.getId(), deleteAction);
			menu.appendToGroup(ICommonMenuConstants.GROUP_EDIT, deleteAction);
		}
	}

	@Override
	public void fillActionBars(IActionBars actionBars) {
		if (textActionHandler == null) {
			textActionHandler = new TextActionHandler(actionBars); // hook handlers
		}
		textActionHandler.setCopyAction(copyAction);
		textActionHandler.setPasteAction(pasteAction);
		textActionHandler.setDeleteAction(deleteAction);
		//renameAction.setTextActionHandler(textActionHandler);
		updateActionBars();

//		textActionHandler.updateActionBars();
		actionBars.setGlobalActionHandler(ActionFactory.COPY.getId(), copyAction);
		actionBars.setGlobalActionHandler(ActionFactory.PASTE.getId(), pasteAction);
		actionBars.setGlobalActionHandler(ActionFactory.DELETE.getId(), deleteAction);
	}

	protected void makeActions() {
		final SameShellProvider shellProvider= new SameShellProvider(shell);
		clipboard = new Clipboard(shell.getDisplay());

		pasteAction = new SimulabPasteAction(shell, clipboard);
		ISharedImages images = PlatformUI.getWorkbench().getSharedImages();
		pasteAction.setDisabledImageDescriptor(images.getImageDescriptor(ISharedImages.IMG_TOOL_PASTE_DISABLED));
		pasteAction.setImageDescriptor(images.getImageDescriptor(ISharedImages.IMG_TOOL_PASTE));
		pasteAction.setActionDefinitionId(IWorkbenchCommandConstants.EDIT_PASTE);

		copyAction = new SimulabCopyAction(shell, clipboard, pasteAction);
		copyAction.setDisabledImageDescriptor(images.getImageDescriptor(ISharedImages.IMG_TOOL_COPY_DISABLED));
		copyAction.setImageDescriptor(images.getImageDescriptor(ISharedImages.IMG_TOOL_COPY));
		copyAction.setActionDefinitionId(IWorkbenchCommandConstants.EDIT_COPY);
 
		deleteAction = new PostGuardProjectElementDeleteAction(shellProvider);
		deleteAction.setDisabledImageDescriptor(
				images.getImageDescriptor(ISharedImages.IMG_TOOL_DELETE_DISABLED));
		deleteAction.setImageDescriptor(images.getImageDescriptor(ISharedImages.IMG_TOOL_DELETE));
		deleteAction.setActionDefinitionId(IWorkbenchCommandConstants.EDIT_DELETE);
	}

	@Override
	public void updateActionBars() {
		IStructuredSelection selection = (IStructuredSelection) getContext().getSelection();

		copyAction.selectionChanged(selection);
		pasteAction.selectionChanged(selection);
		deleteAction.selectionChanged(selection); 
	}
}
