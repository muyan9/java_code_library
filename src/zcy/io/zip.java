package zcy.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class zip {
	public static HashMap<String, byte[]> unZip(String f) {
		File ff = new File(f);
		try {
			InputStream is = new FileInputStream(ff);
			ZipInputStream zipis = new ZipInputStream(is);
			ZipEntry entry;
			HashMap<String, byte[]> hmFileContent = new HashMap<String, byte[]>();
			while((entry = zipis.getNextEntry()) != null) {
				if(entry.isDirectory()) {
					continue;
				}
				String fname = entry.getName();
				
				long l = entry.getSize();
				byte[] content = new byte[(int) l];
				zipis.read(content);
				
				if(fname.endsWith(".json")) {
					continue;
				}
				System.out.println(fname);
				hmFileContent.put(fname, content);
			}
			
			return hmFileContent;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
//		String fname = "E:\\git\\java_code_library\\bin\\test/fac31dddee21567ba5a436821a22a0b7.zip";
//		String fname = "E:\\git\\java_code_library\\bin\\test/fb8f1378aace87f28cb8d38bb819599e.zip";
		String fname = "C:\\Users\\zcy\\Desktop\\todo\\fac31dddee21567ba5a436821a22a0b7.zip";
		unZip(fname);
	}

}
