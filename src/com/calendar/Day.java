package com.calendar;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class Day {
	
	private int date;//Number of the day in the month
	private int dayOfWeek;//1-Monday...7-Tuesday
	private int month;
	private int year;
	private Date dateObject;
	private List<Appointment> appointments;
	
	private Day(int date, int dayOfWeek, int month, int year)
	{
		this.date = date;
		this.dayOfWeek = dayOfWeek;
		this.month = month;
		this.year = year;
		dateObject = new GregorianCalendar(this.year, this.month, this.date).getTime();//new Date(this.year, this.month, this.date);
		this.appointments = new ArrayList<Appointment>();
		
	}
	public static Day createDay(int date, int dayOfWeek, int month, int year)
	{
		return new Day(date, dayOfWeek, month, year);
	}
	public int getDate()
	{
		return date;
	}
	public void addAppointment(Appointment appointment)
	{
		this.appointments.add(appointment);
	}
}
