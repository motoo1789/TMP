package tmp;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.ui.part.ViewPart;

import widgets.CreateAddButton;
import widgets.CreateDeleteButton;
import widgets.CreateSelectionAddButton;
import widgets.CreateTabFolder;


public class View extends ViewPart {

	private Composite container;

	//widget
	private TabFolder tabFolder;
	private Button addButton;
	private Button deleteButton;
	private Button selectionButton;

	//CreateObject
	private CreateTabFolder cTabFolder;
	private CreateAddButton cAddButton;
	private CreateDeleteButton cDeleteButton;
	private CreateSelectionAddButton cSelectionButton;


	public View() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	@Override
	public void createPartControl(Composite parent) {
		// TODO 自動生成されたメソッド・スタブ

		container = new Composite(parent,SWT.NONE);
		container.setLayout(new GridLayout(2,true));

		//タブフォルダー
		cTabFolder = new CreateTabFolder(container);
		tabFolder = cTabFolder.getTabFolder();

		//テキスト
//		cText = new CreateTextField(container);
//		text = cText.getText();

		//ボタン
//		cAddButton = new CreateAddButton(container,cTabFolder);
//		addButton = cAddButton.getButton();
//
//		cSelectionButton = new CreateSelectionAddButton(container,cTabFolder);
//		selectionButton = cSelectionButton.getButton();
//
		cDeleteButton = new CreateDeleteButton(container,cTabFolder);
		deleteButton = cDeleteButton.getButton();

	}

	public CreateTabFolder getTabFolder() {
		return cTabFolder;
	}
	@Override
	public void setFocus() {
		// TODO 自動生成されたメソッド・スタブ

	}

}
