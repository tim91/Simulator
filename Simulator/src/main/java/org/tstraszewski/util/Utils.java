package org.tstraszewski.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class Utils {

	
	public static String getDate(long time,int timeZoneOffset){
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		String id = TimeZone.getAvailableIDs(timeZoneOffset)[0];
		if(id == null){
			return null;
		}
		TimeZone tz = TimeZone.getTimeZone(id);
		sdf.setTimeZone(tz);
		
		Calendar c = Calendar.getInstance(tz);
		c.setTimeInMillis(time);
		
		String res = sdf.format(c.getTime());
		return res;
	}
	
	
	public static int UTCOffset(String timeZoneId){
		
		TimeZone tz = TimeZone.getTimeZone(timeZoneId);
		return tz.getRawOffset();
	}
}
