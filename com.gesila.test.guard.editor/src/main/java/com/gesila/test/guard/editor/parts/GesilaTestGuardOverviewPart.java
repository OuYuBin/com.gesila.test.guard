package com.gesila.test.guard.editor.parts;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.model.application.ui.basic.MPartStack;
import org.eclipse.e4.ui.model.application.ui.basic.MStackElement;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.e4.ui.workbench.modeling.EPartService.PartState;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;

import com.gesila.test.guard.edit.providers.GesilaAdapterFactoryContentProvider;
import com.gesila.test.guard.edit.providers.GesilaAdapterFactoryStyleLabelProvider;
import com.gesila.test.guard.edit.providers.GesilaDecoratingStyleCellLabelProvider;
import com.gesila.test.guard.edit.providers.GesilaTestGuardItemProviderAdapterFactory;
import com.gesila.test.guard.edit.xml.GesilaTestGuardResourceImpl;
import com.gesila.test.guard.model.testGuard.TestGuard;
import com.gesila.test.guard.model.testGuard.TestGuardFactory;
import com.gesila.test.guard.model.testGuard.TestGuardModule;
import com.gesila.test.guard.model.testGuard.TestGuardPackage;
import com.gesila.test.guard.model.testGuard.TestGuardUnit;

/**
 * 
 * @author robin
 *
 */
public class GesilaTestGuardOverviewPart {

	@Inject
	private ESelectionService selectionService;

	@Inject
	private EPartService partService;

	@Inject
	private EModelService modelService;

	@Inject
	private MApplication application;

	private TreeViewer treeViewer;

	@PostConstruct
	public void createCompoiste(Composite parent) {
		GridLayout layout = new GridLayout(1, false);
		layout.horizontalSpacing = 0;
		layout.verticalSpacing = 1;
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		parent.setLayout(layout);

		FormToolkit formToolkit = new FormToolkit(parent.getDisplay());
		Form form = formToolkit.createForm(parent);
		form.setText("Gesila Test Guard");
		formToolkit.decorateFormHeading(form);
		form.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));

		//form.setHeadClient(formToolkit.createButton(form.getHead(), "This is the head client", SWT.PUSH));

		Composite body = form.getBody();
		layout = new GridLayout(1, false);
		layout.horizontalSpacing = 0;
		//layout.verticalSpacing = 0;
		layout.marginWidth = 0;
		//layout.marginHeight = 0;
		body.setLayout(layout);

		final Section section = formToolkit.createSection(body, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		section.clientVerticalSpacing = 0;
		section.marginWidth = 0;
		//section.marginHeight = 0;
		section.setText("Filter");
		GridData gd = new GridData(GridData.FILL_BOTH);
		gd.grabExcessHorizontalSpace = true;
		section.setLayoutData(gd);

		Composite searchSectionClient = formToolkit.createComposite(section, SWT.NONE);
		layout = new GridLayout(1, false);
		layout.horizontalSpacing = 0;
		layout.verticalSpacing = 0;
		//layout.marginHeight = 0;
		//layout.marginWidth = 5;
		searchSectionClient.setLayout(layout);
		Text searchText = formToolkit.createText(searchSectionClient, "",
				SWT.BORDER | SWT.SEARCH | SWT.ICON_SEARCH | SWT.CANCEL);
		searchText.setMessage("搜索:Test");
		searchText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		section.setClient(searchSectionClient);

		Composite client = formToolkit.createComposite(parent, SWT.NONE);
		layout = new GridLayout();
		layout.marginWidth = 5;
		layout.marginTop = 0;
		//layout.marginHeight = 0;
		client.setLayout(layout);
		gd = new GridData(SWT.FILL, SWT.FILL, true, true);
		client.setLayoutData(gd);

		Tree tree = formToolkit.createTree(client, SWT.FULL_SELECTION);
		tree.setLayoutData(gd);

		treeViewer = new TreeViewer(tree);
		treeViewer.addSelectionChangedListener(new ISelectionChangedListener() {

			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				IStructuredSelection selection = (IStructuredSelection) event.getSelection();
				selectionService.setSelection(selection.getFirstElement());
				MPartStack partStack = (MPartStack) modelService
						.find("com.gesila.test.guard.application.partstack.detail", application);
				// MPart part =
				// partService.createPart("com.gesila.test.guard.application.partdescriptor.detail");
				Object object = selection.getFirstElement();
//				if (object instanceof TestGuardUrlObject) {
//					// part.setLabel(((TestGuardUrlObject) object).getName());
//					// part.setElementId(object.getClass().toString());
//					String id = object.toString();
//					List<MStackElement> elements = partStack.getChildren();
//					for (MStackElement element : elements) {
//						if (id.equals(element.getElementId())) {
//							partService.showPart((MPart) element, PartState.VISIBLE);
//							return;
//						}
//					}
					// partStack.getChildren().add(part);
					// partService.showPart(part, PartState.ACTIVATE);

					// part.setLabel((String) selection.getFirstElement());
					// part.setElementId((String) selection.getFirstElement());
					// String id = (String) selection.getFirstElement();
					//
					// List<MStackElement> elements = partStack.getChildren();
					// for (MStackElement element : elements) {
					// if (id.equals(element.getElementId())) {
					// partService.showPart((MPart) element, PartState.VISIBLE);
					// return;
					// }
					// }
					// }

					// MPart mPart =
					// modelService.createModelElement(MPart.class);
					// mPart.setLabel("Test");
					// mPart.setElementId("newid");
					// mPart.setContributionURI(
					// "bundleclass://com.gesila.test.guard.application/com.gesila.test.guard.application.parts.SamplePart");
					// partStack.getChildren().add(part);
					// partService.showPart(part, PartState.ACTIVATE);

				//}
			}
		});
		treeViewer.addDoubleClickListener(new IDoubleClickListener() {

			@Override
			public void doubleClick(DoubleClickEvent event) {
				IStructuredSelection selection = (IStructuredSelection) event.getSelection();
				// selectionService.setSelection(selection.getFirstElement());
				MPartStack partStack = (MPartStack) modelService
						.find("com.gesila.test.guard.application.partstack.detail", application);
				MPart part = partService.createPart("com.gesila.test.guard.application.partdescriptor.detail");
				System.out.println(part.getObject());

				Object object = selection.getFirstElement();
				if (object instanceof EObject) {
					String id = object.toString();
					List<MStackElement> elements = partStack.getChildren();
					for (MStackElement element : elements) {
						if (id.equals(element.getElementId())) {
							partService.showPart((MPart) element, PartState.ACTIVATE);
							return;
						}
					}
					part.setLabel(((EObject) object).toString());
					part.setElementId(object.toString());
					partStack.getChildren().add(part);
					partService.showPart(part, PartState.ACTIVATE);
				}

			}
		});

		treeViewer.getControl().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		GesilaTestGuardItemProviderAdapterFactory testGuardAdapterFactory = new GesilaTestGuardItemProviderAdapterFactory();
		treeViewer
				.setContentProvider(new GesilaAdapterFactoryContentProvider((AdapterFactory) testGuardAdapterFactory));
		GesilaAdapterFactoryStyleLabelProvider gesilaAdapterFactoryStyleLabelProvider = new GesilaAdapterFactoryStyleLabelProvider(
				(AdapterFactory) testGuardAdapterFactory, treeViewer);
		treeViewer.setLabelProvider(
				new GesilaDecoratingStyleCellLabelProvider(gesilaAdapterFactoryStyleLabelProvider, null, null));

		// treeViewer.setContentProvider(new ITreeContentProvider() {
		//
		// @Override
		// public void dispose() {
		// // TODO Auto-generated method stub
		//
		// }
		//
		// @Override
		// public void inputChanged(Viewer viewer, Object oldInput, Object
		// newInput) {
		// // TODO Auto-generated method stub
		//
		// }
		//
		// @Override
		// public Object[] getElements(Object inputElement) {
		//
		// return ((List) inputElement).toArray();
		// }
		//
		// @Override
		// public Object[] getChildren(Object parentElement) {
		// // TODO Auto-generated method stub
		// if (parentElement instanceof TestGuardMoudleObject) {
		// return ((TestGuardMoudleObject)
		// parentElement).getTestGuardUrls().toArray();
		// }
		// return new Object[0];
		// }
		//
		// @Override
		// public Object getParent(Object element) {
		// // TODO Auto-generated method stub
		// return null;
		// }
		//
		// @Override
		// public boolean hasChildren(Object element) {
		// return getChildren(element).length > 0;
		// }
		//
		// });

		// treeViewer.setLabelProvider(new ILabelProvider() {
		//
		// @Override
		// public void removeListener(ILabelProviderListener listener) {
		// // TODO Auto-generated method stub
		//
		// }
		//
		// @Override
		// public boolean isLabelProperty(Object element, String property) {
		// // TODO Auto-generated method stub
		// return false;
		// }
		//
		// @Override
		// public void dispose() {
		// // TODO Auto-generated method stub
		//
		// }
		//
		// @Override
		// public void addListener(ILabelProviderListener listener) {
		// // TODO Auto-generated method stub
		//
		// }
		//
		// @Override
		// public String getText(Object element) {
		// return element.toString();
		// }
		//
		// @Override
		// public Image getImage(Object element) {
		// if (element instanceof TestGuardMoudleObject) {
		// return
		// Activator.getDefault().getImageRegistry().get("TestGuardModule");
		// }
		// // TODO Auto-generated method stub
		// return Activator.getDefault().getImageRegistry().get("TestGuardUrl");
		// }
		// });
		String[] models = new String[] { "http://localhost:8080/cloud-nat/v1/stat/channel",
				"http://localhost:8080/cloud-admin/v1/classes/login?name=admin&pass=111111",
				"http://localhost:8080/cloud-admin/v1/classes/channelstat/summary",
				"http://localhost:8080/cloud-admin/v1/classes/channelstat/csv",
				"http://localhost:8080/cloud-support/v1/login?username=13524631949&password=123456",
				"http://localhost:8080/cloud-support/v1/news", "http://localhost:8080/cloud-nat" };
		treeViewer.setInput(createModels());
	}

	private Object createModels() {
		// List list = new ArrayList();
		// TestGuardMoudleObject testGuardMoudleObject = new
		// TestGuardMoudleObject("Default");
		//
		// TestGuardMoudleObject adminTestGuardMoudleObject = new
		// TestGuardMoudleObject("Clound-Admin");
		// TestGuardUrlObject loginGuardUrlObject = new
		// TestGuardUrlObject("Login");
		// loginGuardUrlObject.setUrl("http://localhost:8080/cloud-admin/v1/classes/login?name=admin&pass=111111");
		// loginGuardUrlObject.setRequestType(RequestType.GET);
		// adminTestGuardMoudleObject.addTestGuardUrl(loginGuardUrlObject);
		//
		// TestGuardUrlObject statChannelSummaryGuardUrlObject = new
		// TestGuardUrlObject("StatChannel Summary");form
		// statChannelSummaryGuardUrlObject.setUrl("http://localhost:8080/cloud-admin/v1/classes/channelstat/summary");
		// statChannelSummaryGuardUrlObject.setRequestType(RequestType.GET);
		// adminTestGuardMoudleObject.addTestGuardUrl(statChannelSummaryGuardUrlObject);
		//
		// TestGuardUrlObject statChannelCSVGuardUrlObject = new
		// TestGuardUrlObject("StatChannel CSV");
		// statChannelCSVGuardUrlObject.setUrl("http://localhost:8080/cloud-admin/v1/classes/channelstat/csv");
		// statChannelCSVGuardUrlObject.setRequestType(RequestType.GET);
		// adminTestGuardMoudleObject.addTestGuardUrl(statChannelCSVGuardUrlObject);
		// part
		// TestGuardMoudleObject supportTestGuardMoudleObject = new
		// TestGuardMoudleObject("Clound-Support");
		// loginGuardUrlObject = new TestGuardUrlObject("Login");
		// loginGuardUrlObject.setRequestType(RequestType.POST);
		// loginGuardUrlObject.setUrl("http://localhost:8080/cloud-support/v1/login");
		// loginGuardUrlObject.setRequestBody(
		// "{\"username\":\"13524631949\",\"password\":\"123456\",\"_method\":\"GET\",\"_ApplicationId\":\"1\",\"_ApplicationKey\":\"1\",\"_ClientVersion\":\"js0.5.4\",\"_InstallationId\":\"46876d56-925b-e32e-5a07-d7823ea0e40a\"}");
		// supportTestGuardMoudleObject.addTestGuardUrl(loginGuardUrlObject);
		//
		// TestGuardUrlObject newsGuardUrlObject = new
		// TestGuardUrlObject("News");
		// newsGuardUrlObject.setRequestType(RequestType.POST);
		// newsGuardUrlObject.setUrl("http://localhost:8080/cloud-support/v1/classes/news");
		// newsGuardUrlObject.setRequestBody(
		// "{\"where\":{\"tagId\":\"1\"},\"keys\":\"title,img,intro,createAt\",\"limit\":8,\"order\":\"-updateAt\",\"_method\":\"GET\",\"_ApplicationId\":\"1\",\"_ApplicationKey\":\"1\",\"_ClientVersion\":\"js0.5.4\",\"_InstallationId\":\"46876d56-925b-e32e-5a07-d7823ea0e40a\",\"_SessionToken\":\"LH-x-jCWgoqcO3ohw-aoalWbeJLKnrFnI5\"}");
		// supportTestGuardMoudleObject.addTestGuardUrl(newsGuardUrlObject);
		//
		// list.add(testGuardMoudleObject);
		// list.add(adminTestGuardMoudleObject);
		// list.add(supportTestGuardMoudleObject);

		return null;
	}

	@Inject
	public void setSelection(@Optional @Named(IServiceConstants.ACTIVE_SELECTION) File file) {
		if (file != null) {
			update(file);
		}

	}

	public void update(File file) {
		URI uri = URI.createFileURI(file.getAbsolutePath());

		TestGuard testGuard = TestGuardFactory.eINSTANCE.createTestGuard();

		TestGuardPackage.eINSTANCE.eClass();

		TestGuardModule testGuardModule = TestGuardFactory.eINSTANCE.createTestGuardModule();
		testGuardModule.setName("nat");

		TestGuardUnit testGuardUnit = TestGuardFactory.eINSTANCE.createTestGuardUnit();
		testGuardUnit.setName("Channel Stat");
		// testGuardUnit.setUrl("");

		testGuardModule.getUnit().add(testGuardUnit);
		testGuard.getModule().add(testGuardModule);

		// --注册扩展
		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("xml", new XMIResourceFactoryImpl());

		// --创建一个资源
		GesilaTestGuardResourceImpl gesilaTestGuardResourceImpl = new GesilaTestGuardResourceImpl(uri);

		gesilaTestGuardResourceImpl.setEncoding("UTF-8");

		// --写入模型至资源
		gesilaTestGuardResourceImpl.getContents().add(testGuard);

		try {
			// --序列化资源
			gesilaTestGuardResourceImpl.save(Collections.EMPTY_MAP);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		load(file);
	}

	public void load(File file) {
		URI uri = URI.createFileURI(file.getAbsolutePath());
		// --创建一个资源
		// GesilaTestGuardResourceImpl gesilaTestGuardResourceImpl = new
		// GesilaTestGuardResourceImpl(uri);
		// gesilaTestGuardResourceImpl.setEncoding("UTF-8");

		TestGuardPackage.eINSTANCE.eClass();

		// --注册扩展
		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("xml", new XMIResourceFactoryImpl());

		ResourceSet resouceSet = new ResourceSetImpl();
		Resource resource = resouceSet.getResource(uri, true);
		resource.getContents().get(0);
		treeViewer.setInput(resource.getContents().get(0));
		treeViewer.refresh(true);
	}

}
