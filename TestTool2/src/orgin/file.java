package orgin;
import java.io.IOException;
import java.io.RandomAccessFile;  
  
/** 
 * 
 * @author malik 
 * @version 2011-3-10 ����10:49:41 
 */  
public class file {  
      
    public  static void createFile(){
//    	 try{  
//             File file = new File("addfile.txt");  
//             if(file.createNewFile()){  
//                 System.out.println("Create file successed");  
//             }  
           
    }
    public static void method3(String fileName, String content) {   
        RandomAccessFile randomFile = null;  
        try {     
            // ��һ����������ļ���������д��ʽ     
            randomFile = new RandomAccessFile(fileName, "rw");     
            // �ļ����ȣ��ֽ���     
            long fileLength = randomFile.length();     
            // ��д�ļ�ָ���Ƶ��ļ�β��     
            randomFile.seek(fileLength);     
            randomFile.writeBytes(content);      
        } catch (IOException e) {     
            e.printStackTrace();     
        } finally{  
            if(randomFile != null){  
                try {  
                    randomFile.close();  
                } catch (IOException e) {  
                    e.printStackTrace();  
                }  
            }  
        }  
    }    

}  