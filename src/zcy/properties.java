package zcy;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

public class properties {
	private Logger logger = Logger.getLogger(properties.class);
	private Properties properties;
	public properties()
	{
		try {
			properties = new Properties();
			InputStream inputStream=getClass().getResourceAsStream("/config.properties");
			properties.load(inputStream);
		} catch (IOException e) {
			logger.debug(e.getMessage());
		}
	}
	public properties(String pathConfig)
	{
		try {
			properties = new Properties();
			InputStream inputStream=getClass().getResourceAsStream(pathConfig);
			properties.load(inputStream);
		} catch (IOException e) {
			logger.debug(e.getMessage());
		}
	}
	
	public String getProperty(String key)
	{
		if(properties==null)
		{
			try {
				properties.load(getClass().getResourceAsStream("/config.properties"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return (String) properties.get(key.trim());
	}
	public String getProperty(String pathConfig, String key)
	{
		Properties p = new Properties();
		try {
			InputStream inputStream = getClass().getResourceAsStream(pathConfig);
			p.load(inputStream);
			p.load(getClass().getResourceAsStream(pathConfig));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return (String) p.get(key.trim());
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		properties p = new properties("/config.properties");
		System.out.println(p.getProperty("/config.properties","datasource.username"));
	}

}
