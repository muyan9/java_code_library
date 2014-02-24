/** 
 * 类    名：DBConn
 * 功能描述：数据库联接及数据操作
 * 创建时间: 2-1-2007
 * 作    者：赵长宇
 * 完成时间：2-1-2007
 */
package zcy.db;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBConn {
	private Connection conn;
	
	/**
	 * 构造函数
	 */
	public DBConn() {
		try {
			Properties properties = new Properties();
			//载入配置文件
			properties.load(new FileInputStream(System.getProperty("user.dir")
					+ "\\data\\sniffer.properties"));
			//取得数据库类型信息
			String dbSort = properties.getProperty("db.DBSort");
			// 若数据库标识为'sql server'，则用sql server连接，否则Access连接
			if (dbSort.equals("Access")) {
				initAccessConn();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//初始化与Access数据库的连接
	private void initAccessConn()
	{
		String strDriver = null;
		String strURL = null;
		String strUserName = null;
		String strPassword = null;

		try {
			//创建配置文件对象，用于加载数据库配置信息
			Properties properties = new Properties();
			//载入配置文件
			properties.load(new FileInputStream(System.getProperty("user.dir")
					+ "\\data\\sniffer.properties"));
			
			strDriver 	= properties.getProperty("Access.Driver");
			strURL 		= properties.getProperty("Access.URL");// + ";pwd=hdbyhdby";
			strUserName = "";
			strPassword = "";
			
			// 载入数据库驱动
			Class.forName(strDriver);

			conn = DriverManager.getConnection(strURL, strUserName, strPassword);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void setConn(Connection conn) {
		this.conn = conn;
	}

	/**
	 * 取得数据库联接对象
	 * @return Connection	数据库联接
	 */
	public Connection getConn() throws Exception {
		return conn;
	}

	/**
	 * 取得符合SQL语句的数据集
	 * @param String		SQL语句
	 * @return ResultSet	取得数据的记录集
	 */
	public ResultSet getResultSet(String strSQL) {
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			//ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE
			rs = stmt.executeQuery(strSQL);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return rs;
	}

	/**
	 * 运行SQL语句
	 * @param String	SQL语句
	 * @throws SQLException 
	 * @throws SQLException 
	 */
	public void ExecuteSQL(String strSQL) throws SQLException {
		Statement stmt = null;
		stmt = conn.createStatement();
		stmt.executeUpdate(strSQL);
	}

	/**
	 * 关闭与数据库的联接
	 */
	public void closeDBConn() {
		try {
			if (conn != null)
				conn.close();
			conn = null;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}