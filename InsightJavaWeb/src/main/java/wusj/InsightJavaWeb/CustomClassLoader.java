package wusj.InsightJavaWeb;

public class CustomClassLoader extends ClassLoader {
	//所要加载的类名
	private String name;
	public CustomClassLoader(ClassLoader parent, String name) {
		super(parent);
		if(name == null || name.length() <= 0){
			throw new NullPointerException();
		}
		this.name = name;
	}
	
	@Override
	protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException{
		
	}

}
