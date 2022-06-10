package com.smt.kata.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/****************************************************************************
 * <b>Title</b>: PerfectSquares.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Write a program that determines the smallest number of 
 * perfect squares that sum up to N.
 * 
 * Here are a few examples:
 * 
 * Given N = 4, return 1 (4)
 * Given N = 17, return 2 (16 + 1)
 * Given N = 18, return 2 (9 + 9)
 * 
 * <b>Copyright:</b> Copyright (c) 2022
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Apr 15, 2022
 * @updates:
 ****************************************************************************/
public class PerfectSquares {

	/**
	 * Finds the smallest number of squares that add to the total "n"
	 * @param n Number to match the squares
	 * @return Number of squares to solve the matches
	 */
	public int findSmallestNumber(int n) {
		List<Integer> nums = new ArrayList<>();
		List<Integer> ret = new ArrayList<>();
		for(int i=0; i < n; i++) {
			if ((int)Math.sqrt(i) * (int)Math.sqrt(i) == i) nums.add(i);
		}
		nums.sort((a,b) ->  b-a);
		int total;
		for (int i = 0, j= nums.size(); i < nums.size(); i++) {
			//if(nums.get(i) > n )
		}
		System.out.println("nums = " + nums.toString());
		
		return n;
	}
	
	
}
