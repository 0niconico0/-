package windows;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class base extends Application {
	public static BorderPane BORDER;
	private Scene scene;
	
	public void start(Stage stage) {	
		BORDER = new BorderPane();   
				
		// ��ʼ�������˵���Top��
		BORDER.setTop(new Top());
		
		// ��ʼ���ļ��ṹ����Left��
		BORDER.setLeft(new Left());

		// ��ʼ�������ı���Center��
		BORDER.setCenter(new Center());
		
		// ��ʼ����������Bottom��
		BORDER.setBottom(new Bottom());
		
		// ��ʼ�������Right��
		BORDER.setRight(new Right());

		// ��������������     
		scene = new Scene(BORDER, 1200, 800);
		stage.setTitle("�Զ��������������ɹ���");
		stage.setScene(scene);
		stage.show();
	}
   
	public static void main(String[] args) {
		launch(args);
	}
}
