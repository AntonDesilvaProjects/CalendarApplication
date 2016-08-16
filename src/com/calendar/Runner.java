package com.calendar;

import java.util.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.List;

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
		
		Timestamp start = TimestampUtility.generateTimestamp(Calendar.JANUARY, 17, 2008, 10, 30);
		Timestamp end = TimestampUtility.generateTimestamp(Calendar.MARCH, 7, 2014, 10, 30);
		Timestamp mid = TimestampUtility.generateTimestamp(Calendar.MARCH , 27, 2014, 10, 30);
		//Month.createMonth(3, 2018).printMonth();
		//AppointmentUtility.createAppointment(start, end, "10 years", "Happy Birthday for 10 years", "NY,USA", false);
		
		Date date = new GregorianCalendar(2014, Calendar.FEBRUARY, 27).getTime();
		Date date2 = new Date(2008, Calendar.FEBRUARY, 17);
		//System.out.println( start.getYear() == date.getYear() && start.getMonth() == date.getMonth() && start.getDate() == date.getDate());
		
		/*List<Appointment> list = AppointmentUtility.getAppointments(2, 2004);
		for(Appointment a : list )
			System.out.println( a.getTitle());*/
		//System.out.println(TimestampUtility.compareYearMonthDay(end, date2));
		
		Appointment a1 = new Appointment(start, null, "2008" , null, null, false);
		Appointment a2 = new Appointment(end, null, "2014" , null, null, false);
		Appointment a3 = new Appointment(mid, null, "2007" , null, null, false);
		
		ArrayList<Appointment> list = new ArrayList<Appointment>();
		//list.add(a1);
		list.add(a2);
		list.add(a3);
		
		/*Collections.sort(list);
		
		for(Appointment a: list )
			System.out.println( a.getTitle());*/
		
		
		Month m = Month.createMonth(Calendar.AUGUST, 2016);
		m.allocateAppointments(list);
		m.printMonth();
		String html = m.generateHTMLView();
	}
}
