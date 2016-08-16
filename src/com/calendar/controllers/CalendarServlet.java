package com.calendar.controllers;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.calendar.Month;

public class CalendarServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response ) throws IOException, ServletException
	{
		Month m = Month.createMonth(Calendar.AUGUST, 2016);
		String html = m.generateHTMLView();
		request.setAttribute("html", html);
		this.getServletContext().getRequestDispatcher("/calendar_view.jsp").forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	{
		Month m = Month.createMonth(Calendar.AUGUST, 2016);
		String html = m.generateHTMLView();
		request.setAttribute("html", html);
		this.getServletContext().getRequestDispatcher("/calendar_view.jsp").forward(request, response);
	}
}
