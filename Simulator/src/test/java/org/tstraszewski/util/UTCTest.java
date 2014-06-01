package org.tstraszewski.util;

import java.util.Calendar;
import java.util.TimeZone;

import org.junit.Test;

public class UTCTest {

	@Test
	public void dateforTimeZone(){
		
		System.out.println(System.currentTimeMillis());
//		System.out.println(TimeZone.getTimeZone("Gambia"));
		System.out.println(Calendar.getInstance(TimeZone.getTimeZone("Gambia")).getTimeInMillis());
	}
}
