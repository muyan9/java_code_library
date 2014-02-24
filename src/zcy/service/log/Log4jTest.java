package zcy.service.log;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log4jTest 
{
	static Logger logger = Logger.getLogger(Log4jTest.class);
	public static void main(String[] args)
	{
		//BasicConfigurator.configure();
		PropertyConfigurator.configure(System.getProperty("user.dir") + "\\log4j.inf");
		//OFF,FATAL,ERROR,WARN,INFO,DEBUG,ALL
		logger.fatal("fatal");
		logger.error("error");
		logger.warn("warn");
		logger.info("info");
		logger.debug("debug");
	}
}
