package test.time;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeFormatTest {

	public static void main(String[] args) {
		LocalDateTime ld = LocalDateTime.now();
		Instant instant = Instant.now();
		
		System.out.println(DateTimeFormatter.BASIC_ISO_DATE.format(ld));
		System.out.println(DateTimeFormatter.ISO_LOCAL_DATE.format(ld));
		System.out.println(DateTimeFormatter.ISO_LOCAL_TIME.format(ld));
		System.out.println(DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(ld));
//		System.out.println(DateTimeFormatter.ISO_OFFSET_DATE.format(ld));
//		System.out.println(DateTimeFormatter.ISO_OFFSET_TIME.format(ld));
//		System.out.println(DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(ld));
//		System.out.println(DateTimeFormatter.ISO_ZONED_DATE_TIME.format(ld));
		System.out.println(DateTimeFormatter.ISO_INSTANT.format(instant));
		System.out.println(DateTimeFormatter.ISO_DATE.format(ld));
		System.out.println(DateTimeFormatter.ISO_TIME.format(ld));
		System.out.println(DateTimeFormatter.ISO_DATE_TIME.format(ld));
		System.out.println(DateTimeFormatter.ISO_WEEK_DATE.format(ld));
//		System.out.println(DateTimeFormatter.RFC_1123_DATE_TIME.format(ld));
	}
}
