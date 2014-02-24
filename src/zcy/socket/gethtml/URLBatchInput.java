package zcy.socket.gethtml;

import java.io.IOException;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class URLBatchInput extends Thread {
	private final Log log = LogFactory.getLog(getClass());
	
	private boolean runflag = true;
	
	public void run() {
		log.info("URLBatchInput Started...");
		while(runflag)
		{
			boolean finish_flag = GetHTML.sendmodule_finish_flag;
			while(!finish_flag)
			{
				
				//取得批量url列表
				ArrayList<String> array_url = GetHTML.array_url_string;
				String sTemp = null;
				//若列表中还有未检测的url，取第一个url并生成URL对象，回存到GetHTML.url
				if(array_url!=null && array_url.size()>0)
				{
					sTemp = array_url.get(0);
					
					log.info("已取得　" + sTemp);
					
					try {
						GetHTML.url = new URL(sTemp);
						log.info(1);
						log.info("port :       " + GetHTML.url.getPort());
						log.info("address :    " + GetHTML.url.getHost());
						log.info("protocol:    " + GetHTML.url.getProtocol());
						GetHTML.socket = new Socket(SimpleDNS.DNS(GetHTML.url), GetHTML.url.getPort()<=0?80:GetHTML.url.getPort());
						log.info("已生成url和socket");
					} catch (MalformedURLException e) {
						e.printStackTrace();
					} catch (UnknownHostException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
					
					GetHTML.array_url_string = array_url;
					//通知SocketSend，已生成新的URL
					GetHTML.sendmodule_finish_flag = false;
					log.info("sendmodule_finish_flag = false");
					//移除url
					array_url.remove(0);
				}
				
			}
		}
	}
}
