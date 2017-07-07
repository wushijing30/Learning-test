package wusj.InsightJavaWeb;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;


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
		Class<?> clazz = null;
		if(this.name.equals(name) && !"java".equals(name)){
			//先看看要加载的类是否已经加载过
			clazz = findLoadedClass(name);
			if(clazz == null){
				clazz = findClass(name);
			}
			//类的生命周期包括：加载、验证、准备、解析、初始化、使用、卸载。其中验证、准备、解析统称为连接 
			//是否要连接类
			if(resolve){
				resolveClass(clazz);
			}
			return clazz;
		}else{
			return super.loadClass(name);
		}
	}
	
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		String fileName = className2FileName(name);
		byte[] bytes = getData(fileName);
		
		return defineClass(name, bytes, 0, bytes.length);
	}
	
	private String className2FileName(String className){
		//编译后class文件存放的路径
		String baseDir = "F:\\idea_workspace\\Test\\target\\classes\\";
		className = className.replace(".", java.io.File.separator);
		StringBuilder fileName = new StringBuilder();
		fileName.append(baseDir).append(className).append(".class");
		return fileName.toString();
	}
	
	private byte[] getData(String fileName){
		try {
			InputStream in = new FileInputStream(fileName);
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			byte[] buffer = new byte[2048];
			int num = 0;
			while((num = in.read(buffer)) != -1){
				out.write(buffer, 0, num);
			}
			in.close();
			return out.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
