package com.gesila.test.guard.editor.editingSupport;

import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.jface.fieldassist.AutoCompleteField;
import org.eclipse.jface.fieldassist.ComboContentAdapter;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.ComboBoxCellEditor;
import org.eclipse.jface.viewers.ComboBoxViewerCellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Table;

import com.gesila.test.guard.model.testGuard.Header;
import com.gesila.test.guard.model.testGuard.Headers;
import com.gesila.test.guard.model.testGuard.TestGuardFactory;
import com.gesila.test.guard.model.testGuard.TestGuardPackage;

/**
 * 
 * @author robin
 *
 */
public class HeaderEditingSupport extends EditingSupport {

	// ComboBoxCellEditor comboBoxViewerCellEditor;
	private CellEditor cellEditor = null;

	private Headers headers;

	public HeaderEditingSupport(ColumnViewer viewer, Headers headers) {
		super(viewer);
		this.headers = headers;
		// String[] values= {"test1","test2","test3","test4","test5","test6"};
		// comboBoxViewerCellEditor=new
		// ComboBoxCellEditor(((Table)viewer.getControl()),values, SWT.NONE);
		// comboBoxViewerCellEditor.setInput(values);
		// new AutoCompleteField(comboBoxViewerCellEditor.getControl(),new
		// CComboContentAdapter(),values);
	}

	@Override
	public CellEditor getCellEditor(Object element) {
		if (element instanceof EEnumLiteral) {
			EAnnotation annotation = ((EEnumLiteral) element).getEAnnotation("ExtendedMetaData");
			if (annotation != null) {
				EMap<String, String> details = annotation.getDetails();
				String content = details.get("content");
				if (content != null) {
					String[] values = content.split("\\|");
					cellEditor = new ComboBoxCellEditor(((Table) getViewer().getControl()), values, SWT.FLAT);
					// comboBoxViewerCellEditor.setInput(values);
					new AutoCompleteField(cellEditor.getControl(), new CComboContentAdapter(), values);
					// return comboBoxViewerCellEditor;
				} else {
				}
			} else {
				cellEditor = new TextCellEditor(((Table) getViewer().getControl()), SWT.FLAT);
			}
		}
		return cellEditor;
	}

	@Override
	protected boolean canEdit(Object element) {
		return true;
	}

	@Override
	protected Object getValue(Object element) {
		if (cellEditor instanceof TextCellEditor) {
			if (element instanceof EEnumLiteral) {
				EAnnotation annotation = ((EEnumLiteral) element).getEAnnotation("ExtendedMetaData");
				if (annotation == null) {
					String literal = ((EEnumLiteral) element).getLiteral();
					List<Header> headerElements = headers.getHeader().stream()
							.filter(header -> header.getName().equals(literal)).collect(Collectors.toList());
					if (!headerElements.isEmpty()) {
						return headerElements.get(0).getValue();
					}
				}
			}
		} else if (cellEditor instanceof ComboBoxCellEditor) {
			return 0;
		}
		return "";
	}

	@Override
	protected void setValue(Object element, Object value) {
		if (cellEditor instanceof TextCellEditor) {
			if (element instanceof EEnumLiteral) {
				EAnnotation annotation = ((EEnumLiteral) element).getEAnnotation("ExtendedMetaData");
				if (annotation == null) {
					String literal = ((EEnumLiteral) element).getLiteral();
					List<Header> headerElements = headers.getHeader().stream()
							.filter(header -> header.getName().equals(literal)).collect(Collectors.toList());
					if (!headerElements.isEmpty()) {
						headerElements.get(0).setValue((String) value);
					} else {
						Header header = TestGuardFactory.eINSTANCE.createHeader();
						header.setName(literal);
						header.setValue((String) value);
						headers.getHeader().add(header);
					}
					getViewer().refresh(element, true);
				}
			}
		} else if (cellEditor instanceof ComboBoxCellEditor) {
			// return 0;
		}

		// return "";
	}

}
