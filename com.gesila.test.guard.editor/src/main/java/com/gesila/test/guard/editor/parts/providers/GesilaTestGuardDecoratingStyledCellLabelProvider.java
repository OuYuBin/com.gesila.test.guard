package com.gesila.test.guard.editor.parts.providers;

import org.eclipse.jface.viewers.IDecorationContext;
import org.eclipse.jface.viewers.ILabelDecorator;
import org.eclipse.jface.viewers.LabelDecorator;
import org.eclipse.jface.viewers.StyledCellLabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.StyledString.Styler;
import org.eclipse.swt.graphics.Image;

import com.gesila.test.guard.edit.providers.GesilaDecoratingStyleCellLabelProvider;
import com.gesila.test.guard.model.testGuard.RequestMethod;
import com.gesila.test.guard.model.testGuard.TestGuardUnit;

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
		// RequestMethod requestMethod = ((TestGuardUnit)
		// element).getRequestMethod();
		// String url = ((TestGuardUnit) element).getUrl();
		// org.eclipse.jface.viewers.StyledString styledString = new
		// org.eclipse.jface.viewers.StyledString("test");
		// //styledString.append(requestMethod.getLiteral(),
		// org.eclipse.jface.viewers.StyledString.DECORATIONS_STYLER);
		// styledString.append(" - " + url,
		// org.eclipse.jface.viewers.StyledString.DECORATIONS_STYLER);
		// return styledString;
	}

}
