package com.smt.kata.word;

/****************************************************************************
 * <b>Title</b>: TransposeMatrix.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Enter the Matrix
 * In this challenge, you have to obtain a sentence from the elements of a given 
 * matrix. In the matrix, each word of the sentence follows a columnar order from 
 * the top to the bottom, instead of the usual left-to-right order: 
 * it's time for transposition! 
 * 
 * Given a matrix mtx, implement a function that returns the complete sentence as 
 * a string, with the words separated by a space between them.
 * 
 * Notes
 * All given matrices are regular, as to say that each column has the same length.
 * Punctuation is already given.
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Mar 1, 2021
 * @updates:
 ****************************************************************************/
public class TransposeMatrix {

	/**
	 * 
	 */
	public TransposeMatrix() {
		super();
	}

	/**
	 * Performs the transposing of the array into a String
	 * @param matrix
	 * @return
	 */
	public String parse(String[][] matrix) {
		if(matrix == null || matrix.length <1)
			return "";

		return parse(matrix, "", 0, 0);
	}
	public String parse(String[][] matrix, String sentence, int y, int x) {
		return (y >= matrix.length-1 && x >= matrix[matrix.length-1].length-1) ? (sentence += " " + matrix[y][x]).trim() : (parse(matrix, (sentence += " " + matrix[y][x]), (y >= matrix.length-1 ? 0 : y+1), (y >=matrix.length-1 ? x+1 : x)));
	}
}
