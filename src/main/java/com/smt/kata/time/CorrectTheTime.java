package com.smt.kata.time;

import com.siliconmtn.data.text.StringUtil;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/****************************************************************************
 * <b>Title</b>: CorretTheTime.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Correct the Time.  You have to create a method, 
 * that corrects a given time string.  There was a problem in addition, 
 * so many of the time strings are broken.
 * Time is formatted using the 24-hour clock, so from 00:00:00 to 23:59:59:
 * Examples
 * "09:10:01" -> "09:10:01"  
 * "11:70:10" -> "12:10:10"  
 * "19:99:99" -> "20:40:39"  
 * "24:01:01" -> "00:01:01" 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Feb 24, 2021
 * @updates:
 ****************************************************************************/
public class CorrectTheTime {

	/**
	 * 
	 */
	public CorrectTheTime() {
		super();
	}
	
	public String transform(String time) {
		if(StringUtil.isEmpty(time)) return "";
		int[] timeList = Arrays.stream(time.split(":")).mapToInt(Integer::parseInt).toArray(); //Arrays.asList(time.split(":"));
		DecimalFormat df = new DecimalFormat("00");
		for (int i = timeList.length-1; i > 0; i--) {
			timeList[i-1] +=timeList[i] / 59;
			timeList[i] = timeList[i] % 60;
		}
		timeList[0] = timeList[0] > 23 ? (timeList[0]/25) : timeList[0];

		return IntStream.of(timeList).mapToObj(num -> df.format(num)).collect(Collectors.joining(":"));
	}
}
