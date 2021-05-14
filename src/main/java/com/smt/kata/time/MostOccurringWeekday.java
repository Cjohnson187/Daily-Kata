package com.smt.kata.time;

import java.time.LocalDate;
// JDK 11.x
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;

/****************************************************************************
 * <b>Title</b>: MostOccurringWeekday.java
 * <b>Project</b>: Daily-Kata
 * <b>Description: </b> Most-Occurring Weekdays in a Year
 * 
 * Find the weekdays that occur the most in a given year.
 * 
 * Write a function MostOccurringWeekday that takes an integer representing a 
 * year as input and returns a list of the most-occurring weekdays throughout that year.
 * 
 * =MostOccurringWeekday[2018]
 * {Monday}
 * 
 * MostOccurringWeekday[2009]
 * {Thursday}
 * 
 * Multiple weekdays occurred the most in 2012:
 * 
 * MostOccurringWeekday[2012]
 * {Sunday, Monday}
 * 
 * ******** Note: Be careful.  Dates may be negative (IE, BC dates)
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since May 10, 2021
 * @updates:
 ****************************************************************************/
public class MostOccurringWeekday {
	/**
	 * Enum for the day of the week
	 */
	public enum WeekDay {
		SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
	}
	
	/**
	 * Calculates the most occurring week day fo rthe given year 
	 * @param year Year to calculate against
	 * @return Collection of weekdays
	 */
	public List<WeekDay> calculate(int year) {
		if (year == 0) return new ArrayList<>();
		
		Calendar date = Calendar.getInstance();
		if (year < 0 ) 
			date.set(Calendar.ERA, GregorianCalendar.BC);
		date.set(Calendar.YEAR, Math.abs( year));
		date.set(Calendar.DAY_OF_YEAR, 1);
		
		
        
        Calendar end = Calendar.getInstance();
        end.set(Calendar.YEAR, year+1);
        end.set(Calendar.DAY_OF_YEAR, 1);
      
        System.out.println(date.YEAR );
        System.out.println(end.YEAR );
        Map<WeekDay, Integer> days = new HashedMap();
        days.put(WeekDay.SUNDAY, 0);
        days.put(WeekDay.MONDAY, 0);
        days.put(WeekDay.TUESDAY, 0);
        days.put(WeekDay.WEDNESDAY, 0);
        days.put(WeekDay.THURSDAY, 0);
        days.put(WeekDay.FRIDAY, 0);
        days.put(WeekDay.SATURDAY, 0);
       System.out.println("day of week = " + date);
        while (date.before(end)) {
    
            
        System.out.println("day of week = " + date.get(Calendar.DAY_OF_WEEK));
        
        	if (date.get(Calendar.DAY_OF_WEEK) == 1) {
        		days.replace(WeekDay.SUNDAY, days.get(WeekDay.SUNDAY) +1);
        	}
        	else if (date.get(Calendar.DAY_OF_WEEK) == 2) {
        		days.replace(WeekDay.MONDAY, days.get(WeekDay.MONDAY) +1);
        	}
        	else if (date.get(Calendar.DAY_OF_WEEK) == 3) {
        		days.replace(WeekDay.TUESDAY, days.get(WeekDay.TUESDAY) +1);
        	}
        	else if (date.get(Calendar.DAY_OF_WEEK) == 4) {
        		days.replace(WeekDay.WEDNESDAY, days.get(WeekDay.WEDNESDAY) +1);
        	}
        	else if (date.get(Calendar.DAY_OF_WEEK) == 5) {
        		days.replace(WeekDay.THURSDAY, days.get(WeekDay.THURSDAY) +1);
        	}
        	else if (date.get(Calendar.DAY_OF_WEEK) == 6) {
        		days.replace(WeekDay.FRIDAY, days.get(WeekDay.FRIDAY) +1);
        	}
        	else if (date.get(Calendar.DAY_OF_WEEK) == 7) {
        		days.replace(WeekDay.SATURDAY, days.get(WeekDay.SATURDAY) +1);
        		System.out.println("sat");
        	}
        	date.add(Calendar.DAY_OF_YEAR, 1);
        
        }
        List<WeekDay> ret = new ArrayList<>();
        int max = 0;
        for (Map.Entry<WeekDay, Integer>  d: days.entrySet() ) {
			if (d.getValue() > max ) {
				max = d.getValue();
			}
		}
        for (Map.Entry<WeekDay, Integer>  d: days.entrySet() ) {
			if (d.getValue() == max ) {
				ret.add(d.getKey());
			}
		}
        System.out.println("days  =" + days.toString());
	
		// Return the collection of most occurring
		return ret;
	}

}
