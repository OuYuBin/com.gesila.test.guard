package com.gesila.test.guard.project.fileInput;

import org.eclipse.core.resources.IFile;
import org.eclipse.ui.part.FileEditorInput;

import com.gesila.test.guard.project.models.IPostGuardProjectElement;

/**
 * 
 * @author robin
 *
 */

public class GesilaTestGuardFileInput extends FileEditorInput {

	IPostGuardProjectElement gesilaTestGuardProjectElement;

	public GesilaTestGuardFileInput(IFile file) {
		super(file);
	}

	public IPostGuardProjectElement getGesilaTestGuardProjectElement() {
		return gesilaTestGuardProjectElement;
	}

	public void setGesilaTestGuardProjectElement(IPostGuardProjectElement gesilaTestGuardProjectElement) {
		this.gesilaTestGuardProjectElement = gesilaTestGuardProjectElement;
	}

}
