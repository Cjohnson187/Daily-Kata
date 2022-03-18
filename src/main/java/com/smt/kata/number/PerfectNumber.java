package com.smt.kata.number;



/****************************************************************************
 * <b>Title</b>: PerfectNumber.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Perfect Number Kata
 * 
 * A number is considered perfect if its digits sum up to exactly 10.
 * 
 * Given a positive integer n, return the n-th perfect number.
 * 
 * For example, given 1, you should return 19. Given 2, you should return 28.
 * 
 * <b>Copyright:</b> Copyright (c) 2022
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Mar 16, 2022
 * @updates:
 ****************************************************************************/
public class PerfectNumber {

	/**
	 * Finds the nth perfect number
	 * @param nth nth value to locate
	 * @return Value of the nth perfect number
	 */
	public int find(int nth) {
		if(nth < 0) return 0;
		int index = nth;
		while (!isPerfect(index)) {
			index++;
		}
		return index;
	}
	public boolean isPerfect(int num){
		String[] nums = (num+"").split("");
		int total = 0;
			for(String n: nums) {
				total += Integer.parseInt(n);
			}
			if(total == 10) return true;
		
		return false;
	}

}
