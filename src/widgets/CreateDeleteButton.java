package widgets;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

public class CreateDeleteButton {

	private Composite container;
	private CreateTabFolder tabfolder;
	private Button button;
	private GridData gd = new GridData(GridData.FILL_HORIZONTAL);

	public CreateDeleteButton(Composite container, CreateTabFolder tabfolder) {

		this.container = container;
		this.tabfolder = tabfolder;
		button = new Button(container,SWT.NULL);
		button.setText("削除");
		gd.horizontalSpan = 2;
		button.setLayoutData(gd);

		button.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {

				tabfolder.deleteTab();

			}
		});

	}

	public Button getButton() {

		return button;

	}
}
