package orgin;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.ScrollPaneConstants;
/**
 * swing����ʵ��
 * @author HZ20232
 *
 */
public class JSwing{
	static NewFrame frame1;
    public static void main(String args[])throws Exception{
        frame1 = new NewFrame();
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//һ��Ҫ���ùر�

        frame1.setVisible(true);
    }
}
class NewFrame extends JFrame{
    private JLabel label1;
    private JButton button1;
    private JButton pause;
    static JTextField[] text = new JTextField[5];
    private JComboBox box;
    private JMenuBar menuBar;
    private JSlider slider;
    private JSpinner spinner;
    private JToolBar toolBar;
    private JTextArea textAreaOutputLeft;
    private static JTextArea textAreaOutputRight;
    private JPanel panel;
    static JPanel panelInput  = new JPanel();
    static String fileContent = "";
    public static boolean ThreadSwitch = true;
    public NewFrame(){
        super();
        this.setSize(600,800);
        this.getContentPane().setLayout(null);//���ò��ֿ�����

//        this.getContentPane().setLayout(new FlowLayout());//���ò��ֿ�����
//
//        this.getContentPane().setLayout(new GridLayout(1,2));//���ò��ֿ�����,��Ҫ�����趨��������Ŀ
//
//        this.getContentPane().setLayout(new BorderLayout());//���ò��ֿ���������North,South,West,East�������ƿؼ�����
//
//        this.getContentPane().setLayout(new GridBagLayout());//���ò��ֿ�����

//          this.add(this.getTextField(),null);//����ı���

          this.add(this.getTextAreaPanelLeft(), null);
          this.add(this.getTextAreaPanelRight(), null);
          this.add(this.getTextAreaPanelBelow(), null);
          this.add(this.getButton(),null);//��Ӱ�ť
          
//          this.add(this.getLabel(),null);//��ӱ�ǩ

//          this.add(this.getBox(),null);//��������б��
//
          this.add(this.getMenu());//��Ӳ˵�
//
//        this.add(this.getSlider(),null);
//          this.add(this.getSpinner(),null);
//        this.add(this.getToolBar(),null);
          this.setTitle("Test");//���ô��ڱ���

    }
    static void appendComponent(){
    
    }
    
//    private JToolBar getToolBar(){
//        if(toolBar==null){
//            toolBar = new JToolBar();
//            toolBar.setBounds(103,260,71,20);
//            toolBar.setFloatable(true);
//        }
//        return toolBar;
//    }
    private JSpinner getSpinner(){
        if(spinner==null){
            spinner = new JSpinner();
            spinner.setBounds(103,220, 80,20);
            spinner.setValue(100);
        }
        return spinner;
    }
    private  JPanel  getTextAreaPanelBelow(){
    		 panelInput.setLayout(null);
    	     
    	     label1 = new JLabel();
             label1.setBounds(0,0,53,18);
             label1.setText("����a");
             label1.setToolTipText("JLabel");
             panelInput.add(label1);
             
             text[0] = new JTextField();
             text[0].setBounds(30,0,80,18);
             text[0].setText("");
             panelInput.add(text[0]);
             
             label1 = new JLabel();
             label1.setBounds(220,0,53,18);
             label1.setText("����b");
             label1.setToolTipText("JLabel");             
    	     panelInput.add(label1);
            
    	     text[1] = new JTextField();
             text[1].setBounds(250,0,80,18);
             text[1].setText("");
             panelInput.add(text[1]);
             
             label1 = new JLabel();
             label1.setBounds(440,0,53,18);
             label1.setText("����c");
             label1.setToolTipText("JLabel");             
    	     panelInput.add(label1);
    	     
    	     text[2] = new JTextField();
             text[2].setBounds(470,0,80,18);
             text[2].setText("");
             panelInput.add(text[2]);
             
             
    	     label1 = new JLabel();
    	     label1.setBounds(0,45,53,18);
    	     label1.setText("������");
    	     panelInput.add(label1);
             
    	     text[3] = new JTextField();
             text[3].setBounds(37,45,80,18);
             text[3].setText("");
             panelInput.add(text[3]);
             
             label1 = new JLabel();
    	     label1.setBounds(220,45,53,18);
    	     label1.setText("���Ƕ�");
    	     panelInput.add(label1);
             
             text[4] = new JTextField();
             text[4].setBounds(257,45,80,18);
             text[4].setText("");
             panelInput.add(text[4]);
             
             
    	     panelInput.setBounds(10,540,580,100);
    
    	return panelInput;
    }
    
    private  JPanel  getTextAreaPanelLeft(){
    	if(textAreaOutputLeft == null){
    		 panel = new JPanel();
    	     panel.setLayout(new BorderLayout());
    	     textAreaOutputLeft = new JTextArea("",10,15);
    	     textAreaOutputLeft.setEditable(false);
    	     textAreaOutputLeft.setAutoscrolls(true);
    	     Dimension d = new Dimension(20, 20);
    	     textAreaOutputLeft.setMinimumSize(d);
    	        
    	     JScrollPane pane = new JScrollPane(textAreaOutputLeft);
    	     pane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
    	     pane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    	     panel.add(pane,BorderLayout.CENTER);
    	     panel.setBounds(10,30,280, 500);
    	}
    	return panel;
    }
    
    private  JPanel  getTextAreaPanelRight(){
    	if(textAreaOutputRight == null){
    		 panel = new JPanel();
    	     panel.setLayout(new BorderLayout());
    	     textAreaOutputRight = new JTextArea("",10,15);
    	     textAreaOutputRight.setEditable(false);
    	     textAreaOutputRight.setAutoscrolls(true);
    	     Dimension d = new Dimension(20, 20);
    	     textAreaOutputRight.setMinimumSize(d);
    	        
    	     JScrollPane pane = new JScrollPane(textAreaOutputRight);
    	     pane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
    	     pane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    	     panel.add(pane,BorderLayout.CENTER);
    	     panel.setBounds(310,30,280, 500);
    	}
    	return panel;
    }
//    private JSlider getSlider(){
//        if(slider==null){
//            slider = new JSlider();
//            slider.setBounds(103,200,100, 20);
//            slider.setMaximum(100);
//            slider.setMinimum(0);
//            slider.setOrientation(0);
//            slider.setValue(0);
//        }
//        return slider;
//    }
    /**
     * �˵��ļ���JMenuBar->JMenu->JMenuItem
     * ��������1��n�Ĺ�ϵ
     * �����Ӳ˵��õ�SetJMenuBar����
     * @return �����õĲ˵�
     */
    private JMenuBar getMenu(){
        if(menuBar==null){
            menuBar = new JMenuBar();
            JMenu m1 = new JMenu();
            m1.setText("�ļ�");
            JMenu m2 = new JMenu();
            m2.setText("�༭");
            JMenu m3 = new JMenu();
            m3.setText("����");
            
            JMenuItem item11 = new JMenuItem();
            item11.setText("��");
            item11.addActionListener(new fileChoose());
            
            JMenuItem item12 = new JMenuItem();
            item12.setText("�ĵ�");
            item12.addActionListener(new DocumentChoose());
            JMenuItem item13 = new JMenuItem();
            item13.setText("�˳�");
            
            JMenuItem item21 = new JMenuItem();
            item21.setText("����");
            JMenuItem item22 = new JMenuItem();
            item22.setText("����");
            JMenuItem item23 = new JMenuItem();
            item23.setText("����");
            
            JMenuItem item31 = new JMenuItem();
            item31.setText("��ӭ");
            JMenuItem item32 = new JMenuItem();
            item32.setText("����");
            JMenuItem item33 = new JMenuItem();
            item33.setText("�汾��Ϣ");
            
            m1.add(item11);
            m1.add(item12);
            m1.add(item13);
            
            m2.add(item21);
            m2.add(item22);
            m2.add(item23);
            
            m3.add(item31);
            m3.add(item32);
            m3.add(item33);
            
            menuBar.add(m1);
            menuBar.add(m2);
            menuBar.add(m3);
            menuBar.setBounds(0,0,600,30);
        }
        return menuBar;
    }
    /**
     * ���������б��
     * @return
     */
//    private JComboBox getBox(){
//        if(box==null){
//            box = new JComboBox();
//            box.setBounds(103,140,71,27);
//            box.addItem("1");
//            box.addItem("2");
//            box.addActionListener(new comboxListener());//Ϊ�����б����Ӽ�������
//
//        }
//        return box;
//    }
//    private class comboxListener implements ActionListener{
//        public void actionPerformed(ActionEvent e){
//            Object o = e.getSource();
//            System.out.println(o.toString());
//        }
//    }
    
    /**
     * �趨�ı���
     * @return
     */
//      private static JTextField getTextField(){
//        if(text1==null){
//            text1 = new JTextField();
//            text1.setBounds(220,650,53,18);
//        }
//        return text1;
//    }
//    
    /**
     * ���ñ�ǩ
     * @return ���úõı�ǩ
     */
//    private static JLabel getLabel(){
//        if(label1==null){
//            label1 = new JLabel();
//            label1.setBounds(0,650,53,18);
//            label1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//            label1.setText("Name");
//            label1.setToolTipText("JLabel");
//        }
//        return label1;
//    }
    /**
     * ���ð�ť
     * @return ���úõİ�ť
     */
    private JButton getButton(){
        if(button1==null){
            button1 = new JButton();
            button1.setBounds(200,650,160,40);
            button1.setText("��ʼ����");
            button1.addActionListener(new generateButton());//��Ӽ������࣬����Ҫ����Ӧ���ɼ�������ķ���ʵ��

        }
        return button1;
    }
    
    /**
     * ��������ʵ��ActionListener�ӿڣ���Ҫʵ��actionPerformed����
     * @author HZ20232
     *
     */
    private class generateButton implements ActionListener{
        public void actionPerformed(ActionEvent e){
        	if(fileContent != ""){
	        	try {
				     GCC.generateTest(fileContent);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        	}
        }
    }
    
    private class fileChoose implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			  //�ÿ�ʼ��ť����
			  button1.setEnabled(true);
			
			  JFileChooser jfc=new JFileChooser();  
		      jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES );  
		      jfc.showDialog(new JLabel(), "ѡ��");  
		      File file=jfc.getSelectedFile();  
		      if(file.isDirectory()){  
		            System.out.println("�ļ���:"+file.getAbsolutePath());  
		      }else if(file.isFile()){  
		            System.out.println("�ļ�:"+file.getAbsolutePath());  
		      }
		      
		 
		      try {
				fileContent = GCC.getFile(jfc.getSelectedFile().getName());
				textAreaOutputLeft.setText(fileContent);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		      System.out.println(jfc.getSelectedFile().getName());  
		}
    }
    
    private class DocumentChoose implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			  JFileChooser jfc=new JFileChooser();  
		      jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES );  
		      jfc.showDialog(new JLabel(), "ѡ��");  
		      File file=jfc.getSelectedFile();  
		      if(file.isDirectory()){  
		            System.out.println("�ļ���:"+file.getAbsolutePath());  
		      }else if(file.isFile()){  
		            System.out.println("�ļ�:"+file.getAbsolutePath());  
		      }
		      
		      try {
				    String DocuemntsContent = GCC.getFile(jfc.getSelectedFile().getName());
				    JFrame frame = new JFrame("title2");
				    frame.setLayout(null);
				    frame.setBounds(20, 20, 300, 520);
				    panel = new JPanel();
		    	    panel.setLayout(new BorderLayout());
		    	    JTextArea textArea = new JTextArea("",10,15);
		    	    textArea.setEditable(false);
		    	    textArea.setAutoscrolls(true);
		    	    Dimension d = new Dimension(20, 20);
		    	    textArea.setMinimumSize(d);
		    	    textArea.setText(DocuemntsContent);
		    	    JScrollPane pane = new JScrollPane(textArea);
		    	    pane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		    	    pane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		    	    panel.add(pane,BorderLayout.CENTER);
		    	    panel.setBounds(0,0,280, 500);
		    	    frame.add(panel,null); 
				    frame.setVisible(true);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		      System.out.println(jfc.getSelectedFile().getName());  
		}
    }
    
    static void appendRightText(String para, int proportion){
    	textAreaOutputRight.setText(textAreaOutputRight.getText() + para + "\n" + "���ɲ��Ը�����:" + proportion + "\n");
    }
    public static void appendRightText(String string) {
		// TODO Auto-generated method stub
		textAreaOutputRight.setText(textAreaOutputRight.getText() +string + "\n" );
	}
    static void appendRightTextDistance(int i){
    	textAreaOutputRight.setText(textAreaOutputRight.getText()  + "����:" + i + "\n");
    }
 
}