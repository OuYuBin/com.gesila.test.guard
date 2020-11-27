package com.gesila.test.guard.editor.editingSupport;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.fieldassist.AutoCompleteField;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.ComboBoxCellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Table;

import com.gesila.test.guard.model.testGuard.Header;
import com.gesila.test.guard.model.testGuard.Headers;
import com.gesila.test.guard.model.testGuard.TestGuardFactory;

/**
 * 
 * @author robin
 *
 */
public class HeaderEditingSupport extends EditingSupport {

	// ComboBoxCellEditor comboBoxViewerCellEditor;
	private CellEditor cellEditor = null;

	private Headers headers;

	private IAdaptable adaptable;

	public HeaderEditingSupport(ColumnViewer viewer, Headers headers, IAdaptable adaptable) {
		super(viewer);
		this.headers = headers;
		this.adaptable = adaptable;
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
			if (element instanceof EEnumLiteral) {
				String literal = ((EEnumLiteral) element).getLiteral();
				List<Header> headerElements = headers.getHeader().stream()
						.filter(header -> header.getName().equals(literal)).collect(Collectors.toList());
				if (!headerElements.isEmpty()) {
					EAnnotation annotation = ((EEnumLiteral) element).getEAnnotation("ExtendedMetaData");
					if (annotation != null) {
						EMap<String, String> details = annotation.getDetails();
						String content = details.get("content");
						if (content != null) {
							String[] values = content.split("\\|");
							int i = 0;
							for (String value : values) {
								Header header = headerElements.get(0);
								if (StringUtils.equals(header.getValue(), value)) {
									return i;
								}
								i++;
							}
//							EditingDomain editingDomain = adaptable.getAdapter(EditingDomain.class);
//							EStructuralFeature feature = (headerElements.get(0)).eClass().getEStructuralFeature("value");
//							SetCommand setCommand = new SetCommand(editingDomain, headerElements.get(0), feature,
//									values[(int) value]);
//							editingDomain.getCommandStack().execute(setCommand);

						}
					}
				}
			}
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
			if (element instanceof EEnumLiteral) {
				String literal = ((EEnumLiteral) element).getLiteral();
				List<Header> headerElements = headers.getHeader().stream()
						.filter(header -> header.getName().equals(literal)).collect(Collectors.toList());
				if (!headerElements.isEmpty()) {
					EAnnotation annotation = ((EEnumLiteral) element).getEAnnotation("ExtendedMetaData");
					if (annotation != null) {
						EMap<String, String> details = annotation.getDetails();
						String content = details.get("content");
						if (content != null) {
							String[] values = content.split("\\|");
							EditingDomain editingDomain = adaptable.getAdapter(EditingDomain.class);
							EStructuralFeature feature = (headerElements.get(0)).eClass()
									.getEStructuralFeature("value");
							SetCommand setCommand = new SetCommand(editingDomain, headerElements.get(0), feature,
									values[(int) value]);
							editingDomain.getCommandStack().execute(setCommand);
						}
					}
				} else {
					Header header = TestGuardFactory.eINSTANCE.createHeader();
					header.setName(literal);
					header.setValue((String) value);
					headers.getHeader().add(header);
				}
				getViewer().refresh(element, true);
			}
		}
	}

}
