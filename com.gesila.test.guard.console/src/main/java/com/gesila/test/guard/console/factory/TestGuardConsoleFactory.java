package com.gesila.test.guard.console.factory;

import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleFactory;
import org.eclipse.ui.console.IConsoleManager;

import com.gesila.test.guard.console.TestGuardMessageConsole;

/**
 * 
 * @author robin
 *
 */
public class TestGuardConsoleFactory implements IConsoleFactory {

	private static TestGuardMessageConsole testGuardMessageConsole = new TestGuardMessageConsole("TestGuard Console",
			null);

	@Override
	public void openConsole() {
		if(testGuardMessageConsole!=null){
			IConsoleManager consoleManager=ConsolePlugin.getDefault().getConsoleManager();
			IConsole[] consoles=consoleManager.getConsoles();
			for(int i=0;i<consoles.length;i++){
				if(consoles[i]==testGuardMessageConsole){
					consoleManager.showConsoleView(testGuardMessageConsole);
					return;
				}
			}
			consoleManager.addConsoles(new IConsole[]{testGuardMessageConsole});
			consoleManager.showConsoleView(testGuardMessageConsole);
		}
	}

}
