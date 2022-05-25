package com.smt.kata.sequence;

import java.util.ArrayList;
import java.util.List;

/****************************************************************************
 * <b>Title</b>: LongestSubarray.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Longest SubArray Kata
 * 
 * Given an array of elements, return the length of the longest subarray where 
 * all its elements are distinct.
 * 
 * For example, given the array [5, 1, 3, 5, 2, 3, 4, 1], return 5 as the 
 * longest subarray of distinct elements is [5, 2, 3, 4, 1]

 * <b>Copyright:</b> Copyright (c) 2022
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since May 18, 2022
 * @updates:
 ****************************************************************************/
public class LongestSubarray {

	/**
	 * Finds the longest subsequence of distinct elements in the array
	 * @param sequence Array of values to process
	 * @return Length of the longest distinct sub-array
	 */
	public int find(int[] sequence) {
		int longest = 0;
		if(sequence == null || sequence.length < 1) 
			return longest;
		List<Integer> seq = new ArrayList<>();
		for (int i = 0; i < sequence.length; i++) {
			if(!seq.contains(sequence[i])) {
				seq.add(sequence[i]);
				longest = seq.size() > longest? seq.size():longest;
			}
			else {
				longest = seq.size() > longest? seq.size():longest;
				if( i+1 == sequence.length)
					return longest;
				
				i = i- seq.indexOf(sequence[i]);
				seq.clear();
//				seq.add(sequence[i]);
			}
		}
		
		return seq.size() > longest? seq.size():longest;
	}
}
