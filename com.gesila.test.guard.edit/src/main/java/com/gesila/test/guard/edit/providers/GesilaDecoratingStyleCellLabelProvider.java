package com.gesila.test.guard.edit.providers;

import org.eclipse.jface.viewers.DecoratingStyledCellLabelProvider;
import org.eclipse.jface.viewers.IDecorationContext;
import org.eclipse.jface.viewers.ILabelDecorator;

/**
 * 
 * @author robin
 *
 */
public class GesilaDecoratingStyleCellLabelProvider extends DecoratingStyledCellLabelProvider {

	public GesilaDecoratingStyleCellLabelProvider(IStyledLabelProvider labelProvider, ILabelDecorator decorator,
			IDecorationContext decorationContext) {
		super(labelProvider, decorator, decorationContext);
	}

}
