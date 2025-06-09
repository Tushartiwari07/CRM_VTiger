package com.tek.javautility;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	public int ramdonNumber()
	{
		Random random = new Random();
		 int randomNumber = random.nextInt(5000);
		 return randomNumber;
	}
	public String getSystemDateyyyyMMdd()
	{
		Date dateobj = new Date();
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		String systemDate = sdf.format(dateobj);
		return systemDate;
	}
	public String getRequiredDate(int date)
	{
//		SimpleDateFormat sdate = new SimpleDateFormat("YYYY-MM-dd");
//		Calendar cal = sdate.getCalendar();
//		cal.add(Calendar.DAY_OF_MONTH,date);
//        String reqDate = sdate.format(cal.getTime());
//		return reqDate;
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdate = new SimpleDateFormat("yyyy-MM-dd");
		cal.add(Calendar.DAY_OF_MONTH,date);
      String reqDate = sdate.format(cal.getTime());
		return reqDate;
	}
	public String getSystemTime()
	{
		return LocalDateTime.now().toString().replace(":", "_");
	}
	

}
