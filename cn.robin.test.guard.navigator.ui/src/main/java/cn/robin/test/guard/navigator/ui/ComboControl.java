package cn.robin.test.guard.navigator.ui;

import javax.annotation.PostConstruct;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;

/**
 * 
 * @author robin
 *
 */
public class ComboControl {

	@PostConstruct
	  public void createGui(final Composite parent)
	  {
	    Combo combo = new Combo(parent, SWT.READ_ONLY);

	    
	  }
}
