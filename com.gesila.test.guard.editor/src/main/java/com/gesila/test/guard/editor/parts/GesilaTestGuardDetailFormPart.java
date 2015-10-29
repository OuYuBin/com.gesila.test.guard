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
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.di.Focus;
import org.eclipse.e4.ui.di.Persist;
import org.eclipse.e4.ui.model.application.ui.MDirtyable;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.ui.forms.widgets.ColumnLayout;
import org.eclipse.ui.forms.widgets.ColumnLayoutData;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.internal.forms.widgets.ColumnLayoutUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gesila.test.guard.common.editor.part.GesilaRequestToolBarItem;
import com.gesila.test.guard.common.editor.part.GesilaRequestTypeToolBarItem;
import com.gesila.test.guard.model.testGuard.TestGuardUnit;

public class GesilaTestGuardDetailFormPart {

	private Text txtInput;

	private Button button;

	private Text bodyText;

	private Combo combo;

	private TableViewer tableViewer;

	@Inject
	private MDirtyable dirty;

	private String url;

	//private TestGuardUrlObject testGuardUrlObject;

	@Inject
	private ESelectionService selectionService;

	private Form form;

	private EObject eOwner;

	private FormToolkit formToolkit;

	@PostConstruct
	public void createComposite(Composite parent) {
		GridLayout layout = new GridLayout(1, false);
		layout.horizontalSpacing = 0;
		layout.verticalSpacing = 1;
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		parent.setLayout(layout);

		formToolkit = new FormToolkit(parent.getDisplay());
		form = formToolkit.createForm(parent);
		formToolkit.decorateFormHeading(form);
		if (eOwner != null) {
			form.setText(((TestGuardUnit) eOwner).getName());
		}
		form.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		Composite body = form.getBody();
		layout = new GridLayout(1, false);
		layout.horizontalSpacing = 0;
		//layout.verticalSpacing = 0;
		layout.marginWidth = 0;
		body.setLayout(layout);
		body.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		//ColumnLayout columnLayout = new ColumnLayout();
		//columnLayout.minNumColumns = 1;
		//columnLayout.maxNumColumns = 1;
		//body.setLayout();

		createRequestSection(body);

	}

	private void createRequestSection(Composite body) {
		Section section = formToolkit.createSection(body, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		section.setText("Request");
		section.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		Composite requestClient = formToolkit.createComposite(section, SWT.NONE);
		requestClient.setLayout(new GridLayout());
		// --URL操作区
		createURLComposite(requestClient);
		// --请求体区
		createRequestBodyComposite(requestClient);
		section.setClient(requestClient);

	}

	private void createURLComposite(Composite composite) {
		Composite urlComposite = new Composite(composite, SWT.NONE | SWT.SHADOW_OUT);
		urlComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		urlComposite.setLayout(new GridLayout(4, false));

		// --请求类型
		ToolBar toolBar = new ToolBar(urlComposite, SWT.FLAT | SWT.RIGHT);
		ToolBarManager toolBarManager = new ToolBarManager(toolBar);
		createRequestTypeToolBar(toolBarManager);
		toolBarManager.update(true);
		toolBarManager.getControl().setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, true));

		// --url输入
		StyledText urlText = new StyledText(urlComposite, SWT.BORDER | SWT.SINGLE);
		// urlText.set
		urlText.setText("http://www.qq.com");
		urlText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		// --请求动作
		toolBar = new ToolBar(urlComposite, SWT.FLAT | SWT.RIGHT);
		toolBarManager = new ToolBarManager(toolBar);
		createRequestSendToolBar(toolBarManager);
		toolBarManager.update(true);
		toolBarManager.getControl().setLayoutData(new GridData(SWT.END, SWT.CENTER, false, true));

	}

	private void createRequestBodyComposite(Composite composite) {
		// TODO Auto-generated method stub
		Composite requestBodyComposite = new Composite(composite, SWT.NONE);
		requestBodyComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		requestBodyComposite.setLayout(new GridLayout());

		CTabFolder bodyCTabFolder = new CTabFolder(requestBodyComposite, SWT.NONE);
		bodyCTabFolder.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		bodyCTabFolder.setSimple(true);

		// --textTabItem
		CTabItem textTabItem = new CTabItem(bodyCTabFolder, SWT.NONE);
		textTabItem.setText("Text");
		textTabItem.setShowClose(false);

		bodyText = new Text(bodyCTabFolder, SWT.BORDER | SWT.WRAP);
		bodyText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		// if (this.testGuardUrlObject != null) {
		// bodyText.setText(this.testGuardUrlObject.getRequestBody());
		// }
		textTabItem.setControl(bodyText);

		// --jsonTabItem
		CTabItem jsonCTabItem = new CTabItem(bodyCTabFolder, SWT.NONE);
		jsonCTabItem.setText("Json");
		jsonCTabItem.setShowClose(false);

		Composite jsonComposite = new Composite(bodyCTabFolder, SWT.BORDER);
		jsonComposite.setLayout(new GridLayout(1, false));
		jsonComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		TreeViewer treeViewer = new TreeViewer(bodyCTabFolder, SWT.NONE);
		TreeColumn column = new TreeColumn(treeViewer.getTree(), SWT.NONE);
		column.setWidth(200);
		column.setText("Name");

		column = new TreeColumn(treeViewer.getTree(), SWT.NONE);
		column.setWidth(200);
		column.setText("Value");
		treeViewer.getControl().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		treeViewer.getTree().setHeaderVisible(true);

		treeViewer.setContentProvider(new ITreeContentProvider() {

			@Override
			public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
				// TODO Auto-generated method stub

			}

			@Override
			public void dispose() {
				// TODO Auto-generated method stub

			}

			@Override
			public boolean hasChildren(Object element) {
				// TODO Auto-generated method stub
				if (getChildren(element).length > 0) {
					return true;
				}
				return false;
			}

			@Override
			public Object getParent(Object element) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Object[] getElements(Object inputElement) {
				// TODO Auto-generated method stubcreateHeadClinet
				return (Object[]) ((List) inputElement).toArray(new Object[0]);
			}

			@Override
			public Object[] getChildren(Object parentElement) {
				// TODO Auto-generated method stub
				return ((ResponseObject) parentElement).getReponseObjects().toArray(new Object[0]);
			}
		});
		treeViewer.setLabelProvider(new ITableLabelProvider() {

			@Override
			public void removeListener(ILabelProviderListener listener) {
				// TODO Auto-generated method stub

			}

			@Override
			public boolean isLabelProperty(Object element, String property) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public void dispose() {
				// TODO Auto-generated method stub

			}

			@Override
			public void addListener(ILabelProviderListener listener) {
				// TODO Auto-generated method stub

			}

			@Override
			public String getColumnText(Object element, int columnIndex) {
				switch (columnIndex) {
				case 0:
					return ((ResponseObject) element).getName() == null ? "" : ((ResponseObject) element).getName();
				case 1:
					return ((ResponseObject) element).getValue() == null ? "" : ((ResponseObject) element).getValue();
				}
				return null;
			}

			@Override
			public Image getColumnImage(Object element, int columnIndex) {
				// TODO Auto-generated method stub
				return null;
			}
		});

//		String requestBody = this.testGuardUrlObject.getRequestBody();
//		JSONObject respJsonObject = null;
//		char[] responseChars = requestBody.toCharArray();
//		char firstChar = responseChars[0];
//		if ('{' == firstChar) {
//			respJsonObject = JSONObject.parseObject(requestBody);
//		} else {
//			Map map = new HashMap();
//			map.put("name", requestBody);
//			respJsonObject = new JSONObject(map);
//		}

		List list = new ArrayList();
		//createJSONObject(respJsonObject, list);
		treeViewer.setInput(list);

		jsonCTabItem.setControl(treeViewer.getControl());

		bodyCTabFolder.setSelection(0);
	}

	private GesilaRequestToolBarItem createRequestSendToolBar(IToolBarManager toolBarManager) {
		return new GesilaRequestToolBarItem(toolBarManager);
	}

	private GesilaRequestTypeToolBarItem createRequestTypeToolBar(IToolBarManager toolBarManager) {
		return new GesilaRequestTypeToolBarItem(toolBarManager);
	}

	private void createJSONObject(JSONObject respJsonObject, List list) {

		Iterator<String> iter = respJsonObject.keySet().iterator();
		while (iter.hasNext()) {
			// --key
			String key = iter.next();
			ResponseObject responseObject = new ResponseObject();
			responseObject.setName(key);
			String value = respJsonObject.getString(key);
			char fchar = 0;
			if (!"".equals(value)) {
				char[] chars = value.toCharArray();
				fchar = chars[0];
			}
			if ('{' == fchar) {
				createJSONObject(JSONObject.parseObject(value), list);
			} else if ('[' == fchar) {
				JSONArray jsonArray = JSONObject.parseArray(value);
				ListIterator<Object> listIter = jsonArray.listIterator();
				ArrayList tmpList = new ArrayList();
				while (listIter.hasNext()) {
					ArrayList arrayList = new ArrayList();
					Object object = listIter.next();
					// --创建虚拟节点对象
					ResponseObject parentReponseObject = new ResponseObject();
					createJSONObject((JSONObject) object, arrayList);
					parentReponseObject.setReponseObjects(arrayList);
					tmpList.add(parentReponseObject);
				}
				responseObject.setReponseObjects(tmpList);
				list.add(responseObject);
			} else {
				responseObject.setValue(value);
				list.add(responseObject);
			}
		}
	}

	/**
	 * 选择提供响应注入
	 * 
	 * @param eObject
	 */
	@Inject
	public void setSelection(@Optional @Named(IServiceConstants.ACTIVE_SELECTION) EObject eOwner) {
		this.eOwner = eOwner;
		// if(eObject!=null){
		// if(eObject instanceof TestGuardUnit){
		// this.form.setText(((TestGuardUnit)eObject).getName());
		// }
		// }
		// txtInput.setText(url);
	}

	@Focus
	public void setFocus() {
		// tableViewer.getTable().setFocus();
	}

	@Persist
	public void save() {
		dirty.setDirty(false);
	}

	private String getResponseJSON(HttpResponse httpResponse) {
		HttpEntity httpEntity = httpResponse.getEntity();
		InputStream inputStream;
		JSONObject respJsonObject = null;
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
			// --判断是否为json字符串
			// char[] responseChars = stringBuffer.toString().toCharArray();
			// char firstChar = responseChars[0];
			// if ('{' == firstChar) {
			// respJsonObject = JSONObject.parseObject(stringBuffer.toString());
			// } else {
			// Map map = new HashMap();
			// map.put("name", stringBuffer.toString());
			// respJsonObject = new JSONObject(map);
			// }

		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

}