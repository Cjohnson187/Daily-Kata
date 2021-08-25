package com.smt.kata.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/****************************************************************************
 * <b>Title</b>: SmallestElement.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b>  Kth Smallest Element in a Sorted Matrix
 *
 * Given an n x n matrix, return the kth smallest element in the matrix.
 *
 * Note that it is the kth smallest element in the sorted order, not the kth distinct element.
 *
 * Example 1:
 * Input: matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
 * Output: 13
 * Explanation: The elements in the matrix are [1,5,9,10,11,12,13,13,15], and the 8th smallest number is 13
 * 
 * Example 2:
 * Input: matrix = [[-5]], k = 1
 * Output: -5
 * 
 * Constraints:
 * n == matrix.length
 * n == matrix[i].length
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Aug 18, 2021
 * @updates:
 ****************************************************************************/
public class SmallestElement {

	/**
	 * Calculates the nth smallest element
	 * @param matrix Grid to calculate against
	 * @param index Nth element to return
	 * @return value of the nth smallest element
	 */
	public int calculate(int[][] matrix, int index) {
		List<Integer> nums = new ArrayList<>();
		System.out.println("m len = "+ matrix.length);
		if(matrix == null || matrix[0] == null) return 0;
		
		for (int a=0; a < matrix.length; a++) {
			if( matrix[a] == null || matrix[a].length <1) return 0;
			for(Integer i : matrix[a]) {
				if(i == null) return 0;
				nums.add(i);
			}
		}
		Collections.sort(nums);
	
		return nums.get(index-1);
	}

}
