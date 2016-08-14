package com.calendar.utilities;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.calendar.Appointment;

public class AppointmentUtility {
	public static void createAppointment(Timestamp start, Timestamp end, String title, String body, String location, boolean allDay)
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
			pStatement.setTimestamp(2, newAppointment.getStart());
			pStatement.setTimestamp(3, newAppointment.getEnd());
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
	public static List<Appointment> getAppointments(int month, int year)
	{
		List<Appointment> appointments = new ArrayList<Appointment>();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cal_apps", "root", "desilva5");
			String SQL = "SELECT * FROM App WHERE MONTH(app_start)= ? AND YEAR(app_start) = ?;";
			PreparedStatement pStatement = connection.prepareStatement(SQL);
			pStatement.setInt(1, month);
			pStatement.setInt(2, year);
			ResultSet results = pStatement.executeQuery();
			Timestamp currentTS;
			
			while(results.next())
			{
				currentTS = results.getTimestamp(2);
				//Get the appointment information
				Appointment newAppointment;
				String id = results.getString(1);
				Timestamp end = results.getTimestamp(3);
				String title = results.getString(4);
				String body = results.getString(5);
				String location = results.getString(6);
				boolean allDay = results.getBoolean(7);
				newAppointment = new Appointment(currentTS, end, title, body, location, allDay);
				appointments.add(newAppointment);
			}
			
		}
		catch(ClassNotFoundException ex)
		{
			ex.printStackTrace();
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
		}
		
		return appointments;
	}
}
