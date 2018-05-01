package com.gesila.test.guard.layout;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.Shell;

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

	/**
	 * 计算通过各子控件大小计算高度与宽度大小
	 * 
	 */
	@Override
	protected Point computeSize(Composite composite, int wHint, int hHint, boolean flushCache) {
		if(sizes==null||flushCache==true) {
			initialize(composite.getChildren());
		}
		int w=wHint;
		int h=hHint;
		if(w==wHint)
			w=width;
		if(h==hHint)
			h=height;
		return new Point(w, h);
		
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
					rectangle.height - sizes[GesilaBorderData.NORTH].y - sizes[GesilaBorderData.SOUTH].y);
		}
		if (controls[GesilaBorderData.SOUTH] != null) {
			controls[GesilaBorderData.SOUTH].setBounds(rectangle.x,
					rectangle.y + rectangle.height - sizes[GesilaBorderData.SOUTH].y, rectangle.width,
					sizes[GesilaBorderData.SOUTH].y);
		}
		if (controls[GesilaBorderData.EAST] != null) {
			controls[GesilaBorderData.EAST].setBounds(rectangle.x + rectangle.width - sizes[GesilaBorderData.EAST].x,
					rectangle.y + sizes[GesilaBorderData.NORTH].y, sizes[GesilaBorderData.EAST].x,
					rectangle.height - sizes[GesilaBorderData.NORTH].y - sizes[GesilaBorderData.NORTH].y);
		}
		if (controls[GesilaBorderData.CENTER] != null) {
			controls[GesilaBorderData.CENTER].setBounds(rectangle.x + sizes[GesilaBorderData.WEST].x,
					rectangle.y + sizes[GesilaBorderData.NORTH].y,
					rectangle.width - sizes[GesilaBorderData.WEST].x - sizes[GesilaBorderData.EAST].x,
					rectangle.height - sizes[GesilaBorderData.SOUTH].y - sizes[GesilaBorderData.NORTH].y);
		}

	}

	/**
	 * 初始化计算合适的容器高度及宽度
	 * @param children
	 */
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
			i++;
		}

		width = Math.max(width, sizes[GesilaBorderData.NORTH].x);

		width = Math.max(width,
				sizes[GesilaBorderData.WEST].x + sizes[GesilaBorderData.CENTER].x + sizes[GesilaBorderData.EAST].x);

		width = Math.max(width, sizes[GesilaBorderData.SOUTH].x);

		height = Math.max(Math.max(sizes[GesilaBorderData.WEST].y, sizes[GesilaBorderData.EAST].y),
				sizes[GesilaBorderData.NORTH].y + sizes[GesilaBorderData.CENTER].y + sizes[GesilaBorderData.SOUTH].y);
	}
	
	public static void main(String[] args) {
		Shell shell=new Shell();
	}
	
	

}
