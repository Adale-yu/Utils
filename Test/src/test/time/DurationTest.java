package test.time;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;

public class DurationTest {

	public static void main(String[] args) {
		
		/*Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		cal2.add(Calendar.DAY_OF_YEAR, -1);
		cal2.add(Calendar.HOUR, -1);
		Duration duration = Duration.between(cal2.toInstant(), cal1.toInstant());
		
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		
		Date date = cal1.getTime();
		System.out.println(format.format(date));
		
		date = cal2.getTime();
		System.out.println(format.format(date));
		
		System.out.println(duration.toDays());*/
		
		testDuration();
	}
	
	public static void testDuration() {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		try {
			Date date = format.parse("2019-03-06 00:01:01");
			Calendar startCal = Calendar.getInstance();
			startCal.setTime(date);
			date = format.parse("2019-03-13 00:00:01");
			Calendar nowCal = Calendar.getInstance();
			nowCal.setTime(date);
			Duration duration = Duration.between(startCal.toInstant(), nowCal.toInstant());
			int days = (int) duration.toDays();
			
			System.out.println(days);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
	}
}
