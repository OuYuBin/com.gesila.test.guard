package com.gesila.test.guard.ui.models;

import java.util.List;

/**
 * 
 * @author robin
 *
 */
public interface IGesilaTestGuardGroup extends IGesilaTestGuard {

	public List<IGesilaTestGuard> getGesilaTestGuards();
}
