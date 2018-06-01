package com.gesila.test.guard.navigator.ui.views.manager;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.ISafeRunnable;
import org.eclipse.core.runtime.SafeRunner;

/**
 * 
 * @author robin
 *
 */
public class GesilaTestGuardModelElementManager implements IResourceChangeListener {

	private static GesilaTestGuardModelElementManager gesilaTestGuardModelElementManager;

	protected List<IGesilaTestGuardModelElementChangeListener> gesilaTestGuardModelElementChangeListeners = new ArrayList<IGesilaTestGuardModelElementChangeListener>();

	private GesilaTestGuardModelElementManager() {

	}

	public static GesilaTestGuardModelElementManager getInstance() {
		if (gesilaTestGuardModelElementManager == null) {
			synchronized (GesilaTestGuardModelElementManager.class) {
				gesilaTestGuardModelElementManager = new GesilaTestGuardModelElementManager();
				ResourcesPlugin.getWorkspace().addResourceChangeListener(gesilaTestGuardModelElementManager,
						IResourceChangeEvent.POST_CHANGE);
			}
		}
		return gesilaTestGuardModelElementManager;
	}

	@Override
	public void resourceChanged(IResourceChangeEvent event) {
		if (event.getType() == IResourceChangeEvent.POST_CHANGE) {
			SafeRunner.run(new ISafeRunnable() {

				@Override
				public void run() throws Exception {
					gesilaTestGuardModelElementChangeListeners.stream()
							.forEach(IGesilaTestGuardModelElementChangeListener::testGuardModelElementChange);

				}

				@Override
				public void handleException(Throwable exception) {

				}
			});
		}

	}

	public void addGesilaTestGuardModelElementListener(
			IGesilaTestGuardModelElementChangeListener gesilaTestGuardModelElementChangeListener) {
		synchronized (gesilaTestGuardModelElementChangeListener) {
			if (!gesilaTestGuardModelElementChangeListeners.contains(gesilaTestGuardModelElementChangeListener))
				gesilaTestGuardModelElementChangeListeners.add(gesilaTestGuardModelElementChangeListener);
		}
	}
	
	public void removeGesilaTestGuardModelElementListener(
			IGesilaTestGuardModelElementChangeListener gesilaTestGuardModelElementChangeListener) {
	}

	public List<IGesilaTestGuardModelElementChangeListener> getGesilaTestGuardModelElementChangeListeners() {
		return gesilaTestGuardModelElementChangeListeners;
	}

}
