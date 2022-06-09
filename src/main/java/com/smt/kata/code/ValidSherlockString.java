package com.smt.kata.code;

import java.util.HashMap;
import java.util.Map;

/****************************************************************************
 * <b>Title</b>: ValidSherlockString.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Sherlock considers a string to be valid if all characters of the string appear 
 * the same number of times. It is also valid if he can remove just 1 character at 
 * 1 index in the string, and the remaining characters will occur the same number of times. 
 * Given a string str, determine if it is valid. If so, return "YES", otherwise return "NO".
 * 
 * For example, If str = "abc", the string is valid because the frequencies of characters 
 * are all the same. If str = "abcc", the string is also valid, because we can 
 * remove 1 "c" and have one of each character remaining in the string. However, 
 * if str = "abccc", the string is not valid, because removing one character does not 
 * result in the same frequency of characters.
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Jan 5, 2021
 * @updates:
 ****************************************************************************/
public class ValidSherlockString {

	/**
	 * Reverse the number and compare to the original
	 * @param startNumber
	 * @return
	 */
	public boolean isValid(String sequence) {

		int mult = 0;
		int freq = 0; 
		Map<Character, Integer> m = new HashMap<>();
	
		char check = sequence.charAt(0);

		for (char c : sequence.toCharArray()) {
			if (m.containsKey(c)) m.put(c, m.get(c)+1);
			else m.put(c, 1);
			if (c == check ) freq ++;
		}
		int count = m.get(sequence.charAt(0));
//		for (var v: m.entrySet()) {
//			if (v.getValue() > count) mult++;
//			if(v.getValue() > freq+1 ) return false;
//			if(v.getValue() < freq ) return false;
//		}	
 		return mult <= 2 ;
	}
}
