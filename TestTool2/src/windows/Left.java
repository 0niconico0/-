/** 
 * �ļ��ṹ����Left�� 
 */

package windows;

import data.FileEvent;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

public class Left extends ScrollPane {	
	public static TreeItem<String> root;
	public static TreeView<String> treeView ;
	
	public Left() {					
		root = new TreeItem<> (FileEvent.fileName);		
		root.setExpanded(true);
		
		treeView = new TreeView<> (root);
		
		setContent(treeView);
		
		// ���� ScrollPane ����
		setFitToHeight(true);
	}
}
