package com.calendar;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.GregorianCalendar;

import com.calendar.utilities.AppointmentUtility;
import com.calendar.utilities.TimestampUtility;

public class Runner {
	public static void main(String[] args) {
		
		/*java.util.Date newDate =  new GregorianCalendar(2016, Calendar.FEBRUARY, 13, 5,30, 0).getTime();
		System.out.println(newDate);
		
		java.sql.Date date = new Date( newDate.getTime());
		System.out.println(date);
		
		java.sql.Timestamp timestamp = new java.sql.Timestamp(newDate.getTime());
		System.out.println( timestamp.getHours());*/
		
		Timestamp start = TimestampUtility.generateTimestamp(Calendar.FEBRUARY, 17, 2004, 10, 30);
		Timestamp end = TimestampUtility.generateTimestamp(Calendar.FEBRUARY, 18, 2005, 11, 00);
		
		//Month.createMonth(3, 2018).printMonth();
		AppointmentUtility.createAppointment(start, end, "10 years", "Happy Birthday for 10 years", "NY,USA", false);
		
		
	}
}
