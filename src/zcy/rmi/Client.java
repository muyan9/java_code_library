package zcy.rmi;

import javax.naming.Context;
import javax.naming.InitialContext;

public class Client {

    public static void main(String[] args) throws Exception {
	Context ctx = new InitialContext();
	RemoteDate startTime = (RemoteDate) ctx
		.lookup("rmi://localhost:2099/systemStartTime");
	while(true)
	System.out.println(startTime.test());

    }

}