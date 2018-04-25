package com.gesila.test.guard.layout;


import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Layout;

/**
 * 自定义布局
 * @author robin
 *
 */
public class GesilaColumnLayout extends Layout {

	Point[] sizes;
	int maxWidth;
	int totalHeight;
	
	@Override
	protected Point computeSize(Composite composite, int wHint, int hHint, boolean flushCache) {
		Control[] children=composite.getChildren();
		if(flushCache||sizes==null){
			initialize(children);
		}
		int width=wHint,height=hHint;
		return new Point(width,height);
	}

	@Override
	protected void layout(Composite composite, boolean flushCache) {
		Control[] children=composite.getChildren();
		if(flushCache||sizes==null){
			initialize(children);
		}
		Rectangle rectangle=composite.getClientArea();
		int x=0,y=0;
		int width=rectangle.width;
		for(int i=0;i<children.length;i++){
			int height=sizes[i].y;
			children[i].setBounds(x, y, width, height);
			y+=height;
		}

	}
	
	private void initialize(Control[] children){
		maxWidth=0;
		totalHeight=0;
		sizes=new Point[children.length];
		for(int i=0;i<children.length;i++){
			sizes[i]=children[i].computeSize(SWT.DEFAULT, SWT.DEFAULT,true);
			maxWidth=Math.max(maxWidth, sizes[i].x);
			totalHeight+=sizes[i].y;
		}
	}

}
