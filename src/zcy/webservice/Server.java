package zcy.webservice;

import javax.xml.ws.Endpoint; 

//import com.xh.datapool.DataPool;

public class Server implements iWebService { 
	public void putCommand(String terminalCode, String cmd)
	{
//		DataPool.putCmd(terminalCode, cmd);
	}
	
	public String getCommand(String terminalCode)
	{
		return null;
//		return DataPool.getCmd(terminalCode);
	}

    public static void main(String[] args) { 
            //发布一个WebService 
        Endpoint.publish("http://192.168.0.102:8080/t/Java6WebService", new Server());
                
    }

	@Override
	public String getCommand() {
		// TODO Auto-generated method stub
		return null;
	}

		
}