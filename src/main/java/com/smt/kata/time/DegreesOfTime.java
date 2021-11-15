package com.smt.kata.time;

import com.siliconmtn.data.text.StringUtil;

/****************************************************************************
 * <b>Title</b>: DegreesOfTime.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Degrees of Time
 * 
 * Given a clock time in hh:mm format, determine, to the nearest degree, the angle 
 * in degrees, between the hour and the minute hands.  The hour will be in 24 hour format.
 * 
 * Example One:
 * Input : 01:05
 * Output: 0 degrees as the hands are in the same location
 * 
 * Example two
 * Input: 00:15
 * Output: 90 degrees as the hour hand is vertical and the minute had is at 90 gegrees
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Nov 10, 2021
 * @updates:
 ****************************************************************************/
public class DegreesOfTime {

	/**
	 * Calculate the difference in degrees for the provided time
	 * @param time Time to calculate in hh:mm 24 hour format
	 * @return difference in degrees between the minute and hour hand.  0 if invalid data
	 */
	public int calculate(String time) {
		if(StringUtil.isEmpty(time)) {
			return 0;
		}
		String[] ti = time.split(":");
		if(ti[0].length() < 1 || ti[0].length() > 2 || ti[1].length() < 1 || ti[1].length()> 2) {
			return 0;
		}
		
		for(char c: ti[0].toCharArray()) {
			if(!Character.isDigit(c)) return 0;
		}
		for(char c: ti[1].toCharArray()) {
			if(!Character.isDigit(c)) return 0;
		}
		int hDeg = 0;

		if(Integer.parseInt(ti[0]) > 12) {
			hDeg  = (Integer.parseInt(ti[0])-12) * 30;
		} else {
			hDeg  = Integer.parseInt(ti[0]) * 30;
		}
		
		int mDeg  = Integer.parseInt(ti[1]) * 6 ;
		System.out.println("hours = " + Integer.parseInt(ti[0]) + "      calced = " + hDeg);
		System.out.println("min = " + Integer.parseInt(ti[1]) + "      calced = " + mDeg);
		 
		
		return Math.abs(hDeg-mDeg);
	}

}
