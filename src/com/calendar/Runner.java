package com.calendar;

import java.sql.Date;

public class Runner {
	public static void main(String[] args) {

		//Month.createMonth(3, 2018).printMonth();
		AppointmentUtility.createAppointment(new Date(1994-1900,6,9), new Date(2004-1900, 6,9), "10 years", "Happy Birthday for 10 years", "NY,USA", false);
	}
}
