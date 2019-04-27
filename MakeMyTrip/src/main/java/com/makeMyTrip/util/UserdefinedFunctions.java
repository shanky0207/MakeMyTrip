package com.makeMyTrip.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.JavascriptExecutor;

import com.makeMyTrip.base.TestBase;

public class UserdefinedFunctions extends TestBase {

	//to get the date(dd) from Month
	public static int getDayofMonth()
	{
		Date date = new Date();
		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		int day = localDate.getDayOfMonth();

		return day;
	}

	//to get the Month(MM)
	public static int getmonthValue()
	{
		Date date = new Date();
		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		int monthValue = localDate.getMonthValue();
		return monthValue;
	}

	//to get the year(yyyy)
	public static int getyearValue()
	{
		Date date = new Date();
		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		int yearValue = localDate.getYear();
		return yearValue;
	}

	//to get the current day date in dd format
	public static int getDepartureDate()
	{
		int departureDay=getDayofMonth();
		return departureDay;
	}

	//to get the return day date by adding 7 days
	public static int getReturnDate()
	{
		int returnDay;
		int year=getyearValue();
		int month=getmonthValue();
		YearMonth yearMonthObject = YearMonth.of(year,month );
		int daysInMonth = yearMonthObject.lengthOfMonth();
		int addDays=getDayofMonth()+Integer.parseInt(prop.getProperty("returnDay"));


		if(addDays>daysInMonth)
		{
			returnDay= addDays-daysInMonth;
			return returnDay;
		}
		else
		{
			return addDays;
		}
	}

	//to scroll the page till bottom of webpage
	public static void scrollTillBottomPage()
	{
		((JavascriptExecutor) driver)
		.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	//to scroll the page till specified coordinate of webpage
	public static void scrollusingCordinate()
	{
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)");
	}
}
