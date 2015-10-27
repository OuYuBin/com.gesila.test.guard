package org.springframework.ide.eclipse.gesila.metadata.actions;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.IWorkbenchWindow;
import org.springframework.ide.eclipse.gesila.metadata.Activator;
import org.springframework.ide.eclipse.gesila.metadata.wizards.ExportTestGuardModelFileWizard;
import org.springframework.ide.eclipse.metadata.core.RequestMappingAnnotationMetadata;
import org.springframework.ide.eclipse.metadata.ui.RequestMappingMethodToClassMap;
import org.springframework.ide.eclipse.metadata.ui.RequestMappingView;
import org.springframework.ide.eclipse.metadata.ui.RequestMappingViewContentProvider;
import org.springframework.ide.eclipse.metadata.ui.RequestMappingViewLabelProvider;

import com.gesila.test.guard.edit.xml.GesilaTestGuardResourceImpl;
import com.gesila.test.guard.model.testGuard.TestGuard;
import com.gesila.test.guard.model.testGuard.TestGuardFactory;
import com.gesila.test.guard.model.testGuard.TestGuardModule;
import com.gesila.test.guard.model.testGuard.TestGuardPackage;
import com.gesila.test.guard.model.testGuard.TestGuardUnit;

/**
 * 
 * @version
 *
 */
public class GesilaExportTestGuardModelAction extends Action {

	private IWorkbenchWindow workbenchWindow;

	private RequestMappingView requestMappingView;

	public GesilaExportTestGuardModelAction(IWorkbenchWindow workbenchWindow, RequestMappingView requestMappingView) {
		this.workbenchWindow = workbenchWindow;
		this.requestMappingView = requestMappingView;
		this.setImageDescriptor(Activator.getImageDescriptor("icons/export.gif"));
	}

	@Override
	public void run() {
		super.run();
		ExportTestGuardModelFileWizard exportTestGuardModelFileWizard = new ExportTestGuardModelFileWizard(
				requestMappingView);
		WizardDialog wizardDialog = new WizardDialog(workbenchWindow.getShell(), exportTestGuardModelFileWizard);
		wizardDialog.setPageSize(500, 600);
		wizardDialog.create();
		if (wizardDialog.open() == Window.OK) {
			Set<RequestMappingAnnotationMetadata> annotations = exportTestGuardModelFileWizard
					.getExportTestGuardModelFileWizardPage().getAnnotations();
			RequestMappingViewLabelProvider requestMappingViewLabelProvider = exportTestGuardModelFileWizard
					.getExportTestGuardModelFileWizardPage().getRequestMappingViewLabelProvider();
			RequestMappingViewContentProvider requestMappingViewContentProvider = exportTestGuardModelFileWizard
					.getExportTestGuardModelFileWizardPage().getRequestMappingViewContentProvider();

			TestGuard testGuard = TestGuardFactory.eINSTANCE.createTestGuard();

			TestGuardPackage.eINSTANCE.eClass();
			TestGuardModule testGuardModule = TestGuardFactory.eINSTANCE.createTestGuardModule();
			testGuardModule.setName("cloud-support");
			;
			// --spring数据模型向emf数据转换并序列化
			for (Object requestMappingMethodToClassMap : requestMappingViewContentProvider.getElements(annotations)) {
				String url = requestMappingViewLabelProvider.getColumnText(requestMappingMethodToClassMap,
						RequestMappingView.COLUMN_URL);
				// --生成TestGuardUnit对象
				TestGuardUnit testGuardUnit = TestGuardFactory.eINSTANCE.createTestGuardUnit();
				testGuardUnit.setUrl(url);
				testGuardUnit.setName(url);
				testGuardModule.getUnit().add(testGuardUnit);
			}
			testGuard.getModule().add(testGuardModule);

			// --注册扩展
			Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
			Map<String, Object> m = reg.getExtensionToFactoryMap();
			m.put("xml", new XMIResourceFactoryImpl());

			// --创建一个资源
			URI uri = URI.createFileURI("/home/robin/logs/test");
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

		}
	}

}
