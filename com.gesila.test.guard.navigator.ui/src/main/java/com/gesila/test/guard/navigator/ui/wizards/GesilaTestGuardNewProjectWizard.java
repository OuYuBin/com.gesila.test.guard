package com.gesila.test.guard.navigator.ui.wizards;

import java.lang.reflect.InvocationTargetException;
import java.net.URI;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResourceStatus;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.osgi.util.NLS;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.ide.undo.CreateProjectOperation;
import org.eclipse.ui.ide.undo.WorkspaceUndoUtil;
import org.eclipse.ui.internal.ide.IDEWorkbenchPlugin;
import org.eclipse.ui.internal.ide.StatusUtil;
import org.eclipse.ui.internal.wizards.newresource.ResourceMessages;
import org.eclipse.ui.statushandlers.StatusAdapter;
import org.eclipse.ui.statushandlers.StatusManager;

import com.gesila.test.guard.navigator.ui.wizards.pages.GesilaTestGuardNewProjectWizardPage;
import com.gesila.test.guard.project.nature.GesilaTestGuardProjectNature;

/**
 * 
 * @author robin
 *
 */
public class GesilaTestGuardNewProjectWizard extends Wizard implements INewWizard {

	GesilaTestGuardNewProjectWizardPage gesilaTestGuardNewProjectWizardPage;

	private IProject newProject;

	public GesilaTestGuardNewProjectWizard() {
		
	}

	@Override
	public void addPages() {
		super.addPages();
		gesilaTestGuardNewProjectWizardPage = new GesilaTestGuardNewProjectWizardPage("gesilaTestGuardNewProjectPage");
		addPage(gesilaTestGuardNewProjectWizardPage);
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
	}

	@Override
	public boolean performFinish() {
		createNewProject();
		return true;
	}

	private IProject createNewProject() {
		if (newProject != null) {
			return newProject;
		}

		// get a project handle
		final IProject newProjectHandle = gesilaTestGuardNewProjectWizardPage.getProjectHandle();

		// get a project descriptor
		URI location = null;
		if (!gesilaTestGuardNewProjectWizardPage.useDefaults()) {
			location = gesilaTestGuardNewProjectWizardPage.getLocationURI();
		}

		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		final IProjectDescription description = workspace.newProjectDescription(newProjectHandle.getName());
		description.setLocationURI(location);

		// try {
		// newProject.setDescription(description, null);
		// addProjectNature(description);
		// } catch (CoreException e1) {
		// e1.printStackTrace();
		// }

		WorkspaceModifyOperation op = new WorkspaceModifyOperation() {

			@Override
			protected void execute(IProgressMonitor monitor)
					throws CoreException, InvocationTargetException, InterruptedException {
				newProjectHandle.create(description, null);
				newProjectHandle.open(new SubProgressMonitor(monitor, 1000));
				addProjectNature(newProjectHandle, monitor);

			}
		};

		// create the new project operation
		// IRunnableWithProgress op = monitor -> {
		// CreateProjectOperation op1 = new CreateProjectOperation(description,
		// ResourceMessages.NewProject_windowTitle);
		// try {
		// // see bug https://bugs.eclipse.org/bugs/show_bug.cgi?id=219901
		// // directly execute the operation so that the undo state is
		// // not preserved. Making this undoable resulted in too many
		// // accidental file deletions.
		// op1.execute(monitor, WorkspaceUndoUtil.getUIInfoAdapter(getShell()));
		// } catch (ExecutionException e) {
		// throw new InvocationTargetException(e);
		// }
		// };

		// run the new project creation operation
		try {
			getContainer().run(true, true, op);
		} catch (InterruptedException e) {
			return null;
		} catch (InvocationTargetException e) {
			Throwable t = e.getTargetException();
			if (t instanceof ExecutionException && t.getCause() instanceof CoreException) {
				CoreException cause = (CoreException) t.getCause();
				StatusAdapter status;
				if (cause.getStatus().getCode() == IResourceStatus.CASE_VARIANT_EXISTS) {
					status = new StatusAdapter(StatusUtil.newStatus(IStatus.WARNING,
							NLS.bind(ResourceMessages.NewProject_caseVariantExistsError, newProjectHandle.getName()),
							cause));
				} else {
					status = new StatusAdapter(StatusUtil.newStatus(cause.getStatus().getSeverity(),
							ResourceMessages.NewProject_errorMessage, cause));
				}
				status.setProperty(StatusAdapter.TITLE_PROPERTY, ResourceMessages.NewProject_errorMessage);
				StatusManager.getManager().handle(status, StatusManager.BLOCK);
			} else {
				StatusAdapter status = new StatusAdapter(new Status(IStatus.WARNING, IDEWorkbenchPlugin.IDE_WORKBENCH,
						0, NLS.bind(ResourceMessages.NewProject_internalError, t.getMessage()), t));
				status.setProperty(StatusAdapter.TITLE_PROPERTY, ResourceMessages.NewProject_errorMessage);
				StatusManager.getManager().handle(status, StatusManager.LOG | StatusManager.BLOCK);
			}
			return null;
		}

		newProject = newProjectHandle;

		return newProject;
	}

	private void addProjectNature(final IProject project, IProgressMonitor monitor) throws CoreException {
		IProjectDescription description = project.getDescription();
		String[] natureIds = description.getNatureIds();
		String[] newNatureIds = new String[natureIds.length + 1];
		System.arraycopy(natureIds, 0, newNatureIds, 0, natureIds.length);
		newNatureIds[natureIds.length] = GesilaTestGuardProjectNature.ID;
		description.setNatureIds(newNatureIds);
		project.setDescription(description, monitor);
	}

}
