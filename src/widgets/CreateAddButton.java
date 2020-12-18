package widgets;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;


public class CreateAddButton {

	private Composite container;
	private CreateTabFolder tabfolder;
	private Button button;
	private GridData gd = new GridData(GridData.FILL_HORIZONTAL);

	public CreateAddButton(Composite container, CreateTabFolder tabfolder) {

		this.container = container;
		this.tabfolder = tabfolder;
		button = new Button(container,SWT.NULL);
		button.setText("add");
		button.setLayoutData(gd);

		button.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {

				tabfolder.addTab(false);

			}
		});

	}

	public Button getButton() {

		return button;

	}

}
