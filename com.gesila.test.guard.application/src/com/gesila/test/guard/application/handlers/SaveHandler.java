/*******************************************************************************
 * Copyright (c) 2010 - 2013 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Lars Vogel <lars.Vogel@gmail.com> - Bug 419770
 *******************************************************************************/
package com.gesila.test.guard.application.handlers;

import java.lang.reflect.InvocationTargetException;

import javax.inject.Named;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.di.Persist;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.swt.widgets.Shell;

public class SaveHandler {

	@CanExecute
	public boolean canExecute(EPartService partService) {
		MPart detail = partService.findPart("com.gesila.test.guard.application.partdescriptor.detail");
		return detail.isDirty();
	}

	@Execute
	public void execute(IEclipseContext context, @Named(IServiceConstants.ACTIVE_SHELL) Shell shell,
			EPartService partService) throws InvocationTargetException, InterruptedException {
		MPart detials = partService.findPart("com.gesila.test.guard.application.partdescriptor.detail");
		IEclipseContext pmContext = context.createChild();
		ProgressMonitorDialog dialog = new ProgressMonitorDialog(shell);
		dialog.open();
		dialog.run(true, true, new IRunnableWithProgress() {

			@Override
			public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
				Object object = detials.getObject();
				ContextInjectionFactory.invoke(object, Persist.class, pmContext, null);

			}
		});
		if (pmContext != null)
			pmContext.dispose();
	}
}