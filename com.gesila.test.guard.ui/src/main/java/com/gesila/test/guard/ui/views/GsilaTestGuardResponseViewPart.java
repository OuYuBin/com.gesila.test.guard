package com.gesila.test.guard.ui.views;

import java.util.List;

import org.eclipse.emf.edit.EMFEditPlugin;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.part.ViewPart;

import com.gesila.test.guard.json.model.GesilaJSONObject;

/**
 * 
 * @author robin
 *
 */
public class GsilaTestGuardResponseViewPart extends ViewPart implements IGesilaTestGuardViewPart{
	
	public static final String ID="com.gesila.test.guard.ui.views.GsilaTestGuardResponseViewPart";

	public GsilaTestGuardResponseViewPart() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createPartControl(Composite parent) {

		
		FormToolkit formToolkit=new FormToolkit(Display.getCurrent());
		Form form=formToolkit.createForm(parent);
		form.setText("Response");
		formToolkit.decorateFormHeading(form);
		Composite body=form.getBody();
		GridLayout gridLayout = new GridLayout(1, false);
		gridLayout.marginWidth = 0;
		gridLayout.marginHeight = 0;
		gridLayout.verticalSpacing = 1;
		gridLayout.horizontalSpacing = 0;
		body.setLayout(gridLayout);
//		Text text=formToolkit.createText(body, null, SWT.BORDER|SWT.MULTI|SWT.WRAP);
//		GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
//		gridData.widthHint = SWT.DEFAULT;
//		gridData.heightHint = SWT.DEFAULT;
//		text.setLayoutData(gridData);

		TreeViewer treeViewer = new TreeViewer(body, SWT.MULTI | SWT.BORDER | SWT.FULL_SELECTION|SWT.V_SCROLL);
		Tree tree = treeViewer.getTree();
		tree.setHeaderVisible(true);
		tree.setLinesVisible(true);
		tree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		TreeColumn column = new TreeColumn(treeViewer.getTree(), SWT.NONE);
		column.setWidth(100);
		column.setText("Name");

		TreeViewerColumn valueColumn = new TreeViewerColumn(treeViewer, SWT.NONE);
		valueColumn.getColumn().setWidth(80);
		valueColumn.getColumn().setText("Value");

		valueColumn.setEditingSupport(new EditingSupport(treeViewer) {

			@Override
			protected void setValue(Object element, Object value) {

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
				//return new GesilaTextCellEditor(tree);
				return null;
			}

			@Override
			protected boolean canEdit(Object element) {
				return true;
			}
		});

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
				switch (columnIndex) {
				case 1:
					String image = "full/obj16/GenericValue";
					String name = ((GesilaJSONObject) element).getName();
					if(name==null){
						return null;
					}
					return ExtendedImageRegistry.getInstance().getImage(EMFEditPlugin.INSTANCE.getImage(image));
				}
				return null;
			}

			@Override
			public String getColumnText(Object element, int columnIndex) {
				switch (columnIndex) {
				case 0:
					return ((GesilaJSONObject) element).getName() == null ? "" : ((GesilaJSONObject) element).getName();
				case 1:
					return ((GesilaJSONObject) element).getValue() == null ? ""
							: ((GesilaJSONObject) element).getValue();
				}
				return null;
			}

		});

	
		
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

	@Override
	public void refresh() {
		
	}

}
