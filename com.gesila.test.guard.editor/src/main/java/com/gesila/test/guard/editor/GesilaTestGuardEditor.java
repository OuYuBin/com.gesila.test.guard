package com.gesila.test.guard.editor;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorPart;

public class GesilaTestGuardEditor extends EditorPart {

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

	@Override
	public void createPartControl(Composite parent) {
		Composite composite = new Composite(parent, SWT.BORDER);
		GridLayout gridLayout = new GridLayout(5, false);
		gridLayout.marginWidth = 5;
		gridLayout.marginHeight = 5;
		gridLayout.verticalSpacing = 0;
		gridLayout.horizontalSpacing = 0;
		composite.setLayout(gridLayout);

		Label label = new Label(composite, SWT.NONE);
		label.setText("Request Method:");
		label.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
		Combo combo = new Combo(composite, SWT.NONE);
		String[] requestMethods = new String[] { "GET", "POST" };
		combo.setItems(requestMethods);
		combo.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
		combo.select(1);
		Label urlLabel = new Label(composite, SWT.NONE);
		urlLabel.setText("URL:");
		urlLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
		Text urlText = new Text(composite, SWT.BORDER);
		urlText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		Button sendButton = new Button(composite, SWT.BUTTON1);
		sendButton.setText("Send");
		sendButton.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
		Label reponseLabel = new Label(composite, SWT.NONE);
		reponseLabel.setText("Response:");
		reponseLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 5, 1));
		Text responseText = new Text(composite, SWT.BORDER | SWT.MULTI | SWT.READ_ONLY|SWT.WRAP);
		responseText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 5, 1));

		sendButton.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					HttpClient httpClient = HttpClients.createDefault();
					String url = urlText.getText();
					HttpPost httpPost = new HttpPost(url);
					httpPost.setEntity(new StringEntity("{\"_method\":\"GET\"}"));
					HttpResponse response = httpClient.execute(httpPost);
					HttpEntity entity = response.getEntity();
					ByteArrayOutputStream outStream = new ByteArrayOutputStream();
					byte[] data = new byte[4096];
					int count = -1;
					while ((count = entity.getContent().read(data, 0, 4096)) != -1)
						outStream.write(data, 0, count);

					data = null;
					responseText.setText(new String(outStream.toByteArray(), "UTF-8"));
				} catch (ClientProtocolException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub

			}
		});

	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

}
