package com.calendar;

import java.util.List;

public class Day {
	private int date;//
	private int day;
	private List<Appointment> appointments;
	
	private Day(int date)
	{
		this.date = date;
	}
	public static Day createDay(int date)
	{
		return new Day(date);
	}
	public int getDate()
	{
		return date;
	}
}
