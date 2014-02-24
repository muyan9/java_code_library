package zcy.date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateFormat {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
//		Date d = new Date("2011/12/06 02:17:25");
//		Date d = new Date(1323109045000l);
//		Calendar cal = Calendar.getInstance();
//		Date d = new Date("2012-04-01".replaceAll("-", "/"));
//		cal.set(Calendar.YEAR, d.getYear());
//		cal.set(Calendar.MONTH, d.getMonth());
//		System.out.println(cal.getActualMaximum(Calendar.DATE));
//		System.exit(0);


//		String strd = d.toLocaleString().substring(0,d.toLocaleString().indexOf(' '));
//		System.out.println(d.toString());
//		System.out.println(d.toGMTString());
//
//		Date ddd = new Date(1984,3,31);
//		System.out.println(java.text.DateFormat.getDateInstance().format(ddd));
//		System.out.println(ddd.getYear());
//		System.out.println(ddd.getMonth());
//		System.out.println(ddd.getDate());
//		Date dddd = new Date(ddd.getYear(),ddd.getMonth(),(ddd.getDate()+2));
//		System.out.println(java.text.DateFormat.getDateInstance().format(dddd));
//		
//		String dd = java.text.DateFormat.getDateInstance().format(d);
//		System.out.println(dd);
//		dd= java.text.DateFormat.getDateTimeInstance().format(d);
//		System.out.println(dd);
//		
//
//		System.out.println("-------------");
//		Date dda = new Date(System.currentTimeMillis());
//		System.out.println(dda.getYear());
//		System.out.println(dda.getMonth());
//		System.out.println(dda.toString());
		
		Date d = new Date("2011/12/06 02:17:25");
//		d.setHours(d.getHours()+8);
//		d.setTime(d.getTime()+1000*60*60*8);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(df.format(d));

		
	}

}
