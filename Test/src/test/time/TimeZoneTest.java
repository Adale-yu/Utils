package test.time;

import java.util.TimeZone;

public class TimeZoneTest {

	public static void main(String[] args) {
		TimeZone timeZone = TimeZone.getDefault();
		System.out.println(timeZone.getID());
		System.out.println(timeZone.getDisplayName());
		System.out.println(timeZone.getOffset(System.currentTimeMillis()));
		
		String[] timeZoneIds = TimeZone.getAvailableIDs();
		for(int i = 0; i< timeZoneIds.length; i++) {
			System.out.println(timeZoneIds[i]);
		}
	}
}
