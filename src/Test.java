import java.sql.DriverManager;
import java.util.HashMap;

import zcy.office.Excel;


/**
 * @author zcy
 *
 */
/**
 * @author zcy
 *
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//getPathClass();
		
		//cHashMap();
		//System.out.println(Test.class.getResource("http://mail.163.com"));
		try
		{
			throw new Exception("dd");
		}
		catch(Exception e)
		{
			//e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	/**
	 * 
	 */
	public static void getPathClass()
	{
		System.out.println("\n\nStart Call PathClass!*****************************************");
		try
		{
			System.out.print("\n(Test.class)\t");
			System.out.println(zcy.path.GetClassPath.getPathFromClass(Test.class));
			System.out.print("../../..)\t");
			System.out.println(zcy.path.GetClassPath.getFullPathRelateClass("../../..",Test.class));
		}
		catch(Exception e)
		{
			System.out.println("getPathClass Error:	" + e.getMessage());
		}
		
		System.out.println("\nCall PathClass Success!***************************************\n");
	}
	
	/**HashMap
	 * 
	 */
	public static void cHashMap()
	{
		HashMap hm = new HashMap();
//		int i = hm.hashCode();
//		System.out.println("hm.hashCode = \t" + i);
//		
//		hm.put("a","aa");
//		int j = hm.hashCode();
//		System.out.println("hm.hashCode = \t" + j);
//		
//		System.out.println("hm.get(\"a\") = \t" + hm.get("a").toString());
//		
//		System.out.println(hm.size());
//		
//		System.out.println("------------------------------");
//		System.out.println(hm.hashCode());
//		System.out.println(hm.put("b","bb"));
//		System.out.println(hm.hashCode());
//		System.out.println(hm.get("b"));
		
		String driver = "net.sourceforge.jtds.jdbc.Driver";
		String username = "sa";
		String password = "1234";
		String url = "jdbc:jtds:sqlserver://127.0.0.1:1433;DatabaseName=hdby";
		
		
		
		try
		{
			java.sql.Connection conn = null;
			Class.forName(driver);
			conn = DriverManager.getConnection(url,username,password);
			java.sql.Statement st = null;
			st = conn.createStatement();
			java.sql.ResultSet rs = null;
			rs = st.executeQuery("select * from t_gongneng");
			
			//rs.first();
			System.out.println(conn);
			System.out.println("1");
			hm = (HashMap)rs;
		}
		catch(Exception e)
		{
			//System.out.println(e.toString() + e.getMessage());
		}
		System.out.println(hm.size());

	}
	
	
	/**
	 * 
	 */
	public void getExcelCells()
	{
		String[][] aa = Excel.readExcel("F:\\Documents\\book1.xls");
		for(int i = 0 ; i < aa.length ; i++)
		{
			for(int j = 0 ; j < aa[i].length ; j++)
			System.out.println(aa[i][j]);
		}

	}
}