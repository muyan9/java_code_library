package zcy.socket.tcp;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.io.*;

public class TCPclient {
	
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		TCPclient tcpclient = new TCPclient();
		
		Socket client = new Socket("127.0.0.1",80);
//		Socket client = new Socket("127.0.0.1",90);
		
		
		InputStream instream = client.getInputStream();
		BufferedReader re = new BufferedReader(new InputStreamReader(instream));
		PrintWriter outstream=new PrintWriter(client.getOutputStream());
		
		while(true)
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String str = br.readLine();
			
			if(str.equals("exit"))
			{
				client.close();
				break;
			}
			byte[] login = null;
			if(str.equals("login"))
			{
				login = tcpclient.loginByteArray();
//				client.close();
//				break;
			}
			
			
			outstream.println(str);
			outstream.flush();
			
			String sReturn = String.valueOf(re.readLine());
			System.out.println(sReturn);
		}
	}
	
	public byte[] loginByteArray()
	{
		String str = "";
		
		byte[] byte_array_login = new byte[7];
		byte_array_login[0] = 0x02;
		byte_array_login[1] = 0x0A;
		byte_array_login[2] = 0x1D;
		byte_array_login[3] = 0x00;
		byte_array_login[4] = 0x22;
		byte_array_login[5] = 0x00;
		byte_array_login[6] = 0x01;
		
		
		
//		ByteArrayInputStream aa = new ByteArrayInputStream(byte_array_login);
//		ByteArrayOutputStream bb = new ByteArrayOutputStream();
//		bb.write(byte_array_login);
//		OutputStream output = new OutputStreamWriter();
//		DataOutputStream bb = new DataOutputStream()
		
//		0x81+0x0A+0x01
		
		return byte_array_login;
	}
}
