/** 
 * ����ĺ��ķ���
 */

package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.FileChooser;
import windows.Center;
import windows.Left;
import windows.base;

public class FileEvent {
	public static File selectedFile; // ѡ�е��ļ�
	public static String fileName = "��ѡ���ļ�"; // �ļ���
	public static String filePath = "��ѡ���ļ�"; // �ļ�·��
	public static String fileContent; // �ļ�����
	public static String itemValue = null; // �ļ��ṹ����Ҷ�����������������
	public static Pattern VAR_NAME_PATTERN; // ��ȡ�������������������ģʽ
	
	// ���ļ�
	public static void openFile() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("��ѡ���ļ�");	
		selectedFile = fileChooser.showOpenDialog(null);	
			
		if(selectedFile != null) {		
			
			// չʾ�ļ�·�����ļ���
			filePath = selectedFile.getAbsolutePath();
			fileName = selectedFile.getName();	
			
			base.BORDER.setLeft(new Left());			
			base.BORDER.setCenter(new Center());
//			base.BORDER.setRight(new Right());
			
			// ��ȡ�ļ�����
			fileContent = readToString(selectedFile);		
			Center.TEXT_CODE.setText(fileContent);
//			Right.TEXT_CODE2.setText(fileContent);

//		    Pattern pattern = Pattern.compile("\\b(int)\\b");
//			Matcher matcher = pattern.matcher(fileContent);
//			while (matcher.find()) { 
//				Right.TEXT_CODE2.setText(fileContent.replaceAll("\\b" + matcher.group() + "\\b", " * "));
//			}

		}
	}
		
	// ��ȡ�ļ����ݣ�һ���Զ�ȡȫ������
	public static String readToString(File file) {  
		String encoding = "gb2312";  
		Long fileLength = file.length();  
	    byte[] filecontent = new byte[fileLength.intValue()];  
	    try {  
            FileInputStream in = new FileInputStream(file);  
            in.read(filecontent);  
            in.close();  
        } catch (FileNotFoundException e) {  
            e.printStackTrace();  
            return "�ļ���ʧ�ܣ�";
        } catch (IOException e) {  
            e.printStackTrace();  
            return "�ļ���ʧ�ܣ�";
        }  
        try {  
            return new String(filecontent, encoding);  
        } catch (UnsupportedEncodingException e) {  
            e.printStackTrace();  
            return "�����֧�ִ˱��룺" + encoding;  
        }  
	} 
	
	// ������ʾ�ؼ��֣�չʾ���ı����� ԭʼ�ı��� ƥ��ģʽ�� ������ɫ��
	public static void hightlightKeywords(TextFlow textFlow, Text text, Pattern pattern, Color color) {
		Text[] t = new Text[200];
		int  i = 0, j;
		
		// ƥ��ؼ���
		Matcher matcher = pattern.matcher(text.getText());
		
		// �Թؼ���Ϊ�ָ�㣬�������ı�
		while (matcher.find()) {  
//		    System.out.println(matcher.group());  	  
			
		    // ���ݱ��ιؼ��ַָ��ı�
			String[] strs = text.getText().split("\\b(" + matcher.group() + ")\\b");
			// matcher.group() �������� \b����Ҫ�ڷָ�ʱ�ٴ����
		
			// �����ιؼ���ǰ���ı����
			textFlow.getChildren().add(new Text(strs[0])); 			
//			System.out.println(strs[0]);
			
			// �����ιؼ��ָ������
			t[i] = new Text();
			t[i].setFill(color);
			t[i].setText(matcher.group());
			textFlow.getChildren().add(t[i]); 
//			System.out.println(t[i].getText());
			i++;
		
			// �����ιؼ��ֺ���ı���Ϊ��һ��ѭ�����ı�
			String s = "";
			for (j = 1; j < strs.length - 1; j++) {
				s = s + strs[j] + matcher.group();
			}
			s += strs[j];
			text.setText(s);
		}  
		
		// �����һ���ؼ���֮���ʣ���ı����
		textFlow.getChildren().add(new Text(text.getText())); 
//		System.out.println(Center.TEXT_CODE.getText());
		text.setText(null);
	}
	
	// ������ʾ�ؼ��֣���������ʾѡ�б���������չʾ���ı����� ԭʼ�ı��� ƥ��ģʽ�� ѡ�е��ֶΣ� ѡ�е��ֶεĸ�����ɫ�� �ؼ��ֵĸ�����ɫ��
	public static void hightlight(TextFlow textFlow, Text text, Pattern pattern, String selectedWord, Color color1, Color color2) {
		Text[] t = new Text[200];
		int  i = 0, j;
		
		// ƥ��ؼ���
		Matcher matcher = pattern.matcher(text.getText());
		
		// �Թؼ���Ϊ�ָ�㣬�������ı�
		while (matcher.find()) {  
		  			
		    // ���ݱ���ѭ��ƥ�䵽�Ĺؼ��ַָ��ı�
			String[] strs = text.getText().split("\\b(" + matcher.group() + ")\\b");
			/** ������� matcher.group() �������� \b����Ҫ�ڷָ�ʱ�ٴ���� */
		
			// ���ؼ���֮ǰ���ı�����ͨ��ʽ���
			textFlow.getChildren().add(new Text(strs[0])); 			
//			System.out.println(strs[0]);
			
			// �����ιؼ��ָ������
			t[i] = new Text();
			if (matcher.group().matches(selectedWord)) {
				t[i].setFill(color1); // ѡ�еı���������һ����ɫ���
			}
			else {
				t[i].setFill(color2); // �ؼ�������һ����ɫ���
			}
			t[i].setText(matcher.group());
			textFlow.getChildren().add(t[i]); 
//			System.out.println(t[i].getText());
			i++;
		
			// ��֮ǰ���ָ��ʣ���ı��ϲ�����Ϊ��һ��ѭ��ƥ����ʹ�õ��ı�
			String s = "";
			for (j = 1; j < strs.length - 1; j++) {
				s = s + strs[j] + matcher.group();
			}
			s += strs[j];
			text.setText(s);
		}  
		
		// �����һ��ƥ�䵽�Ĺؼ��ֺ����ʣ���ı����
		textFlow.getChildren().add(new Text(text.getText())); 
//		System.out.println(Center.TEXT_CODE.getText());
		text.setText(null);
	}
	
	// ƥ�亯���ͱ����������ļ��ṹ��չʾ���ļ��ṹ������ ƥ��ģʽ�� �ı����ݣ�
	public static void showFileTreeView(TreeItem<String> root, Pattern pattern, String content) {
		TreeItem<String> treeItem;
		
		// ƥ�亯���ͱ���
		Matcher matcher = pattern.matcher(content);
		
		// ÿƥ�䵽һ���ؼ��֣����½�һ��Ҷ��
		while (matcher.find()) {  
//		    System.out.println(matcher.group()); 
		    treeItem = new TreeItem<> (matcher.group());	   	    
		    root.getChildren().add(treeItem); 	    
		}
		
		// Ϊ�ļ��ṹ����Ӽ���
		selectedItem(Left.treeView);
	}	
	
	// ��ȡ TreeView ��ѡ�еĽڵ�
	public static void selectedItem(TreeView<String> treeView) {
		treeView.getSelectionModel().selectedItemProperty().addListener(   
                new ChangeListener<TreeItem<String>>() {
                    @Override
                    public void changed(ObservableValue<? extends TreeItem<String>> observableValue,
                    TreeItem<String> oldItem, TreeItem<String> newItem) {       
                    	
                    	// ��ȡ�������������
                        itemValue = newItem.getValue().replaceAll(RegEx.VarName, "");
                        String varName = "\\b(" + itemValue + ")\\b"; 
                        
                        // ��ƥ��ģʽ����Ϊ�ؼ��ֺͺ�������������Ĳ���
                	    Pattern pattern = Pattern.compile(RegEx.CKeyWord + "|" + varName);
                        
                        // ˢ�������ı���
                        base.BORDER.setCenter(new Center());
                        Center.TEXT_CODE.setText(fileContent);             	
                		
                		// ������ʾ
                	    hightlight(Center.TEXT_FLOW, Center.TEXT_CODE, pattern, itemValue, Color.RED, Color.BLUE);
                		
//                        System.out.println(itemValue);
                    }
                });
	}

/** ����Ϊ��ʹ�ù��Ĵ��� */
//	// ��ȡ�ļ����ݣ����ж�ȡ
//	public void readFile() {
//		BufferedReader br = null;
//		String str;
//		try {
//			br = new BufferedReader(new FileReader(selectedFile)); // ��ʱ��ȡ����br���������ļ��Ļ�����
//		} catch (FileNotFoundException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//			Center.TEXT_CODE.setText("��ȡ��������"); 
//		}
//		try {
//			Center.TEXT_CODE.setText("");
//			while ((str = br.readLine())!= null) // �ж����һ�в����ڣ�Ϊ�ս���ѭ��
//			{
//				Center.TEXT_CODE.appendText(str + "\n"); // �˴�������д�뵽TextArea����
//			}
//			br.close();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			Center.TEXT_CODE.appendText("��ȡ��������"); 
//		}	
//	}	
	
//	// �����ļ�
//	public void saveFile() {
//		selectedFile = new File(Bottom.LABEL_FILE_PATH.getText());  
//        
//        // д���ļ�����
//        try {
//        	String str = Center.TEXT_CODE.getText();
//        	FileOutputStream os = new FileOutputStream(selectedFile);
//        	PrintStream ps = new PrintStream(os);
//        	ps.print(str);
//        	//System.out.print(str);
//        	ps.close();
//        	os.close();
//        	setAlert(AlertType.INFORMATION, "����ɹ�", null, "�ļ��ѱ��棡");
//        } catch(Exception ex) {
//			setAlert(AlertType.INFORMATION, "����ʧ��", null, "����δ֪���󣬱���ʧ�ܣ�");
//        }
//	}
		
//	// �ؼ��ָ���
//	public static void matchKeyWords() {
//		Text[] t = new Text[200];
//		int  i = 0, j;
//		
//		// ƥ��ؼ���
//		Matcher matcher = RegEx.C_KEYWORD_PATTERN.matcher(Center.TEXT_CODE.getText());
//		
//		// �Թؼ���Ϊ�ָ�㣬�������ı�
//		while (matcher.find()) {  
////		    System.out.println(matcher.group());  	  
//			
//		    // ���ݱ��ιؼ��ַָ��ı�
//			String[] strs = Center.TEXT_CODE.getText().split(matcher.group());
//			
//			// �����ιؼ���ǰ���ı����
//			Center.TEXT_FLOW.getChildren().add(new Text(strs[0])); 			
////			System.out.println(strs[0]);
//			
//			// �����ιؼ��ָ������
//			t[i] = new Text();
//			t[i].setFill(Color.BLUE);
//			t[i].setText(matcher.group());
//			Center.TEXT_FLOW.getChildren().add(t[i]); 
////			System.out.println(t[i].getText());
//			i++;
//		
//			// �����ιؼ��ֺ���ı���Ϊԭʼ�ı�
//			String s = "";
//			for (j = 1; j < strs.length - 1; j++) {
//				s = s + strs[j] + matcher.group();
//			}
//			s += strs[j];
//			Center.TEXT_CODE.setText(s);
//		}  
//		
//		// �����һ���ؼ��ֺ���ı����
//		Center.TEXT_FLOW.getChildren().add(new Text(Center.TEXT_CODE.getText())); 
////		System.out.println(Center.TEXT_CODE.getText());
//		Center.TEXT_CODE.setText(null);
//	}
	
//	// ������ʾѡ�к��������
//	public static void highlight() {
//		Text[] t = new Text[200];
//		int  i = 0, j;
//		
//		base.BORDER.setRight(new Right());
//		Right.TEXT_CODE2.setText(fileContent);
//		
//		// ƥ��ؼ���		
//		Matcher matcher = VAR_NAME_PATTERN.matcher(Right.TEXT_CODE2.getText());
//		
//		// �Թؼ���Ϊ�ָ�㣬�������ı�
//		while (matcher.find()) {  
////		    System.out.println(matcher.group());  	  
//			
//		    // ���ݱ��ιؼ��ַָ��ı�
//			String[] strs = Right.TEXT_CODE2.getText().split(matcher.group());
//			
//			// �����ιؼ���ǰ���ı����
//			Right.TEXT_FLOW2.getChildren().add(new Text(strs[0])); 			
////			System.out.println(strs[0]);
//			
//			// �����ιؼ��ָ������
//			t[i] = new Text();
//			t[i].setFill(Color.RED);
//			t[i].setText(matcher.group());
//			Right.TEXT_FLOW2.getChildren().add(t[i]); 
////			System.out.println(t[i].getText());
//			i++;
//		
//			// �����ιؼ��ֺ���ı���Ϊԭʼ�ı�
//			String s = "";
//			for (j = 1; j < strs.length - 1; j++) {
//				s = s + strs[j] + matcher.group();
//			}
//			s += strs[j];
//			Right.TEXT_CODE2.setText(s);
//		}  
//		
//		// �����һ���ؼ��ֺ���ı����
//		Right.TEXT_FLOW2.getChildren().add(new Text(Center.TEXT_CODE.getText())); 
////		System.out.println(Center.TEXT_CODE.getText());
//		Right.TEXT_CODE2.setText(null);
//	}
/** ��ʹ�ù��Ĵ��� */	

}
