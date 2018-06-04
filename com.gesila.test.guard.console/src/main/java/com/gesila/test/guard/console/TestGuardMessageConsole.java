package com.gesila.test.guard.console;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.MessageConsoleStream;

/**
 * 
 * @author robin
 *
 */
public class TestGuardMessageConsole extends MessageConsole {

	public TestGuardMessageConsole(String name, ImageDescriptor imageDescriptor) {
		super(name, imageDescriptor);
	}

	@Override
	public MessageConsoleStream newMessageStream() {
		return new TestGuardMessageConsoleStream(this);
	}
	
	

}
