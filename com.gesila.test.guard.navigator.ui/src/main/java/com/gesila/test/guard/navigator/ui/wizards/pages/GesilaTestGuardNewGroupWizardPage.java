package com.gesila.test.guard.navigator.ui.wizards.pages;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.ide.undo.CreateFileOperation;
import org.eclipse.ui.ide.undo.CreateFolderOperation;
import org.eclipse.ui.ide.undo.WorkspaceUndoUtil;
import org.eclipse.ui.internal.ide.IDEWorkbenchMessages;
import org.eclipse.ui.internal.ide.IDEWorkbenchPlugin;

import com.gesila.test.guard.model.testGuard.Header;
import com.gesila.test.guard.model.testGuard.Headers;
import com.gesila.test.guard.model.testGuard.Param;
import com.gesila.test.guard.model.testGuard.Params;
import com.gesila.test.guard.model.testGuard.RequestBody;
import com.gesila.test.guard.model.testGuard.TestGuard;
import com.gesila.test.guard.model.testGuard.TestGuardFactory;
import com.gesila.test.guard.model.testGuard.TestGuardPackage;
import com.gesila.test.guard.navigator.ui.Activator;
import com.gesila.test.guard.navigator.ui.wizards.PostGuardNewRequestWizard;
import com.gesila.test.guard.navigator.ui.wizards.models.GesilaTestGuardGroup;
import com.gesila.test.guard.navigator.ui.wizards.models.PostGuardRequest;

/**
 * 
 * @author robin
 *
 */
public class GesilaTestGuardNewGroupWizardPage extends WizardPage {

	private ISelection selection;

	private GesilaTestGuardGroup gesilaTestGuardGroup;

	public GesilaTestGuardNewGroupWizardPage(String pageName, ISelection selection) {
		super(pageName);
		this.setTitle("模块");
		this.setDescription("创建一个新的模块");
		this.setImageDescriptor(Activator.getDefault().getImageRegistry().getDescriptor("moduleWizard"));
		this.selection = selection;
		gesilaTestGuardGroup=new GesilaTestGuardGroup();
	}

	@Override
	public void createControl(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		GridLayout gridLayout = new GridLayout(2, false);
		gridLayout.marginWidth = 5;
		gridLayout.marginHeight = 5;
		gridLayout.verticalSpacing = 5;
		gridLayout.horizontalSpacing = 5;
		composite.setLayout(gridLayout);
		Label nameLabel = new Label(composite, SWT.NONE);
		nameLabel.setText("模块名称:");
		nameLabel.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false));
		Text nameText = new Text(composite, SWT.BORDER);
		nameText.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
		nameText.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent e) {
				gesilaTestGuardGroup.setName(nameText.getText());
			}
		});
		setControl(parent);
	}
	
	public IFolder createNewFolder(){
		String folderName=gesilaTestGuardGroup.getName();
		Object object = ((IStructuredSelection) selection).getFirstElement();
		IPath path = ((IAdaptable) object).getAdapter(IPath.class).append(folderName);
		IFolder folder=(IFolder) createFolderHandle(path);
		IRunnableWithProgress op = monitor -> {
			CreateFolderOperation createFileOperation = new CreateFolderOperation(folder, null,
					IDEWorkbenchMessages.WizardNewFolderCreationPage_title);

			try {
				createFileOperation.execute(monitor, WorkspaceUndoUtil.getUIInfoAdapter(getShell()));
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		};
		try {

			this.getContainer().run(true, true, op);
		} catch (InvocationTargetException | InterruptedException e) {
			e.printStackTrace();
		}
		return folder;
	}

//	public IFile createNewRequest() {
//		String name = gesilaTestGuardRequest.getName();
//		Object object = ((IStructuredSelection) selection).getFirstElement();
//		IPath path = ((IAdaptable) object).getAdapter(IPath.class).append(name+".gtg");
//		IFile newFileHandle = createFileHandle(path);
//		// final InputStream initialContents = getInitialContents(newFileHandle);
//
//		IRunnableWithProgress op = monitor -> {
//			CreateFileOperation createFileOperation = new CreateFileOperation(newFileHandle, null, null,
//					IDEWorkbenchMessages.WizardNewFileCreationPage_title);
//
//			try {
//				createFileOperation.execute(monitor, WorkspaceUndoUtil.getUIInfoAdapter(getShell()));
//				createInitialModel(newFileHandle);
//			} catch (ExecutionException e) {
//				e.printStackTrace();
//			}
//		};
//		try {
//
//			this.getContainer().run(true, true, op);
//		} catch (InvocationTargetException | InterruptedException e) {
//			e.printStackTrace();
//		}
//		return newFileHandle;
//	}

//	/**
//	 * 初始化序列化文件
//	 * 
//	 * @return
//	 */
//	private void createInitialModel(IFile file) {
//		ResourceSet resourceSet = new ResourceSetImpl();
//		URI uri = URI.createPlatformResourceURI(file.getFullPath().toString());
//		Resource resource = resourceSet.createResource(uri);
//		EObject rootEObject = createInitialModel();
//		if (rootEObject != null) {
//			resource.getContents().add(rootEObject);
//		}
//		Map<Object, Object> options = new HashMap<Object, Object>();
//		options.put(XMLResource.OPTION_ENCODING, "UTF-8");
//		try {
//			resource.save(options);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//
//	private EObject createInitialModel() {
//		TestGuard testGuard = TestGuardFactory.eINSTANCE.createTestGuard();
//		testGuard.setName(gesilaTestGuardRequest.getName());
//		testGuard.setUrl(gesilaTestGuardRequest.getUrl());
//		TestGuardPackage.eINSTANCE.getRequestMethod().getEEnumLiteral(0).getName();
//		//testGuard.setRequestMethod(testGuard);
//		Headers headers=TestGuardFactory.eINSTANCE.createHeaders();
//		Header header=TestGuardFactory.eINSTANCE.createHeader();
//		header.setName("Content-Type");
//		header.setValue("application/json");
//		headers.getHeader().add(header);
//		testGuard.setHeaders(headers);
//		Params params=TestGuardFactory.eINSTANCE.createParams();
//		testGuard.setParams(params);
//		RequestBody requestBody=TestGuardFactory.eINSTANCE.createRequestBody();
//		testGuard.setRequestBody(requestBody);
//		return testGuard;
//	}
//
//	protected IFile createFileHandle(IPath filePath) {
//		return IDEWorkbenchPlugin.getPluginWorkspace().getRoot().getFile(filePath);
//	}

	protected IFolder createFolderHandle(IPath filePath) {
		return IDEWorkbenchPlugin.getPluginWorkspace().getRoot().getFolder(filePath);
	}
}
