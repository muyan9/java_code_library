package zcy.swing;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Date;

import org.apache.log4j.Logger;

public class TCPListener extends Thread {
	Logger logger = Logger.getLogger(TCPListener.class);
	private ServerSocket tcpSocketServer;
	private int port;
	private int soTimeout;
	
	public testSocket form;
	/**
	 * 创建socket监听服务，并创建连接请求
	 * @param port		监听端口号
	 * @param timeout	每个连接的两次数据传送之间的超时时间，用于判断与终端的连接是否正常
	 */
	public TCPListener(int port, int timeout)
	{
		this.port = port;
		this.soTimeout = timeout;
	}
	public void run()
	{
		try {
			tcpSocketServer = new ServerSocket(this.port);
		} catch (IOException e) {
			logger.fatal("创建socketserver异常 : " + e.getMessage());
			logger.fatal("系统将终止运行，请检查是否端口已被占用，或与管理员联系！");
			//TODO 考虑定义错误码
			System.exit(1);
		}
		
		while (true) {
			Socket request = null;
			
			try {
				request = tcpSocketServer.accept();
			} catch (IOException e1) {
				logger.fatal("接受连接时创建socket连接异常");
				e1.printStackTrace();
			}
			try {
				request.setKeepAlive(true);
				request.setSoTimeout(this.soTimeout);
				form.socketList.add(request);
			} catch (SocketException e) {
				logger.fatal("socket超时");
				e.printStackTrace();
			}
			new TcpSocketProcess(request).start();
			
		}
	}
}
