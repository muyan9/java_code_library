package zcy.date;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class DateAdd {

	public static void main(String[] args) {
		Date date = new Date(System.currentTimeMillis());
		DateFormat df = DateFormat.getDateTimeInstance(DateFormat.MEDIUM,
				DateFormat.MEDIUM, Locale.CHINA);
		String dt = df.format(date);
		System.out.println(dt);
		
		date = new Date(System.currentTimeMillis() + 30 * 60 * 1000); // ��Сʱ�Ժ��ʱ��
		dt = df.format(date);
		System.out.println(dt);
		
		
		date = new Date(109, 10, 11);
		dt = df.format(date);
		System.out.println(dt);
		System.out.println(date.getTime());
		}
}