package com.calendar.mappers;

import com.calendar.Appointment;

public interface AppointmentMapper {
	
	public void saveAppointment( Appointment appointment );
	public void deleteAppointment( Appointment appointment );
}
