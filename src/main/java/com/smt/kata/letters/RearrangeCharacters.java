package com.smt.kata.letters;

import java.util.Random;

import com.siliconmtn.data.text.StringUtil;

/****************************************************************************
 * <b>Title</b>: RearrangeCharacters.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Rearrange Charcters Kata
 * 
 * Given a string s, rearrange the characters so that any two adjacent characters 
 * are not the same. If this is not possible, return null.
 * 
 * For example, if s = yyz then return yzy. If s = yyy then return ""

 * <b>Copyright:</b> Copyright (c) 2022
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Jan 27, 2022
 * @updates:
 ****************************************************************************/
public class RearrangeCharacters {

	/**
	 * Rearranges letters in the word such that no two letters of the same are 
	 * adjacent to each other
	 * @param word Word to rearrange the letters
	 * @return Rearranged word
	 */
	public String arrange(String word) {
		if (StringUtil.isEmpty(word)) return "";
		if(word.length() < 2) return word;
		if(word.equals((word.charAt(0)+"").repeat(word.length()) )) return "";
		StringBuilder s = new StringBuilder(word);
		Random rand = new Random();
		
		for (int i = 0; i < s.length()-1; i++) {
			char cur = s.charAt(i);
			if(cur == s.charAt(i+1)) {
				s.deleteCharAt(i);
				s.insert(rand.nextInt(s.length()), cur);
				i = 0;
			}
		} 
		return s.toString();
	}
	
}
