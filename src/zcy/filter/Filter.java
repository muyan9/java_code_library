package zcy.filter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

import zcy.db.DBConn;

public class Filter {

	File fileSniffedFile;
	
	public Filter(){}
	
	public Filter(File file){this.fileSniffedFile = file;}
	
	public void Split()
	{
		
		
	}
	
	private void LoadFile()
	{
		FileInputStream infile = null; 

//		 生成对象infile 准备读取文件 
		try {
			infile = new FileInputStream(fileSniffedFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		
		String sLine1,sLine2,sLine3,sLine4;
		BufferedReader in = new BufferedReader(new InputStreamReader(infile));
		DBConn db = new DBConn();
		boolean bFlag = true;
		while (bFlag) 
		{
			
			try {
				sLine1 = in.readLine();
				sLine2 = in.readLine();
				sLine3 = in.readLine();
				sLine4 = in.readLine();
				if(sLine4==null){}
				if(sLine1 == null)
				{
					bFlag = false;
					break;
				}
				if(sLine1.equals(""))
					continue;
				
				SniffedInfo si = new SniffedInfo();
				//protocol
				//^TCP|UDP\\s
				String sTemp = sLine1.substring(0,3);
				if(sTemp.equals("TCP"))
					si.setProtocol("TCP");
				else
					si.setProtocol("UDP");
				//time
				//\\[\\d{2}/\\d{2}/\\d{2} \\d{2}:\\d{2}:\\d{2}\\]$
				//[06/29/07 12:02:08]
				sTemp = sLine1.substring(5,6);
				if(sTemp.equals("["))
				{
					sTemp = sLine1.substring(6).replace(']',' ').trim();
					si.setTime(sTemp);
				}
				
				//IP,Port
				//(\\d{1,3}\\.){3}\\d{1,3}->(\\d{1,3}\\.){3}\\d{1,3}
				//192.168.0.13->212.27.60.27
				//\\d{1,5}->\\d{1,5}$
				//Port: 2287->21
				if(sLine2.indexOf(" Port: ") > 0)
				{
					String[] ss = sLine2.split(" Port: ");
					String[] IP = ss[0].split("->");
					String[] Port = ss[1].split("->");
					si.setSourceIP(IP[0]);
					si.setTargetIP(IP[1]);
					si.setSourcePort(Port[0]);
					si.setTargetPort(Port[1]);
				}
				//user,pass,host
				//USER .[^ ]+
				//PASS .[^ ]+
				if(sLine3.substring(0,5).equals("HOST:"))
				{
					String s = sLine3.substring(5,sLine3.indexOf(' ',6)).trim();
					si.setHost(s);
				}
				if(sLine3.indexOf("USER")>=0)
				{
					sLine3 = sLine3 + " ";
					int index1 = sLine3.indexOf("USER") + 4;
					int index2 = sLine3.indexOf(' ',index1 + 2);
					String s = sLine3.substring(index1,sLine3.indexOf(' ',index2));
					s = s.replace(',',' ').replace(':',' ').trim();
					si.setUsername(s);
				}
				if(sLine3.indexOf("PASS")>=0)
				{
					sLine3 = sLine3 + " ";
					int index1 = sLine3.indexOf("PASS") + 4;
					int index2 = sLine3.indexOf(' ',index1 + 2);
					String s = sLine3.substring(index1,sLine3.indexOf(' ',index2));
					s = s.replace(',',' ').replace(':',' ').trim();
					si.setPassword(s);
				}
				//SELECT keyid, protocol, snifferTime, sourceIP, targetIP, sourcePort, targetPort, host, username, password FROM sniffed
				String sql = "insert into temp(protocol, snifferTime, sourceIP, targetIP,"
							+ " sourcePort, targetPort, host, username, password) values("
							+ "'" + si.getProtocol() + "',"
							+ "#" + si.getTime() + "#,"
							+ "'" + si.getSourceIP() + "',"
							+ "'" + si.getTargetIP() + "',"
							+ "'" + si.getSourcePort() + "',"
							+ "'" + si.getTargetPort() + "',"
							+ "'" + si.getHost() + "',"
							+ "'" + (si.getUsername()==null?"":si.getUsername()).replaceAll("'","''") + "',"
							+ "'" + (si.getPassword()==null?"":si.getPassword()).replaceAll("'","''") + "')";
				db.ExecuteSQL(sql);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				if(e.getErrorCode()!=-1605)
				e.printStackTrace();
			}
		}
		db.closeDBConn();
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String path = "f:\\a.log";
		load(path);
		
		File tmp = new File(path);
		tmp.delete();
	}
	
	private static void load(String path)
	{
		File file = new File(path);
		Filter f = new Filter(file);
		f.LoadFile();
		file = null;
		System.gc();
	}


	public final File getSniffedFile() {
		return fileSniffedFile;
	}


	public final void setSniffedFile(File fileSniffedFile) {
		this.fileSniffedFile = fileSniffedFile;
	}

	public void echo(Object o)
	{
		System.out.println(o);
	}
}
