package zcy.service.down;
/*
 * 命令行方式获取网页内容
 * 可改装为服务器压力测试工具
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class down {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			//http://111.33bbb.com/index.htm?i=2721.htm&ii=Down
			String surl = "http://cn.dada.net/%e9%ab%98%e6%b8%85%e6%99%b0%e7%ba%af%e7%9c%9fmm%e8%a7%86%e9%a2%91/";//args[0];
			String host = Url.getHost(surl);
			String path = Url.getPath(surl);
			

//			host = pingServer(host,20);
			Socket socket = new Socket(host, 80);

			// 发送命令
			BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(
					socket.getOutputStream(), "UTF8"));
			wr.write("GET " + path + " HTTP/1.0\r\n");
			wr.write("HOST:" + host + "\r\n");
			wr.write("\r\n");
			wr.flush();

			String strline = null;
			BufferedReader buf = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while((strline = buf.readLine()) != null)
            {
                System.out.println(strline);
//                    System.out.println(new String(strline.getBytes("gbk"),"utf8"));
//                    System.out.println(new String(strline.getBytes("gb2312"),"utf8"));
            }
			socket.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * ping the server
	 * 
	 * @param server
	 *            String
	 * @param timeout
	 *            int
	 * @return boolean
	 * @throws IOException
	 */
	public static String pingServer(String server, int timeout) {
		BufferedReader in = null;
		Runtime r = Runtime.getRuntime();

		String pingCommand = "ping   " + server + "   -n   1   -w   " + timeout;
		try {
			Process p = r.exec(pingCommand);
			if (p == null) {
				return null;
			}
			in = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line = null;
			String patternStr = "(\\d{1,3}\\.){3}\\d{1,3}";
			Pattern pattern = Pattern.compile(patternStr);
			
			while ((line = in.readLine()) != null) {
				Matcher matcher = pattern.matcher(line);
				if (matcher.find()) {
					return matcher.group();
				}
			}
			in.close();
		} catch (Exception ex) {
			return null;
		}
		return null;
	}
}
