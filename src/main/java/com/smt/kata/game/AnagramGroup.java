package com.smt.kata.game;

import java.util.ArrayList;
import java.util.Arrays;
// JDK 11.x
import java.util.Collection;
import java.util.List;

import com.siliconmtn.data.text.StringUtil;

/****************************************************************************
 * <b>Title</b>: AnagramGroup.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Anagram Group Kata
 * 
 * Given an array of strings, group anagrams together.
 * 
 * For example, given the following array:
 * 
 * ['eat', 'ate', 'apt', 'pat', 'tea', 'now']
 * 
 * Return:
 * 
 * [['eat', 'ate', 'tea'],
 *  ['apt', 'pat'],
 *  ['now']]
 *  
 *  Constraints
 *  All words must be lower case or converted to lower case if not.
 *  Return empty collection if source array is empty or null
 *  Skip all null words in the array
 *  
 * <b>Copyright:</b> Copyright (c) 2022
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Feb 21, 2022
 * @updates:
 ****************************************************************************/
public class AnagramGroup {

	/**
	 * Groups all of the words into anagrams
	 * @param words Array of words to group
	 * @return A collection of lists grouping the 
	 */
	public Collection<List<String>> findGroups(String[] words) {
		List<List<String>> groups = new ArrayList<>();
		if(words == null || words.length < 1) return groups;
		for (String word : words) {
			if(StringUtil.isEmpty(word)) continue;
			List<String> curWords = getAn(words, word);
			if(!curWords.isEmpty())
				groups.add(curWords);
		
		}
		System.out.println(groups.toString());
		return groups;
	}
	
	public List<String> getAn(String[] words, String word) {
		List<String> an = new ArrayList<>();
		char[] oC = word.toLowerCase().toCharArray();
		Arrays.sort(oC);
		if(StringUtil.isEmpty(word)) return an;
		for (String w : words) {
			if(StringUtil.isEmpty(w)) continue;
			char[] wC = w.toLowerCase().toCharArray();
			Arrays.sort(wC);
			if( !w.equalsIgnoreCase(word)  &&  Arrays.equals(wC, oC))
				an.add(w);
		}
		if(!an.isEmpty()) an.add(word);
		return an;
 	}
}
