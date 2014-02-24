package zcy.regex;
import java.util.regex.*;

public class regex {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//email
		String patternStr = "^\\s*\\S+@\\S\\.\\S\\s*$";
		patternStr = "^[\\w-]+(\\.[\\w-]+)*@[\\w-]+(\\.[\\w-]+)+$";
		//age
//		patternStr = "^\\s*\\d{1,2}\\s*$";
		
//		patternStr = "^TCP|UDP\\s";
		patternStr = "(\\d{1,3}\\.){3}\\d{1,3}->(\\d{1,3}\\.){3}\\d{1,3}";
//		patternStr = "\\d{1,5}->\\d{1,5}$";
//		patternStr = "USER .[^ ]+";
//		patternStr = "[^(\\[url=[^\\[\\]]*\\]test\\[/url\\])]";
		
//		*HQ,7110729537,V1,021754,V,3952.1948,N,11616.3783,E,000.00,
		patternStr = "(?<=\\*HQ,)\\d{10}(?=,.+)";
		
		Pattern pattern = Pattern.compile(patternStr);
		
		String s = " 199.117.44.232 ";
		s = "1*HQ,7110729537,V1,021754,V,3952.1948,N,11616.3783,E,000.00,";
		Matcher matcher = pattern.matcher(s);
		if (matcher.find()) {
			System.out.println(matcher.groupCount());
			System.out.println(matcher.group());
		}
		
//		pattern = Pattern.compile("(USER|USER:) .[^ ]+");
//		matcher = pattern.matcher("dsdf USER: 34df ff");
//		if (matcher.find()) {
//			String t = matcher.group();
//			System.out.println(t);
//		}
	}
}
