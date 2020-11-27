package com.gesila.test.guard.common.editor.part;

import java.rmi.activation.ActivateFailedException;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.IMenuCreator;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.Widget;

import com.gesila.test.guard.common.Activator;
import com.gesila.test.guard.common.part.GesilaPartToolBarItem;
import com.gesila.test.guard.model.testGuard.TestGuardPackage;

/**
 * 
 * @author robin
 *
 */
public class GesilaRequestTypeToolBarItem extends GesilaPartToolBarItem {

	public GesilaRequestTypeToolBarItem(IToolBarManager toolBarManager,IAdaptable adapter) {
		super(toolBarManager,adapter);
	}

	@Override
	public void createControl() {
		IAction requestTypeAction = new Action(null, IAction.AS_DROP_DOWN_MENU | SWT.FocusOut) {

			@Override
			public void run() {
				super.run();
				Menu menu = this.getMenuCreator().getMenu(((ToolBarManager) toolBarManager).getControl());
				if (menu != null) {
					IContributionItem item = toolBarManager.find(this.getId());
					Widget widget = ((ActionContributionItem) item).getWidget();
					Rectangle rect = ((ToolItem) widget).getBounds();
					Point point = new Point(rect.x, rect.y + rect.height);
					point = ((ToolBarManager) toolBarManager).getControl().toDisplay(point);
					menu.setLocation(point.x, point.y);
				}
				menu.setVisible(true);
			}

			@Override
			public String getText() {
				return "POST";
			}

			@Override
			public ImageDescriptor getImageDescriptor() {
				return Activator.getDefault().getImageRegistry().getDescriptor("method");
			}
			
			

		};
		requestTypeAction.setId("RequestType");
		requestTypeAction.setMenuCreator(new IMenuCreator() {

			@Override
			public Menu getMenu(Menu parent) {
				return null;
			}

			@Override
			public Menu getMenu(Control parent) {
//				Menu menu = new Menu(parent);
//				EEnum eEnum = TestGuardPackage.eINSTANCE.getRequestMethod();
//				EList<EEnumLiteral> eList = eEnum.getELiterals();
//				for (EEnumLiteral literal : eList) {
//					MenuItem menuItem = new MenuItem(menu, SWT.RADIO);
//					menuItem.setText(literal.getLiteral());
//				}
//				return menu;
				return null;
			}

			@Override
			public void dispose() {

			}
		});

		ActionContributionItem actionContributionItem = new ActionContributionItem(requestTypeAction);
		//actionContributionItem.setId("request type");
		actionContributionItem.setMode(ActionContributionItem.MODE_FORCE_TEXT);
		this.toolBarManager.add(actionContributionItem);
	}

}
