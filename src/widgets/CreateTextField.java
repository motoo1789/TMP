package widgets;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

public class CreateTextField {

	private Text text;
	private GridData gd = new GridData(GridData.FILL_HORIZONTAL);

	public CreateTextField(Composite container, String settext){

		text = new Text(container,SWT.SINGLE);
		text.setText(settext);
		text.setLayoutData(gd);

	}

	public Text getText() {
		return text;
	}
}
