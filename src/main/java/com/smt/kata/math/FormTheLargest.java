package com.smt.kata.math;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/****************************************************************************
 * <b>Title</b>: FormTheLargest.java
 * <b>Project</b>: SMT-Kata 
 * <b>Description:</b> Form the Largest Kata
 * 
 * Given a number , Return _The Maximum number _ could be formed from the digits
 * of the number given .
 * 
 * Notes Only Natural numbers passed to the function , numbers Contain digits
 * [0:9] inclusive
 * 
 * Digit Duplications could occur , So also consider it when forming the Largest
 * 
 * Input >> Output Examples: maxNumber (213) ==> return (321) Explanation: As
 * 321 is _The Maximum number _ could be formed from the digits of the number
 * 213 .
 * 
 * NOTE:  This Kata MUST be solved in a SINGLE LINE statement.  You can use any
 * class in the JDK to accomplish this task
 * 
 * <b>Copyright:</b> Copyright (c) 2021 
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since May 30, 2021
 * @updates:
 ****************************************************************************/
public class FormTheLargest {

	/**
	 * Takes the source string and reorders the individual digits to create the 
	 * largest number possible
	 * @param source Number to evaluate
	 * @return Largest number possible from the source
	 */
	public long calculate(long source) {
		

		return  Long.valueOf(Stream.of((Math.abs(source)+"").split(""))
				.sorted(Collections.reverseOrder())
				.collect(Collectors.joining()));
    }
}
