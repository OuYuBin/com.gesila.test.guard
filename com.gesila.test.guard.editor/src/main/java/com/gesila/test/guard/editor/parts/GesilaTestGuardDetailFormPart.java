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

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.di.Focus;
import org.eclipse.e4.ui.di.Persist;
import org.eclipse.e4.ui.model.application.ui.MDirtyable;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;

import com.alibaba.fastjson.JSONObject;
import com.gesila.test.guard.common.editor.part.GesilaRequestToolBarItem;
import com.gesila.test.guard.common.editor.part.GesilaRequestTypeToolBarItem;
import com.gesila.test.guard.common.editor.part.support.GesilaTextCellEditor;
import com.gesila.test.guard.edit.xml.GesilaTestGuardResourceImpl;
import com.gesila.test.guard.editor.parts.providers.GesilaTestGuardRequestBodyContentProvider;
import com.gesila.test.guard.editor.parts.providers.GesilaTestGuardRequestBodyLableProvider;
import com.gesila.test.guard.json.model.GesilaJSONObject;
import com.gesila.test.guard.json.utils.JSONUtils;
import com.gesila.test.guard.model.testGuard.TestGuardUnit;

public class GesilaTestGuardDetailFormPart implements IAdaptable {
	private Text bodyText;

	@Inject
	private MDirtyable dirtyable;

	@Inject
	private ESelectionService selectionService;

	private Form form;

	private EObject eOwner;

	private FormToolkit formToolkit;

	private boolean commitChanges = false;

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
		// layout.verticalSpacing = 0;
		layout.marginWidth = 0;
		body.setLayout(layout);
		body.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		// --请求单元
		createRequestSection(body);

		commitChanges = true;

	}

	private void createRequestSection(Composite body) {
		Section section = formToolkit.createSection(body, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		section.setText("Request");
		section.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		Composite requestClient = formToolkit.createComposite(section, SWT.NONE);
		GridLayout gridLayout = new GridLayout();
		gridLayout.verticalSpacing = 1;
		gridLayout.marginWidth = 1;
		requestClient.setLayout(gridLayout);
		// --URL操作区
		createURLComposite(requestClient);
		// --请求体区
		createRequestBodyComposite(requestClient);
		section.setClient(requestClient);

	}

	private void createURLComposite(Composite composite) {
		Composite urlComposite = new Composite(composite, SWT.NONE | SWT.SHADOW_OUT);
		urlComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		urlComposite.setLayout(new GridLayout(3, false));

		// --请求类型
		ToolBar toolBar = new ToolBar(urlComposite, SWT.FLAT | SWT.RIGHT);
		ToolBarManager toolBarManager = new ToolBarManager(toolBar);
		createRequestTypeToolBar(toolBarManager);
		toolBarManager.update(true);
		toolBarManager.getControl().setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, true));

		// --url输入
		Text urlText = new Text(urlComposite, SWT.BORDER | SWT.SINGLE);
		if (eOwner != null) {
			urlText.setText(((TestGuardUnit) eOwner).getUrl());
		}
		urlText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		urlText.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent e) {
				if (commitChanges) {
					Text source = (Text) e.getSource();
					((TestGuardUnit) eOwner).setUrl(source.getText());
					setDirty(true);
				}
			}
		});

		// --请求动作
		toolBar = new ToolBar(urlComposite, SWT.FLAT | SWT.RIGHT);
		toolBar.setBackground(new Color(null, 228, 58, 72));
		toolBar.setForeground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		toolBar.setBackgroundMode(SWT.INHERIT_FORCE);
		toolBarManager = new ToolBarManager(toolBar);
		createRequestSendToolBar(toolBarManager);
		toolBarManager.update(true);
		toolBarManager.getControl().setLayoutData(new GridData(SWT.END, SWT.CENTER, false, true));

	}

	private void createRequestBodyComposite(Composite composite) {
		Composite requestBodyComposite = new Composite(composite, SWT.NONE);
		requestBodyComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		requestBodyComposite.setLayout(new GridLayout());

		CTabFolder bodyCTabFolder = new CTabFolder(requestBodyComposite, SWT.NONE);
		bodyCTabFolder.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		bodyCTabFolder.setSimple(true);

		// --文本模式
		CTabItem textTabItem = new CTabItem(bodyCTabFolder, SWT.NONE);
		textTabItem.setText("Text");
		textTabItem.setShowClose(false);

		bodyText = new Text(bodyCTabFolder, SWT.BORDER | SWT.WRAP);
		bodyText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		if (eOwner != null) {
			String requestBody = ((TestGuardUnit) eOwner).getRequestBody();
			bodyText.setText(requestBody);
		}
		bodyText.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent e) {
				if (commitChanges) {
					((TestGuardUnit) eOwner).setRequestBody(bodyText.getText());
					setDirty(true);
				}

			}
		});
		textTabItem.setControl(bodyText);

		// --JSON格式列表模式
		CTabItem jsonCTabItem = new CTabItem(bodyCTabFolder, SWT.NONE);
		jsonCTabItem.setText("Json");
		jsonCTabItem.setShowClose(false);

		Composite jsonComposite = new Composite(bodyCTabFolder, SWT.BORDER);
		jsonComposite.setLayout(new GridLayout(1, false));
		jsonComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		TreeViewer treeViewer = new TreeViewer(bodyCTabFolder, SWT.BORDER);
		Tree tree = treeViewer.getTree();
		tree.setHeaderVisible(true);
		tree.setLinesVisible(true);
		tree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		TreeColumn column = new TreeColumn(treeViewer.getTree(), SWT.NONE);
		column.setWidth(200);
		column.setText("Name");

		TreeViewerColumn valueColumn = new TreeViewerColumn(treeViewer, SWT.NONE);
		valueColumn.getColumn().setWidth(200);
		valueColumn.getColumn().setText("Value");

		valueColumn.setEditingSupport(new EditingSupport(treeViewer) {

			@Override
			protected void setValue(Object element, Object value) {
				
			}

			@Override
			protected Object getValue(Object element) {
				if(element instanceof GesilaJSONObject){
					return ((GesilaJSONObject)element).getValue();
				}
				return null;
			}

			@Override
			protected CellEditor getCellEditor(Object element) {
				return new GesilaTextCellEditor(tree);
			}

			@Override
			protected boolean canEdit(Object element) {
				return true;
			}
		});
		treeViewer.setContentProvider(new GesilaTestGuardRequestBodyContentProvider());
		treeViewer.setLabelProvider(new GesilaTestGuardRequestBodyLableProvider());

		List<GesilaJSONObject> list = new ArrayList<GesilaJSONObject>();
		if (eOwner != null) {
			String requestBody = ((TestGuardUnit) eOwner).getRequestBody();
			JSONObject jsonObject = JSONUtils.createJSONObject(requestBody);
			JSONUtils.createGesilaJSONObject(jsonObject, list);
			treeViewer.setInput(list);
		}
		jsonCTabItem.setControl(treeViewer.getControl());
		bodyCTabFolder.setSelection(0);
	}

	@Persist
	public void doSave(@Optional IProgressMonitor progressMonitor) throws IOException {
		// URI uri = URI.createFileURI(file.getAbsolutePath());
		// --创建一个资源
		// GesilaTestGuardResourceImpl gesilaTestGuardResourceImpl = new
		// GesilaTestGuardResourceImpl(uri);
		// gesilaTestGuardResourceImpl.setEncoding("UTF-8");
		// gesilaTestGuardResourceImpl.save(Collections.EMPTY_MAP);

		Resource resource = eOwner.eResource();
		if (resource != null) {
			resource.save(Collections.EMPTY_MAP);
		}
		dirtyable.setDirty(false);

	}

	/**
	 * 选择提供响应注入
	 * 
	 * @param eObject
	 */
	@Inject
	public void setSelection(@Optional @Named(IServiceConstants.ACTIVE_SELECTION) EObject eOwner) {
		if (eOwner != null)
			this.eOwner = eOwner;
	}

	private GesilaRequestToolBarItem createRequestSendToolBar(IToolBarManager toolBarManager) {
		return new GesilaRequestToolBarItem(toolBarManager, this);
	}

	private GesilaRequestTypeToolBarItem createRequestTypeToolBar(IToolBarManager toolBarManager) {
		return new GesilaRequestTypeToolBarItem(toolBarManager, this);
	}

	@Focus
	public void setFocus() {
		form.getBody().setFocus();
	}

	void setDirty(boolean dirty) {
		dirtyable.setDirty(dirty);
	}

	@Persist
	public void save() {
		setDirty(false);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T getAdapter(Class<T> adapter) {
		if (adapter == EObject.class) {
			return (T) eOwner;
		} else if (adapter == ESelectionService.class) {
			return (T) selectionService;
		}
		return null;
	}

}