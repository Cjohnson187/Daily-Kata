package com.smt.kata.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/****************************************************************************
 * <b>Title</b>: SortMatrixDiagonally.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Sort the Matrix Diagonally Kata
 * 
 * A matrix diagonal is a diagonal line of cells starting from some cell in 
 * either the topmost row or leftmost column and going in the bottom-right direction 
 * until reaching the matrix's end. For example, the matrix diagonal starting 
 * from mat[2][0], where mat is a 6 x 3 matrix, includes cells mat[2][0], mat[3][1], and mat[4][2].
 * 
 * Given an m x n matrix mat of integers, sort each matrix diagonal in ascending order and return the resulting matrix.
 * 
 * Example 1:
 * https://assets.leetcode.com/uploads/2020/01/21/1482_example_1_2.png
 * Input: mat = [[3,3,1,1],[2,2,1,2],[1,1,1,2]]
 * Output: [
 * 	[3,3,1,1] [1,1,1,1],
 * 	[2,2,1,2] [1,2,2,2],
 * 	[1,1,1,2] [1,2,3,3]
 * ]
 * 
 * Example 2:
 * Input: mat = [[11,25,66,1,69,7],[23,55,17,45,15,52],[75,31,36,44,58,8],[22,27,33,25,68,4],[84,28,14,11,5,50]]
 * Output: [
 * 	[11,25,66, 1,69, 7] [8, 11, 11, 14, 15, 17]
 * 	[23,55,17,45,15,52] [7, 25, 27, 28, 31, 33]
 * 	[75,31,36,44,58, 8] [5, 25, 45, 50, 52, 55]
 * 	[22,27,33,25,68, 4] [4, 23, 44, 66, 68, 69]
 * 	[84,28,14,11, 5,50] [1, 22, 36, 58, 75, 84]
 * ]
 * 
 * 
 * 3311
 * 2212
 * 5678
 * 
 * 1321
 *  112
 *   32
 *   
 * 211
 * 232
 * 567
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Sep 16, 2021
 * @updates:
 ****************************************************************************/
public class SortMatrixDiagonally {

	
	public List<Integer> sorted;
	int[][] matrix0;
	int index;
	/**
	 * Sorts the matrix into diagonally ordered matrix
	 * @param matrix Matrix to be sorted
	 * @return A sorted matrix
	 */
	public int[][] sort(int[][] matrix) {
		if (matrix == null || matrix.length < 1) return new int[0][];
		
		matrix0 = new int[matrix.length][matrix[0].length];
		sorted = new ArrayList<>();
		index = 0;
		
		for (int[] in : matrix) {
			for (int inner : in) {
				sorted.add(inner);
			}
		}
		matrix0 = matrix;
		Collections.sort(sorted); 
		
		int[] coord = new int[2];
		coord[0] = 0; // x pos
		coord[1] =0;  // y limit
		
		while (coord[0] < matrix0[0].length && coord[1] < matrix0.length) {
			fillUp(coord);
			coord[0]++;
			fillRight(coord);
			coord[1]++;
		}
	
		return matrix0;
	}
	
	
	public void fillUp(int[] coord){
		for (int y=matrix0.length-1; y >=coord[1]; y--) {
			matrix0[coord[0]][y] = sorted.get(index);
			index++;
		}	
	}
	
	public void fillRight(int[] coord){
		for (int x=coord[0]; x < matrix0[coord[1]].length; x++) {
			matrix0[coord[1]][x] = sorted.get(index);
			index++;
		}
	}
	
}


















