package com.smt.kata.letters;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.siliconmtn.data.text.StringUtil;

/****************************************************************************
 * <b>Title</b>: ReorderLetters.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Reorder Letters Kata
 * 
 * Given a string, sort it in decreasing order based on the frequency of characters. 
 * If there are multiple characters with the same count, the letters should be
 * sorted alphabetically.  Same letter with different case should be consider as 
 * 2 different characters
 * 
 * Example One
 * Input: tweet
 * Output: eettw
 * 
 * Example Two
 * Input: TwEet
 * Output: ETetw
 * 
 * Empty/Null
 * Input: null or ""
 * Output: ""
 * 
 * <b>Copyright:</b> Copyright (c) 2022
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Jan 31, 2022
 * @updates:
 ****************************************************************************/
public class ReorderLetters {

	/**
	 * Reorders the letters based upon the total number each character is present and 
	 * then ordered alphabetically.
	 * @param word Word to reorder it's letters
	 * @return Reordered word
	 */
	public String process(String word) {
		if(StringUtil.isEmpty(word)) return "";
		Map<Character, String> let = new HashMap<>();
		
		for(char c: word.toCharArray()) {
			if(!let.containsKey(c) ) {
				let.put(c, ""+c);
			} else {
				String n = let.get(c) + (""+c);
				let.put(c, n );
			}
		}
		LinkedHashMap<Character, String> sortedMap = new LinkedHashMap<>();
		let.entrySet()
	    .stream()
	    .sorted(Map.Entry.comparingByValue())
	    .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));
		String ret ="";
		
		for (Map.Entry<Character, String> v : sortedMap.entrySet()) {
			ret += v.getValue();
		}
		
		return ret;
	}
}
