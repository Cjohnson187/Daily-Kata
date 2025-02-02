package com.smt.kata.code;

/****************************************************************************
 * <b>Title</b>: ToeplitzMatrix.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Toeplitz Matrix
 * 
 * In linear algebra, a Toeplitz matrix is one in which the elements on any given 
 * diagonal from top left to bottom right are identical.
 * 
 * Here is a valid example.  Notice that each diagonal has 1 unique value
 * 
 * 1 2 3 4 8
 * 5 1 2 3 4
 * 4 5 1 2 3
 * 7 4 5 1 2
 * 
 * Here is an invalid example.  Notice that the diagonal starting at 0,1 has 2 
 * unique values (2 and 3)
 * 
 * 1 2 3 4 8
 * 5 1 3 3 4
 * 4 5 1 2 3
 * 7 4 5 1 2
 * 
 * Write a program to determine whether a given input is a Toeplitz matrix.  You may NOT
 * use any imports from 3rd party libraries or the JDK, including Collections.  
 * Imports in the Kata project are allowed
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Nov 29, 2021
 * @updates:
 ****************************************************************************/
public class ToeplitzMatrix {

	/**
	 * Checks all of the diagonals to make sure the values are the same
	 * @param matrix Matrix to validate
	 * @return True if its a toeplitz.  False otherwise
	 */
	public boolean isToeplitz(int[][] matrix) {
		if(matrix == null || matrix.length < 1 || matrix[0].length <1) return false;
	
		// horizontal
		for (int i = 0; i < matrix[0].length; i++) 
			if( ! checkDiag(0,i, matrix) ) return false;
		// Vertical
		for (int i = 0; i < matrix.length; i++) 
			if(! checkDiag(i,0, matrix) ) return false;

		return true;
	}
	public boolean checkDiag(int y0, int x0, int[][] matrix) {
		if(matrix[y0] == null) return false;
		int val = matrix[y0][x0];
		for (int y = y0, x = x0; y < matrix.length && matrix[y] != null && x < matrix[y].length; ++y, ++x) 
			if(matrix[y].length < 1 || matrix[y][x] != val) 
				return false;
		return true;
	}
}











