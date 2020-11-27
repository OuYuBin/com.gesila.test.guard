package com.gesila.test.guard.navigator.ui.views.listeners.manager;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.ISafeRunnable;
import org.eclipse.core.runtime.SafeRunner;

import com.gesila.test.guard.navigator.ui.views.listeners.IGesilaTestGuardModelElementChangeListener;

/**
 * 
 * @author robin
 *
 */
public class PostGuardModelElementManager implements IResourceChangeListener {

	private static PostGuardModelElementManager gesilaTestGuardModelElementManager;

	protected List<IGesilaTestGuardModelElementChangeListener> gesilaTestGuardModelElementChangeListeners = new ArrayList<IGesilaTestGuardModelElementChangeListener>();

	private PostGuardModelElementManager() {

	}

	public static PostGuardModelElementManager getInstance() {
		if (gesilaTestGuardModelElementManager == null) {
			synchronized (PostGuardModelElementManager.class) {
				gesilaTestGuardModelElementManager = new PostGuardModelElementManager();
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
							.forEach(listener -> listener.resourceChanged(event));
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
