package com.gesila.test.guard.editor.pages;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.http.HttpEntity;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.EMFEditPlugin;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
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

import com.alibaba.fastjson.JSONObject;
import com.gesila.test.guard.common.editor.part.support.GesilaTextCellEditor;
import com.gesila.test.guard.editor.Activator;
import com.gesila.test.guard.editor.editingSupport.HeaderEditingSupport;
import com.gesila.test.guard.editor.editingSupport.ParamsEditingSupport;
import com.gesila.test.guard.editor.parts.providers.GesilaTestGuardRequestBodyContentProvider;
import com.gesila.test.guard.editor.parts.providers.GesilaTestGuardRequestBodyLableProvider;
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
import com.gesila.test.guard.model.testGuard.TestGuardUnit;
import com.gesila.test.guard.ui.views.IGesilaTestGuardViewPart;

/**
 * 
 * @author robin
 *
 */
public class GesilaTestGuardFormPage extends FormPage {

	private TestGuard testGuard;

	private TreeViewer jsonTreeViewer;

	private CCombo methodsCombo;

	private Text bodyText;

	private Logger logger = LoggerFactory.getLogger(GesilaTestGuardFormPage.class);

	public GesilaTestGuardFormPage(FormEditor editor, String id, String title) {
		super(editor, id, title);
		Resource resource = getEditor().getAdapter(Resource.class);
		testGuard = (TestGuard) resource.getContents().get(0);
	}

	@Override
	protected void createFormContent(IManagedForm managedForm) {
		super.createFormContent(managedForm);
		FormToolkit formToolkit = managedForm.getToolkit();
		ScrolledForm scrolledForm = managedForm.getForm();
		scrolledForm.setText("Request");
		Form form = scrolledForm.getForm();
		formToolkit.decorateFormHeading(form);

		Composite composite = form.getBody();

		// TableWrapLayout tableWrapLayout = new TableWrapLayout();
		// composite.setLayout(tableWrapLayout);

		GridLayout gridLayout = new GridLayout();
		composite.setLayout(gridLayout);

		Section section = formToolkit.createSection(composite,
				Section.TITLE_BAR | Section.EXPANDED | Section.CLIENT_INDENT | Section.COMPACT);
		section.setText("Request URL");
		section.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		Composite requestComposite = formToolkit.createComposite(section);
		gridLayout = new GridLayout(5, false);
		gridLayout.marginWidth = 5;
		gridLayout.marginHeight = 5;
		gridLayout.verticalSpacing = 0;
		gridLayout.horizontalSpacing = 5;
		requestComposite.setLayout(gridLayout);

		Label methodLabel = formToolkit.createLabel(requestComposite, "Request Method", SWT.NONE);
		methodLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));

		methodsCombo = new CCombo(requestComposite, SWT.BORDER);

		EEnum methodEnum = TestGuardPackage.eINSTANCE.getMethod();
		Object[] methods = methodEnum.getELiterals().toArray();
		String[] items = new String[methods.length];
		int i = 0;
		for (Object method : methods) {
			items[i] = method.toString();
			i++;
		}
		methodsCombo.setItems(items);

		methodsCombo.select(0);
		methodsCombo.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));

		Label addressLabel = formToolkit.createLabel(requestComposite, "Address", SWT.NONE);
		addressLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));

		Text urlText = formToolkit.createText(requestComposite, null, SWT.BORDER);
		GridData gridData=new GridData(SWT.FILL, SWT.CENTER, true, false);
		gridData.widthHint=100;
		urlText.setLayoutData(gridData);
		urlText.setText(testGuard.getUrl()==null?"":testGuard.getUrl());
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

		Button button = formToolkit.createButton(requestComposite, "Send", SWT.BUTTON1);
		button.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));

		button.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				HttpUriRequest httpUriRequest = null;
				try {
					HttpClient httpClient = HttpClients.createDefault();
					String url = urlText.getText();
					EList<Param> params = testGuard.getParams().getParam();
					if (!params.isEmpty()) {
						StringBuffer sb = new StringBuffer();
						// sb.append("?");
						for (Param param : params) {
							String paramName = param.getName();
							String paramValue = param.getValue();
							if (paramName != null && paramValue != null) {
								sb.append(paramName);
								sb.append("=");
								sb.append(paramValue);
							}
							sb.append("&");
						}
						url += "?" + sb.toString().substring(0, sb.toString().length() - 1);
					}
					logger.info("Request URL is {}", url);
					int index = methodsCombo.getSelectionIndex();
					switch (index) {
					case 0:
						httpUriRequest = new HttpGet(url);
						break;
					case 1:
						httpUriRequest = new HttpPost(url);
						HttpEntity httpEntity = new StringEntity(testGuard.getRequestBody().getValue());
						((HttpPost) httpUriRequest).setEntity(httpEntity);
						break;
					default:
						break;
					}
					// httpPost.setEntity(new
					// StringEntity("{\"_method\":\"GET\"}"));
					// if(combo.getSelectionIndex())

					HttpResponse response = httpClient.execute(httpUriRequest);
					HttpEntity entity = response.getEntity();
					ByteArrayOutputStream outStream = new ByteArrayOutputStream();
					byte[] data = new byte[4096];
					int count = -1;
					while ((count = entity.getContent().read(data, 0, 4096)) != -1)
						outStream.write(data, 0, count);

					data = null;
					IViewPart viewPart = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
							.findView("com.gesila.test.guard.ui.views.GsilaTestGuardResponseViewPart");
					if (viewPart instanceof IGesilaTestGuardViewPart) {
						((IGesilaTestGuardViewPart) viewPart).refresh(new String(outStream.toByteArray()));
					}

					// responseText.setText(new String(outStream.toByteArray(),
					// "UTF-8"));
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
		section.setClient(requestComposite);

		Section bodySection = formToolkit.createSection(composite,
				Section.TITLE_BAR | Section.EXPANDED | Section.CLIENT_INDENT | Section.COMPACT);
		bodySection.setText("Request Context");
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
		tabItem.setText("Headers");
		Composite headerComposite = createHeaderComposite(tabFolder);
		tabItem.setControl(headerComposite);

		CTabItem bodytabItem = new CTabItem(tabFolder, SWT.BORDER);
		bodytabItem.setText("Body");

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
		tableViewerColumn.getColumn().setText("Name");
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

		cellEditingSupport = new HeaderEditingSupport(tableViewer, headers);
		tableViewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		tableViewerColumn.getColumn().setWidth(400);
		tableViewerColumn.getColumn().setText("Value");
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
		tabItem.setText("URL Params");
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
		tableViewerColumn.getColumn().setText("Name");
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
		tableViewerColumn.getColumn().setText("Value");
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
		column.setText("Name");

		TreeViewerColumn valueColumn = new TreeViewerColumn(jsonTreeViewer, SWT.NONE);
		valueColumn.getColumn().setWidth(200);
		valueColumn.getColumn().setText("Value");

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
		tabItem.setText("Text");
		Composite textComposite = new Composite(tabFolder, SWT.NONE);
		GridLayout gridLayout = new GridLayout(1, false);
		gridLayout.marginWidth = 0;
		gridLayout.marginHeight = 0;
		gridLayout.verticalSpacing = 0;
		gridLayout.horizontalSpacing = 0;
		textComposite.setLayout(gridLayout);

		ToolBar toolbar = new ToolBar(textComposite, SWT.NONE);
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

		bodyText = new Text(textComposite, SWT.BORDER | SWT.MULTI | SWT.WRAP);
		gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
		gridData.widthHint = SWT.DEFAULT;
		gridData.heightHint = SWT.DEFAULT;
		bodyText.setText(testGuard.getRequestBody().getValue()==null?"":testGuard.getRequestBody().getValue());
		bodyText.setLayoutData(gridData);
		bodyText.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent event) {
				Text text = (Text) event.getSource();
				//RequestBody requestBody = testGuard.getRequestBody();
//				if (requestBody == null){
//					requestBody = TestGuardFactory.eINSTANCE.createRequestBody();
//					testGuard.setRequestBody(requestBody);
//				}
				EditingDomain editingDomain = getEditor().getAdapter(EditingDomain.class);
				RequestBody requestBody=testGuard.getRequestBody();
				EAttribute valueAttribute = TestGuardPackage.eINSTANCE.getRequestBody_Value();
				SetCommand setCommand = new SetCommand(editingDomain, requestBody, valueAttribute, text.getText());
				editingDomain.getCommandStack().execute(setCommand);
			}
		});

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
