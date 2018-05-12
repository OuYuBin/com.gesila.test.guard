package com.gesila.test.guard.editor;

import java.util.EventObject;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.command.CommandStackListener;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.util.EditUIUtil;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.forms.editor.FormEditor;

import com.gesila.test.guard.editor.pages.GesilaTestGuardFormPage;

/**
 * 
 * 
 * @author robin
 *
 */
public class GesilaTestGuardEditor extends FormEditor {

	private EditingDomain editingDomain;

	private Resource resource;

	@Override
	protected void createPages() {
		super.createPages();
	}

	public GesilaTestGuardEditor() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		// TODO Auto-generated method stub

	}

	@Override
	public void doSaveAs() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(IEditorSite site, IEditorInput input) throws PartInitException {
		// TODO Auto-generated method stub
		setSite(site);
		setInput(input);
		initializedEditingDomain();
	}

	private void initializedEditingDomain() {
		CommandStack commandStack = new BasicCommandStack();
		ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		commandStack.addCommandStackListener(new CommandStackListener() {

			@Override
			public void commandStackChanged(EventObject event) {
				// TODO Auto-generated method stub

			}
		});
		editingDomain = new AdapterFactoryEditingDomain(adapterFactory, commandStack);
	}

	@Override
	public boolean isDirty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isSaveAsAllowed() {
		// TODO Auto-generated method stub
		return false;
	}

	// @Override
	// public void createPartControl(Composite parent) {
	// Composite composite = new Composite(parent, SWT.BORDER);
	// GridLayout gridLayout = new GridLayout(5, false);
	// gridLayout.marginWidth = 5;
	// gridLayout.marginHeight = 5;
	// gridLayout.verticalSpacing = 0;
	// gridLayout.horizontalSpacing = 0;
	// composite.setLayout(gridLayout);
	//
	// Label label = new Label(composite, SWT.NONE);
	// label.setText("Request Method:");
	// label.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
	// Combo combo = new Combo(composite, SWT.NONE);
	// String[] requestMethods = new String[] { "GET", "POST" };
	// combo.setItems(requestMethods);
	// combo.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
	// combo.select(1);
	// Label urlLabel = new Label(composite, SWT.NONE);
	// urlLabel.setText("URL:");
	// urlLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
	// Text urlText = new Text(composite, SWT.BORDER);
	// urlText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
	//
	// Button sendButton = new Button(composite, SWT.BUTTON1);
	// sendButton.setText("Send");
	// sendButton.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
	// Label reponseLabel = new Label(composite, SWT.NONE);
	// reponseLabel.setText("Response:");
	// reponseLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 5,
	// 1));
	// Text responseText = new Text(composite, SWT.BORDER | SWT.MULTI |
	// SWT.READ_ONLY|SWT.WRAP);
	// responseText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 5,
	// 1));
	//
	// sendButton.addSelectionListener(new SelectionListener() {
	//
	// @Override
	// public void widgetSelected(SelectionEvent e) {
	// try {
	// HttpClient httpClient = HttpClients.createDefault();
	// String url = urlText.getText();
	// HttpPost httpPost = new HttpPost(url);
	// httpPost.setEntity(new StringEntity("{\"_method\":\"GET\"}"));
	// HttpResponse response = httpClient.execute(httpPost);
	// HttpEntity entity = response.getEntity();
	// ByteArrayOutputStream outStream = new ByteArrayOutputStream();
	// byte[] data = new byte[4096];
	// int count = -1;
	// while ((count = entity.getContent().read(data, 0, 4096)) != -1)
	// outStream.write(data, 0, count);
	//
	// data = null;
	// responseText.setText(new String(outStream.toByteArray(), "UTF-8"));
	// } catch (ClientProtocolException e1) {
	// e1.printStackTrace();
	// } catch (IOException e1) {
	// e1.printStackTrace();
	// }
	// }
	//
	// @Override
	// public void widgetDefaultSelected(SelectionEvent e) {
	// // TODO Auto-generated method stub
	//
	// }
	// });
	//
	// }

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void addPages() {
		createModel();
		GesilaTestGuardFormPage gesilaTestGuardFormPage = new GesilaTestGuardFormPage(this, "GesilaTestGuardPage",
				"Gesila TestGuard");
		try {
			addPage(gesilaTestGuardFormPage);
		} catch (PartInitException e) {
			e.printStackTrace();
		}
	}

	private void createModel() {
		URI resourceURI = EditUIUtil.getURI(getEditorInput(), editingDomain.getResourceSet().getURIConverter());
		resource = editingDomain.getResourceSet().getResource(resourceURI, true);
		System.out.println(resource);
	}

	public <T> T getAdapter(Class<T> adapter) {
		if (Resource.class==adapter) {
			return (T) resource;
		}
		return super.getAdapter(adapter);
	}
}
