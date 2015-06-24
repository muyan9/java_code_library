package zcy.webservice;

import javax.jws.WebService;

@WebService 
public interface iWebService { 
	public void putCommand(String terminalCode, String cmd);
	public String getCommand(String terminalCode);
}