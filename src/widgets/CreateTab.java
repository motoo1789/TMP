package widgets;

import org.eclipse.core.resources.IFile;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;

import resource.GetResource;

public class CreateTab {

	private Composite container;
	private TabFolder tabFolder;
	private Table errormap;
	private GridData gd = new GridData(GridData.FILL_BOTH);


	public CreateTab(Composite container,TabFolder tabFolder) {

		this.tabFolder = tabFolder;
		this.container = container;

	}

	public void makeTab(boolean isSelect) {

		TabItem item = new TabItem(tabFolder,SWT.NONE);

		//resourceとってファイルの名前取得
		GetResource resourceObj = GetResource.getInstance();
		IFile file = resourceObj.getIFile();
		item.setText(file.getName());

		Composite composite1 = new Composite(tabFolder,SWT.NULL);
		composite1.setLayout(new GridLayout(1, false));

		//タイトル部分
		CreateTextField cText = new CreateTextField(composite1,"保存した理由");
		Text title = cText.getText();
//		item.setControl(title);

//		//プログラム部分
		CreateMultiField cMulti = new CreateMultiField(composite1);
		Text multi = cMulti.getText(isSelect);
//		item.setControl(multi);

		item.setControl(composite1);
	}

}
