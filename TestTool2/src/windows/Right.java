/** 
 * �����Right��
 */

package windows;

import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;

public class Right extends ScrollPane {
	public static TextArea OUTPUT;
	
	public Right() {					
		OUTPUT = new TextArea();
		OUTPUT.setPromptText("�����");
		OUTPUT.setPrefSize(300, 623);
		
		// ���� ScrollPane ����
		setContent(OUTPUT);
	}
}
