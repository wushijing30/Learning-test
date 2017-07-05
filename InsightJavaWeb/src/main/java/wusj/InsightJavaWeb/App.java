package wusj.InsightJavaWeb;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	String srcFileString2 = App.class.getClassLoader().getResource("/").getPath();
        System.out.println( "Hello World!" + srcFileString2 );
    }
}
