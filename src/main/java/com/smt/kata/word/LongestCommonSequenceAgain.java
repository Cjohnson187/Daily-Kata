package com.smt.kata.word;

import java.util.ArrayList;
import java.util.List;

import com.siliconmtn.data.text.StringUtil;

/****************************************************************************
 * <b>Title</b>: LongestCommonSequenceAgain.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Longest Common Sequence Again Kata
 *  
 * Write a program that computes the length of the longest common subsequence of 
 * a variable number of given strings. For example, given "epidemiologist", "refrigeration", 
 * and "believingmore", it should return "eieio" since that is the longest common subsequence.
 * 
 * The sequences are case sensitive.  The sequences do not need to be sequntial,
 * though they must be in order.
 * 
 * Another Example
 * Given: "bat", "hat", "cat"
 * Return: "at"
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Aug 12, 2021
 * @updates:
 ****************************************************************************/
public class LongestCommonSequenceAgain {
	

	/**
	 * Calculates the longest matching sequence of the words
	 * @param words Words to evaluate
	 * @return Longest sequence in all words
	 */
	public String getSequence(String[] wordsArray) {
		if(wordsArray == null || wordsArray.length < 2) return "";
		for(String s: wordsArray)
			if(StringUtil.isEmpty(s)) return "";
		List<String> segments = new ArrayList<>();

		
		String longestWord = "";
		int[] indexes = new int[wordsArray.length];
		for(int x = 0; x < wordsArray[0].length(); x++){

			char c = wordsArray[0].charAt(x);
			int[] indexes2 = new int[wordsArray.length];
			boolean wasFoundInAll = true;
			for(int y = 1; y < wordsArray.length; y++){
				int index = wordsArray[y].indexOf(c, indexes[y]);
				if(index < 0){
					wasFoundInAll = false;
					break;
				}else
					indexes2[y] = index + 1;
			}

			if(wasFoundInAll){
				longestWord += c;
				indexes = indexes2;
			}
		}
		
		// Return the longest match
		return longestWord;
	}
}
