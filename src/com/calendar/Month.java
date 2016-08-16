package com.calendar;

import java.time.YearMonth;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

public class Month {
	
	private int month;
	private int year;
	private Day[][] days;
	private YearMonth yearMonth;
	
	private Month(int month, int year)
	{
		this.month = month;
		this.year = year;
		yearMonth = YearMonth.of(year, month + 1); //YearMonth is from 1 - 12(not 0 based)
		days = generateMonth(yearMonth);
	}
	//Create a new month object
	public static Month createMonth(int month, int year)
	{
		return new Month(month, year);
	}
	//Fill the 3D structure of the month with actual dates
	private Day[][] generateMonth(YearMonth ym)
	{
		Day[][] monthDays = new Day[6][8];
		int firstDay = ym.atDay(1).getDayOfWeek().getValue();//1-Mon...7-Sunday
		int lastDate = ym.atEndOfMonth().getDayOfMonth();//Returns 30, 31 or 29
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
					monthDays[i][j] = Day.createDay(++counter, j, month, year);
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
				{
					if( !days[i][j].getAppointments().isEmpty())
						System.out.print("*");
					System.out.print( days[i][j].getDate() + "\t");
				}
				else
					System.out.print( "\t");
			}
			System.out.println();
		}	
	}
	public String generateHTMLView()
	{
		//Generate the HTML representation of the month
		StringBuilder cal_html = new StringBuilder();
		cal_html.append("<table border='1'>");
		cal_html.append("<tr>");
		cal_html.append("<th>Sunday</th>");
		cal_html.append("<th>Monday</th>");
		cal_html.append("<th>Tuesday</th>");
		cal_html.append("<th>Wednesday</th>");
		cal_html.append("<th>Thursday</th>");
		cal_html.append("<th>Friday</th>");
		cal_html.append("<th>Saturday</th>");
		cal_html.append("</tr>");
		
		for(int i = 0; i < 6; i++)
		{
			cal_html.append("<tr>");
			for(int j = 1; j <= 7; j++)
			{
				if( days[i][j] != null)
				{
					cal_html.append(" <td data-day='" + days[i][j].getDate() + "'>" + "</td>");
				}
				else
					cal_html.append(" <td>" + "</td>");
			}
			cal_html.append("</tr>");
		}
		cal_html.append("</table>");
		
		return cal_html.toString();
	}
	public String getMonthName(int i)
	{
		if( i == 0)
			return "January";
		else if( i == 1)
			return "February";
		else if( i == 2)
			return "March";
		else if( i == 3)
			return "April";
		else if( i == 4)
			return "May";
		else if( i == 5)
			return "June";
		else if( i == 6)
			return "July";
		else if( i == 7)
			return "August";
		else if( i == 8)
			return "September";
		else if( i == 9)
			return "October";
		else if( i == 10)
			return "November";
		else if( i == 11)
			return "December";
		else
			return null;
	}
	public void allocateAppointments(List<Appointment> appointments)
	{
		//Sort the appointments
		Collections.sort(appointments);
		int firstDay = yearMonth.atDay(1).getDayOfWeek().getValue();
		//index of firstday is [0][firstDay];
		for(Appointment currentAppointment : appointments )
		{
			int dayOfAppointment = currentAppointment.getStart().getDate();
			int row = ( dayOfAppointment - 1 ) / 7;
			int column = (dayOfAppointment - 1) % 7 + firstDay;
			if( column > 7)
			{
				row += 1;
				column -= 7;
			}
			days[row][column].addAppointment(currentAppointment);
		}
	}
}
