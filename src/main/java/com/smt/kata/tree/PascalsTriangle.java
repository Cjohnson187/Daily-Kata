package com.smt.kata.tree;

/****************************************************************************
 * <b>Title</b>: PascalsTriangle.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Pascals Triangle Kata
 * 
 * Given an integer numRows, return the first numRows of Pascal's triangle.
 * In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
 * 
 * https://upload.wikimedia.org/wikipedia/commons/0/0d/PascalTriangleAnimated2.gif
 * 
 * Example 1:
 * Input: numRows = 5
 * Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 * 
 * Example 2:
 * Input: numRows = 1
 * Output: [[1]]
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Aug 27, 2021
 * @updates:
 ****************************************************************************/
public class PascalsTriangle {

	/**
	 * Builds a pascal triangle with the provided number of levels
	 * @param levels Number of levels in the triangle
	 * @return Pascal Triangle
	 */
	public int[][] build(int levels) {
		if (levels < 1) return new int[0][];
		int[][] pascals = new int[levels][];

		for (int i = 0; i < levels ; i++) {
			pascals[i] = new int[i+1];
			pascals[i][0] = 1;
			pascals[i][pascals[i].length-1]= 1;

			for(int j = 1; pascals[i].length > 2 && j < pascals[i].length-1; j++){
				pascals[i][j] = pascals[i-1][j] + pascals[i-1][j-1];
			}
		}
		return pascals;
	}
}
