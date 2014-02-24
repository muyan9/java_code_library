package zcy.socket.gethtml;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SimpleDNS {
	private static final Log log = LogFactory.getLog(new SimpleDNS().getClass());
	
	public static void main(String[] args) {
		try {
			System.out.println(DNS(new URL("http://localhost/")));
			InetAddress address = InetAddress.getByName("dict.iciba.com");
//			for (int i = 0; i < address.length; i++) {
				System.out.println(address.getHostAddress());
//			}
		} catch (Exception e) {
			System.out.println(e.toString());
			System.exit(1);
		}
	}
	
	public static String DNS(URL host) {
		InetAddress address;
		log.info(1);
		try {
			log.info(2);
			address = InetAddress.getByName(host.getHost());
			log.info(3);
			
			return address.getHostAddress();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return null;
	}
}