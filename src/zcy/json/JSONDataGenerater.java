package zcy.json;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author zcy
 * 生成json数据
 */
public class JSONDataGenerater {
	public static void main(String[] args) {

		Terminaltype t1 = new Terminaltype();
		t1.setTertypeId(1);
		t1.setTertypename("t1");
//		t1.setDescription("t1d");
		Terminaltype t2 = new Terminaltype();
		t2.setTertypeId(2);
		t2.setTertypename("t2");
//		t2.setDescription("t2d");
		
		ArrayList list = new ArrayList();
		list.add(t1);
		list.add(t2);
		
		System.out.println(JSONDataGenerater.JSONListData("TertypeId,Tertypename,Description", list, Terminaltype.class));
		System.out.println(JSONDataGenerater.JSONTableData("id,名称,描述", "TertypeId,Tertypename,Description", list, Terminaltype.class));
		System.out.println(JSONDataGenerater.JSONTableData("id,描述,名称,名称,描述", "TertypeId,Description,Tertypename,Tertypename,Description", list, Terminaltype.class));
	}
	
	/**
	 * 生成table表格使用的json数据
	 * @param headNames			列头部文字
	 * @param fieldNames		数据字段名，json数据data段以此字段顺序排列
	 * @param list				数据pojo类集合
	 * @param classDefine		pojo类
	 * @return					json字符串
	 */
	public static String JSONTableData(String headNames, String fieldNames, ArrayList<POJO> list, Class classDefine)
	{
		//存储待转换为json的数据
		Map map = new HashMap();
		//存储表格数据
		ArrayList<ArrayList<String>> tableData = new ArrayList<ArrayList<String>>();
		//存储给定的字段名
		String[] saFieldName = fieldNames.toUpperCase().split(",");
		
		String sClassName = classDefine.getName();
		//获取classDefine类中的所有成员方法
		Method[] aMethod = classDefine.getMethods();
		ArrayList<Method> alMethod = new ArrayList<Method>();
		for(int i=0;i<saFieldName.length;i++)
		{
			for (int j = 0; j < aMethod.length; j++) {
				//若成员方法是继承自Object，方法定义中不会存在类名，略过这个方法继续循环
				if (aMethod[j].toString().indexOf(sClassName) < 0)
					continue;
				//取得方法名，并裁减为短方法名格式，便于跟给定的字段名匹配
				String sMethodName = (aMethod[j].toString().split(sClassName + "."))[1].trim();
				//跳过set方法
				if (sMethodName.indexOf("set") == 0)
					continue;
				sMethodName = sMethodName.substring(3, sMethodName.length() - 2).toUpperCase();
				//将给定字段的get方法加入列表
				
				if(sMethodName.equals(saFieldName[i].trim()))
				{
					alMethod.add(aMethod[j]);
				}
			}
		}
		//循环get方法取得数据，并按照fieldNames指定的顺序添加进ArrayList中
		for(Object o : list)
		{
			ArrayList<String> alDataperLine = new ArrayList<String>();
			
			for (int j = 0; j < alMethod.size(); j++) {
				try {
					Object oData = alMethod.get(j).invoke(o);
					if(oData == null)
						oData = "";
					alDataperLine.add( oData.toString() );
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
			tableData.add(alDataperLine);
		}
		
		map.put("head", headNames);
		map.put("data", tableData);
		
		return JSONObject.fromObject( map ).toString();
	}
	
	/**
	 * 生成下拉列表使用的json数据
	 * @param fieldNames		数据字段名，json数据data段以此字段顺序排列
	 * @param list				数据pojo类集合
	 * @param classDefine		pojo类
	 * @return					json字符串
	 */
	public static String JSONListData(String fieldNames, ArrayList<POJO> list, Class classDefine)
	{
		//存储列表数据
		ArrayList<ArrayList<String>> listData = new ArrayList<ArrayList<String>>();
		//存储给定的字段名
		String[] saFieldName = fieldNames.toUpperCase().split(",");
		
		String sClassName = classDefine.getName();
		//获取classDefine类中的所有成员方法
		Method[] aMethod = classDefine.getMethods();
		ArrayList<Method> alMethod = new ArrayList<Method>();
		for(int i=0;i<saFieldName.length;i++)
		{
			for (int j = 0; j < aMethod.length; j++) {
				//若成员方法是继承自Object，方法定义中不会存在类名，略过这个方法继续循环
				if (aMethod[j].toString().indexOf(sClassName) < 0)
					continue;
				//取得方法名，并裁减为短方法名格式，便于跟给定的字段名匹配
				String sMethodName = (aMethod[j].toString().split(sClassName + "."))[1].trim();
				//跳过set方法
				if (sMethodName.indexOf("set") == 0)
					continue;
				sMethodName = sMethodName.substring(3, sMethodName.length() - 2).toUpperCase();
				//将给定字段的get方法加入列表
				
				if(sMethodName.equals(saFieldName[i].trim()))
				{
					alMethod.add(aMethod[j]);
				}
			}
		}
		//循环get方法取得数据，并按照fieldNames指定的顺序添加进ArrayList中
		for(Object o : list)
		{
			ArrayList<String> alDataperLine = new ArrayList<String>();
			
			for (int j = 0; j < alMethod.size(); j++) {
				try {
					Object oData = alMethod.get(j).invoke(o);
					if(oData == null)
						oData = "";
					alDataperLine.add( oData.toString() );
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
			listData.add(alDataperLine);
		}
		
		
		return JSONArray.fromObject( listData ).toString();
	}
}
