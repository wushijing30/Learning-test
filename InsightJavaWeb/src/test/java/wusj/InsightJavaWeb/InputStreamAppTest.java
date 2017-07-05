package wusj.InsightJavaWeb;

import java.io.IOException;

import org.junit.Test;

public class InputStreamAppTest {
	
	@Test
	public void copyBytesTest(){
		InputStreamApp testObj = new InputStreamApp();
		try {
			String srcFileString = InputStreamAppTest.class.getResource("/abc.txt").getPath();
			String desFileString = InputStreamAppTest.class.getClassLoader().getResource("outabc.txt").getPath();
			System.out.println(srcFileString);
			System.out.println(desFileString);
			testObj.CopyBytes(srcFileString, desFileString);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
