package zcy.socket.gethtml;
/*
 * 命令行方式获取网页内容
 * 可改装为服务器压力测试工具
 */
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class GetHTML {
	private final Log log = LogFactory.getLog(getClass());
	
	public static URL url = null;
	public static Socket socket = null;
	public static boolean sendmodule_finish_flag = false;
	public static ArrayList<String> array_url_string = new ArrayList<String>();
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//String urls = ".*((http|https|ftp):\\/\\/[@a-zA-Z0-9\\-/\\\\\\.\\+:]+).*";
		
		URLInput url = new URLInput();
		URLBatchInput urlbatch = new URLBatchInput();
		SocketSend send = new SocketSend();
		SocketReceive receive = new SocketReceive();
		url.start();
		urlbatch.start();
		send.start();
		receive.start();
	}
}
