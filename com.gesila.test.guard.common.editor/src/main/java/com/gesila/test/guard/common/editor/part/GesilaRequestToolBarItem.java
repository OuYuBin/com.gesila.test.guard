package com.gesila.test.guard.common.editor.part;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.SWT;

import com.gesila.test.guard.common.Activator;
import com.gesila.test.guard.common.part.GesilaPartToolBarItem;
import com.gesila.test.guard.http.GesilaHttpClient;
import com.gesila.test.guard.model.testGuard.RequestMethod;
import com.gesila.test.guard.model.testGuard.TestGuardUnit;

/**
 * 
 * @author robin
 *
 */
public class GesilaRequestToolBarItem extends GesilaPartToolBarItem {

	public GesilaRequestToolBarItem(IToolBarManager toolBarManager,IAdaptable adapter) {
		super(toolBarManager,adapter);
	}

	@Override
	public void createControl() {
		IAction requestTypeAction = new Action("Send", IAction.AS_PUSH_BUTTON | SWT.FocusIn) {

			@Override
			public void run() {
				super.run();
				// Menu menu = this.getMenuCreator().getMenu(((ToolBarManager)
				// toolBarManager).getControl());
				// if (menu != null) {
				// IContributionItem item = toolBarManager.find(this.getId());
				// Widget widget = ((ActionContributionItem) item).getWidget();
				// Rectangle rect = ((ToolItem) widget).getBounds();
				// Point point = new Point(rect.x, rect.y + rect.height);
				// point = ((ToolBarManager)
				// toolBarManager).getControl().toDisplay(point);
				// menu.setLocation(point.x, point.y);
				// }
				// menu.setVisible(true);
				EObject eObject=adapter.getAdapter(EObject.class);
				if(eObject!=null&&eObject instanceof TestGuardUnit){
					TestGuardUnit testGuardUnit=(TestGuardUnit)eObject;
					GesilaHttpClient gesilaHttpClient=new GesilaHttpClient(testGuardUnit.getUrl());
					String requestBody=((TestGuardUnit)eObject).getRequestBody();
					RequestMethod requestMethod=((TestGuardUnit)eObject).getRequestMethod();
					gesilaHttpClient.setRequestMethod(requestMethod);
					
				}
			}

			@Override
			public ImageDescriptor getImageDescriptor() {
				return Activator.getDefault().getImageRegistry().getDescriptor("running");
			}

		};
		requestTypeAction.setId("RequestSend");

		ActionContributionItem actionContributionItem = new ActionContributionItem(requestTypeAction);
		actionContributionItem.setMode(ActionContributionItem.MODE_FORCE_TEXT);
		this.toolBarManager.add(actionContributionItem);
	}
}
