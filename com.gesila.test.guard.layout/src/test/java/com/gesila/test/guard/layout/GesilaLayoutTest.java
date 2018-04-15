package com.gesila.test.guard.layout;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
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
		Shell shell=new Shell(display,SWT.NO_TRIM);
		shell.setSize(300,300);
		shell.open();
		GesilaLayout gesilaLayout=new GesilaLayout();
		shell.setLayout(gesilaLayout);
		for(int i=0;i<5;i++){
			Button button=new Button(shell,SWT.BUTTON1);
			button.setText("test"+i);
		}
		
		while(!shell.isDisposed()){
			if(!display.readAndDispatch())
				display.sleep();
		}
		display.beep();
		display.dispose();
	}
}
