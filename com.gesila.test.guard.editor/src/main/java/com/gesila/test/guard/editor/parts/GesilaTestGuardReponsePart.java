package com.gesila.test.guard.editor.parts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gesila.test.guard.http.GesilaHttpResponse;
import com.gesila.test.guard.json.model.GesilaJSONObject;
import com.gesila.test.guard.json.utils.GesilaJSONUtils;
import com.gesila.test.guard.model.testGuard.TestGuardUnit;

/**
 * 
 * @author robin
 *
 */
public class GesilaTestGuardReponsePart {

	private TreeViewer treeViewer;

	@PostConstruct
	public void createComposite(Composite parent) {
		GridLayout layout = new GridLayout(1, false);
		layout.horizontalSpacing = 0;
		layout.verticalSpacing = 1;
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		parent.setLayout(layout);

		FormToolkit formToolkit = new FormToolkit(parent.getDisplay());
		Form form = formToolkit.createForm(parent);
		form.setText("Reponse");
		formToolkit.decorateFormHeading(form);
		form.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));

		Composite body = form.getBody();
		layout = new GridLayout(1, false);
		layout.horizontalSpacing = 0;
		//layout.verticalSpacing = 0;
		layout.marginWidth = 0;
		body.setLayout(layout);
		
		final Section section = formToolkit.createSection(body, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		section.clientVerticalSpacing = 0;
		section.marginWidth = 0;
		//section.marginHeight = 0;
		section.setText("Filter");
		GridData gd = new GridData(SWT.FILL,SWT.TOP,true,false);
		section.setLayoutData(gd);
		
		Composite searchSectionClient = formToolkit.createComposite(section, SWT.NONE);
		layout = new GridLayout(1, false);
		layout.horizontalSpacing = 0;
		layout.verticalSpacing = 0;
		//layout.marginHeight = 0;
		//layout.marginWidth = 5;
		searchSectionClient.setLayout(layout);
		Text searchText = formToolkit.createText(searchSectionClient, "",
				SWT.BORDER | SWT.SEARCH | SWT.ICON_SEARCH | SWT.CANCEL);
		searchText.setMessage("搜索:Test");
		searchText.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
		section.setClient(searchSectionClient);
		
		Composite client = formToolkit.createComposite(parent, SWT.NONE);
		layout = new GridLayout();
		layout.marginWidth = 5;
		layout.marginTop = 0;
		//layout.marginHeight = 0;
		client.setLayout(layout);
		gd = new GridData(SWT.FILL, SWT.FILL, true, true);
		client.setLayoutData(gd);

		createResponseComposite(client);

	}

	private void createResponseComposite(Composite client) {
		treeViewer = new TreeViewer(client,SWT.MULTI|SWT.BORDER|SWT.FULL_SELECTION);
		Tree tree=treeViewer.getTree();
		tree.setHeaderVisible(true);
		tree.setLinesVisible(true);
		tree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		TreeColumn column = new TreeColumn(treeViewer.getTree(), SWT.NONE);
		column.setWidth(200);
		column.setText("Name");

		column = new TreeColumn(treeViewer.getTree(), SWT.NONE);
		column.setWidth(200);
		column.setText("Value");

		treeViewer.setContentProvider(new ITreeContentProvider() {

			@Override
			public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {

			}

			@Override
			public void dispose() {

			}

			@Override
			public boolean hasChildren(Object element) {
				if (getChildren(element).length > 0) {
					return true;
				}
				return false;
			}

			@Override
			public Object getParent(Object element) {
				return null;
			}

			@Override
			public Object[] getElements(Object inputElement) {
				return (Object[]) ((List) inputElement).toArray(new Object[0]);
			}

			@Override
			public Object[] getChildren(Object parentElement) {
				return ((GesilaJSONObject) parentElement).getGesilaJSONObjects().toArray(new Object[0]);
			}
		});
		treeViewer.setLabelProvider(new ITableLabelProvider() {

			@Override
			public void addListener(ILabelProviderListener listener) {

			}

			@Override
			public void dispose() {

			}

			@Override
			public boolean isLabelProperty(Object element, String property) {
				return false;
			}

			@Override
			public void removeListener(ILabelProviderListener listener) {

			}

			@Override
			public Image getColumnImage(Object element, int columnIndex) {
				return null;
			}

			@Override
			public String getColumnText(Object element, int columnIndex) {
				switch (columnIndex) {
				case 0:
					return ((GesilaJSONObject) element).getName() == null ? "" : ((GesilaJSONObject) element).getName();
				case 1:
					return ((GesilaJSONObject) element).getValue() == null ? "" : ((GesilaJSONObject) element).getValue();
				}
				return null;
			}

		});

	}

	@Inject
	public void setSelection(
			@Optional @Named(IServiceConstants.ACTIVE_SELECTION) GesilaHttpResponse gesilaHttpResponse) {
		if (gesilaHttpResponse != null) {
			update(gesilaHttpResponse);
		}

	}

	private void update(GesilaHttpResponse gesilaHttpResponse) {
		HttpResponse httpResponse = gesilaHttpResponse.getHttpResponse();
		String strResponse = gesilaHttpResponse.getStrResponse();
		String response = null;

		if (strResponse != null) {
			response = strResponse;

		} else if (httpResponse != null) {
			Header[] headers = httpResponse.getAllHeaders();
			HttpEntity httpEntity = httpResponse.getEntity();
			response = getResponseJSON(httpResponse);
			gesilaHttpResponse.setStrResponse(response);
		}

		List list = new ArrayList();
		JSONObject jsonObject = GesilaJSONUtils.createJSONObject(response);
		GesilaJSONUtils.createGesilaJSONObject(jsonObject, list);
		if (!list.isEmpty()) {
			treeViewer.setInput(list);
			treeViewer.refresh(true);
			treeViewer.expandToLevel(3);

		}

	}

	private String getResponseJSON(HttpResponse httpResponse) {
		HttpEntity httpEntity = httpResponse.getEntity();
		InputStream inputStream;
		try {
			if (httpEntity.isStreaming()) {
				inputStream = httpEntity.getContent();
				InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
				BufferedReader bufferReader = new BufferedReader(inputStreamReader);
				StringBuffer stringBuffer = new StringBuffer();
				String str = null;
				while ((str = bufferReader.readLine()) != null) {
					stringBuffer.append(str);
				}
				inputStream.close();
				inputStreamReader.close();
				bufferReader.close();
				return stringBuffer.toString();
			}

		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		return null;

	}

}
