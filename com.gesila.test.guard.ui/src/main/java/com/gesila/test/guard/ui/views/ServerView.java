package com.gesila.test.guard.ui.views;

import java.util.ArrayList;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.DrillDownAdapter;
import org.eclipse.ui.part.ViewPart;

//import com.gesila.test.guard.editor.input.GesilaTestGuardEditorInput;
import com.gesila.test.guard.ui.models.GesilaTestGuardEntry;
import com.gesila.test.guard.ui.models.GesilaTestGuardGroup;
import com.gesila.test.guard.ui.models.GesilaTestGuardRoot;
import com.gesila.test.guard.ui.providers.GesilaTestGuardLabelProvider;
import com.gesila.test.guard.ui.providers.GesilaTestGuardTreeContentProvider;

/**
 * This sample class demonstrates how to plug-in a new workbench view. The view
 * shows data obtained from the model. The sample creates a dummy model on the
 * fly, but a real implementation would connect to the model available either in
 * this or another plug-in (e.g. the workspace). The view is connected to the
 * model using a content provider.
 * <p>
 * The view uses a label provider to define how model objects should be
 * presented in the view. Each view can present the same model objects using
 * different labels and icons, if needed. Alternatively, a single label provider
 * can be shared between views in order to ensure that objects of the same type
 * are presented in the same way everywhere.
 * <p>
 */

public class ServerView extends ViewPart {

	/**
	 * The ID of the view as specified by the extension.
	 */
	public static final String ID = "com.gesila.test.guard.ui.views.ServerView";

	private TreeViewer viewer;
	private DrillDownAdapter drillDownAdapter;
	private Action action1;
	private Action action2;
	private Action doubleClickAction;

	class TreeObject implements IAdaptable {
		private String name;
		private TreeParent parent;

		public TreeObject(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}

		public void setParent(TreeParent parent) {
			this.parent = parent;
		}

		public TreeParent getParent() {
			return parent;
		}

		public String toString() {
			return getName();
		}

		public <T> T getAdapter(Class<T> key) {
			return null;
		}
	}

	class TreeParent extends TreeObject {
		private ArrayList children;

		public TreeParent(String name) {
			super(name);
			children = new ArrayList();
		}

		public void addChild(TreeObject child) {
			children.add(child);
			child.setParent(this);
		}

		public void removeChild(TreeObject child) {
			children.remove(child);
			child.setParent(null);
		}

		public TreeObject[] getChildren() {
			return (TreeObject[]) children.toArray(new TreeObject[children.size()]);
		}

		public boolean hasChildren() {
			return children.size() > 0;
		}
	}

	class ViewContentProvider implements ITreeContentProvider {
		private TreeParent invisibleRoot;

		public Object[] getElements(Object parent) {
			if (parent.equals(getViewSite())) {
				if (invisibleRoot == null)
					initialize();
				return getChildren(invisibleRoot);
			}
			return getChildren(parent);
		}

		public Object getParent(Object child) {
			if (child instanceof TreeObject) {
				return ((TreeObject) child).getParent();
			}
			return null;
		}

		public Object[] getChildren(Object parent) {
			if (parent instanceof TreeParent) {
				return ((TreeParent) parent).getChildren();
			}
			return new Object[0];
		}

		public boolean hasChildren(Object parent) {
			if (parent instanceof TreeParent)
				return ((TreeParent) parent).hasChildren();
			return false;
		}

		/*
		 * We will set up a dummy model to initialize tree heararchy. In a real code,
		 * you will connect to a real model and expose its hierarchy.
		 */
		private GesilaTestGuardRoot initialize() {
			// TreeObject to1 = new TreeObject("Leaf 1");
			// TreeObject to2 = new TreeObject("Leaf 2");
			// TreeObject to3 = new TreeObject("Leaf 3");
			// TreeParent p1 = new TreeParent("Parent 1");
			// p1.addChild(to1);
			// p1.addChild(to2);
			// p1.addChild(to3);
			//
			// TreeObject to4 = new TreeObject("Leaf 4");
			// TreeParent p2 = new TreeParent("Parent 2");
			// p2.addChild(to4);
			//
			// TreeParent root = new TreeParent("Root");
			// root.addChild(p1);
			// root.addChild(p2);
			//
			// invisibleRoot = new TreeParent("");
			// invisibleRoot.addChild(root);
			GesilaTestGuardRoot gesilaTestGuardRoot = new GesilaTestGuardRoot();

			GesilaTestGuardGroup gesilaTestGuardGroup = new GesilaTestGuardGroup(null);
			gesilaTestGuardGroup.setName("Group1");
			GesilaTestGuardEntry gesilaTestGuard = new GesilaTestGuardEntry(gesilaTestGuardGroup);
			gesilaTestGuard.setName("test1");
			gesilaTestGuardGroup.addTestGuard(gesilaTestGuard);

			gesilaTestGuardRoot.addTestGuard(gesilaTestGuardGroup);
			return gesilaTestGuardRoot;

		}
	}

	class ViewLabelProvider extends LabelProvider {

		public String getText(Object obj) {
			return obj.toString();
		}

		public Image getImage(Object obj) {
			String imageKey = ISharedImages.IMG_OBJ_ELEMENT;
			if (obj instanceof TreeParent)
				imageKey = ISharedImages.IMG_OBJ_FOLDER;
			return PlatformUI.getWorkbench().getSharedImages().getImage(imageKey);
		}
	}

	/**
	 * The constructor.
	 */
	public ServerView() {
	}

	private GesilaTestGuardRoot initialize() {
		// TreeObject to1 = new TreeObject("Leaf 1");
		// TreeObject to2 = new TreeObject("Leaf 2");
		// TreeObject to3 = new TreeObject("Leaf 3");
		// TreeParent p1 = new TreeParent("Parent 1");
		// p1.addChild(to1);
		// p1.addChild(to2);
		// p1.addChild(to3);
		//
		// TreeObject to4 = new TreeObject("Leaf 4");
		// TreeParent p2 = new TreeParent("Parent 2");
		// p2.addChild(to4);
		//
		// TreeParent root = new TreeParent("Root");
		// root.addChild(p1);
		// root.addChild(p2);
		//
		// invisibleRoot = new TreeParent("");
		// invisibleRoot.addChild(root);
		GesilaTestGuardRoot gesilaTestGuardRoot = new GesilaTestGuardRoot();

		GesilaTestGuardGroup gesilaTestGuardGroup = new GesilaTestGuardGroup(null);
		gesilaTestGuardGroup.setName("Group1");
		GesilaTestGuardEntry gesilaTestGuardEntry = new GesilaTestGuardEntry(gesilaTestGuardGroup);
		gesilaTestGuardEntry.setName("test1");
		gesilaTestGuardGroup.addTestGuard(gesilaTestGuardEntry);

		gesilaTestGuardRoot.addTestGuard(gesilaTestGuardGroup);
		return gesilaTestGuardRoot;

	}

	/**
	 * This is a callback that will allow us to create the viewer and initialize it.
	 */
	public void createPartControl(Composite parent) {
		viewer = new TreeViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		drillDownAdapter = new DrillDownAdapter(viewer);

		viewer.setContentProvider(new GesilaTestGuardTreeContentProvider());
		viewer.setInput(initialize());
		viewer.setLabelProvider(new GesilaTestGuardLabelProvider());

		// Create the help context id for the viewer's control
		// PlatformUI.getWorkbench().getHelpSystem().setHelp(viewer.getControl(),
		// "com.gesila.test.guard.ui.viewer");
		getSite().setSelectionProvider(viewer);
		viewer.addDoubleClickListener(new IDoubleClickListener() {
			
			@Override
			public void doubleClick(DoubleClickEvent event) {
				ISelection selection=event.getSelection();
//				GesilaTestGuardEditorInput gesilaTestGuardEditorInput=new GesilaTestGuardEditorInput();
//				try {
//					ServerView.this.getViewSite().getPage().openEditor(gesilaTestGuardEditorInput, "com.gesila.test.guard.editor.GesilaTestGuardEditor");
//				} catch (PartInitException e) {
//					e.printStackTrace();
//				}
			}
		});
		// makeActions();
		// hookContextMenu();
		// hookDoubleClickAction();
		// contributeToActionBars();
	}

	private void hookContextMenu() {
		MenuManager menuMgr = new MenuManager("#PopupMenu");
		menuMgr.setRemoveAllWhenShown(true);
		menuMgr.addMenuListener(new IMenuListener() {
			public void menuAboutToShow(IMenuManager manager) {
				ServerView.this.fillContextMenu(manager);
			}
		});
		Menu menu = menuMgr.createContextMenu(viewer.getControl());
		viewer.getControl().setMenu(menu);
		getSite().registerContextMenu(menuMgr, viewer);
	}

	private void contributeToActionBars() {
		IActionBars bars = getViewSite().getActionBars();
		fillLocalPullDown(bars.getMenuManager());
		fillLocalToolBar(bars.getToolBarManager());
	}

	private void fillLocalPullDown(IMenuManager manager) {
		manager.add(action1);
		manager.add(new Separator());
		manager.add(action2);
	}

	private void fillContextMenu(IMenuManager manager) {
		manager.add(action1);
		manager.add(action2);
		manager.add(new Separator());
		drillDownAdapter.addNavigationActions(manager);
		// Other plug-ins can contribute there actions here
		manager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
	}

	private void fillLocalToolBar(IToolBarManager manager) {
		manager.add(action1);
		manager.add(action2);
		manager.add(new Separator());
		drillDownAdapter.addNavigationActions(manager);
	}

	private void makeActions() {
		action1 = new Action() {
			public void run() {
				showMessage("Action 1 executed");
			}
		};
		action1.setText("Action 1");
		action1.setToolTipText("Action 1 tooltip");
		action1.setImageDescriptor(
				PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));

		action2 = new Action() {
			public void run() {
				showMessage("Action 2 executed");
			}
		};
		action2.setText("Action 2");
		action2.setToolTipText("Action 2 tooltip");
		action2.setImageDescriptor(
				PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));
		doubleClickAction = new Action() {
			public void run() {
				ISelection selection = viewer.getSelection();
				Object obj = ((IStructuredSelection) selection).getFirstElement();
				showMessage("Double-click detected on " + obj.toString());
			}
		};
	}

	private void hookDoubleClickAction() {
		viewer.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				doubleClickAction.run();
			}
		});
	}

	private void showMessage(String message) {
		MessageDialog.openInformation(viewer.getControl().getShell(), "Sample View", message);
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
		viewer.getControl().setFocus();
	}
}
