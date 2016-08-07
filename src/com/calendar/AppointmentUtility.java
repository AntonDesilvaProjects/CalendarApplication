package com.calendar;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class AppointmentUtility {
	public static void createAppointment(Date start, Date end, String title, String body, String location, boolean allDay)
	{
		Appointment newAppointment = new Appointment(start, end, title, body, location, allDay);
		//Send appointment to the database
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cal_apps", "root", "desilva5");
			String SQL = "INSERT INTO App (id, app_start, app_end, title, body, location, allDay) VALUES (?,?,?,?,?,?,?)";
			PreparedStatement pStatement = connection.prepareStatement(SQL);
			pStatement.setString(1, newAppointment.getId());
			pStatement.setDate(2, newAppointment.getStart());
			pStatement.setDate(3, newAppointment.getEnd());
			pStatement.setString(4, newAppointment.getTitle());
			pStatement.setString(5, newAppointment.getBody());
			pStatement.setString(6, newAppointment.getLocation());
			pStatement.setBoolean(7, newAppointment.isAllDay());
			int rowsAffected = pStatement.executeUpdate();
			System.out.println("<<DEBUG>>: Rows Affected: " + rowsAffected );
		}
		catch(ClassNotFoundException cnfe)
		{
			cnfe.printStackTrace();
		}
		catch(SQLException sqle)
		{
			sqle.printStackTrace();
		}
		//Add to the appropriate day
		//Invalidate user interface
	}
	public void deleteAppointment(String ID)
	{
		
	}
	public List<Appointment> getAppointments(int month, int year)
	{
		return null;
	}
}
