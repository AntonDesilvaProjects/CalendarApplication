package com.calendar;

import java.util.ArrayList;
import java.util.List;

public class Day {
	
	private int date;//Number of the day in the month
	private int dayOfWeek;//1-Monday...7-Tuesday
	private List<Appointment> appointments;
	
	private Day(int date, int dayOfWeek)
	{
		this.date = date;
		this.dayOfWeek = dayOfWeek;
		this.appointments = new ArrayList<Appointment>();
	}
	public static Day createDay(int date, int dayOfWeek)
	{
		return new Day(date, dayOfWeek);
	}
	public int getDate()
	{
		return date;
	}
}
