package com.smt.kata.number;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/****************************************************************************
 * <b>Title</b>: MaxKSumPairs.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Max Number of K-Sum Pairs
 * 
 * You are given an integer array nums and an integer k.
 * 
 * In one operation, you can pick two numbers from the array whose sum equals k 
 * and remove them from the array.
 * 
 * Return the maximum number of operations you can perform on the array.
 * 
 * Example 1:
 * Input: nums = [1,2,3,4], k = 5
 * Output: 2
 * Explanation: Starting with nums = [1,2,3,4]:
 * - Remove numbers 1 and 4, then nums = [2,3]
 * - Remove numbers 2 and 3, then nums = []
 * There are no more pairs that sum up to 5, hence a total of 2 operations.
 * 
 * Example 2:
 * Input: nums = [3,1,3,4,3], k = 6
 * Output: 1
 * Explanation: Starting with nums = [3,1,3,4,3]:
 * - Remove the first two 3's, then nums = [1,4,3]
 * There are no more pairs that sum up to 6, hence a total of 1 operation.
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Sep 24, 2021
 * @updates:
 ****************************************************************************/
public class MaxKSumPairs {
	
	
	/**
	 * In one operation, you can pick two numbers from the array whose sum equals k 
 	 * and remove them from the array.
	 * @param source Source array of numbers
	 * @param target Target number to calculate against
	 * @return Number of operations
	 */
	public int calculate(int[] source, int target) {
		int sum = 0;
		if(source == null || source.length < 1) return sum;
		List<Integer> s = new ArrayList();
		for(int i: source) {
			s.add(i);
		}
		
		int count = 0;
		int index = 0;
		while ( s.size() > 0) {
			List<Integer> newS = sum(s, target, index);
			if(newS.size() < s.size()) {
				s = newS;
				count++;
				
			}
			else if(newS.size() == s.size() && index <newS.size()   ) {
				newS = sum(s, target, index++);
			}
			else if(newS.size() == s.size()) {
				break;
			}
		}
		
		
		return count;
	}
	
	public List<Integer> sum(List<Integer> nums,  int target, int index) {
		List<Integer> newNums= new ArrayList<>( nums);
		Collections.sort(newNums);
		Collections.reverse(newNums);
 		int sum = 0;
		
		for(int i=index; i < newNums.size(); i++) {
			if((newNums.get(i) + sum) <= target ) {
				sum += newNums.get(i);
				newNums.remove(i);
				i--;
			}
			
			if(sum == target) {
				return newNums;
			}
			
		}
		
			return nums;
		
	}
}
