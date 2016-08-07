package com.calendar;

import java.util.Date;
import java.util.UUID;

public class Appointment {
	
	private Date start;
	private Date end;
	private String title;
	private String body;
	private String location;
	private boolean allDay;
	private String id;
	
	public Appointment(Date start, Date end, String title, String body, String location, boolean allDay )
	{
		this.start = start;
		this.end = end;
		this.title = title;
		this.body = body;
		this.location = location;
		this.allDay = allDay;
		this.id = UUID.randomUUID().toString();
	}
	public Date getStart() {
		return start;
	}
	public void setStart(Date start) {
		this.start = start;
	}
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
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

}
