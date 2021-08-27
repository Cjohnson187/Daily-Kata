package com.smt.kata.number;

import java.util.ArrayList;
import java.util.List;

/****************************************************************************
 * <b>Title</b>: SmallestPositiveInteger.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Smallest Positive Integer Kata
 * Given an array of positive numbers, find the smallest positive integer value 
 * that cannot be represented as sum of elements of any subset of given set. 
 * 
 * Input:  arr[] = {1, 3, 6, 10, 11, 15};
 * Output: 2
 * 
 * Input:  arr[] = {1, 1, 1, 1};
 * Output: 5
 * 
 * Input:  arr[] = {1, 1, 3, 4};
 * Output: 10
 * 
 * Input:  arr[] = {1, 2, 5, 10, 20, 40};
 * Output: 4
 * 
 * Input:  arr[] = {1, 2, 3, 4, 5, 6};
 * Output: 22
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Aug 20, 2021
 * @updates:
 ****************************************************************************/
public class SmallestPositiveInteger {

	/**
	 * Finds the smallest positive integer NOT in the sum of values
	 * @param arr Values to evaluate and sum
	 * @return smallest integer
	 */
	public int find(int[] arr) {
		if(arr == null || arr.length < 1) return 0;
		List<Integer> sets = new ArrayList<>();
		//List<Integer> sets = new ArrayList<>();
		int len = arr.length;
		for (int i = 0; i< (1<<len); i++ ) {
			
			//sets.add(arr[i]);
			int total = 0;
			for (int j = 0; j< len; j++  ) {
				if ((i & (1 << j)) > 0) {
					total += j;
				}
				//if(j == i) continue;
				
				
			}
			
			if(!sets.contains(total)) sets.add(total);
		}
		int ret = 1;
		boolean in = false;
		System.out.println(sets.toString());
		while(true ) {
			if(sets.contains(ret)) {
				ret++;
			}
			else return ret;
		}

	}
}
