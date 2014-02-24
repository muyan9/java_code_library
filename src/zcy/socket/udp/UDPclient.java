package zcy.socket.udp;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPclient {
	
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
//		InetAddress target = InetAddress.getByName("219.133.49.170");
		InetAddress target = InetAddress.getByName("127.0.0.1");
		//得到目标机器的地址实例
		DatagramSocket ds = new DatagramSocket(9999);
		//从9999端口发送数据报
		String hello = "Hello, I am come in!";
		//要发送的数据
		byte[] buf = hello.getBytes();
		
		byte[] sendmessage = {(byte)0x02,(byte)0x11,(byte)0x1D,(byte)0x00,(byte)0x91,(byte)0x00,(byte)0x00,(byte)0x37,(byte)0xB3,(byte)0xCD,
				(byte)0x02,(byte)0x62,(byte)0x64,(byte)0xBA,(byte)0xD4,(byte)0xA5,(byte)0x87,(byte)0xD5,(byte)0x3E,(byte)0x77,
				(byte)0x20,(byte)0x1B,(byte)0x73,(byte)0x01,(byte)0x44,(byte)0xA4,(byte)0x3E,(byte)0x44,(byte)0xD0,(byte)0xD4,
				(byte)0x0E,(byte)0xE4,(byte)0x42,(byte)0xB0,(byte)0x78,(byte)0xED,(byte)0xFA,(byte)0x27,(byte)0xCF,(byte)0x8E,
				(byte)0xDB,(byte)0x92,(byte)0x2D,(byte)0xD2,(byte)0xD6,(byte)0xEA,(byte)0xB2,(byte)0xF4,(byte)0x6D,(byte)0x8C,
				(byte)0x12,(byte)0x4F,(byte)0x2A,(byte)0x27,(byte)0xA4,(byte)0x0E,(byte)0xE4,(byte)0xF1,(byte)0xB3,(byte)0x03
};
		//将数据转换成Byte类型
		DatagramPacket op = new DatagramPacket(sendmessage, sendmessage.length, target, 50021); 
		//将BUF缓冲区中的数据打包
		ds.send(op); 
		//发送数据
		
		byte[] receive = new byte[1024];
		op = new DatagramPacket(receive, receive.length);
		ds.receive(op);
		java.io.ByteArrayInputStream a = new java.io.ByteArrayInputStream(op.getData());
		BufferedReader br = new BufferedReader(new InputStreamReader(a));
		int ch;
		
		byte[] b = op.getData();
		
//		for(int j=0;j<i;j++)
		{
//			Byte b = (byte)br.read();
//			int ab = b.intValue();
			System.out.println((byte)br.read());
		}
//		System.out.println(br.readLine());
		ds.close();
		//关闭连接

	}
}
