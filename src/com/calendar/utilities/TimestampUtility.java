package com.calendar.utilities;

import java.sql.Timestamp;
import java.util.Date;
import java.util.GregorianCalendar;

public class TimestampUtility {
	public static Timestamp generateTimestamp(int month, int day, int year, int hour, int seconds)
	{
		Date date = new GregorianCalendar(year, month, day, hour, seconds ).getTime();
		return new Timestamp( date.getTime() );
	}
}
