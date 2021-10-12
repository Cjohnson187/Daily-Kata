package com.smt.kata.code;

import java.util.Arrays;

/****************************************************************************
 * <b>Title</b>: HarmoniousSequence.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Longest Harmonious Sequence Kata
 * 
 * We define a harmonious array as an array where the difference between its 
 * maximum value and its minimum value is exactly 1.
 * 
 * Given an integer array nums, return the length of its longest harmonious 
 * subsequence among all its possible subsequences.
 * 
 * A subsequence of array is a sequence that can be derived from the array by 
 * deleting some or no elements without changing the order of the remaining elements.
 * 
 * Example 1:
 * Input: nums = [1,3,2,2,5,2,3,7]
 * Output: 5
 * Explanation: The longest harmonious subsequence is [3,2,2,2,3].
 * 
 * Example 2:
 * Input: nums = [1,2,3,4]
 * Output: 2
 * 
 * Example 3:
 * Input: nums = [1,1,1,1]
 * Output: 0
 * 
 * Constraints:
 * 1 <= nums.length <= 2 * 104
 * -109 <= nums[i] <= 109
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Sep 16, 2021
 * @updates:
 ****************************************************************************/
public class HarmoniousSequence {

	/**
	 * Calculates the Longest Harmonious Sequence
	 * @param sequence Numbers to use to calculate
	 * @return total items in the harmonious sequence
	 */
	public int getLongest(int[] sequence) {
		
		if(sequence == null ) {
			return 0;
		}
		
		for (int start = 0; start <= sequence.length/2; start++) {
			for (int end = sequence.length-1; end >= start; end--) {
				
				System.out.println( "   checking  ="+ Arrays.toString(sequence) +"   start "+ start +  "   end = " +end);
				int is =  isHarm(sequence, start, end);
				if(is >0) return is;
				
			}
		}
		
		
		return 0;
	}
	
	
	public int isHarm(int[] nums, int start, int end) {
		int val  = Math.abs(nums[start] - nums[end]);
		System.out.println(val  + "   checking  ="+ Arrays.toString(nums) +"   start  =" + nums[start] + "   end = " + nums[end]);
		if(val == 1) return end-start+1;
		return 0;
	}
}
