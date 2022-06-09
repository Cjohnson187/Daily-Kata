package com.smt.kata.word;

import java.util.Arrays;
import java.util.function.BinaryOperator;

import org.apache.commons.lang3.StringUtils;

/****************************************************************************
 * <b>Title</b>: WordRank.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Word Rank
 * Take a phrase and evaluate each word in the phrase.  Add up all of the values for
 * each word.  Return the word in the phrase that has the highest value.  If two words
 * share the same value, use the first value.  The values will be a=1, b=2, ....
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Mar 1, 2021
 * @updates:
 ****************************************************************************/
public class WordRank {

	/**
	 * 
	 */
	public WordRank() {
		super();
	}

	/**
	 * Ranks the words and returns the proper entry
	 * @param phrase
	 * @return
	 */
	public String calculate(String phrase) {
		if(StringUtils.isEmpty(phrase)) return "";
		
		
		System.out.println(phrase);
		String[] words = phrase.split("");
		int index= 0;
		for (int i = 0; i < words.length; i++) {
			int val = Arrays.asList(words[i].split("")).stream().reduce(0, (total, el) -> total + el.charAt(0), Integer::sum);
			System.out.println(val);
		}
		
		return phrase;
	}
	
	
}
