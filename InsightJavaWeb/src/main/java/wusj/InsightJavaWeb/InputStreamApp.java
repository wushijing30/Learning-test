package wusj.InsightJavaWeb;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class InputStreamApp {
	
	public void CopyBytes(String srcFile, String desFile) throws IOException{
		InputStream in = null;
		OutputStream out = null;
		try{
			in = new FileInputStream(srcFile);
			out = new FileOutputStream(desFile);
			int c;
			while((c = in.read()) != -1){
				out.write(c);
			}
		}finally{
			if(in != null){
				in.close();
			}
			if(out != null){
				out.close();
			}
		}
	}

}
