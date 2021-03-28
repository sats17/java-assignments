package com.github.sats17.inheritance.util;

import com.github.sats17.inheritance.exceptions.WrongInputException;

public class DateFormatImpl {

	private static String Months[] = new String[] { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep",
			"Oct", "Nov", "Dec" };

	public static boolean checkLeapYear(int year) {
		boolean leap;
		if (year % 4 == 0) {
			if (year % 100 == 0) {
				if (year % 400 == 0)
					leap = true;
				else
					leap = false;
			} else
				leap = true;
		} else
			leap = false;
		if (leap)
			return true;
		else
			return false;
	}

	public static String fomater(String usrDate) throws WrongInputException {
		String[] dateArr = usrDate.split(",");
		if (dateArr.length != 3) {
			throw new WrongInputException("Please Enter valid date.");
		}

		int date = Integer.parseInt(dateArr[0]);
		int month = Integer.parseInt(dateArr[1]);

		String formatedDate = "";

		if (checkLeapYear(Integer.parseInt(dateArr[0])) && month == 2 && date > 29) {
			throw new WrongInputException("Please enter proper date.");
		}

		if (month <= 0 || month > 12 || date <= 0 || date >= 31 || dateArr[2].length() != 4) {
			throw new WrongInputException("Please enter proper date.");
		} else {
			formatedDate = dateArr[0] + "/" + Months[month - 1] + "/" + dateArr[2];
		}

		return formatedDate;
	}

}
