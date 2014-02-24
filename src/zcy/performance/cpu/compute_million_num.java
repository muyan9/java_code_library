package zcy.performance.cpu;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Date;
import java.math.BigInteger;

public class compute_million_num {
	public static void main(String[] args) throws Exception {
		Date d1 = new Date();
		String localeString = d1.toLocaleString();
		System.out.println(localeString);
//		compute_million_file();
		compute_million_number();
//		java.lang.Thread.sleep(5);
		Date d2 = new Date();
		
		System.out.println(d2.toLocaleString());
		System.out.println((d2.getTime()-d1.getTime())/1000);
	}

	public static void compute_million_number()
	{
		BigInteger i = new BigInteger("0");
		BigInteger a = new BigInteger("1");
		while(i.intValue()<100000000)
		{
			i = i.add(a);
		}
		System.out.println(i);
	}
	
	
	public static void compute_million_file() throws Exception
	{
		ArrayList<String> list = new ArrayList<String>();
		String path_root = "D:/work/compare/adfs.txt";
		File file_r = new File(path_root);		
		
		FileReader fr = new FileReader(file_r); 
		BufferedReader br = new BufferedReader(fr); 
		String str = br.readLine();
		int i = 0;
		while (str != null)
		{
			i++;
			if(i%1000==0)
				System.out.println(i);
			list.add(str);
			str = br.readLine(); 
		} 
		br.close(); 
		fr.close();   
	}
}
