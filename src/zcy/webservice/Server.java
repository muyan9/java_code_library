package zcy.webservice;

import java.util.HashMap;

import javax.xml.ws.Endpoint;

public class Server implements iWebService {
	HashMap<String, String> DataPool = new HashMap<String, String>();

	public void putCommand(String terminalCode, String cmd) {
		DataPool.put(terminalCode, cmd);
	}

	public String getCommand(String terminalCode) {
		// return null;
		return DataPool.get(terminalCode);
	}

	public static void main(String[] args) {
		// 发布一个WebService
		Endpoint.publish("http://127.0.0.1:8080/t/Java6WebService",
				new Server());

	}
}