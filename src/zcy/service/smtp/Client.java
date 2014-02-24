package zcy.service.smtp;
import java.io.*;
import java.net.*;
//import java.io.InputStream;
//import java.net.ServerSocket;
//import java.net.Socket;

public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		/*
		 * try { System.out.println("Port 25 listening !"); String sHost =
		 * "192.168.0.13"; int portnumber = 25; Socket sock = new
		 * Socket(sHost,portnumber); sock sock.close(); } catch(Exception e) {
		 * e.printStackTrace(); }
		 */

		//Socket server = new Socket(InetAddress.getLocalHost(), 25);
		Socket server = new Socket("smtp.163.com",25);
		BufferedReader in = new BufferedReader(new InputStreamReader(server
				.getInputStream()));
		PrintWriter out = new PrintWriter(server.getOutputStream());
		BufferedReader wt = new BufferedReader(new InputStreamReader(System.in));

		while (true)
		{
			String str = wt.readLine();
			out.println(str);
			out.flush();
			if (str.substring(0,3).equals("221")) 
			{
				System.out.println(str);
				break;
			}
			System.out.println(in.readLine());
		}
		server.close();
		System.out.println("�Ự����");
	}
}



/*
		private void WriteStream(string strCmd)
		{
			strCmd+=CRLF;
			byte[] bw=System.Text.Encoding.Default.GetBytes(strCmd);
			netStrm.Write(bw,0,bw.Length);
		}

		private string AuthStream(string strCmd)
		{
			try
			{
				byte[] by=System.Text.Encoding.Default.GetBytes(strCmd);
				strCmd=Convert.ToBase64String(by);
			}
			catch(Exception err)
			{
				return err.ToString();
			}
			return strCmd;
		}

		string data;
		string SmtpServer=textBoxSrv.Text.Trim();
		smtpSrv=new TcpClient(SmtpServer,25);
		netStrm=smtpSrv.GetStream();
		StreamReader rdStrm=new StreamReader(smtpSrv.GetStream());
		WriteStream("EHLO Local");
		listBoxMsg.Items.Add(rdStrm.ReadLine());
		WriteStream("AUTH LOGIN");
		listBoxMsg.Items.Add(rdStrm.ReadLine());
		data=textBoxUser.Text.Trim();
		data=AuthStream(data);
		WriteStream(data);
		listBoxMsg.Items.Add(rdStrm.ReadLine());
		data=textBoxPwd.Text.Trim();
		data=AuthStream(data);
		WriteStream(data);
		listBoxMsg.Items.Add(rdStrm.ReadLine());
		data="MAIL FROM:<" + textBoxSend.Text.Trim() + ">";
		WriteStream(data);
		listBoxMsg.Items.Add(rdStrm.ReadLine());
		data="RCPT TO:<" + textBoxRev.Text.Trim() + ">";
		WriteStream(data);
		listBoxMsg.Items.Add(rdStrm.ReadLine());
		WriteStream("DATA");
		listBoxMsg.Items.Add(rdStrm.ReadLine());
		data="Date:" + DateTime.Now;
		WriteStream(data);
		data="From:" + textBoxSend.Text.Trim();
		WriteStream(data);
		data="TO:" + textBoxRev.Text.Trim();
		WriteStream(data);
		data="SUBJECT" + textBoxSubject.Text.Trim();
		WriteStream(data);
		data="Repl-TO:" + textBoxSend.Text.Trim();
		WriteStream(data);
		WriteStream("");
		WriteStream(textBoxMailText.Text.Trim());
		WriteStream(".");
		listBoxMsg.Items.Add(rdStrm.ReadLine());
		WriteStream("QUIT");
		listBoxMsg.Items.Add(rdStrm.ReadLine());
		netStrm.Close();
		rdStrm.Close();
		
*/