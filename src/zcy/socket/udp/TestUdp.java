package zcy.socket.udp;

import java.net.*;

public class TestUdp {
	public static void main(String[] args) throws Exception {
		InetAddress ia = InetAddress.getLocalHost();
//		String ipAdr = ia.getHostAddress();
		System.out.println(ia);
	}
}