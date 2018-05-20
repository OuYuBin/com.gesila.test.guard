package com.gesila.test.guard.editor.editingSupport;

import org.eclipse.jface.fieldassist.AutoCompleteField;
import org.eclipse.jface.fieldassist.ComboContentAdapter;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.ComboBoxCellEditor;
import org.eclipse.jface.viewers.ComboBoxViewerCellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Table;

/**
 * 
 * @author robin
 *
 */
public class HeaderEditingSupport extends EditingSupport {

	ComboBoxCellEditor comboBoxViewerCellEditor;
	
	public HeaderEditingSupport(ColumnViewer viewer) {
		super(viewer);
		String[] values= {"test1","test2","test3","test4","test5","test6"};
		comboBoxViewerCellEditor=new ComboBoxCellEditor(((Table)viewer.getControl()),values, SWT.NONE);
		//comboBoxViewerCellEditor.setInput(values);
		new AutoCompleteField(comboBoxViewerCellEditor.getControl(),new CComboContentAdapter(),values);
	}
	
	@Override
	public CellEditor getCellEditor(Object element) {
		return comboBoxViewerCellEditor;
	}

	@Override
	protected boolean canEdit(Object element) {
		return true;
	}

	@Override
	protected Object getValue(Object element) {
		return 1;
	}

	@Override
	protected void setValue(Object element, Object value) {
		

	}

}
