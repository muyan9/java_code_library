package zcy.socket.gethtml;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.URL;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SocketSend extends Thread {
	private final Log log = LogFactory.getLog(getClass());
	
	private boolean runflag = true;
	
	public SocketSend(){}
	
	public void run() {
		URL temp_url = null;
		log.info("SocketSend Started...");
		BufferedWriter wr = null;
		
		while(runflag)
		{
			try {
//				System.gc();
				Thread.sleep(500);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			//System.out.println("waiting...");
			if(GetHTML.url==null || GetHTML.url.equals(temp_url))continue;
			if(GetHTML.socket==null)continue;
			
			try {
				wr = new BufferedWriter(new OutputStreamWriter(
						GetHTML.socket.getOutputStream(), "UTF8"));
				if(!GetHTML.url.equals(temp_url))
				{
					wr.write("GET " + GetHTML.url.getPath() + " HTTP/1.0\r\n");
					wr.write("HOST:" + GetHTML.url.getHost() + "\r\n");
					wr.write("\r\n");
					wr.flush();
					log.info("send finished...\n-------------------------------------------");
					temp_url = GetHTML.url;
					
					GetHTML.sendmodule_finish_flag = true;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public boolean isRunflag() {
		return runflag;
	}

	public void setRunflag(boolean runflag) {
		this.runflag = runflag;
	}
}
