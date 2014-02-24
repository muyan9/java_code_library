package zcy.socket.gethtml;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SocketReceive extends Thread {
	private final Log log = LogFactory.getLog(getClass());
	
	private boolean runflag = true;
	
	public SocketReceive(){}

	public void run() {
		log.info("SocketReceive Started...");
		BufferedReader buf = null;
		while(runflag)
		{
			if(GetHTML.socket==null || GetHTML.socket.isClosed()) continue;
//			try {
//				Thread.sleep(100);
//			} catch (InterruptedException e1) {
//				e1.printStackTrace();
//			}
			
			String strline = null;
			try {
				buf = new BufferedReader(new InputStreamReader(GetHTML.socket.getInputStream()));
			} catch (IOException e2) {
				e2.printStackTrace();
			}
			
			try {
				while((strline = buf.readLine()) != null)
				{
					log.info(strline);
				}
				buf.close();
				GetHTML.socket.close();
				GetHTML.socket = null;
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
