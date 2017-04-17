/** 
 * ������ʽ
 */

package data;

import java.util.regex.Pattern;

public class RegEx {
	// C���Թؼ���
	static String[] C_KEYWORDS = new String[] {
			"auto", "double", "int", "struct", "break", "else", "long", "switch",   
			"case", "enum", "register", "typedef", "char", "extern", "return", "union",  
			"const", "float", "short", "unsigned", "continue", "for", "signed", "void",  
			"default", "goto", "sizeof", "volatile", "do", "if", "while", "static"
	};	
	// ��ȡC���Թؼ��ֵ�����
	public static String CKeyWord = 
			"\\b(" + String.join("|", C_KEYWORDS) + ")\\b";
    public static final Pattern C_KEYWORD_PATTERN = Pattern.compile(CKeyWord);
    
	// C���Ժ�������
    private static String[] FUNC_TYPES = new String[] {
			"double", "int", "long", "char", "float", "short", "void", 
	};

//	// ��ȡC���Ժ���������
//	private static String FuncType = 
//			"\\b(" + String.join("|", FUNC_TYPES) + ")(\\s+)(\\w+)\\((.*)\\)";
//    public static final Pattern FUNC_TYPES_PATTERN = Pattern.compile(FuncType);
	
	// ��ȡC���Ժ��������������
	private static String VarType = 
			"\\b(" + String.join("|", FUNC_TYPES) + ")(\\s+)(\\w+)\\b";	
    public static final Pattern VAR_TYPE_PATTERN = Pattern.compile(VarType);
    
	// ��ȡC���Ժ������������������
    public static String VarName = 
    		"\\b(" + String.join("|", FUNC_TYPES) + ")\\s+";	
    
//	// Java���Թؼ���
//    private static final String[] JAVA_KEYWORDS = new String[] {
//            "abstract", "assert", "boolean", "break", "byte",
//            "case", "catch", "char", "class", "const",
//            "continue", "default", "do", "double", "else",
//            "enum", "extends", "final", "finally", "float",
//            "for", "goto", "if", "implements", "import",
//            "instanceof", "int", "interface", "long", "native",
//            "new", "package", "private", "protected", "public",
//            "return", "short", "static", "strictfp", "super",
//            "switch", "synchronized", "this", "throw", "throws",
//            "transient", "try", "void", "volatile", "while"
//    };
}
