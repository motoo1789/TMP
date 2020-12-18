package widgets;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.texteditor.ITextEditor;

import resource.GetResource;


public class CreateMultiField {

	private Text text;
	private GridData gd;

	public CreateMultiField(Composite container) {

		gd = new GridData(GridData.FILL_BOTH);
		text = new Text(container,SWT.MULTI | SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		text.setText("保存内容");
		text.setLayoutData(gd);

	}

	private void setText(boolean isSelect) {

		if(isSelect == true)
		{
			GetResource resourceObj = GetResource.getInstance();
			IEditorPart editor = resourceObj.getEditorPart();
			ITextEditor textEditor = (ITextEditor)editor;
			ISelectionProvider selectionProvider = textEditor.getSelectionProvider();
			ISelection selection = selectionProvider.getSelection();
			ITextSelection textSelection = (ITextSelection)selection;

			String selectionString = textSelection.getText();
			text.setText(selectionString);
		}
		else
		{
			GetResource resourceObj = GetResource.getInstance();
			IDocument document = resourceObj.getIDocument();

			text.setText(document.get());
		}
	}

	public Text getText(boolean isSelect) {
		setText(isSelect);
		return text;
	}

}
