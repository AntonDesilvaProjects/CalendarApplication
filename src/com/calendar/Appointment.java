package com.calendar;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Comparator;
import java.util.UUID;

public class Appointment implements Comparable<Appointment> {
	
	private Timestamp start;
	private Timestamp end;
	private String title;
	private String body;
	private String location;
	private boolean allDay;
	private String id;
	
	public Appointment(Timestamp start, Timestamp end, String title, String body, String location, boolean allDay )
	{
		this.start = start;
		this.end = end;
		this.title = title;
		this.body = body;
		this.location = location;
		this.allDay = allDay;
		this.id = UUID.randomUUID().toString();
	}
	public Timestamp getStart() {
		return start;
	}
	public void setStart(Timestamp start) {
		this.start = start;
	}
	public Timestamp getEnd() {
		return end;
	}
	public void setEnd(Timestamp end) {
		this.end = end;
	}
	public String getTitle() {
		return title;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}


	public String getBody() {
		return body;
	}


	public void setBody(String body) {
		this.body = body;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public boolean isAllDay() {
		return allDay;
	}


	public void setAllDay(boolean allDay) {
		this.allDay = allDay;
	}
	
	@Override
	public int compareTo(Appointment appointment) {
		return this.start.compareTo(appointment.getStart());
	}
}
