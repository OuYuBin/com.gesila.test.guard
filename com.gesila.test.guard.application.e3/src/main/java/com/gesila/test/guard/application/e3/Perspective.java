package com.gesila.test.guard.application.e3;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;
import org.eclipse.ui.console.IConsoleConstants;

public class Perspective implements IPerspectiveFactory {

	/**
	 * The ID of the perspective as specified in the extension.
	 */
	public static final String ID = "com.gesila.test.guard.application.e3.perspective";

	@Override
	public void createInitialLayout(IPageLayout layout) {
		String editorArea = layout.getEditorArea();
		layout.setEditorAreaVisible(true);

		layout.addView("com.gesila.test.guard.navigator.ui.views.GesilaTestGuardCommonNavigator", IPageLayout.LEFT,
				0.25f, editorArea);
		
		layout.addView("com.gesila.test.guard.ui.views.GsilaTestGuardResponseViewPart", IPageLayout.RIGHT,
				0.70f, editorArea);

		IFolderLayout bottom= layout.createFolder("left", IPageLayout.BOTTOM, 0.70F, editorArea);
		bottom.addView(IConsoleConstants.ID_CONSOLE_VIEW);
		// IFolderLayout folder = layout.createFolder("messages",
		// IPageLayout.TOP, 0.5f, editorArea);
		// folder.addPlaceholder(View.ID + ":*");
		// folder.addView(View.ID);
		//
		// layout.getViewLayout(NavigationView.ID).setCloseable(false);
		layout.addNewWizardShortcut("com.gesila.test.guard.navigator.ui.wizards.GesilaTestGuardNewProjectWizard");

	}
}
