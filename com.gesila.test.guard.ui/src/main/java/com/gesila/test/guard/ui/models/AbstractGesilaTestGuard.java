package com.gesila.test.guard.ui.models;

import java.beans.PropertyChangeSupport;

import org.eclipse.core.runtime.Preferences.IPropertyChangeListener;
import org.eclipse.core.runtime.Preferences.PropertyChangeEvent;

/**
 * 
 * @author robin
 *
 */
public class AbstractGesilaTestGuard implements IGesilaTestGuard {

	String name;

	GesilaTestGuardGroup parent;

	PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

	public AbstractGesilaTestGuard() {

	}

	public GesilaTestGuardGroup getParent() {
		return parent;
	}

	public void setParent(GesilaTestGuardGroup parent) {
		this.parent = parent;
	}

	public AbstractGesilaTestGuard(GesilaTestGuardGroup parent) {
		this.parent = parent;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
