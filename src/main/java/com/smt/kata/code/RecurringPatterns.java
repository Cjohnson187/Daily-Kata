package com.smt.kata.code;

// JDK 11.x
import java.util.ArrayList;
import java.util.List;

/****************************************************************************
 * <b>Title</b>: RecurringPatterns.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Recurring Patterns Kata
 * 
 * Given a string and a pattern, find the starting indices of all occurrences of 
 * the pattern in the string. For example, given the string "abracadabra" and 
 * the pattern "abr", you should return [0, 7]
 * 
 * Any spaces in the word or the should be ignored
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Aug 10, 2021
 * @updates:
 ****************************************************************************/
public class RecurringPatterns {

	/**
	 * Gets the number of occurrences of a pattern in a word
	 * @param pattern Pattern to evaluate
	 * @param word word to search against
	 * @return starting location of all patterms
	 */
	public List<Integer> count(String word, String pattern) {
		int index = 0;
		String rem = word;
		int lenrem = 0;
		List<Integer> found = new ArrayList<>();
		while(word.contains(pattern)) {
			if(word.contains(pattern) ) {
				System.out.println("index = " + word.indexOf(pattern) + "   len rem" + (word.indexOf(pattern) + pattern.length()) + "  word " + word);
				lenrem += (word.indexOf(pattern) + pattern.length());
				word = word.substring(word.indexOf(pattern) + pattern.length());
				System.out.println("lenrem = " + lenrem);
				found.add(lenrem);
			}
		}
		

		
		return found;
	}

}
