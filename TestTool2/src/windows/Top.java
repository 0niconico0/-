/** 
 * �����˵���Top�� 
 */

package windows;

import data.FileEvent;
import data.RegEx;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.paint.Color;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;

public class Top extends MenuBar {
	private Menu menuFile, menuHelp;
	private MenuItem itemOpen, itemSave, itemExit, itemAbout;
	private SeparatorMenuItem separator1;	
	
	public Top() {	   		
		// �ļ��˵�
		menuFile = new Menu("�ļ�");
		
		itemOpen = new MenuItem("��");
		itemOpen.setOnAction((ActionEvent e) -> {
			FileEvent.openFile();
			if(FileEvent.selectedFile != null) {	
				FileEvent.hightlightKeywords(Center.TEXT_FLOW, Center.TEXT_CODE, RegEx.C_KEYWORD_PATTERN, Color.BLUE);
				FileEvent.showFileTreeView(Left.root, RegEx.VAR_TYPE_PATTERN, FileEvent.fileContent);
//				FileEvent.showFileTreeView(Left.root, RegEx.FUNC_TYPES_PATTERN, Right.TEXT_CODE2.getText());
			}
		});
		
		itemSave = new MenuItem("����");
		itemSave.setDisable(true);
//		itemSave.setOnAction((ActionEvent e) -> {
//			saveFile();
//		});
		
		itemExit = new MenuItem("�˳�");
		itemExit.setOnAction((ActionEvent e) -> {
		    System.exit(0);
		});
		
		separator1 = new SeparatorMenuItem();
		
		menuFile.getItems().addAll(itemOpen, itemSave, separator1, itemExit);
		
		// �����˵�
		menuHelp = new Menu("����");
		itemAbout = new MenuItem("����");
		itemAbout.setOnAction((ActionEvent e) -> {
			setAlert(AlertType.INFORMATION, "����", null, "�Զ��������������ɹ���");
		});
		
		menuHelp.getItems().addAll(itemAbout);
		
		getMenus().addAll(menuFile, menuHelp);
	}
	
	// ������ʾ��
	public void setAlert(AlertType alertType, String title, String header, String content) {
		Alert alert = new Alert(alertType);
		alert.setTitle(title);
		alert.setHeaderText(header);
		alert.setContentText(content);

		alert.showAndWait();
	}
		
}
