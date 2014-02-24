package zcy.socket.gethtml;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class URLInput extends Thread {
	private final Log log = LogFactory.getLog(getClass());
	
	public void run() {
		log.info("URLInput Started...");
		try {
			String strline = "";
			BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
				strline = buf.readLine();
	            
				if (strline.equals("-q") || strline.equals("--quit")) {
					System.exit(0);
				}
				
				if (strline.equals("batch")) {
					log.info("batch start...");
					GetHTML.array_url_string = batch();
					continue;
				}
				
				GetHTML.array_url_string.add(strline);
	        }
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private ArrayList<String> batch()
	{
		ArrayList<String> list = new ArrayList<String>();
		
		list.add("http://dict.iciba.com/");
		list.add("http://www.baidu.com/");
		list.add("http://mail.163.com/");
		
		return list;		
	}
}
