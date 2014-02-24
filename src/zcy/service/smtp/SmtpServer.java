package zcy.service.smtp;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

class SmtpServer {
	public static void main(String[] args) throws Exception 
	{	 
		/*
		try
		{
			System.out.println("Port 25 listening !"); 
			int portnumber = 5678;
			ServerSocket serv = new ServerSocket(portnumber);
 
			for(;;) 
			{
				Socket sock = serv.accept(); InputStream instream = sock.getInputStream(); 
				int ch; 
				while((ch=instream.read())>=0)
				System.out.print((char)ch);
				//sock.close(); 
			} 
		} 
		catch(Exception e) 
		{ 
			e.printStackTrace(); 
		}
		*/
		///*
		ServerSocket server = new ServerSocket(25);
		Socket client = server.accept();
		BufferedReader in = new BufferedReader(new InputStreamReader(client
				.getInputStream()));
		PrintWriter out = new PrintWriter(client.getOutputStream());
		while (true) 
		{
			String str = in.readLine();
			System.out.println(str);
			out.println("has receive....");
			out.flush();
			if (str.equals("end"))
				break;
		}
		client.close();
		//*/
	}
}