import java.net.*;
import java.io.*;

public class dumper
{
	public static void main(String[] args)
	{
		try
		{
			int portnumber = 90;
			try
			{
				portnumber = Integer.parseInt(System.getProperty("port"));	
			}	
			catch(Exception e)
			{}
			ServerSocket serv = new ServerSocket(portnumber);
			
			for(;;)
			{
				Socket sock = serv.accept();
				InputStream instream = sock.getInputStream();
				int ch;
				while((ch=instream.read())>=0)
					System.out.print((char)ch);
					
				sock.close();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();	
		}
	}	
}