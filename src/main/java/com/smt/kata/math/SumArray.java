package com.smt.kata.math;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.stream.IntStream;

/****************************************************************************
 * <b>Title</b>: SumArray.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Sum Array Kata
 * 
 * Given a list of numbers L, implement a method sum(i, j) which returns the sum 
 * from the sublist L[i:j] (including i, excluding j).
 * 
 * For example, given L = [1, 2, 3, 4, 5], sum(1, 3) should return sum([2, 3]), 
 * which is 5.
 * 
 * <b>Copyright:</b> Copyright (c) 2022
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Feb 24, 2022
 * @updates:
 ****************************************************************************/
public class SumArray {
	private int[] vals;
	private int sum = 0;
	/**
	 * Constructor to assigns vals
	 * @param vals
	 */
	public SumArray(int[] vals) {
		this.vals = vals;
		this.sum = IntStream.of(vals).sum();
		
	}
	
	/**
	 * Sums range of elments in the vals array
	 * @param i Start index
	 * @param j End index
	 * @return Sum of values in range
	 */
	public int sum(int i, int j) {
		return vals[i] + vals[j];
	}

}
