package com.gesila.test.guard.edit.providers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.DecorationOverlayIcon;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.jface.viewers.IDecorationContext;
import org.eclipse.jface.viewers.ILabelDecorator;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.LabelDecorator;
import org.eclipse.swt.graphics.Image;


/**
 * 
 * @author robin
 * 
 */
public class SysConfigLabelDecorator extends LabelDecorator {

	private Image decoratedImage = null;

	public SysConfigLabelDecorator() {

	}

	@Override
	public void addListener(ILabelProviderListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		if (decoratedImage != null)
			decoratedImage.dispose();
		decoratedImage = null;

	}

	@Override
	public boolean isLabelProperty(Object element, String property) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeListener(ILabelProviderListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public Image decorateImage(Image image, Object element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String decorateText(String text, Object element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Image decorateImage(Image image, Object element,
			IDecorationContext context) {
		return null;
	}

	@Override
	public String decorateText(String text, Object element,
			IDecorationContext context) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean prepareDecoration(Object element, String originalText,
			IDecorationContext context) {
		// TODO Auto-generated method stub
		return true;
	}

}
