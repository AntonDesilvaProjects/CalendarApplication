package com.calendar;

import java.time.YearMonth;

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
	
	public static Month createMonth(int month, int year)
	{
		return new Month(month, year);
	}
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
		for(int i = 0; i < 6; i++)
		{
			for(int j = 1; j <= 7; j++)
			{
				if( days[i][j] != null)
					System.out.print( days[i][j].getDate() + " | ");
				else
					System.out.print( " | ");
			}
			System.out.println();
		}
			
	}
}