package com.gesila.test.guard.editor.parts.providers;

import java.util.List;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

import com.gesila.test.guard.editor.parts.ResponseObject;
import com.gesila.test.guard.json.model.GesilaJSONObject;

/**
 * 
 * @author robin
 *
 */
public class GesilaTestGuardRequestBodyContentProvider implements ITreeContentProvider {

	@Override
	public void dispose() {

	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {

	}

	@Override
	public Object[] getElements(Object inputElement) {
		return (Object[]) ((List) inputElement).toArray(new Object[0]);
	}

	@Override
	public Object[] getChildren(Object parentElement) {
		return ((GesilaJSONObject) parentElement).getGesilaJSONObjects().toArray(new Object[0]);
	}

	@Override
	public Object getParent(Object element) {
		return null;
	}

	@Override
	public boolean hasChildren(Object element) {
		if (getChildren(element).length > 0) {
			return true;
		}
		return false;
	}

}
