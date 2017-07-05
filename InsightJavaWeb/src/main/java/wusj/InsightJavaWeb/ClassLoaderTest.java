package wusj.InsightJavaWeb;

import java.net.URL;


public class ClassLoaderTest {
	public ClassLoaderTest() {
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated constructor stub
		ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
		while(classLoader != null){
			System.out.println(classLoader.getClass().getCanonicalName());
			classLoader = classLoader.getParent();
		}
		
		/*查看BootStrap ClassLoader从哪些路径加载*/
		URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
		for(URL url : urls){
			System.out.println(url.toString());
		}
	}
}
