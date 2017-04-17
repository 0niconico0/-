/** 
 * �����ı���Center�� 
 */

package windows;

import javafx.scene.control.ScrollPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class Center extends ScrollPane {	
	private FlowPane fp;
	public static TextFlow TEXT_FLOW;
	public static Text TEXT_CODE;
	
	public Center() {					
		TEXT_CODE = new Text("��ѡ���ļ�");
		TEXT_CODE.setFont(Font.font("Dialog", 20));
		TEXT_CODE.setFill(Color.BLUE);
		
		TEXT_FLOW = new TextFlow(TEXT_CODE);
		
		// ���� FlowPane ����
		fp = new FlowPane();
		fp.getChildren().add(TEXT_FLOW);
		fp.setStyle("-fx-background-color: white;");	
		
		// ���� ScrollPane ����
		setContent(fp);
		setFitToHeight(true);
		setFitToWidth(true);
//		setStyle(" -fx-background-color: white; ");	
	}
}
