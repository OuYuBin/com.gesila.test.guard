package com.gesila.test.guard.console;

import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.MessageConsoleStream;

/**
 * 
 * @author robin
 *
 */
public class TestGuardMessageConsoleStream extends MessageConsoleStream {

	public TestGuardMessageConsoleStream(MessageConsole console) {
		super(console);
	}

	@Override
	public void println(String message) {
		super.println(message);
		
	}
	

}
