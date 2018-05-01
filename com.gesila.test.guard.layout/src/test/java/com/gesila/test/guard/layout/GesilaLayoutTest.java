package com.gesila.test.guard.layout;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

/**
 * 
 * @author robin
 *
 */
public class GesilaLayoutTest {

	public static void main(String[] args) {
		Display display=new Display();
		Shell shell=new Shell(display);
		shell.setSize(300,500);
		FillLayout gesilaLayout=new FillLayout();
		shell.setLayout(gesilaLayout);
		shell.open();
		Composite composite=new Composite(shell,SWT.BORDER);
		GesilaBoderLayout gesilaColumnLayout=new GesilaBoderLayout();
		composite.setLayout(gesilaColumnLayout);
		//shell.setLayout(gesilaLayout);
		//for(int i=0;i<5;i++){
			Button button=new Button(composite,SWT.BUTTON1);
			button.setText("north");
			button.setLayoutData(new GesilaBorderData(GesilaBorderData.NORTH));
			button=new Button(composite,SWT.BUTTON2);
			button.setText("south");
			button.setLayoutData(new GesilaBorderData(GesilaBorderData.SOUTH));
			button=new Button(composite,SWT.BUTTON3);
			button.setText("west");
			button.setLayoutData(new GesilaBorderData(GesilaBorderData.WEST));
			button=new Button(composite,SWT.BUTTON4);
			button.setText("east");
			button.setLayoutData(new GesilaBorderData(GesilaBorderData.EAST));
			button=new Button(composite,SWT.BUTTON5);
			button.setText("center");
			button.setLayoutData(new GesilaBorderData(GesilaBorderData.CENTER));
		//}
		
		
		while(!shell.isDisposed()){
			if(!display.readAndDispatch())
				display.sleep();
		}
		display.beep();
		display.dispose();
	}
}
