package com.smt.kata.math;

/****************************************************************************
 * <b>Title</b>: PythagoreamTriplet.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Pythagorean Triplet Kata
 * 
 * Given an array of integers, determine whether it contains a Pythagorean triplet. 
 * Recall that a Pythogorean triplet (a, b, c) is defined by the equation a2 + b2 = c2.
 * 
 * Example:
 * input: [9, 3, 7, 5, 4]
 * result: true (3sq + 4sq = 5sq)
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Oct 22, 2021
 * @updates:
 ****************************************************************************/
public class PythagoreamTriplet {

	/**
	 * Checks to see if any of the triplets in the values array make a 
	 * pythagoream theory equate to true
	 * @param values Array of numbers to evaluate
	 * @return True if 3 values match pythagoreams thereom.  False otherwise
	 */
	public boolean hasMatch(int[] values) {
		int matches = 0; 
		for (int i = 0; i < values.length; i++) {
			for (int j = 0; j < values.length; j++) {
				
			}
		}
		return matches == 3;
	}
	
	public void coprimePairs() {
		
	}
	
	public int euclid(int a, int b)  {
		int r = a%b;
		int c = a/b;
		if (r > 0 ) return euclid(b, r) ;
		else return b;
	}
}
