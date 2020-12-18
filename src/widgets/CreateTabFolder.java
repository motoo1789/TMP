package widgets;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Text;

public class CreateTabFolder {

	private Composite container;
	private TabFolder tabFolder;
	private Text title = null;
	private Text multi = null;
	private GridData gd = new GridData(GridData.FILL_BOTH);

	private int index = 0;

	public CreateTabFolder(Composite container) {

		this.container = container;

//		gd.heightHint = 400;
//		gd.widthHint = 600;
		gd.horizontalSpan = 2;

		tabFolder = new TabFolder(container,SWT.NONE);
		tabFolder.setLayoutData(gd);

		tabFolder.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				// TODO 自動生成されたメソッド・スタブ
				TabFolder tab = (TabFolder) e.getSource();
				index = tab.getSelectionIndex();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO 自動生成されたメソッド・スタブ

			}

		});

	}

	public void addTab(boolean isSelect) {

		CreateTab cTab = new CreateTab(container,tabFolder);
		cTab.makeTab(isSelect);

	}

	public void deleteTab() {

		//選択されてるタブを消す
		TabItem[] ts = tabFolder.getItems();
		if(ts.length != 0)
			ts[index].dispose();

	}

	public TabFolder getTabFolder() {
		return tabFolder;
	}
}
