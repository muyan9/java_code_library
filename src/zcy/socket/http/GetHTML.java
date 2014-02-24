package zcy.socket.http;
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

public class GetHTML {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			String host = "";
			String path = "";
			while (true) {
				if (path.equals("-q") || path.equals("--quit")) {
					System.exit(0);
				}
				BufferedReader line = new BufferedReader(new InputStreamReader(
						System.in));
				if (path.equals("") || path.equals("-s")
						|| path.equals("--host")) {
					System.out.println("input host:");
					host = line.readLine();
				}

//				host = pingServer(host,20);
				Socket socket = new Socket(host, 80);

				// 发送命令
				BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(
						socket.getOutputStream(), "UTF8"));
				wr.write("GET " + path + " HTTP/1.0\r\n");
				wr.write("HOST:" + host + "\r\n");
				wr.write("\r\n");
				wr.flush();

//				int ch;
				String strline = null;
				BufferedReader buf = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                while((strline = buf.readLine()) != null)
                {
                    System.out.println(strline);
//                    System.out.println(new String(strline.getBytes("gbk"),"utf8"));
//                    System.out.println(new String(strline.getBytes("gb2312"),"utf8"));
                }
				socket.close();

				System.out.println("input path:");
				path = line.readLine().trim().toLowerCase();
			}
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
