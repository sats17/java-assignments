package com.github.sats17.inheritance.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateParser {
	
	 public static Date parseDate(String date) {
	     try {
	         return new SimpleDateFormat("yyyy-MM-dd").parse(date);
	     } catch (ParseException e) {
	         return null;
	     }
	  }
	
}
