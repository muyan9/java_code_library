package zcy.socket.udp.test;

/*
 * Miwenshu Created on 2005-9-15
 *
 */
import java.net.*;
import java.io.*;

class DatagramServer {
	private static int PORT = 8122;

	public static void main(String[] args) {
		try {
			System.out.println("Datagram Server.");
			byte[] buf = new byte[1000];
			DatagramSocket ds = new DatagramSocket(PORT);
			// ��ʼ����12345�˿�
			DatagramPacket ip = new DatagramPacket(buf, buf.length);
			// �����������ݱ���ʵ��
			int i = 0;
			String base = "";
			while (true) {
				ds.receive(ip);
				// ������ֱ���յ����ݱ�������װ��IP��
				String info = new String(buf);
//				if (i == 1)
//					base = info;
//				if (base.equals(info)) {
//				} else {
					System.out.println("-------------");
					System.out.println(info.trim());
//					base = info;
//				}
				i++;
			}
		} catch (SocketException e1) {
			System.out.println("SocketException");
		} catch (UnknownHostException e11) {
			System.out.println("UnknownHostException");
		} catch (IOException e) {
			System.out.println("IOException");
		}
	}
}