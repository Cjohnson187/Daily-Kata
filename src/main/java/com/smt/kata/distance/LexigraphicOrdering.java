package com.smt.kata.distance;

import static org.mockito.Mockito.spy;

import java.util.ArrayList;
import java.util.List;

/****************************************************************************
 * <b>Title:</b> LexigraphicOrdering.java
 * <b>Project:</b> SMT-Kata
 * <b>Description:</b> Lexigraphic Ordering
 * 
 * You are given an N by M 2D matrix of lowercase letters. Determine the minimum 
 * number of columns that can be removed to ensure that each row is ordered from 
 * top to bottom lexicographically. That is, the letter at each column is 
 * lexicographically later as you go down each row. It does not matter whether 
 * each row itself is ordered lexicographically.
 * 
 * For example, given the following table:
 * 
 * cba
 * daf
 * ghi
 * 
 * This is not ordered because of the a in the center. We can remove the second 
 * column to make it ordered:
 * 
 * ca
 * df
 * gi
 * 
 * So your function should return the above updated Matrix, since we only needed to remove 1 column.
 * As another example, given the following table:
 * 
 * abcdef
 * 
 * Your function should return the original, since the rows are already ordered (there's only one row).
 * As another example, given the following table:
 * 
 * zyx
 * wvu
 * tsr
 * 
 * Your function should return an empty matrix, since we would need to remove all the columns to order it.
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Mar 23, 2021
 * <b>updates:</b>
 * 
 ****************************************************************************/
public class LexigraphicOrdering {

	/**
	 * Reorders the columns based upon lexigraphic order
	 * @param data matrix data to process
	 * @return matrix of data that is properly ordered
	 */
	public char[][] orderData(char[][] data) {
		List<String> rows = new ArrayList();
		List<String> cols = new ArrayList();
		// get rows
		if (data.length == 0 || data[0].length == 1) {
			return new char[0][0];
		}
		// get rows
		for (int i = 0 ; i < data.length ; i++) {	
			String row = "";
			for (int j = 0 ; j < data.length ; j++) {
				System.out.println("rows = " + data[i][j]);
				row += data[i][j];
			}
			rows.add(row);
		}
	
		
		// get cols
		for (int i = 0 ; i < data.length ; i++) {	
			String col = "";
			for (int j = 0 ; j < data.length ; j++) {
				System.out.println("cols = " + data[j][i]);
				col += data[j][i];
			}
			cols.add(col);
		}
		
		// check order
		

		for (int i= 0; i < rows.size(); i++  ) { 
			int prev = 0;
			for (char current : rows.get(i).toCharArray()) {
		        if (current < prev) {
		        	rows.remove(i);
		        	i--;
		        	break;
		        	
		        }
		        else prev = current;
		    }

		}
		
		for (int i= 0; i < cols.size(); i++  ) { 
			int prev = 0;
			for (char current : cols.get(i).toCharArray()) {
		        if (current < prev) {
		        	cols.remove(i);
		        	i--;
		        	break;
		        	
		        }
		        else prev = current;
		    }
			
		}
		System.out.println("cols size = " + cols.size());
		System.out.println("rows size = " + rows.size());
		
		char[][] end = new char[rows.size()][cols.size()];
		
		// get rows
		for (int i = 0 ; i < data.length ; i++) {	
			end[i] = rows.get(i).toCharArray();
		}
	

		
		return end;
	}
	

}
