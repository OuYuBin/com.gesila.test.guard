package com.gesila.test.guard.editor.pages;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;

import com.alibaba.fastjson.JSONObject;
import com.gesila.test.guard.common.editor.part.support.GesilaTextCellEditor;
import com.gesila.test.guard.editor.Activator;
import com.gesila.test.guard.editor.parts.providers.GesilaTestGuardRequestBodyContentProvider;
import com.gesila.test.guard.editor.parts.providers.GesilaTestGuardRequestBodyLableProvider;
import com.gesila.test.guard.json.model.GesilaJSONObject;
import com.gesila.test.guard.json.utils.GesilaJSONUtils;
import com.gesila.test.guard.model.testGuard.TestGuard;
import com.gesila.test.guard.model.testGuard.TestGuardUnit;

/**
 * 
 * @author robin
 *
 */
public class GesilaTestGuardFormPage extends FormPage {

	private TestGuard testGuard;
	
	
	public GesilaTestGuardFormPage(FormEditor editor, String id, String title) {
		super(editor, id, title);
		Resource resource=getEditor().getAdapter(Resource.class);
		testGuard=(TestGuard) resource.getContents().get(0);
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
		section.setText("Http Request");
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

		Combo combo = new Combo(requestComposite, SWT.BORDER);
		combo.setItems("GET", "POST", "PUT", "DELETE");
		combo.select(0);
		combo.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));

		Label addressLabel = formToolkit.createLabel(requestComposite, "Address", SWT.NONE);
		addressLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));

		Text urlText = formToolkit.createText(requestComposite, null, SWT.BORDER);
		urlText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		Button button = formToolkit.createButton(requestComposite, "Send", SWT.BUTTON1);
		button.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));

		section.setClient(requestComposite);
		
//		Section headerSection=formToolkit.createSection(composite,
//				Section.TITLE_BAR | Section.EXPANDED | Section.CLIENT_INDENT | Section.COMPACT);
//		headerSection.setText("Http Header");
//		headerSection.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		
		

		Section bodySection = formToolkit.createSection(composite,
				Section.TITLE_BAR | Section.EXPANDED | Section.CLIENT_INDENT | Section.COMPACT);
		bodySection.setText("Request Body");
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

		createTextTab(tabFolder);

		createJSONTab(tabFolder);
		tabFolder.setSelection(0);

		// Text bodyText = new Text(requestBodyComposite, SWT.BORDER | SWT.WRAP |
		// SWT.MULTI);
		// GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
		// gridData.widthHint = SWT.DEFAULT;
		// gridData.heightHint = SWT.DEFAULT;
		// bodyText.setLayoutData(gridData);

		bodySection.setClient(requestBodyComposite);

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

		//Tree tree = new Tree(jsonComposite, SWT.NONE);

		TreeViewer jsonTreeViewer = new TreeViewer(jsonComposite, SWT.FULL_SELECTION|SWT.BORDER);
		Tree tree=jsonTreeViewer.getTree();
		tree.setHeaderVisible(true);
		tree.setLinesVisible(true);
		GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
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
						// .createJSONObject(((TestGuardUnit) eOwner).getRequestBody());
						// String name = ((GesilaJSONObject) element).getName();
						// if (jsonObject.containsKey(name)) {
						// jsonObject.put(name, value);
						// }
						// ((TestGuardUnit)
						// eOwner).setRequestBody(GesilaJSONUtils.createGesilaJSONOString(jsonObject));
						// ((GesilaJSONObject) element).setValue((String) value);
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
		// if (eOwner != null) {
		// String requestBody = ((TestGuardUnit) eOwner).getRequestBody();
		// JSONObject jsonObject = GesilaJSONUtils.createJSONObject(requestBody);
		// GesilaJSONUtils.createGesilaJSONObject(jsonObject, list);
		// jsonTreeViewer.setInput(list);
		// }
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

		Text text = new Text(textComposite, SWT.BORDER | SWT.MULTI | SWT.WRAP);
		GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
		gridData.widthHint = SWT.DEFAULT;
		gridData.heightHint = SWT.DEFAULT;
		text.setLayoutData(gridData);

		tabItem.setControl(textComposite);

	}

}
