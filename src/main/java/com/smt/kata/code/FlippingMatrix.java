package com.smt.kata.code;

import java.util.ArrayList;
import java.util.List;

/****************************************************************************
 * <b>Title</b>: FlippingMatrix.java <b>Project</b>: SMT-Kata <b>Description:
 * </b> Score After Flipping Matrix Kata
 * 
 * You are given an m x n binary matrix grid.
 * 
 * A move consists of choosing any row or column and toggling each value in that
 * row or column (i.e., changing all 0's to 1's, and all 1's to 0's).
 * 
 * Every row of the matrix is interpreted as a binary number, and the score of
 * the matrix is the sum of these numbers.
 * 
 * Return the highest possible score after making any number of moves (including
 * zero moves).
 * 
 * https://assets.leetcode.com/uploads/2021/07/23/lc-toogle1.jpg
 * 
 * Example 1: Input: grid = [[0,0,1,1],[1,0,1,0],[1,1,0,0]] Output: 39
 * Explanation: 0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39
 * 
 * Example 2: Input: grid = [[0]] Output: 1
 * 
 * Constraints: m == grid.length n == grid[i].length 1 <= m, n <= 20 grid[i][j]
 * is either 0 or 1.
 * 
 * <b>Copyright:</b> Copyright (c) 2021 <b>Company:</b> Silicon Mountain
 * Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Nov 30, 2021
 * @updates:
 ****************************************************************************/


public class FlippingMatrix {

	/**
	 * Calculates the sum of the binaries for the matrix with as many moves as
	 * needed
	 * 
	 * @param matrix Matrix to calculate against
	 * @return Sum of the binary values for each row
	 */
	public int calculate(int[][] matrix) {
		if (matrix == null || matrix[0] == null)
			return 0;
	
		
		
		for (int i = 0; i < matrix.length; i++) {
			if(matrix[i].length > 0 && matrix[i][0] == 0  ) {
				for (int j = 0; j < matrix[0].length; j++) {
					matrix[i][j] = matrix[i][j] == 0 ? 1 : 0;
				}
			}
		}
		
		
		
		return add(matrix);
	}
	
	public List<Integer> getInt() {
		List<Integer> numbers = new ArrayList<>();
		
		return numbers;
	}
	
	/**
	 * 
	 */
	public int[][] flipCol(int[][] matrix) {
		for (int i = 0;matrix.length > 0 && i < matrix[0].length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				matrix[j][i] = matrix[j][i] == 0 ? 1 : 0;
			}
		}
		
		
		return matrix;
	}

	public int add(int[][] matrix) {
		int total = 0;
		for (int[] row : matrix) {
			String rowNum = "";
			for (int num : row) {
				rowNum += num;
			}
			total = Integer.parseInt(rowNum, 2);

		}

		return total;
	}
	

}
