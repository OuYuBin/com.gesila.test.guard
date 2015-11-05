package com.gesila.test.guard.common.font;

import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.viewers.StyledString.Styler;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.TextStyle;

public final class GesilaTestGuardFont {

	private static final GesilaTestGuardFont INSTANCE = new GesilaTestGuardFont();

	private Styler requestMethodDecorationStyler;

	private FontData defaultFontData;

	private GesilaTestGuardFont() {
		requestMethodDecorationStyler = new Styler() {
			public void applyStyles(TextStyle textStyle) {
				FontData fontData = GesilaTestGuardFont.this.getDefaultFontData();
				FontData requestMethodFontData = new FontData();
				requestMethodFontData.setStyle(SWT.BOLD);
				int height = fontData.getHeight();
				requestMethodFontData.setHeight(height / 2);
				Font requestFont = new Font(null, requestMethodFontData);
				textStyle.font = requestFont;
				textStyle.foreground = new Color(null, 24, 122, 204);
			}
		};
	}

	public static synchronized GesilaTestGuardFont getInstance() {
		if (INSTANCE == null) {
			return new GesilaTestGuardFont();
		} else {
			return INSTANCE;
		}
	}

	private FontData getDefaultFontData() {
		if (defaultFontData == null) {
			defaultFontData = JFaceResources.getFontRegistry().getFontData(JFaceResources.DEFAULT_FONT)[0];
		}
		return defaultFontData;
	}

	public Styler getRequestMethodDecorationStyler() {
		return requestMethodDecorationStyler;
	}

}
