package test.time;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarTest {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		
		System.out.println(cal.get(Calendar.AM_PM ));
		System.out.println(cal.get(Calendar.DATE));
		System.out.println(cal.get(Calendar.DAY_OF_WEEK));
		System.out.println(cal.get(Calendar.DAY_OF_MONTH));
		System.out.println(cal.get(Calendar.DAY_OF_YEAR));
		System.out.println(cal.getActualMaximum(Calendar.YEAR));
		System.out.println(cal.getFirstDayOfWeek());
		System.out.println(cal.getMinimalDaysInFirstWeek());
		
		
		cal.set(Calendar.YEAR, cal.get(Calendar.YEAR)-1);
		
		Date date = cal.getTime();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		System.out.println(format.format(date));
		
		cal.add(Calendar.YEAR, 1);
		
		date = cal.getTime();
		System.out.println(format.format(date));
	}
}
