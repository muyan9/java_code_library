package zcy.socket.udp;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.*;

public class UDPserver {
	
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) {
				
		try
		{
			byte[] buf = new byte[1000]; 
			DatagramSocket ds = new DatagramSocket(12345); 
			//开始监视12345端口
			DatagramPacket ip = new DatagramPacket(buf, buf.length); 
			//创建接收数据报的实例
			while (true) 
			{
				ds.receive(ip);
				//阻塞，直到收到数据报后将数据装入IP中
				String ss = new String(buf);
				System.out.println(ss.trim()); 
				ip.setData("ok".getBytes());
				ds.send(ip);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
