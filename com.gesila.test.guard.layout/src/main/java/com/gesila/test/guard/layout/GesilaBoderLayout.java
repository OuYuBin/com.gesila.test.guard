package com.gesila.test.guard.layout;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Layout;

/**
 * 
 * @author robin
 *
 */
public class GesilaBoderLayout extends Layout {
	
	
	private Control[] controls=new Control[5];
	

	private Point[] sizes;

	@Override
	protected Point computeSize(Composite composite, int wHint, int hHint, boolean flushCache) {
		return null;
	}

	@Override
	protected void layout(Composite composite, boolean flushCache) {
		Control[] children = composite.getChildren();
		for (Control child : children) {
			Object layoutData = child.getLayoutData();
			if (layoutData == null || !(layoutData instanceof GesilaBorderData)) {
				continue;
			}
			GesilaBorderData gesilaBorderData=(GesilaBorderData)layoutData;
			if(gesilaBorderData.getRegion()<0||gesilaBorderData.getRegion()>4) {
				continue;
			}
			controls[gesilaBorderData.getRegion()]=child;
		}
		
		sizes=new Point[5];
		int i=0;
		for(Control control:controls) {
			if(control==null)
				sizes[i]=new Point(0, 0);
			else
				sizes[i]=control.computeSize(SWT.DEFAULT, SWT.DEFAULT, true);
		}
		
		int width=0;
		
		int height=0;
		
		width=Math.max(width, sizes[GesilaBorderData.NORTH].x);

		height=Math.max(height, )
	}

}
