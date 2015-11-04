package com.gesila.test.guard.editor.parts.providers;

import org.eclipse.jface.viewers.IDecorationContext;
import org.eclipse.jface.viewers.ILabelDecorator;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.swt.graphics.Image;

import com.gesila.test.guard.edit.providers.GesilaDecoratingStyleCellLabelProvider;

/**
 * 
 * @author robin
 *
 */
public class GesilaTestGuardDecoratingStyledCellLabelProvider extends GesilaDecoratingStyleCellLabelProvider {

	public GesilaTestGuardDecoratingStyledCellLabelProvider(IStyledLabelProvider labelProvider,
			ILabelDecorator decorator, IDecorationContext decorationContext) {
		super(labelProvider, decorator, decorationContext);
	}

	@Override
	public Image getImage(Object element) {
		return super.getImage(element);
	}

	protected StyledString getStyledText(Object element) {
		return getStyledStringProvider().getStyledText(element);
	}

}
