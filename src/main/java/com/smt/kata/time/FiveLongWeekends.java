package com.smt.kata.time;

import java.text.SimpleDateFormat;
import java.util.Calendar;
// JDK 11.x
import java.util.Date;
import java.util.GregorianCalendar;

/****************************************************************************
 * <b>Title:</b> FiveLongWeekends.java
 * <b>Project:</b> SMT-Kata
 * <b>Description:</b> Five Long Weekends in a Month
 * 
 * Write a function that finds months containing five long weekends.
 * 
 * "Everybody's working for the weekend", so a month with five long weekends would 
 * be nice. A long weekend consists of the days Friday through Sunday.
 * Five long weekends in a month occur about once a year. For example, 
 * five long weekends occurred in December 2017:
 * 
 *  Mo|Tu|We|Th|Fr|Sa|Su|
 *    |  |  |  |1 |2 |3 |
 *   4|5 |6 |7 |8 |9 |10|
 *  11|12|13|14|15|16|17|
 *  18|19|20|21|22|23|24|
 *  25|26|27|28|29|30|31|
 * 
 * Write a function called findNextFromDate that takes a date d as 
 * input and returns a DateObject representing the first month after d that 
 * contains five long weekends
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Apr 30, 2021
 * <b>updates:</b>
 * 
 ****************************************************************************/
public class FiveLongWeekends {

	/**
	 * Find the next Five long weekends month form the current month
	 * @param d Start date
	 * @return Date of the five long weekends month.  Null otherwise
	 */
	public Date findNext(Date d) {
		Calendar date = Calendar.getInstance();
        date.setTime(d);
       
        if (d == null || d.equals(new Date())) return null;
        while(date.getTime().compareTo( Calendar.getInstance().getTime()) < 0) {
        
        }


		
		return d;
	}
	

}
