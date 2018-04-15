package com.gesila.test.guard.ui.models;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author robin
 *
 */
public class GesilaTestGuardGroup extends AbstractGesilaTestGuard implements IGesilaTestGuardGroup{

	List<IGesilaTestGuard> gesilaTestGuards = new ArrayList<IGesilaTestGuard>();

	public GesilaTestGuardGroup() {

	}

	public GesilaTestGuardGroup(GesilaTestGuardGroup parent) {
		super(parent);
	}

	public void addTestGuard(IGesilaTestGuard gesilaTestGuard) {
		gesilaTestGuards.add(gesilaTestGuard);
	}

	public List<IGesilaTestGuard> getGesilaTestGuards() {
		return gesilaTestGuards;
	}



}
