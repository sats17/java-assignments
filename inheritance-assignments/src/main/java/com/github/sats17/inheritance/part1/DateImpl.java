package com.github.sats17.inheritance.part1;


import java.util.Date;

/**
 * @author sats17
 *
 */
public class DateImpl {
	
	private Date date;
	
	
	/**
	 * Default Constructor
	 */
	public DateImpl(){}
	
	/**
	 * @param date
	 */
	public DateImpl(Date date){
		this.date = date;
	}
	
	/**
	 * @return date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
