package zcy.io;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class FileInOut {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("D:/20111217.log")));
		FileOutputStream w = new FileOutputStream("d:\\1.log");
		
		String data = null;
		java.text.DecimalFormat df = new DecimalFormat("#.###");
		while((data = br.readLine())!=null)
		{
			String[] s = data.split(",");
			String licheng = s[9];
			double d = new Double(licheng);
			double dd = 804371.388-815.388;
			if(d<80000)
			{
				data = data.replace(licheng, df.format(d+dd));
			}
			w.write(data.getBytes());
			w.write("\r\n".getBytes());
		}
	}

}
