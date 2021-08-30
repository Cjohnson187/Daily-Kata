package com.smt.kata.number;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/****************************************************************************
 * <b>Title</b>: CountingNumbers.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Counting Numbers Kata
 * 
 * You are given an integer array nums and you have to return a new counts array. 
 * The counts array has the property where counts[i] is the number of smaller 
 * elements to the right of nums[i].  When you get to the last element, jump 
 * back to the 0 element to calculate
 * 
 * Example 1:
 * Input: nums = [5,2,6,1]
 * Output: [2,1,1,0]
 * Explanation:
 * To the right of 5 there are 2 smaller elements (2 and 1).
 * To the right of 2 there is only 1 smaller element (1).
 * To the right of 6 there is 1 smaller element (1).
 * To the right of 1 (starting with the zero location) there is 0 smaller elements.
 * 
 * Example 2:
 * Input: nums = [-1]
 * Output: [0]
 * 
 * Example 3:
 * Input: nums = [-1,-1]
 * Output: [0,0]
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Aug 26, 2021
 * @updates:
 ****************************************************************************/
public class CountingNumbers {

	/**
	 * Calculates the number of smaller elements for each location in the array
	 * @param source Source array to calculate against
	 * @return Number of smaller elements for each item in the source array
	 */
	public int[] calculate(int[] source) {
		if(source == null || source.length < 1) return new int[0];
		int[] re = new int[source.length];
		for(int i=0; i< source.length; i++) {
			if(i == source.length -1) {
				int temp = source[0];
				source[0] = source[i];
				source[i] = temp;
				re[i] = getSmaller(source, source[0], 1).size();
			}
			else 
				re[i] = getSmaller(source, source[i], i+1).size();
			
		}
		return re;
	}
	public List<Integer> getSmaller(int[] source, int num, int index) {
		List<Integer> smaller = new ArrayList();
		for(int i=index; i< source.length; i++) {
			if(source[i] < num) {
				smaller.add(source[i]);
			}
		}
		return smaller;
		
	}
}
