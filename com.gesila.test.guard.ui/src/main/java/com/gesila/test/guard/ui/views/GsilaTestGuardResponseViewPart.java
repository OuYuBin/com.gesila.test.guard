package com.gesila.test.guard.ui.views;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.edit.EMFEditPlugin;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentExtension3;
import org.eclipse.jface.text.IDocumentPartitioner;
import org.eclipse.jface.text.rules.FastPartitioner;
import org.eclipse.jface.text.source.CompositeRuler;
import org.eclipse.jface.text.source.LineNumberRulerColumn;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.internal.editors.text.EditorsPlugin;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.ui.texteditor.ChainedPreferenceStore;

import com.alibaba.fastjson.JSONObject;
import com.aptana.editor.common.CommonEditorPlugin;
import com.aptana.editor.common.ExtendedFastPartitioner;
import com.aptana.editor.common.IExtendedPartitioner;
import com.aptana.editor.common.NullPartitionerSwitchStrategy;
import com.aptana.editor.common.text.rules.CompositePartitionScanner;
import com.aptana.editor.common.text.rules.NullSubPartitionScanner;
import com.aptana.editor.common.viewer.CommonProjectionViewer;
import com.aptana.editor.html.HTMLPlugin;
import com.aptana.editor.html.HTMLSourceConfiguration;
import com.aptana.editor.html.HTMLSourceViewerConfiguration;
import com.gesila.test.guard.json.model.GesilaJSONObject;
import com.gesila.test.guard.json.utils.GesilaJSONUtils;
import com.gesila.test.guard.ui.Activator;

/**
 * 
 * @author robin
 *
 */
public class GsilaTestGuardResponseViewPart extends ViewPart implements IGesilaTestGuardViewPart {

	public static final String ID = "com.gesila.test.guard.ui.views.GsilaTestGuardResponseViewPart";

	private TreeViewer treeViewer;

	private CommonProjectionViewer commonProjectionViewer;

	private StyledText styledText;

	private Text text;

	private Form form;

	public GsilaTestGuardResponseViewPart() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createPartControl(Composite parent) {

		FormToolkit formToolkit = new FormToolkit(Display.getCurrent());
		form = formToolkit.createForm(parent);
		form.setText("Response");
		formToolkit.decorateFormHeading(form);
		Composite body = form.getBody();
		GridLayout gridLayout = new GridLayout(1, false);
		gridLayout.marginWidth = 0;
		gridLayout.marginHeight = 0;
		gridLayout.verticalSpacing = 1;
		gridLayout.horizontalSpacing = 0;
		body.setLayout(gridLayout);

		CTabFolder cTabFolder = new CTabFolder(body, SWT.NONE);
		GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
		gridData.widthHint = SWT.DEFAULT;
		gridData.heightHint = SWT.DEFAULT;
		cTabFolder.setLayoutData(gridData);

		CTabItem cTabItem = new CTabItem(cTabFolder, SWT.NONE);
		cTabItem.setImage(Activator.getDefault().getImageRegistry().get("text"));
		cTabItem.setText("Text");

		CompositeRuler ruler = new CompositeRuler();
		LineNumberRulerColumn lineCol = new LineNumberRulerColumn();
		lineCol.setBackground(new Color(Display.getCurrent(), 147, 224, 255));
		ruler.addDecorator(0, lineCol);

		Document document = new Document();
		commonProjectionViewer = new CommonProjectionViewer(cTabFolder, ruler, null, false,
				SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		commonProjectionViewer.configure(new HTMLSourceViewerConfiguration(getChainedPreferenceStore(), null));
		CompositePartitionScanner partitionScanner = new CompositePartitionScanner(HTMLSourceConfiguration
				.getDefault().createSubPartitionScanner(), new NullSubPartitionScanner(),
				new NullPartitionerSwitchStrategy());
		IDocumentPartitioner partitioner = new ExtendedFastPartitioner(partitionScanner, HTMLSourceConfiguration
				.getDefault().getContentTypes());
		partitionScanner.setPartitioner((IExtendedPartitioner) partitioner);
		partitioner.connect(document);
		document.setDocumentPartitioner(partitioner);
		CommonEditorPlugin.getDefault().getDocumentScopeManager().registerConfiguration(document,
				HTMLSourceConfiguration.getDefault());
		commonProjectionViewer.setDocument(document);
		styledText = commonProjectionViewer.getTextWidget();

		// 设置自动换行
		styledText.setWordWrap(true);
		styledText.setFont(JFaceResources.getTextFont());

		// text = formToolkit.createText(cTabFolder, null, SWT.BORDER |
		// SWT.MULTI | SWT.WRAP | SWT.V_SCROLL);
		gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
		gridData.widthHint = SWT.DEFAULT;
		gridData.heightHint = SWT.DEFAULT;
		styledText.setLayoutData(gridData);
		cTabItem.setControl(commonProjectionViewer.getControl());

		CTabItem jsonCTabItem = new CTabItem(cTabFolder, SWT.NONE);
		jsonCTabItem.setImage(Activator.getDefault().getImageRegistry().get("json"));
		jsonCTabItem.setText("JSON");

		treeViewer = new TreeViewer(cTabFolder, SWT.MULTI | SWT.BORDER | SWT.FULL_SELECTION | SWT.V_SCROLL);
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
				// return new GesilaTextCellEditor(tree);
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
				if (((GesilaJSONObject) element).getValue() == null
						|| "".equals(((GesilaJSONObject) element).getValue())) {
					return null;
				}
				String image = "full/obj16/GenericValue";
				switch (columnIndex) {
				case 1:
					String name = ((GesilaJSONObject) element).getName();
					if (name.equals("_ApplicationId") || name.equals("_ApplicationKey")) {
						image = "full/obj16/IntegralValue.gif";
					}
					break;
				}
				return ExtendedImageRegistry.getInstance().getImage(EMFEditPlugin.INSTANCE.getImage(image));
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
		jsonCTabItem.setControl(tree);
		cTabFolder.setSelection(0);
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

	@Override
	public void refresh(Object object) {
		List list = new ArrayList();
		JSONObject jsonObject = GesilaJSONUtils.createJSONObject((String) object);
		GesilaJSONUtils.createGesilaJSONObject(jsonObject, list);
		if (!list.isEmpty()) {
			form.setText("Response 200 OK");
			treeViewer.setInput(list);
			treeViewer.refresh(true);
			treeViewer.expandToLevel(3);
		}
		commonProjectionViewer.getDocument().set((String) object);
		commonProjectionViewer.refresh();
		// styledText.setText((String) object);

	}

	public static IPreferenceStore getChainedPreferenceStore() {
		return new ChainedPreferenceStore(new IPreferenceStore[] { HTMLPlugin.getDefault().getPreferenceStore(),
				CommonEditorPlugin.getDefault().getPreferenceStore(),
				EditorsPlugin.getDefault().getPreferenceStore() });
	}
	

}
