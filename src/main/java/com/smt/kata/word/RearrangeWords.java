package com.smt.kata.word;

import java.util.ArrayList;
import java.util.Arrays;
// JDK 11.x
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.siliconmtn.data.text.StringUtil;


/****************************************************************************
 * <b>Title</b>: RearrangeWords.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Rearrange Words Kata
 * 
 * Given a string with repeated characters, rearrange the string so that no two 
 * adjacent characters are the same. If this is not possible, return None.  Return a 
 * collection of all of the possible variations that can occur with no two
 * characters repeated
 * 
 * If the word passed in already has no repeating characters, return just that word
 * 
 * For example, given "aaabbc", you could return :
 * ababac, ababca, abacab, abacba, abcaba, acabab, acbaba, babaca, bacaba, cababa 
 * 
 * Given "aaab", return an empty collection.
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Aug 30, 2021
 * @updates:
 ****************************************************************************/
public class RearrangeWords {

	/**
	 * Rearranges the characters in a word such that there are no 2 adjacent characters
	 * @param word Word to rearrange
	 * @return All the possible ways the word can be rearranged to not have sequential characters
	 */
	public Collection<String> arrange(String word) {
		if(StringUtil.isEmpty(word) || word.length() < 2) return new ArrayList<>();
		for(char c : word.toLowerCase().toCharArray()) {
			if(c  > 122 || c < 97) {
				return new ArrayList<>();
			}
		}
		return isValid(word) ? Arrays.asList(word):  reArrangeWord("", word, new ArrayList<String>());
	}
	public List<String> reArrangeWord(String prefix ,String word, List<String> words){
		int n = word.length();
		if(n == 0 && !words.contains(prefix) && isValid(prefix)) {
			words.add(prefix);
		}
		else {
			for (int i = 0; i < n; i++) {
				reArrangeWord((prefix+ word.charAt(i)), (word.substring(0, i) + word.substring(i+1, n))  , words );	
			}
		}
		return words;
	}
	public boolean isValid(String word) {
		
		for (int i = 1; i < word.length(); i++) {
			char prev = word.charAt(i-1);
			if (word.charAt(i) == prev) return false;
		}
		return true;
	}

}
