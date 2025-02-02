package com.smt.kata.number;

import java.util.ArrayList;
import java.util.List;

/****************************************************************************
 * <b>Title</b>: ConsecutiveDifferences.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Numbers With Same Consecutive Differences Kata
 * 
 * Return all non-negative integers of length n such that the absolute difference between every two consecutive digits is k.
 * 
 * Note that every number in the answer must not have leading zeros. For example, 01 has one leading zero and is invalid.
 * 
 * You may return the answer in any order.
 * 
 * Example 1:
 * Input: n = 3, k = 7
 * Output: [181,292,707,818,929]
 * Explanation: Note that 070 is not a valid number, because it has leading zeroes.
 * 
 * Example 2:
 * Input: n = 2, k = 1
 * Output: [10,12,21,23,32,34,43,45,54,56,65,67,76,78,87,89,98]
 * 
 * Example 3:
 * Input: n = 2, k = 0
 * Output: [11,22,33,44,55,66,77,88,99]
 * 
 * Example 4:
 * Input: n = 2, k = 2
 * Output: [13,20,24,31,35,42,46,53,57,64,68,75,79,86,97]
 * 
 * Constraints:
 * 2 <= n <= 9
 * 0 <= k <= 9
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Dec 1, 2021
 * @updates:
 ****************************************************************************/
public class ConsecutiveDifferences {

	/**
	 * Finds the consecutive differences in the provided n/k values
	 * @param n number of digits to search against
	 * @param k differences between values
	 * @return collection of the consecutive differences.  Empty collection if invalid
	 * data or none found
	 */
	public List<Integer> find(int n, int k) {
		List<Integer> nums = new ArrayList<>();
		if(n < 2 || n > 9 || k< 0 || k > 9) return nums;
		
		//build number
		String number = "1";
		for (int i = 1; i < n; i++) {
			number += "0";
		}
	
		
		int current = Integer.parseInt(number);
		// check numbers
		for (int i = current;  (current+"").length() < k ; i++) {
			
			int checked = validate(current+"" , k);
			if(checked == 0) {
				current++;
				continue;
			}
			nums.add(checked); 
			current++;
		} 
		
		
		return nums;
	}
	
	public int validate(String num, int dif ) {
		
		for (int i = 1; i < num.length(); i++) {
			int num1 = Integer.parseInt(num.substring(i-1,i));
			int num2 = Integer.parseInt(num.substring(i,i+1));
			
			if((num1 - num2 ) != dif ) {
				return 0;
			}
		}
		
		
		return Integer.parseInt(num);
				
	}
	


}
