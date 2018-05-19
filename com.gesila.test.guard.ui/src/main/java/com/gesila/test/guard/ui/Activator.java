package com.gesila.test.guard.ui;

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
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "com.gesila.test.guard.ui"; //$NON-NLS-1$

	// The shared instance
	private static Activator plugin;
	
	/**
	 * The constructor
	 */
	public Activator() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}
	
	
	@Override
	protected void initializeImageRegistry(ImageRegistry reg) {
		Bundle bundle=plugin.getBundle();
		Map<String,String> map=new HashMap<String,String>();
		map.put("text", "icons/text.png");
		map.put("json", "icons/json.png");
		
		for(Iterator<Entry<String,String>> iter=map.entrySet().iterator();iter.hasNext();) {
			Map.Entry<String, String> entry=iter.next();
			IPath path=new Path(entry.getValue());
			URL url=FileLocator.find(bundle, path, null);
			ImageDescriptor imageDesc=ImageDescriptor.createFromURL(url);
			reg.put(entry.getKey(), imageDesc);
		}
	}

	public static void main(String[] args) {
		int i=255;
		byte[] bytes=new byte[1];
		bytes[0]=(byte) (i);
		System.out.println(bytes);
		
		int j=bytes[0]&0xFF;
		System.out.println(j);
	}

}
