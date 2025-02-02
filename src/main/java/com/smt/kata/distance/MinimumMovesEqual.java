package com.smt.kata.distance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

/****************************************************************************
 * <b>Title</b>: MinimumMovesEqual.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Minimum Moves to Equal Array Elements
 * 
 * Given an integer array nums of size n, return the minimum number of moves 
 * required to make all array elements equal.
 * 
 * In one move, you can increment or decrement an element of the array by 1.
 * Test cases are designed so that the answer will fit in a 32-bit integer.
 * 
 * Example 1:
 * Input: nums = [1,2,3]
 * Output: 2
 * Explanation:
 * Only two moves are needed (remember each move increments or decrements one element):
 * [1,2,3]  =>  [2,2,3]  =>  [2,2,2]
 * 
 * Example 2:
 * Input: nums = [1,10,2,9]
 * Output: 16
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Aug 30, 2021
 * @updates:
 ****************************************************************************/
public class MinimumMovesEqual {


	/**
	 * Calculates the number of moves to make each item in the array the equal
	 * @param elements Array to make equal
	 * @return Number of moves to make equal
	 */
	public int calculate(int[] elements) {
		if(elements == null || elements.length < 2) return 0;
		int moves = 0;
		int[] sorted = IntStream.of(elements).sorted().toArray();
		int median = elements.length % 2 >0? sorted[sorted.length/2] :(sorted[(sorted.length/2)-1] +sorted[(sorted.length/2)])/2;
		int iqr = Math.abs(sorted[((sorted.length/2)/2)] - sorted[((sorted.length/4)*3)+1]);
		int upperFence = (int) (sorted[((sorted.length/4)*3)+1] + (1.5*iqr));
		int lowerFence = (int) (sorted[((sorted.length/2)/2)] - (1.5*iqr));
		for(int i: elements)
		 //if outlier- move to median
			if(i> lowerFence || i < upperFence)
				moves+= Math.abs(median-i);
		return moves;
	}


//	public int calculate(int[] elements) {
//		if(elements == null || elements.length < 2) return 0;
//		int median =  IntStream.of(elements).sum()/elements.length;
//		int moves = 0;
//		for(int i: elements)
//			moves+= Math.abs(median-i);
//		return moves;
//	}
//	public int calculate(int[] elements) {
//		if(elements == null || elements.length < 2) return 0;
//		int total = 0;
//		for (int i: elements) {
//			total += i;
//		}
//		total = total/elements.length;
//		int moves = 0;
//		for(int i=0, j=elements.length-1; i < elements.length && j >= 0; i++) {
//			while (elements[i] != total) {
//				if(elements[i] < total) {
//					elements[i]++;
//					moves++;
//				}
//				else if (elements[i] > total) {
//					elements[i]--;
//					moves++;
//				}
//			}
//		}
//		return moves;
//	}
}
