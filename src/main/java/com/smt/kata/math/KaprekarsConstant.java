package com.smt.kata.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/****************************************************************************
 * <b>Title</b>: KaprekarsConstant.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Kaprekar's Constant Kata
 * 
 * The number 6174 is known as Kaprekar's constant, after the mathematician who 
 * discovered an associated property: for all four-digit numbers with at least 
 * two distinct digits, repeatedly applying a simple procedure eventually results 
 * in this value. The procedure is as follows:
 * 
 * For a given input x, create two new numbers that consist of the digits in x in 
 * ascending and descending order.
 * 
 * Subtract the smaller number from the larger number.
 * For example, this algorithm terminates in three steps when starting from 1234:
 * 
 * 4321 - 1234 = 3087
 * 8730 - 0378 = 8352
 * 8532 - 2358 = 6174
 * 
 * Write a function that returns how many steps this will take for a given input N.
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Oct 25, 2021
 * @updates:
 ****************************************************************************/
public class KaprekarsConstant {

	/**
	 * Calculates the number of steps until Kaprekar's Constant is achieved
	 * @param num Number to evaluate
	 * @return the number of steps to acheive the number
	 */
	public int calculateSteps(int num) {
		if(num < 0 || num > 9999) return 0;

		int count = 0;
		
		count =run(num, count);
		
		return count;
	}
	
	
	public String stringIt(List<String> lets) {
		String num = "";
		for(String s: lets) 
			num+=s;
		
		return num;
	}
	
	public int run(int num, int count) {
		
		String start = num+"";
		List<String> forward = Arrays.asList(start.split(""));
		Collections.sort(forward);
		List<String> backward = new ArrayList<>(forward);
		Collections.reverse(backward);
		
	
		 
		// check for 2 unique
		String let = forward.get(0);
		boolean dup = false;
		for(int i = 0; i < forward.size(); i++) 
			if(!forward.get(i).equals(let)) dup = true;
		if(dup == false) return count;
		
		
		int newNum = Integer.parseInt(stringIt( backward)) - Integer.parseInt(stringIt(forward)) ;
		if(num != newNum) 
			count = run(newNum, ++count);
		
		return count;
		
	}
}
