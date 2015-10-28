package com.gesila.test.guard.common.part;

import org.eclipse.jface.action.IToolBarManager;

/**
 * part页顶部功能区
 * @author robin
 *
 */
public abstract class GesilaPartToolBarItem{
	
	public IToolBarManager toolBarManager;
	
	public GesilaPartToolBarItem(IToolBarManager toolBarManager){
		this.toolBarManager=toolBarManager;
		createControl();
	}
	
	public abstract void createControl();
}
