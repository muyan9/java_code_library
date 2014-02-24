package zcy.swing;

import java.io.IOException;
import java.net.Socket;

import org.apache.log4j.Logger;

public class TcpSocketProcess extends Thread {
	Logger logger = Logger.getLogger(TcpSocketProcess.class);
	private Socket tcpSocket;
	
	public Socket getTcpSocket() {
		return tcpSocket;
	}

	public void setTcpSocket(Socket tcpSocket) {
		this.tcpSocket = tcpSocket;
	}

	public TcpSocketProcess(Socket socket)
	{
		this.tcpSocket = socket;
	}
	
	
	public void run()
	{
		while (true) {
			byte[] bs = new byte[4096];
			int len = 0;
			try {
				len = tcpSocket.getInputStream().read(bs);
				
				
			} catch (NegativeArraySizeException e) {
				logger.info("断开连接:" + tcpSocket.getRemoteSocketAddress());
				try {
					tcpSocket.close();
					tcpSocket = null;
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				break;
			} catch (IOException e) {
				logger.debug("连接后两次数据请求间隔时间超长，连接断开:" + tcpSocket.getRemoteSocketAddress());
				logger.debug("len:" + len);
				try {
					tcpSocket.close();
					tcpSocket = null;
				} catch (IOException e1) {
				}
				break;
			}
		}
	}
}
