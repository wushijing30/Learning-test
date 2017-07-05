package wusj.ResourceFileTest;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	/*********方法1 通过ClassLoader.getResource()读取********/
    	ClassLoader classLoader = App.class.getClassLoader();
    	//得到的路径是classpath
    	System.out.println(classLoader.getResource("").toString());
    	//读取abc.txt
    	System.out.println(classLoader.getResource("abc.txt").toString());
    	System.out.println();
    	
    	/********方法2 通过class.getResource()读取*********/
    	//得到的路径是classpath
    	System.out.println(App.class.getResource("/").toString());
    	//得到当前类所在文件夹
    	System.out.println(App.class.getResource("").toString());
    	//读取classpath下的abc.txt,必须加/,否则会定位到当前类所在文件夹
    	System.out.println(App.class.getResource("/abc.txt").toString());
    	//读取当前类所在文件夹下的resources/def.txt
    	System.out.println(App.class.getResource("resources/def.txt").toString());
    }
}
