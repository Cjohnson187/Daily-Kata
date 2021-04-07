package com.smt.kata.math;

/****************************************************************************
 * <b>Title:</b> CountingParens.java
 * <b>Project:</b> SMT-Kata
 * <b>Description:</b> Counting Parenthesis
 * 
 * Given a string of parentheses, write a function to compute the minimum number of 
 * parentheses to be removed to make the string valid (i.e. each open parenthesis 
 * is eventually closed).
 * 
 * For example, given the string "()())()", you should return 1. 
 * Given the string ")(", you should return 2, since we must remove all of them.
 * 
 * Any non-alphanumeric characters (other than parenthesis) should be removed from 
 * the source string
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Apr 2, 2021
 * <b>updates:</b>
 * 
 ****************************************************************************/
public class CountingParens {

	/**
	 * 
	 * @param parens
	 * @return
	 */
	public int calculate(String parens) {
		if (parens == null ) {
			return 0;
		}
		int rem = 0;
		int left = 0;
		
		for (int i = 0; i < parens.length(); i++) {
			if (parens.charAt(i) == '(') {
				left++;
			}
			else if (parens.charAt(i) == ')') {
				if ( left-1 < 0) {
					rem++;
				}
				else left--;
			}

		}
		if (Math.abs(left)>0) rem+=Math.abs(left);
		

		return rem;
	}
}
