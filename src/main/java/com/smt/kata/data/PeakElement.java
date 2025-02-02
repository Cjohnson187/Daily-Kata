package com.smt.kata.data;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/****************************************************************************
 * <b>Title</b>: PeakElement.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Peak Element Kata
 * 
 * A peak element is an element that is strictly greater than its neighbors.
 * 
 * Given an integer array nums, find a peak element, and return its index. If the 
 * array contains multiple peaks, return the index to all of the peaks.
 * 
 * You may imagine that nums[-1] = nums[n] = -∞.
 * 
 * Example 1:
 * Input: nums = [1,2,3,1]
 * Output: 2
 * Explanation: 3 is a peak element and your function should return the index number 2.
 * 
 * Example 2:
 * Input: nums = [1,2,1,3,5,6,4]
 * Output: 1, 5
 * Explanation: Your function can return either index number 1 where the peak 
 * element is 2, or index number 5 where the peak element is 6.

 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Aug 18, 2021
 * @updates:
 ****************************************************************************/
public class PeakElement {

	/**
	 * Finds all of the peak elements inside the provided array
	 * @param elements Array of elements to search for peaks
	 * @return Array of all peak element s (thier array index value)
	 */
	public Integer[] find(int[] elements) {
		
		List<Integer> ret = new ArrayList<>();
		if(elements == null)
			return ret.toArray(Integer[]::new);
		
		for (int i = 0; i < elements.length; i++) 
			try {
				if(elements[i] > elements[i-1] && elements[i] > elements[i+1]) 
					ret.add(i);
			} catch (Exception e) {
				System.out.println("stonks");
			}
		
		return ret.toArray(Integer[]::new);
	}
}
