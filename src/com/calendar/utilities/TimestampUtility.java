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
	public static boolean compareYearMonthDay(Timestamp timestamp, Date date)
	{
		/*System.out.println(timestamp.getYear() + "/" + timestamp.getMonth() + "/" + timestamp.getDate());
		System.out.println(date.getYear() + "/" + date.getMonth() + "/" + date.getDate());*/
		return timestamp.getYear() == date.getYear() && timestamp.getMonth() == date.getMonth() && timestamp.getDate() == date.getDate();
	}
}
