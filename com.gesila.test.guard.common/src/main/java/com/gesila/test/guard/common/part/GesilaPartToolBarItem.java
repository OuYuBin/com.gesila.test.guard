package com.gesila.test.guard.common.part;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.action.IToolBarManager;

/**
 * part页顶部功能区
 * @author robin
 *
 */
public abstract class GesilaPartToolBarItem{
	
	public IToolBarManager toolBarManager;
	
	public IAdaptable adapter;
	
	public GesilaPartToolBarItem(IToolBarManager toolBarManager,IAdaptable adapter){
		this.toolBarManager=toolBarManager;
		this.adapter=adapter;
		createControl();
	}
	
	public abstract void createControl();
}
