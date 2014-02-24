/** 
 * 类    名：RSUtil
 * 功能描述：记录集数据操作
 * 创建时间: 2-1-2007
 * 作    者：赵长宇
 * 完成时间：2-1-2007
 */
package zcy.db;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

public class RSUtil {

	//记录集实例
	private ResultSet rs;
	//记录集描述信息
	private ResultSetMetaData rsmd;
	//记录集列数
	private int colCount;

	/**
	 * 构造函数
	 * @param ResultSet	记录集
	 */
	public RSUtil(ResultSet rs) throws Exception {
		this.rs 		= rs;
		this.rsmd 		= rs.getMetaData();
		this.colCount 	= rsmd.getColumnCount();
	}

	/**
	 * 取得记录集列名信息
	 * @return List	记录集列名集合
	 */
	public List<String> getRsColumnNames() throws Exception {
		List<String> alTemp = new ArrayList<String>();
		for (int i = 1; i <= colCount; i++) {
			alTemp.add(rsmd.getColumnName(i));
		}
		return alTemp;
	}

	/**
	 * 取得记录集列数
	 * @return int 记录集列数
	 */
	public int getColCount() {
		return colCount;
	}

	/**
	 * 取得记录集行数
	 * @return int 记录集行数
	 */
	public int getRowCount() {
		int count = 0;
		try {
			while (rs.next()) {
				count++;
			}
			rs.beforeFirst();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return count;
	}
	
    /**
	 * 关闭数据集
	 */
	public void closeRS() throws Exception {
		try {
			rs.close();
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}
}