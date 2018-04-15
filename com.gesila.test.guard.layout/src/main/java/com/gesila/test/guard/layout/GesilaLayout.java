package com.gesila.test.guard.layout;

import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Layout;

/**
 * 自定义布局
 * @author robin
 *
 */
public class GesilaLayout extends Layout {

	@Override
	protected Point computeSize(Composite composite, int wHint, int hHint, boolean flushCache) {
		Control[] controls=composite.getChildren();
		int width=wHint,height=hHint;
		return null;
	}

	@Override
	protected void layout(Composite arg0, boolean arg1) {
		// TODO Auto-generated method stub

	}

}
