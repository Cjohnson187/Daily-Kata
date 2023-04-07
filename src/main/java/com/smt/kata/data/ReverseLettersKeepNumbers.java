package com.smt.kata.data;

import java.util.*;

/****************************************************************************
 * <b>Title</b>: MissingNumber.java 
 * <b>Project</b>: SMT-Kata 
 * <b>Description: </b> Create a method that reverses letters in a string but 
 * keeps digits in their current order.
 * <b>Copyright:</b> Copyright (c) 2020 
 * <b>Company:</b> SiliconMountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Dec 21, 2020
 * @updates:
 ****************************************************************************/
public class ReverseLettersKeepNumbers {

	/**
	 * Reverses a string keeping the numbers in place
	 * @param cWord
	 * @return
	 */
	public String reverse(char[] cWord) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < cWord.length; i++) {
			if(cWord[i] > 58) {
				stack.push(cWord[i]);
				cWord[i] = 127;
			}
		}
		for (int i = 0; i < cWord.length; i++) {
			if (cWord[i] == 127) cWord[i] = stack.pop();
		}

		return new String(cWord);
	}
}