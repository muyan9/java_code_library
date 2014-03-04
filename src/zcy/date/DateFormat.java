package zcy.date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormat {

	public static long dateToMillisecond(Date d){
		return d.getTime();
	}
	
	public static Date stringToDate(String dateString) throws ParseException{
		String format = "yyyy-MM-dd HH:mm:ss";
		return stringToDate(dateString, format);
	}

	public static Date stringToDate(String dateString, String dateFormat) throws ParseException{
		SimpleDateFormat df = new SimpleDateFormat(dateFormat);
		return df.parse(dateString);
	}
	
	public static String dateToString(Date d){
		String format = "yyyy-MM-dd HH:mm:ss";
		return dateToString(d, format);
	}
	
	public static String dateToString(Date d, String dateFormat){
		SimpleDateFormat df = new SimpleDateFormat(dateFormat);
		return df.format(d);
	}
	
	/**
	 * @param args
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException {
		long d = DateFormat.dateToMillisecond(DateFormat.stringToDate("1970-01-01 08:00:00", "yyyy-MM-dd HH:mm:ss"));
		System.out.println(d);
	}

}
