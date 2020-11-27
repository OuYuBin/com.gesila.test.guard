package com.gesila.test.guard.editor.pages;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.message.BasicNameValuePair;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.EMFEditPlugin;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.source.CompositeRuler;
import org.eclipse.jface.text.source.LineNumberRulerColumn;
import org.eclipse.jface.text.source.projection.ProjectionViewer;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sweetlemonade.eclipse.json.JsonPlugin;
import org.sweetlemonade.eclipse.json.editor.JsonConfiguration;
import org.sweetlemonade.eclipse.json.editor.JsonFormatter;
import org.sweetlemonade.eclipse.json.model.JsonElement;
import org.sweetlemonade.eclipse.json.model.JsonParserMy;

import com.alibaba.fastjson.JSONObject;
import com.gesila.test.guard.common.editor.part.support.GesilaTextCellEditor;
import com.gesila.test.guard.editor.Activator;
import com.gesila.test.guard.editor.editingSupport.HeaderEditingSupport;
import com.gesila.test.guard.editor.editingSupport.ParamsEditingSupport;
import com.gesila.test.guard.editor.parts.providers.GesilaTestGuardRequestBodyContentProvider;
import com.gesila.test.guard.editor.parts.providers.GesilaTestGuardRequestBodyLableProvider;
import com.gesila.test.guard.http.PostGuardHttpClient;
import com.gesila.test.guard.http.PostGuardHttpClientUtil;
import com.gesila.test.guard.http.models.PostResponseInfo;
import com.gesila.test.guard.json.model.GesilaJSONObject;
import com.gesila.test.guard.json.utils.GesilaJSONUtils;
import com.gesila.test.guard.model.testGuard.Header;
import com.gesila.test.guard.model.testGuard.Headers;
import com.gesila.test.guard.model.testGuard.Param;
import com.gesila.test.guard.model.testGuard.Params;
import com.gesila.test.guard.model.testGuard.RequestBody;
import com.gesila.test.guard.model.testGuard.TestGuard;
import com.gesila.test.guard.model.testGuard.TestGuardFactory;
import com.gesila.test.guard.model.testGuard.TestGuardPackage;
import com.gesila.test.guard.ui.views.IGesilaTestGuardViewPart;

/**
 * 
 * @author robin
 *
 */
public class PostGuardFormPage extends FormPage {

	private TestGuard testGuard;

	private TreeViewer jsonTreeViewer;

	private Combo methodsCombo;

	private Text bodyText;

	private ProjectionViewer sourceViewer;

	private Logger logger = LoggerFactory.getLogger(PostGuardFormPage.class);

	private ProgressBar progressBar;

	Form form;

	public PostGuardFormPage(FormEditor editor, String id, String title) {
		super(editor, id, title);
		Resource resource = getEditor().getAdapter(Resource.class);
		testGuard = (TestGuard) resource.getContents().get(0);
	}

	@Override
	protected void createFormContent(IManagedForm managedForm) {
		super.createFormContent(managedForm);
		FormToolkit formToolkit = managedForm.getToolkit();
		ScrolledForm scrolledForm = managedForm.getForm();
		scrolledForm.setText("请求");
		form = scrolledForm.getForm();
		formToolkit.decorateFormHeading(form);

		Composite composite = form.getBody();

		// TableWrapLayout tableWrapLayout = new TableWrapLayout();
		// composite.setLayout(tableWrapLayout);

		GridLayout gridLayout = new GridLayout();
		composite.setLayout(gridLayout);

		Section section = formToolkit.createSection(composite,
				Section.TITLE_BAR | Section.EXPANDED | Section.CLIENT_INDENT | Section.COMPACT);
		section.setText("请求地址");
		section.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		Composite requestComposite = formToolkit.createComposite(section);
		gridLayout = new GridLayout(5, false);
		gridLayout.marginWidth = 5;
		gridLayout.marginHeight = 5;
		gridLayout.verticalSpacing = 0;
		gridLayout.horizontalSpacing = 5;
		requestComposite.setLayout(gridLayout);

		Label methodLabel = formToolkit.createLabel(requestComposite, "请求方法", SWT.NONE);
		methodLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
		methodsCombo = new Combo(requestComposite, SWT.READ_ONLY);
		String currentMethod = testGuard.getMethod();
		EEnum methodEnum = TestGuardPackage.eINSTANCE.getMethod();
		Object[] methods = methodEnum.getELiterals().toArray();
		String[] items = new String[methods.length];
		int i = 0;
		int selectIndex = 0;
		for (Object method : methods) {
			items[i] = method.toString();
			if (StringUtils.equals(items[i], currentMethod)) {
				selectIndex = i;
			}
			i++;
		}
		methodsCombo.setItems(items);

		methodsCombo.select(selectIndex);
		methodsCombo.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
		methodsCombo.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent event) {
				Combo methodsCombo = (Combo) event.getSource();
				EditingDomain editingDomain = getEditor().getAdapter(EditingDomain.class);
				EAttribute methodAttribute = TestGuardPackage.eINSTANCE.getTestGuard_Method();
				String method = methodsCombo.getText();
				SetCommand setCommand = new SetCommand(editingDomain, testGuard, methodAttribute, method);
				editingDomain.getCommandStack().execute(setCommand);
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {

			}

		});

		Label addressLabel = formToolkit.createLabel(requestComposite, "地址", SWT.NONE);
		addressLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));

		Text urlText = formToolkit.createText(requestComposite, null, SWT.BORDER);
		GridData gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
		gridData.widthHint = 100;
		urlText.setLayoutData(gridData);
		urlText.setText(testGuard.getUrl() == null ? "" : testGuard.getUrl());
		urlText.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent event) {
				Text urlText = (Text) event.getSource();
				EditingDomain editingDomain = getEditor().getAdapter(EditingDomain.class);
				EAttribute urlAttribute = TestGuardPackage.eINSTANCE.getTestGuard_Url();
				SetCommand setCommand = new SetCommand(editingDomain, testGuard, urlAttribute, urlText.getText());
				editingDomain.getCommandStack().execute(setCommand);
			}
		});

		Button button = formToolkit.createButton(requestComposite, "发送", SWT.BUTTON1);
		button.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));

		button.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				Job sendJob = new Job("发送服务请求") {

					@Override
					protected IStatus run(IProgressMonitor monitor) {
						try {
							SubMonitor subMonitor = SubMonitor.convert(monitor, 100);
							startSend();
							
							subMonitor.setTaskName("组织请求链接信息...");
							String url = testGuard.getUrl();
							logger.info("Request URL is {}", url);
							subMonitor.worked(10);

							String method = testGuard.getMethod();
							PostGuardHttpClient httpClient = new PostGuardHttpClient(url);
							httpClient.setRequestMethod(method);

							subMonitor.setTaskName("组织消息头信息...");
							// --设置消息头信息
							Headers headers = testGuard.getHeaders();
							Map<String, String> headMap = httpClient.getHeaderMap();
							for (Header header : headers.getHeader()) {
								if (header.getValue() != null) {
									headMap.put(header.getName(), header.getValue());
								}
							}
							subMonitor.worked(10);
							
							subMonitor.setTaskName("组织参数信息...");
							// --设置请求参数
							EList<Param> params = testGuard.getParams().getParam();
							List<org.apache.http.NameValuePair> paramList = new ArrayList<>();
							if (!params.isEmpty()) {
								for (Param param : params) {
									if (StringUtils.isNotBlank(param.getName())
											&& StringUtils.isNotBlank(param.getValue())) {
										paramList.add(new BasicNameValuePair(param.getName(), param.getValue()));
									}
								}
								UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(paramList);
								httpClient.setHttpEntity(formEntity);
							}
							subMonitor.worked(10);

							subMonitor.setTaskName("正在发送请求...");
							// --请求链接
							CloseableHttpResponse response = (CloseableHttpResponse) PostGuardHttpClientUtil
									.execute(httpClient);
							subMonitor.worked(70);
							endSend(response);
						} catch (ClientProtocolException e1) {
							e1.printStackTrace();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						return Status.OK_STATUS;
					}

				};
				sendJob.setUser(true);
				sendJob.schedule();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {

			}

			public void startSend() {
				Display.getDefault().asyncExec(new Runnable() {

					@Override
					public void run() {
						form.setBusy(true);
					}
				});

			}

			private void endSend(CloseableHttpResponse response) {
				Display.getDefault().asyncExec(() -> {
					try {
						form.setBusy(false);
						String responseInfo = "";
						if (response.getStatusLine().getStatusCode() == HttpStatus.SC_MOVED_TEMPORARILY) {
							responseInfo = response.toString();
						} else {
							HttpEntity entity = response.getEntity();
							InputStream inputStream = entity.getContent();
							ByteArrayOutputStream outStream = new ByteArrayOutputStream();
							byte[] data = new byte[4096];
							int count = -1;
							while ((count = inputStream.read(data, 0, 4096)) != -1) {
								outStream.write(data, 0, count);
							}
							responseInfo = new String(outStream.toByteArray());
						}
						PostResponseInfo postRepsoseInfo = new PostResponseInfo();
						postRepsoseInfo.setStatusCode(response.getStatusLine().getStatusCode());
						postRepsoseInfo.setResponseInfo(responseInfo);

						IViewPart viewPart = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
								.findView("com.gesila.test.guard.ui.views.GsilaTestGuardResponseViewPart");
						if (viewPart instanceof IGesilaTestGuardViewPart) {
							((IGesilaTestGuardViewPart) viewPart).refresh(postRepsoseInfo);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				});
			}
		});

		section.setClient(requestComposite);

		Section bodySection = formToolkit.createSection(composite,
				Section.TITLE_BAR | Section.EXPANDED | Section.CLIENT_INDENT | Section.COMPACT);
		bodySection.setText("请求上下文");
		gridLayout = new GridLayout();
		gridLayout.marginWidth = 0;
		gridLayout.marginHeight = 0;
		gridLayout.verticalSpacing = 0;
		gridLayout.horizontalSpacing = 5;
		bodySection.setLayout(gridLayout);
		bodySection.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		Composite requestBodyComposite = formToolkit.createComposite(bodySection, SWT.NONE | SWT.WRAP);
		gridLayout = new GridLayout(1, false);
		gridLayout.marginWidth = 0;
		gridLayout.marginHeight = 0;
		gridLayout.verticalSpacing = 0;
		gridLayout.horizontalSpacing = 0;
		requestBodyComposite.setLayout(gridLayout);

		CTabFolder tabFolder = new CTabFolder(requestBodyComposite, SWT.NONE);
		tabFolder.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		// --Headers
		CTabItem tabItem = new CTabItem(tabFolder, SWT.BORDER);
		tabItem.setText("消息头");
		Composite headerComposite = createHeaderComposite(tabFolder);
		tabItem.setControl(headerComposite);

		CTabItem bodytabItem = new CTabItem(tabFolder, SWT.BORDER);
		bodytabItem.setText("请求体");

		Composite bodyComposite = new Composite(tabFolder, SWT.NONE);
		bodytabItem.setControl(bodyComposite);
		gridLayout = new GridLayout(1, false);
		gridLayout.marginWidth = 0;
		gridLayout.marginHeight = 0;
		gridLayout.verticalSpacing = 0;
		gridLayout.horizontalSpacing = 0;
		bodyComposite.setLayout(gridLayout);

		CTabFolder bodyCTabFolder = new CTabFolder(bodyComposite, SWT.NONE);
		bodyCTabFolder.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		bodyCTabFolder.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent event) {
				CTabFolder bodyCTabFolder = (CTabFolder) event.getSource();
				CTabItem cTabItem = bodyCTabFolder.getSelection();
				String itemText = cTabItem.getText();
				if (itemText.equals("JSON")) {
					List<GesilaJSONObject> list = new ArrayList<GesilaJSONObject>();
					String requestBody = testGuard.getRequestBody().getValue();
					if (requestBody != null) {
						JSONObject jsonObject = GesilaJSONUtils.createJSONObject(requestBody);
						GesilaJSONUtils.createGesilaJSONObject(jsonObject, list);
					}
					jsonTreeViewer.setInput(list);
				}
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent event) {
				// TODO Auto-generated method stub

			}
		});

		createTextTab(bodyCTabFolder);

		createJSONTab(bodyCTabFolder);

		bodyCTabFolder.setSelection(0);

		// --url参数
		createParamsTab(tabFolder);
		tabItem.setControl(headerComposite);

		tabFolder.setSelection(0);

		// Text bodyText = new Text(requestBodyComposite, SWT.BORDER | SWT.WRAP
		// |
		// SWT.MULTI);
		// GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
		// gridData.widthHint = SWT.DEFAULT;
		// gridData.heightHint = SWT.DEFAULT;
		// bodyText.setLayoutData(gridData);

		bodySection.setClient(requestBodyComposite);

	}

	private Composite createHeaderComposite(CTabFolder tabFolder) {

		TableViewerColumn tableViewerColumn;
		HeaderEditingSupport cellEditingSupport = null;
		Composite headerComposite = new Composite(tabFolder, SWT.NONE);
		GridLayout gridLayout = new GridLayout(1, false);
		gridLayout.marginWidth = 0;
		gridLayout.marginHeight = 0;
		gridLayout.verticalSpacing = 0;
		gridLayout.horizontalSpacing = 0;
		headerComposite.setLayout(gridLayout);

		ToolBar toolbar = new ToolBar(headerComposite, SWT.NONE);
		GridData gridData = new GridData(SWT.LEFT, SWT.FILL, true, false);
		ToolItem addItem = new ToolItem(toolbar, SWT.NONE);
		addItem.setImage(Activator.getDefault().getImageRegistry().get("add"));

		ToolItem removeItem = new ToolItem(toolbar, SWT.NONE);
		removeItem.setImage(Activator.getDefault().getImageRegistry().get("remove"));

		toolbar.setLayoutData(gridData);

		TableViewer tableViewer = new TableViewer(headerComposite, SWT.BORDER);

		addItem.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				// List list = (List) tableViewer.getInput();
				/// tableViewer.editElement(list.get(0), 0);
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub

			}
		});

		Table table = tableViewer.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		tableViewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		tableViewerColumn.getColumn().setWidth(200);
		tableViewerColumn.getColumn().setText("名称");
		tableViewerColumn.setLabelProvider(new CellLabelProvider() {

			@Override
			public void update(ViewerCell cell) {
				// Header header = (Header) cell.getElement();
				// cell.setText(header.getName());
				Object object = cell.getElement();
				cell.setText(object.toString());
			}
		});

		Headers headers = testGuard.getHeaders();

		cellEditingSupport = new HeaderEditingSupport(tableViewer, headers, getEditor());
		tableViewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		tableViewerColumn.getColumn().setWidth(400);
		tableViewerColumn.getColumn().setText("值");
		tableViewerColumn.setLabelProvider(new CellLabelProvider() {

			@Override
			public void update(ViewerCell cell) {
				EEnumLiteral element = (EEnumLiteral) cell.getElement();
				// cell.setText(header.getValue());
				String literal = ((EEnumLiteral) element).getLiteral();
				List<Header> headerElements = headers.getHeader().stream()
						.filter(header -> (header.getName()).equals(literal)).collect(Collectors.toList());
				if (!headerElements.isEmpty()) {
					cell.setText(headerElements.get(0).getValue());
				} else {
					// Font initialFont = cell.getFont();
					// FontData[] fontData = initialFont.getFontData();
					// for (int i = 0; i < fontData.length; i++) {
					// fontData[i].setStyle(SWT.ITALIC);
					// }
					// Font newFont = new Font(cell.getControl().getDisplay(),
					// fontData);
					// cell.setFont(newFont);
					// cell.setText("<empty>");
				}
				cell.setImage(getColumnImage());
			}

			public Image getColumnImage() {
				// if (((GesilaJSONObject) element).getValue() == null
				// || "".equals(((GesilaJSONObject) element).getValue())) {
				// return null;
				// }
				String image = "full/obj16/GenericValue";
				// switch (columnIndex) {
				// case 1:
				// String name = ((GesilaJSONObject) element).getName();
				// if (name.equals("_ApplicationId") ||
				// name.equals("_ApplicationKey")) {
				// image = "full/obj16/IntegralValue.gif";
				// }
				// break;
				// }
				return ExtendedImageRegistry.getInstance().getImage(EMFEditPlugin.INSTANCE.getImage(image));
			}
		});
		tableViewerColumn.setEditingSupport(cellEditingSupport);
		// CellEditor cellEditor=cellEditingSupport.getCellEditor(new Object());
		// cellEditor.activate();

		gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
		table.setLayoutData(gridData);

		gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
		headerComposite.setLayoutData(gridData);

		EEnum entityHeaderFieldEnum = TestGuardPackage.eINSTANCE.getEntityHeaderFields();
		Object[] entityHeaderFields = entityHeaderFieldEnum.getELiterals().toArray();

		tableViewer.setContentProvider(new IStructuredContentProvider() {

			@Override
			public Object[] getElements(Object inputElement) {
				return (Object[]) inputElement;
			}
		});
		tableViewer.setInput(entityHeaderFields);

		return headerComposite;
	}

	private void createParamsTab(CTabFolder tabFolder) {
		CTabItem tabItem = new CTabItem(tabFolder, SWT.BORDER);
		// tabItem.setImage(Activator.getDefault().getImageRegistry().get("params"));
		tabItem.setText("URL重组参数");
		Composite paramsComposite = new Composite(tabFolder, SWT.NONE);
		GridLayout gridLayout = new GridLayout(1, false);
		gridLayout.marginWidth = 0;
		gridLayout.marginHeight = 0;
		gridLayout.verticalSpacing = 0;
		gridLayout.horizontalSpacing = 0;
		paramsComposite.setLayout(gridLayout);

		ToolBar toolbar = new ToolBar(paramsComposite, SWT.NONE);
		GridData gridData = new GridData(SWT.RIGHT, SWT.FILL, true, false);
		ToolItem addItem = new ToolItem(toolbar, SWT.NONE);
		addItem.setImage(Activator.getDefault().getImageRegistry().get("add"));
		TableViewer tableViewer = new TableViewer(paramsComposite, SWT.FULL_SELECTION | SWT.BORDER);
		addItem.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				EditingDomain editingDomain = getEditor().getAdapter(EditingDomain.class);
				EReference paramEReference = TestGuardPackage.eINSTANCE.getParams_Param();
				Params params = testGuard.getParams();
				Param param = TestGuardFactory.eINSTANCE.createParam();
				AddCommand addCommand = new AddCommand(editingDomain, params, paramEReference, param);
				editingDomain.getCommandStack().execute(addCommand);
				// param.setName("param1");
				// param.setValue("value1");
				// EList<Param> params = testGuard.getParams().getParam();
				// params.add(param);
				// tableViewer.add(param);
				tableViewer.refresh(true);
				tableViewer.editElement(param, 0);
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub

			}
		});
		ToolItem removeItem = new ToolItem(toolbar, SWT.NONE);
		removeItem.setImage(Activator.getDefault().getImageRegistry().get("remove"));

		Table table = tableViewer.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
		gridData.widthHint = SWT.DEFAULT;
		gridData.heightHint = SWT.DEFAULT;
		table.setLayoutData(gridData);

		TableViewerColumn tableViewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		tableViewerColumn.getColumn().setWidth(200);
		tableViewerColumn.getColumn().setText("名称");
		tableViewerColumn.setEditingSupport(new ParamsEditingSupport(tableViewer, "name", getEditor()));
		tableViewerColumn.setLabelProvider(new CellLabelProvider() {

			@Override
			public void update(ViewerCell cell) {
				Object element = cell.getElement();
				if (element instanceof Param) {
					String name = ((Param) element).getName();
					if (name == null) {
						Font initialFont = cell.getFont();
						FontData[] fontData = initialFont.getFontData();
						for (int i = 0; i < fontData.length; i++) {
							fontData[i].setStyle(SWT.ITALIC);
						}
						Font newFont = new Font(cell.getControl().getDisplay(), fontData);
						cell.setFont(newFont);
						cell.setText("<empty>");
					} else {
						Font initialFont = cell.getFont();
						FontData[] fontData = initialFont.getFontData();
						for (int i = 0; i < fontData.length; i++) {
							fontData[i].setStyle(SWT.NORMAL);
						}
						Font newFont = new Font(cell.getControl().getDisplay(), fontData);
						cell.setFont(newFont);
						cell.setText(name);
					}
				} else {
					cell.setText(element.toString());
				}
			}
		});

		tableViewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		tableViewerColumn.getColumn().setWidth(200);
		tableViewerColumn.getColumn().setText("值");
		tableViewerColumn.setEditingSupport(new ParamsEditingSupport(tableViewer, "value", getEditor()));
		tableViewerColumn.setLabelProvider(new CellLabelProvider() {

			@Override
			public void update(ViewerCell cell) {
				Object element = cell.getElement();
				if (element instanceof Param) {
					String value = ((Param) element).getValue();
					if (value == null) {
						Font initialFont = cell.getFont();
						FontData[] fontData = initialFont.getFontData();
						for (int i = 0; i < fontData.length; i++) {
							fontData[i].setStyle(SWT.ITALIC);
						}
						Font newFont = new Font(cell.getControl().getDisplay(), fontData);
						cell.setFont(newFont);
						cell.setText("<empty>");
					} else {
						Font initialFont = cell.getFont();
						FontData[] fontData = initialFont.getFontData();
						for (int i = 0; i < fontData.length; i++) {
							fontData[i].setStyle(SWT.NORMAL);
						}
						Font newFont = new Font(cell.getControl().getDisplay(), fontData);
						cell.setFont(newFont);
						cell.setText(value);
					}
				} else {
					cell.setText(element.toString());
				}
			}
		});

		tabItem.setControl(paramsComposite);
		tableViewer.setContentProvider(new IStructuredContentProvider() {

			@Override
			public Object[] getElements(Object inputElement) {
				if (inputElement instanceof List) {
					return ((List) inputElement).toArray(new Object[0]);
				}
				return Collections.EMPTY_LIST.toArray();
			}
		});

		EList<Param> params = testGuard.getParams().getParam();
		tableViewer.setInput(params);
	}

	private void createJSONTab(CTabFolder tabFolder) {
		CTabItem tabItem = new CTabItem(tabFolder, SWT.BORDER);
		tabItem.setImage(Activator.getDefault().getImageRegistry().get("json"));
		tabItem.setText("JSON");
		Composite jsonComposite = new Composite(tabFolder, SWT.NONE);
		GridLayout gridLayout = new GridLayout(1, false);
		gridLayout.marginWidth = 0;
		gridLayout.marginHeight = 0;
		gridLayout.verticalSpacing = 0;
		gridLayout.horizontalSpacing = 0;
		jsonComposite.setLayout(gridLayout);

		ToolBar toolbar = new ToolBar(jsonComposite, SWT.NONE);
		GridData gridData = new GridData(SWT.RIGHT, SWT.FILL, true, false);
		ToolItem addItem = new ToolItem(toolbar, SWT.NONE);
		addItem.setImage(Activator.getDefault().getImageRegistry().get("add"));
		addItem.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub

			}
		});
		ToolItem removeItem = new ToolItem(toolbar, SWT.NONE);
		removeItem.setImage(Activator.getDefault().getImageRegistry().get("remove"));

		jsonTreeViewer = new TreeViewer(jsonComposite, SWT.FULL_SELECTION | SWT.BORDER);
		Tree tree = jsonTreeViewer.getTree();
		tree.setHeaderVisible(true);
		tree.setLinesVisible(true);
		gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
		gridData.widthHint = SWT.DEFAULT;
		gridData.heightHint = SWT.DEFAULT;
		tree.setLayoutData(gridData);
		TreeColumn column = new TreeColumn(tree, SWT.NONE);
		column.setWidth(200);
		column.setText("名称");

		TreeViewerColumn valueColumn = new TreeViewerColumn(jsonTreeViewer, SWT.NONE);
		valueColumn.getColumn().setWidth(200);
		valueColumn.getColumn().setText("值");

		valueColumn.setEditingSupport(new EditingSupport(jsonTreeViewer) {

			@Override
			protected void setValue(Object element, Object value) {
				if (element instanceof GesilaJSONObject) {
					Object oldValue = ((GesilaJSONObject) element).getValue();
					if (!value.equals(oldValue)) {
						// JSONObject jsonObject = GesilaJSONUtils
						// .createJSONObject(((TestGuardUnit)
						// eOwner).getRequestBody());
						// String name = ((GesilaJSONObject) element).getName();
						// if (jsonObject.containsKey(name)) {
						// jsonObject.put(name, value);
						// }
						// ((TestGuardUnit)
						// eOwner).setRequestBody(GesilaJSONUtils.createGesilaJSONOString(jsonObject));
						// ((GesilaJSONObject) element).setValue((String)
						// value);
						// jsonTreeViewer.refresh(((GesilaJSONObject) element));
						// setDirty(true);
					}
				}
			}

			@Override
			protected Object getValue(Object element) {
				if (element instanceof GesilaJSONObject) {
					return ((GesilaJSONObject) element).getValue();
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
		jsonTreeViewer.setContentProvider(new GesilaTestGuardRequestBodyContentProvider());
		jsonTreeViewer.setLabelProvider(new GesilaTestGuardRequestBodyLableProvider());

		List<GesilaJSONObject> list = new ArrayList<GesilaJSONObject>();
		RequestBody requestBody = testGuard.getRequestBody();
		if (requestBody != null) {
			String requestBodyValue = testGuard.getRequestBody().getValue();
			JSONObject jsonObject = GesilaJSONUtils.createJSONObject(requestBodyValue);
			GesilaJSONUtils.createGesilaJSONObject(jsonObject, list);
		}
		jsonTreeViewer.setInput(list);

		tabItem.setControl(jsonComposite);

	}

	private void createTextTab(CTabFolder tabFolder) {

		CTabItem tabItem = new CTabItem(tabFolder, SWT.BORDER);
		tabItem.setImage(Activator.getDefault().getImageRegistry().get("text"));
		tabItem.setText("文本");
		Composite textComposite = new Composite(tabFolder, SWT.NONE);
		GridLayout gridLayout = new GridLayout(1, false);
		gridLayout.marginWidth = 0;
		gridLayout.marginHeight = 0;
		gridLayout.verticalSpacing = 0;
		gridLayout.horizontalSpacing = 0;
		// FillLayout fillLayout = new FillLayout();
		textComposite.setLayout(gridLayout);

		Document document = new Document();
		ToolBar toolbar = new ToolBar(textComposite, SWT.NONE);
		GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, false);
		ToolItem formatItem = new ToolItem(toolbar, SWT.NONE);
		formatItem.setImage(Activator.getDefault().getImageRegistry().get("format"));
		formatItem.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				JsonElement mElement = new JsonParserMy(document).parse();
				JsonFormatter mFormatter = new JsonFormatter(mElement, JsonPlugin.getDefault().getPreferenceStore());
				String format = mFormatter.format(document.getLength());
				sourceViewer.getDocument().set(format);
				EditingDomain editingDomain = getEditor().getAdapter(EditingDomain.class);
				EAttribute value = TestGuardPackage.eINSTANCE.getRequestBody_Value();
				RequestBody requestBody = testGuard.getRequestBody();
				// Param param = TestGuardFactory.eINSTANCE.createParam();
				SetCommand setCommand = new SetCommand(editingDomain, requestBody, value, format);
				editingDomain.getCommandStack().execute(setCommand);
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub

			}
		});
		toolbar.setLayoutData(gridData);
		// ToolItem removeItem = new ToolItem(toolbar, SWT.NONE);
		// removeItem.setImage(Activator.getDefault().getImageRegistry().get("remove"));

		CompositeRuler ruler = new CompositeRuler();

		LineNumberRulerColumn lineCol = new LineNumberRulerColumn();
		lineCol.setBackground(new Color(Display.getCurrent(), 147, 224, 255));
		ruler.addDecorator(0, lineCol);

		sourceViewer = new ProjectionViewer(textComposite, ruler, null, false, SWT.BORDER | SWT.H_SCROLL);
		sourceViewer.setDocument(document);
		sourceViewer.configure(new JsonConfiguration(null));
		StyledText styledText = sourceViewer.getTextWidget();

		// 设置自动换行
		styledText.setWordWrap(true);
		styledText.setFont(JFaceResources.getTextFont());
		styledText.setText(testGuard.getRequestBody().getValue() == null ? "" : testGuard.getRequestBody().getValue());

		// bodyText = new Text(textComposite, SWT.BORDER | SWT.MULTI |
		// SWT.WRAP);
		gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
		// gridData.widthHint = SWT.DEFAULT;
		// gridData.heightHint = SWT.DEFAULT;
		// bodyText.setText(testGuard.getRequestBody().getValue()==null?"":testGuard.getRequestBody().getValue());
		sourceViewer.getControl().setLayoutData(gridData);
		// bodyText.addModifyListener(new ModifyListener() {
		//
		// @Override
		// public void modifyText(ModifyEvent event) {
		// Text text = (Text) event.getSource();
		// //RequestBody requestBody = testGuard.getRequestBody();
		//// if (requestBody == null){
		//// requestBody = TestGuardFactory.eINSTANCE.createRequestBody();
		//// testGuard.setRequestBody(requestBody);
		//// }
		// EditingDomain editingDomain =
		// getEditor().getAdapter(EditingDomain.class);
		// RequestBody requestBody=testGuard.getRequestBody();
		// EAttribute valueAttribute =
		// TestGuardPackage.eINSTANCE.getRequestBody_Value();
		// SetCommand setCommand = new SetCommand(editingDomain, requestBody,
		// valueAttribute, text.getText());
		// editingDomain.getCommandStack().execute(setCommand);
		// }
		// });

		tabItem.setControl(textComposite);

	}

	class CellEditingSupport extends EditingSupport {

		public CellEditingSupport(ColumnViewer viewer) {
			super(viewer);
		}

		@Override
		protected void setValue(Object element, Object value) {
			// setValue(element, value);
			// if(element instanceof )
		}

		@Override
		protected Object getValue(Object element) {
			if (element instanceof Header) {
				return ((Header) element).getName();
			}
			return "";
		}

		@Override
		protected CellEditor getCellEditor(Object element) {
			return new TextCellEditor((Composite) getViewer().getControl(), SWT.NONE);
		}

		@Override
		protected boolean canEdit(Object element) {
			// TODO Auto-generated method stub
			return true;
		}
	}
}
