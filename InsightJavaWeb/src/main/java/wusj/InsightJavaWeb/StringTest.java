package wusj.InsightJavaWeb;

public class StringTest {

	public static void main(String[] args) {
		 String str = "abcde";
		
		if(str.startsWith("cd", 2)){
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}
		
		System.out.println("hashCode:" + str.hashCode() + str.toString());
		System.out.println(str.concat("ffff"));
		 char buf[] = new char[10];
		//str.getChars(buf, 4);

	}
}
