package zcy.webservice;

import java.util.HashMap;

public class Pojo { 
	HashMap<String, String> hm = new HashMap<String, String>();
	public HashMap<String, String> getMap()
	{
		return hm;
	}
	public void setMap(HashMap<String, String> hm)
	{
		this.hm = hm;
	}
}