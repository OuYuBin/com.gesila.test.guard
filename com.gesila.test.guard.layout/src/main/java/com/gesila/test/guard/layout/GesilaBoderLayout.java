package com.gesila.test.guard.layout;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Layout;

/**
 * 
 * @author robin
 *
 */
public class GesilaBoderLayout extends Layout {

	private Control[] controls = new Control[5];

	private Point[] sizes;

	private int width;

	private int height;

	@Override
	protected Point computeSize(Composite composite, int wHint, int hHint, boolean flushCache) {
		return null;
	}

	@Override
	protected void layout(Composite composite, boolean flushCache) {
		Control[] children = composite.getChildren();
		if (sizes == null) {
			initialize(children);
		}

		Rectangle rectangle = composite.getClientArea();
		if (controls[GesilaBorderData.NORTH] != null) {
			controls[GesilaBorderData.NORTH].setBounds(rectangle.x, rectangle.y, rectangle.width,
					sizes[GesilaBorderData.NORTH].y);
		}
		if (controls[GesilaBorderData.WEST] != null) {
			controls[GesilaBorderData.WEST].setBounds(rectangle.x, rectangle.y + sizes[GesilaBorderData.NORTH].y,
					sizes[GesilaBorderData.WEST].x,
					rectangle.height - sizes[GesilaBorderData.NORTH].y - sizes[GesilaBorderData.SOURTH].y);
		}

	}

	private void initialize(Control[] children) {
		for (Control child : children) {
			Object layoutData = child.getLayoutData();
			if (layoutData == null || !(layoutData instanceof GesilaBorderData)) {
				continue;
			}
			GesilaBorderData gesilaBorderData = (GesilaBorderData) layoutData;
			if (gesilaBorderData.getRegion() < 0 || gesilaBorderData.getRegion() > 4) {
				continue;
			}
			controls[gesilaBorderData.getRegion()] = child;
		}

		sizes = new Point[5];
		int i = 0;
		for (Control control : controls) {
			if (control == null)
				sizes[i] = new Point(0, 0);
			else
				sizes[i] = control.computeSize(SWT.DEFAULT, SWT.DEFAULT, true);
		}

		width = Math.max(width, sizes[GesilaBorderData.NORTH].x);

		width = Math.max(width,
				sizes[GesilaBorderData.WEST].x + sizes[GesilaBorderData.CENTER].x + sizes[GesilaBorderData.EAST].x);

		width = Math.max(width, sizes[GesilaBorderData.SOURTH].x);

		height = Math.max(Math.max(sizes[GesilaBorderData.WEST].y, sizes[GesilaBorderData.EAST].y),
				sizes[GesilaBorderData.NORTH].y + sizes[GesilaBorderData.CENTER].y + sizes[GesilaBorderData.SOURTH].y);
	}

}
