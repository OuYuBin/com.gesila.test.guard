package com.gesila.test.guard.application;

import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

	private static BundleContext context;

	private static Activator plugin;

	public static Activator getDefault() {
		return plugin;
	}

	static BundleContext getContext() {
		return context;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.
	 * BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		this.plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
		this.plugin = null;
	}

	protected void initializeImageRegistry(ImageRegistry registry) {
		Bundle bundle = context.getBundle();
		Map map = new HashMap();
		map.put("TestGuardModule", "icons/module.gif");
		map.put("TestGuardUrl", "icons/sample.png");

		for (Iterator iter = map.entrySet().iterator(); iter.hasNext();) {
			Map.Entry entry = (Entry) iter.next();
			IPath path = new Path((String) entry.getValue());
			URL url = FileLocator.find(bundle, path, null);
			ImageDescriptor desc = ImageDescriptor.createFromURL(url);
			registry.put((String) entry.getKey(), desc);
		}

	}

	public static int[] sort(int[] args) {
		int size = args.length;
		for (int i = 0; i < size; i++) {
			int max = i;
			for (int j = i; j < size; j++) {
				if (args[j] > args[i]) {
					max = j;
					int tmp = args[i];
					args[i] = args[max];
					args[max] = tmp;
				}
			}
		}
		return args;
	}

	public static void main(String[] args) {
		int[] test = new int[] { 4, 6, 5, 7 };
		sort(test);
		System.out.println(test);
	}

}
