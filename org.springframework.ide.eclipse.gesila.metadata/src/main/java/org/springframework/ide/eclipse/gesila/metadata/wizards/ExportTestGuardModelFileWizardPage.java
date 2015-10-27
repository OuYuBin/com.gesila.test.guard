package org.springframework.ide.eclipse.gesila.metadata.wizards;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;
import org.springframework.ide.eclipse.beans.core.internal.model.BeansModelUtils;
import org.springframework.ide.eclipse.beans.core.metadata.BeansMetadataPlugin;
import org.springframework.ide.eclipse.beans.core.metadata.model.IBeanMetadata;
import org.springframework.ide.eclipse.beans.core.model.IBean;
import org.springframework.ide.eclipse.beans.core.model.IBeansConfig;
import org.springframework.ide.eclipse.beans.core.model.IBeansConfigSet;
import org.springframework.ide.eclipse.beans.core.model.IBeansModelElement;
import org.springframework.ide.eclipse.beans.core.model.IBeansProject;
import org.springframework.ide.eclipse.metadata.core.RequestMappingAnnotationMetadata;
import org.springframework.ide.eclipse.metadata.ui.Messages;
import org.springframework.ide.eclipse.metadata.ui.RequestMappingViewContentProvider;
import org.springframework.ide.eclipse.metadata.ui.RequestMappingViewLabelProvider;

/**
 * 
 * @author robin
 *
 */

public class ExportTestGuardModelFileWizardPage extends WizardPage {

	private IBeansModelElement beansModelElement;

	private TableViewer tableViewer;
	
	private Set<RequestMappingAnnotationMetadata> annotations;
	
	private RequestMappingViewLabelProvider requestMappingViewLabelProvider;
	
	private RequestMappingViewContentProvider requestMappingViewContentProvider;

	protected ExportTestGuardModelFileWizardPage(String pageName, IBeansModelElement beansModelElement) {
		super(pageName);
		this.beansModelElement = beansModelElement;
	}

	@Override
	public void createControl(Composite parent) {
		Composite content = new Composite(parent, SWT.NONE);
		GridLayout gridLayout = new GridLayout();
		content.setLayout(gridLayout);

		GridData gd = new GridData(SWT.FILL, SWT.FILL, true, true);
		content.setLayoutData(gd);

		Composite fileComposite = new Composite(content, SWT.NONE);
		gridLayout = new GridLayout();
		gridLayout.numColumns = 3;
		gridLayout.makeColumnsEqualWidth = false;
		fileComposite.setLayout(gridLayout);

		Label exportFileLabel = new Label(fileComposite, SWT.NONE);
		exportFileLabel.setText("Export To File:");
		exportFileLabel.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, true));

		Text exportFilePathText = new Text(fileComposite, SWT.NONE);
		exportFilePathText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, true));

		Button browserButton = new Button(fileComposite, SWT.BUTTON1);
		browserButton.setText("Browser...");
		browserButton.setLayoutData(new GridData(SWT.END, SWT.CENTER, false, true));

		fileComposite.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));

		tableViewer = new TableViewer(content,
				SWT.SINGLE | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER | SWT.FULL_SELECTION | SWT.CHECK);
		final Table table = tableViewer.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		String[] columnText = { Messages.RequestMappingView_HEADER_RESOURCE_URL,
				Messages.RequestMappingView_HEADER_REQUEST_METHOD, Messages.RequestMappingView_HEADER_HANDLER_METHOD };
		int[] columnWidth = { 200, 150, 300 };
		for (int i = 0; i < columnText.length; i++) {
			final TableViewerColumn column = new TableViewerColumn(tableViewer, SWT.NONE);
			column.getColumn().setText(columnText[i]);
			column.getColumn().setWidth(columnWidth[i]);
			column.getColumn().setResizable(true);
		}
		requestMappingViewContentProvider=new RequestMappingViewContentProvider();
		tableViewer.setContentProvider(requestMappingViewContentProvider);
		requestMappingViewLabelProvider = new RequestMappingViewLabelProvider();
		tableViewer.setLabelProvider(requestMappingViewLabelProvider);
		internalSetInput();
		tableViewer.getControl().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		setControl(content);
	}

	private void internalSetInput() {
		annotations = new HashSet<RequestMappingAnnotationMetadata>();
		if (beansModelElement == null) {
			return;
		} else if (beansModelElement instanceof IBeansConfig) {
			addAnnotationsForConfig(annotations, (IBeansConfig) beansModelElement);
		} else if (beansModelElement instanceof IBeansConfigSet) {
			for (IBeansConfig config : ((IBeansConfigSet) beansModelElement).getConfigs()) {
				addAnnotationsForConfig(annotations, config);
			}
		} else if (beansModelElement instanceof IBeansProject) {
			for (IBeansConfig config : ((IBeansProject) beansModelElement).getConfigs()) {
				addAnnotationsForConfig(annotations, config);
			}
		}

		PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() {
			public void run() {
				tableViewer.setInput(annotations);
			}
		});
	}

	private void addAnnotationsForConfig(Set<RequestMappingAnnotationMetadata> annotations, IBeansConfig config) {
		for (IBean bean : BeansModelUtils.getBeans(config)) {
			Set<IBeanMetadata> metadataSet = BeansMetadataPlugin.getMetadataModel().getBeanMetadata(bean);
			for (IBeanMetadata metadata : metadataSet) {
				if (metadata instanceof RequestMappingAnnotationMetadata) {
					annotations.add((RequestMappingAnnotationMetadata) metadata);
				}
			}
		}
	}

	public Set<RequestMappingAnnotationMetadata> getAnnotations() {
		return annotations;
	}

	public RequestMappingViewLabelProvider getRequestMappingViewLabelProvider() {
		return requestMappingViewLabelProvider;
	}

	public RequestMappingViewContentProvider getRequestMappingViewContentProvider() {
		return requestMappingViewContentProvider;
	}



}
