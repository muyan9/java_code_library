package zcy.socket.http;
/*
 * �����з�ʽ��ȡ��ҳ����
 * �ɸ�װΪ������ѹ�����Թ���
 */
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class tttt {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			int i = 0;
			while (true) {
				Socket socket = new Socket("202.108.9.226", 80);
				
				// ��������
				BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(
						socket.getOutputStream(), "UTF8"));
				java.util.Date d = new java.util.Date();
				System.out.println((i++) + "   ��");
				wr.write("GET /xmastree/inc/?userId=35545375&t="+d.getTime()+" HTTP/1.1\r\n");
				wr.write("Accept: */* \r\n");
				wr.write("Referer: http://blog.163.com/act/swf_071225/bottom.swf\r\n");
				wr.write("x-flash-version: 9,0,47,0 \r\n");
				wr.write("UA-CPU: x86\r\n");
				wr.write("Accept-Encoding: gzip, deflate\r\n");
				wr.write("User-Agent: Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; .NET CLR 2.0.50727)\r\n");
				wr.write("Host: blog.163.com\r\n");
				wr.write("Connection: Keep-Alive\r\n");
				wr.write("Cookie: MAIL163_SSN=muyan9; theaddr=%u9ED1%u9F99%u6C5F; NETEASE_SSN=muyan9; NETEASE_ADV=11&21&1197872351959; vjuids=-768db76a1.116c69fd5ee.0.72106ecb556be4; vjlast=1197333272; _ntes_nnid=a81385dac1f23e33d47dfb90da351653,0|news|; NEBLOG_LOGIN=0%7Cnull%7Cnull; Province=0450; City=0451; ntes_mail_firstpage=normal; NTES_SESS=PbEGh6mHVwSmqkt3rKZzAev8fxO4b9M3FxyHOKNoEikV5PbfT5eb_gDalfYjp4TwDckIj26jGPoj40fotbMyAq_a5; Coremail=RamqDnVbVZagE%fBnGSaiizvODbwDAhgiibbvMcypOvhbi; wmsvr_domain=g4a65.mail.163.com; ntes_mail_truename=�Գ���; ntes_mail_province=50953; ntes_mail_sex=0; mail_style=js3; USERTRACK=211.93.37.17.1197872379811585; NETEASE_AUTH_USERNAME=muyan9; NTESBLOGSI=1823E94B34B33478068BDBEA637B1E4C.app-18; NETEASE_AUTH_SOURCE=space; NTESACTSI=7BDF87DEDE06A25E646E896B88A74762.act-1; NTESMSGSI=8C3A065395D9DA8CF37AF20D4B91659F.act-3\r\n");
				wr.write("\r\n");
				wr.flush();

//				int ch;
//				String strline = null;
//				BufferedReader buf = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//                while((strline = buf.readLine()) != null)
//                {
//                    System.out.println(strline);
//                	System.out.println(new String(strline.getBytes("gbk"),"utf8"));
//                	System.out.println(new String(strline.getBytes("utf8"),"gbk"));
//                    System.out.println(new String(strline.getBytes("gb2312"),"utf8"));
//                }
				socket.close();

			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
