package com.gesila.test.guard.navigator.ui.wizards.pages;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EEnum;
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
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.ide.undo.CreateFileOperation;
import org.eclipse.ui.ide.undo.WorkspaceUndoUtil;
import org.eclipse.ui.internal.ide.IDEWorkbenchMessages;
import org.eclipse.ui.internal.ide.IDEWorkbenchPlugin;

import com.gesila.test.guard.model.testGuard.Header;
import com.gesila.test.guard.model.testGuard.Headers;
import com.gesila.test.guard.model.testGuard.Params;
import com.gesila.test.guard.model.testGuard.RequestBody;
import com.gesila.test.guard.model.testGuard.TestGuard;
import com.gesila.test.guard.model.testGuard.TestGuardFactory;
import com.gesila.test.guard.model.testGuard.TestGuardPackage;
import com.gesila.test.guard.navigator.ui.Activator;
import com.gesila.test.guard.navigator.ui.wizards.models.PostGuardRequest;

/**
 * 
 * @author robin
 *
 */
public class PostGuardNewRequestWizardPage extends WizardPage {

	private ISelection selection;

	private PostGuardRequest postGuardRequest;

	public PostGuardNewRequestWizardPage(String pageName, ISelection selection) {
		super(pageName);
		this.setTitle("接口服务");
		this.setMessage("创建一个新的接口服务");
		this.setImageDescriptor(Activator.getDefault().getImageRegistry().getDescriptor("interfaceWizard"));
		this.selection = selection;
		postGuardRequest = new PostGuardRequest();
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
		nameLabel.setText("名称:");
		nameLabel.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false));
		Text nameText = new Text(composite, SWT.BORDER);
		nameText.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
		nameText.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent e) {
				postGuardRequest.setName(nameText.getText());
			}
		});

		Label urlLabel = new Label(composite, SWT.NONE);
		urlLabel.setText("请求地址:");
		urlLabel.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false));
		Text urlText = new Text(composite, SWT.BORDER);
		urlText.setMessage("http://www.eclipse.com/");
		urlText.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
		urlText.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent e) {
				postGuardRequest.setUrl(urlText.getText());
			}
		});

		Label methodLabel = new Label(composite, SWT.NONE);
		methodLabel.setText("请求方法");
		Combo methodsCombo = new Combo(composite, SWT.BORDER);

		EEnum methodEnum = TestGuardPackage.eINSTANCE.getMethod();
		Object[] methods = methodEnum.getELiterals().toArray();
		String[] items = new String[methods.length];
		int i = 0;
		for (Object method : methods) {
			items[i] = method.toString();
			i++;
		}
		methodsCombo.setItems(items);

		methodsCombo.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
		methodsCombo.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent event) {
				Combo methodsCombo = (Combo) event.getSource();
				String method = methodsCombo.getText();
				postGuardRequest.setMethod(method);
			}
		});
		methodsCombo.select(0);

		Label descLabel = new Label(composite, SWT.NONE);
		descLabel.setText("简要描述:");
		urlLabel.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false));
		Text descText = new Text(composite, SWT.BORDER | SWT.MULTI | SWT.WRAP);
		descText.setMessage("填写简要描述信息");
		descText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		descText.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent e) {
				postGuardRequest.setDesc(descText.getText());
			}
		});
		setControl(parent);
	}

	public IFile createNewRequest() {
		String name = postGuardRequest.getName();
		Object object = ((IStructuredSelection) selection).getFirstElement();
		IPath path = ((IAdaptable) object).getAdapter(IPath.class).append(name + ".ptg");
		IFile newFileHandle = createFileHandle(path);
		// final InputStream initialContents = getInitialContents(newFileHandle);

		IRunnableWithProgress op = monitor -> {
			CreateFileOperation createFileOperation = new CreateFileOperation(newFileHandle, null, null,
					IDEWorkbenchMessages.WizardNewFileCreationPage_title);

			try {
				createFileOperation.execute(monitor, WorkspaceUndoUtil.getUIInfoAdapter(getShell()));
				createInitialModel(newFileHandle);
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		};
		try {

			this.getContainer().run(true, true, op);
		} catch (InvocationTargetException | InterruptedException e) {
			e.printStackTrace();
		}
		return newFileHandle;
	}

	/**
	 * 初始化序列化文件
	 * 
	 * @return
	 */
	private void createInitialModel(IFile file) {
		ResourceSet resourceSet = new ResourceSetImpl();
		URI uri = URI.createPlatformResourceURI(file.getFullPath().toString());
		Resource resource = resourceSet.createResource(uri);
		EObject rootEObject = createInitialModel();
		if (rootEObject != null) {
			resource.getContents().add(rootEObject);
		}
		Map<Object, Object> options = new HashMap<Object, Object>();
		options.put(XMLResource.OPTION_ENCODING, "UTF-8");
		try {
			resource.save(options);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private EObject createInitialModel() {
		TestGuard testGuard = TestGuardFactory.eINSTANCE.createTestGuard();
		testGuard.setName(postGuardRequest.getName());
		testGuard.setUrl(postGuardRequest.getUrl());
		testGuard.setDesc(postGuardRequest.getDesc());
		testGuard.setMethod(postGuardRequest.getMethod());
		// TestGuardPackage.eINSTANCE.getRequestMethod().getEEnumLiteral(0).getName();
		// testGuard.setRequestMethod(testGuard);
		// testGuard.setMethod(value);
		Headers headers = TestGuardFactory.eINSTANCE.createHeaders();
		Header header = TestGuardFactory.eINSTANCE.createHeader();
		header.setName("Content-Type");
		header.setValue("application/json");
		headers.getHeader().add(header);
		testGuard.setHeaders(headers);
		Params params = TestGuardFactory.eINSTANCE.createParams();
		testGuard.setParams(params);
		RequestBody requestBody = TestGuardFactory.eINSTANCE.createRequestBody();
		testGuard.setRequestBody(requestBody);
		return testGuard;
	}

	protected IFile createFileHandle(IPath filePath) {
		return IDEWorkbenchPlugin.getPluginWorkspace().getRoot().getFile(filePath);
	}

}
