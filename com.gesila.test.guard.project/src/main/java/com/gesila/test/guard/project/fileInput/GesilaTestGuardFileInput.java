package com.gesila.test.guard.project.fileInput;

import org.eclipse.core.resources.IFile;
import org.eclipse.ui.part.FileEditorInput;

import com.gesila.test.guard.project.models.IGesilaTestGuardProjectElement;

/**
 * 
 * @author robin
 *
 */

public class GesilaTestGuardFileInput extends FileEditorInput {

	IGesilaTestGuardProjectElement gesilaTestGuardProjectElement;

	public GesilaTestGuardFileInput(IFile file) {
		super(file);
	}

	public IGesilaTestGuardProjectElement getGesilaTestGuardProjectElement() {
		return gesilaTestGuardProjectElement;
	}

	public void setGesilaTestGuardProjectElement(IGesilaTestGuardProjectElement gesilaTestGuardProjectElement) {
		this.gesilaTestGuardProjectElement = gesilaTestGuardProjectElement;
	}

}
