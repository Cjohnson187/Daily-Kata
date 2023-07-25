package com.smt.kata.data;

import java.util.Comparator;

/****************************************************************************
 * <b>Title</b>: StrobogrammaticNumber.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Strobogrammatic Number Kata
 * 
 * A strobogrammatic number is a positive number that appears the same after 
 * being rotated 180 degrees. For example, 16891 is strobogrammatic.
 * 
 * Create a program that finds all strobogrammatic numbers with N digits.
 * 
 * <b>Copyright:</b> Copyright (c) 2022
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Feb 22, 2022
 * @updates:
 ****************************************************************************/
public class StrobogrammaticNumber {
	
	/**
	 * Determines if a number is strobomatic
	 * @param source Number to evaluate
	 * @return True if stobomatic.  False otherwise
	 */
	public boolean isStrobogrammaticNumber(int source) {
		if(source < 1) return false;
		Comparator<String> spin = new Comparator<>() {
			@Override
			public int compare(String s, String t1) {
				for (int i = 0; i < s.length(); i++) {
					if(s.charAt(i) != t1.charAt(i) || s.charAt(i) == '9' || s.charAt(i) == '6'){
						if ((s.charAt(i) == '6' && t1.charAt(i) == '9') || (s.charAt(i) == '9' && t1.charAt(i) == '6')) continue;
						else return -1;
					}
				}
				return 0;
			}
		};

		String rev = new StringBuilder((source+"")).reverse().toString();
		return spin.compare((source+""), rev.toString()) == 0;
	}

//	public boolean isStrobogrammaticNumber(int source) {
//		if(source < 1) return false;
//		String s = source +"";
//
//		for (int i = 0 ,j= s.length()-1; i < s.length()/2 && j > (s.length()/2); i++, j--) {
//			if((s.charAt(i) == '9' && s.charAt(j) == '9') || (s.charAt(i) == '6' && s.charAt(j) == '6'))
//				return false;
//			else if((s.charAt(i) == '9' && s.charAt(j) == '6')|| (s.charAt(i) == '6' && s.charAt(j) == '9') || s.charAt(i) == s.charAt(j))
//				continue;
//			else
//				return false;
//		}
//
//		return true;
//	}

}
