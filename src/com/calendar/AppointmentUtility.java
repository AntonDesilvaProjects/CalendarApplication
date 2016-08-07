package com.calendar;

import java.util.Date;
import java.util.List;

public class AppointmentUtility {
	public void createAppointment(Date start, Date end, String title, String body, String location, boolean allDay)
	{
		Appointment a = new Appointment(start, end, title, body, location, allDay);
	}
	public void deleteAppointment()
	{
		
	}
	public List<Appointment> getAppointments(int month, int year)
	{
		return null;
	}
}
