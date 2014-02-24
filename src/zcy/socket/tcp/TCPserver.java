package zcy.socket.tcp;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPserver {
	
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) {
				
		try
		{
			int portnumber = 80;
			
			ServerSocket serv = new ServerSocket(portnumber);
			
			for(;;)
			{
				Socket server = serv.accept();
				InputStream instream = server.getInputStream();
				PrintWriter outstream = new PrintWriter(server.getOutputStream()); 
				
				BufferedReader re = new BufferedReader(new InputStreamReader(instream));
				
				while(true){
					String str=re.readLine();
					System.out.println(str);
					outstream.println("has receive....");
					outstream.flush();
					if(str.equals("exit"))
						break;
				}
					
				server.close();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();	
		}
	}

}
