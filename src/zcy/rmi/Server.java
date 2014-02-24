package zcy.rmi;

import java.rmi.registry.LocateRegistry;

import javax.naming.Context;
import javax.naming.InitialContext;

public class Server {

    public static void main(String[] args) throws Exception {
	LocateRegistry.createRegistry(2099);
	System.setProperty(Context.INITIAL_CONTEXT_FACTORY,
		"com.sun.jndi.rmi.registry.RegistryContextFactory");
	System.setProperty(Context.PROVIDER_URL, "rmi://localhost:2099");
	Context ctx = new InitialContext();

	ctx.bind("systemStartTime", new RemoteDate());
	ctx.close();

	while (true)
	    Thread.sleep(1000);

    }

}


