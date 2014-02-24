package zcy.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ReadWriteFile {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		write();
	}
	
	
	public static void read() {
		FileInputStream infile = null;
		String path = "F:\\program\\VB\\oa_server\\Empty\\teshufuhao.txt";
		
		File fileSniffedFile = new File(path);
		try {
			infile = new FileInputStream(fileSniffedFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		
		String sLine1;
		String str = "";
		BufferedReader in = new BufferedReader(new InputStreamReader(infile));
		boolean bFlag = true;
		while (bFlag) 
		{
			
			try {
				sLine1 = in.readLine();
				if(sLine1==null)
					break;
				if(sLine1.equals(""))
					continue;
				byte[] b = str.getBytes();
				String ss = "";
				for(int i=0; i<b.length;i++)
				{
					ss+=b[i];
				}
				str = sLine1 + " : " + ss;
				ss = "";
				System.out.println(str);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public static void write() {
		FileOutputStream infile = null;
		String path = "d:\\1.txt";
		
		File fileSniffedFile = new File(path);
		try {
			infile = new FileOutputStream(fileSniffedFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(infile));
		try {
			out.write("ddd");
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
