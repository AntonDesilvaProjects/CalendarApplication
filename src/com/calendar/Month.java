package com.calendar;

import java.time.YearMonth;
import java.util.Calendar;

public class Month {
	
	private int month;
	private int year;
	private Day[][] days;
	private YearMonth yearMonth;
	
	private Month(int month, int year)
	{
		this.month = month;
		this.year = year;
		yearMonth = YearMonth.of(year, month);
		days = generateMonth(yearMonth);
	}
	//Create a new month object
	public static Month createMonth(int month, int year)
	{
		return new Month(month, year);
	}
	//File the 3D structure of the month with actual dates
	private Day[][] generateMonth(YearMonth ym)
	{
		Day[][] monthDays = new Day[6][8];
		int firstDay = ym.atDay(1).getDayOfWeek().getValue();
		int lastDate = ym.atEndOfMonth().getDayOfMonth();
		int counter = 0;
		boolean startCounter = false;
		for(int i = 0; i < 6; i++)
			for(int j = 1; j <= 7; j++)
			{
				if( j == firstDay )
				{
					startCounter = true;
				}
				if(counter == lastDate)
				{
					startCounter = false;
				}
				if(startCounter)
				{
					monthDays[i][j] = Day.createDay(++counter);
				}
			}
		return monthDays;
	}
	public void printMonth()
	{
		System.out.println("\t\t\t" + getMonthName(this.month) + "," + this.year );
		System.out.println("Mon\tTue\tWed\tThur\tFri\tSat\tSun");
		for(int i = 0; i < 6; i++)
		{
			for(int j = 1; j <= 7; j++)
			{
				if( days[i][j] != null)
					System.out.print( days[i][j].getDate() + "\t");
				else
					System.out.print( "\t");
			}
			System.out.println();
		}
			
	}
	public String generateHTMLView()
	{
		return new String();
	}
	public String getMonthName(int i)
	{
		if( i == 1)
			return "January";
		else if( i == 2)
			return "February";
		else if( i == 3)
			return "March";
		else if( i == 4)
			return "April";
		else if( i == 5)
			return "May";
		else if( i == 6)
			return "June";
		else if( i == 7)
			return "July";
		else if( i == 8)
			return "August";
		else if( i == 9)
			return "September";
		else if( i == 10)
			return "October";
		else if( i == 11)
			return "November";
		else if( i == 12)
			return "December";
		else
			return null;
	}
}
