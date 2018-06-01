package com.gesila.test.guard.editor.editingSupport;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

import com.gesila.test.guard.model.testGuard.Param;

/**
 * 
 * @author robin
 *
 */
public class ParamsEditingSupport extends EditingSupport {

	private TextCellEditor textCellEditor;

	private String featureName;
	
	private IAdaptable adaptable;

	public ParamsEditingSupport(ColumnViewer viewer, String featureName,IAdaptable adaptable) {
		super(viewer);
		this.featureName = featureName;
		this.textCellEditor = new TextCellEditor((Composite) viewer.getControl(), SWT.FLAT);
		this.adaptable=adaptable;
		

	}

	@Override
	protected CellEditor getCellEditor(Object element) {
		return textCellEditor;
	}

	@Override
	protected boolean canEdit(Object element) {
		return true;
	}

	@Override
	protected Object getValue(Object element) {
		if (element instanceof Param) {
			if (featureName.equals("name"))
				return ((Param) element).getName()==null?"":((Param) element).getName();
			else if (featureName.equals("value"))
				return ((Param) element).getValue()==null?"":((Param) element).getValue();
		}
		return "";
	}

	@Override
	protected void setValue(Object element, Object value) {
		String oldValue = (String) getValue(element);
		if (!oldValue.equals(value)&&!value.equals("")) {
			EditingDomain editingDomain=adaptable.getAdapter(EditingDomain.class);
			EStructuralFeature feature=((Param)element).eClass().getEStructuralFeature(featureName);
			SetCommand setCommand=new SetCommand(editingDomain, (Param)element, feature, value);
			editingDomain.getCommandStack().execute(setCommand);
//			if (featureName.equals("name"))
//				((Param) element).setName((String) value);
//			else if (featureName.equals("value"))
//				((Param) element).setValue((String) value);
		}
		getViewer().refresh(element, true);

	}

}
