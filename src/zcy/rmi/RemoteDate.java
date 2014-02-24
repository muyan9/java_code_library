package zcy.rmi;

import java.io.Serializable;
import java.rmi.Remote;

class RemoteDate implements Remote, Serializable {
	/**
	 * 
	 */
//	private static final long serialVersionUID = 3446255091027253852L;
	private static final long serialVersionUID = -1681865097142272323L;

	public String test()
	{
		return "test ok";
	}
}