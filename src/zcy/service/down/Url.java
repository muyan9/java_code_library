package zcy.service.down;
import java.util.regex.*;

public class Url {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//email
		//http://111.33bbb.com/index.htm?i=2721.htm&ii=Down
		
		String s = "http://111.33bbb.com/index.htm?i=2721.htm&ii=Down";//args[0];
		System.out.println(getHost(s));
		System.out.println(getPath(s));
		
	}
	
	public static String getHost(String url)
	{
		String patternStr = "[a-zA-z]+://[^\\s]*?/";
		Pattern pattern = Pattern.compile(patternStr);
		
		Matcher matcher = pattern.matcher(url);
		if (matcher.find()) {
			return matcher.group().replace("http:", "").replace("/", "");
		}
		return null;
	}
	
	public static String getPath(String url)
	{
		String patternStr = "[a-zA-z]+://[^\\s]*/";
		Pattern pattern = Pattern.compile(patternStr);
		
		Matcher matcher = pattern.matcher(url);
		if (matcher.find()) {
			return "/" + url.replace(matcher.group(), "");
		}
		return null;
	}
}
