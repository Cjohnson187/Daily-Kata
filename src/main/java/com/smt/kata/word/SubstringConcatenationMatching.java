package com.smt.kata.word;

// JDK 11.x
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.siliconmtn.data.text.StringUtil;

/****************************************************************************
 * <b>Title</b>: SubstringConcatenationMatching.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Substring with Concatenation of All Words Kata
 * 
 * You are given a string s and an array of strings words of the same length. 
 * Return all starting indices of substring(s) in s that is a concatenation of 
 * each word in words exactly once, in any order, and without any intervening 
 * characters.
 * 
 * You can return the answer in any order.
 * 
 * Example 1:
 * Input: s = "barfoothefoobarman", words = ["foo","bar"]
 * Output: [0,9]
 * Explanation: Substrings starting at index 0 and 9 are "barfoo" and "foobar" respectively.
 * The output order does not matter, returning [9,0] is fine too.
 * 
 * Example 2:
 * Input: s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
 * Output: []
 * 
 * Example 3:
 * Input: s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
 * Output: [6,9,12]
 

Constraints:
1 <= s.length <= 104
s consists of lower-case English letters.
1 <= words.length <= 5000
1 <= words[i].length <= 30
words[i] consists of lower-case English letters.
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Nov 4, 2021
 * @updates:
 ****************************************************************************/
public class SubstringConcatenationMatching {

	/**
	 * Finds the indexes of the matches of the words in any order in the phrase
	 * @param phrase Phrase to locate the substrings
	 * @param words Words to find
	 * @return List of matching indexes
	 */
	public List<Integer> find(String phrase, String[] words) {
		List<Integer> ret = new ArrayList<>();
		if(phrase == null||phrase.length() >= 104 || phrase.length() <1  || words == null || words.length < 1 || words.length > 5000) 
			return ret;
		
		List<String> ww = new ArrayList<>();
		ww  = buildWords(new ArrayList<String>( Arrays.asList(words)), "",ww);
		
		phrase = phrase.toLowerCase();
		
		for(String word : ww) {
			if(word.length() < 1 || word.length() >30) 
				continue;
			for(int i =0 ; i < phrase.length(); i++) {
				if(phrase.substring(i).contains(word)) {
					ret.add(phrase.substring(0 ,  i).length() + phrase.substring(i).indexOf(word));
					i =phrase.substring(0, i).length() + phrase.substring(i).indexOf(word) + word.length();
				}
			}
		}
		
		return ret;
	}
	
	public List<String> buildWords(List<String> words, String word, List<String> cat) {
		words.remove(null);
		if(words.isEmpty())  {
			cat.add(word.toLowerCase());
			return cat;
		}

		for(String w : words) {
			List<String> rem = new ArrayList<String>(words);
			rem.remove(rem.indexOf(w));
 			buildWords(rem, word+w , cat);
		}

		return cat;
	}
}
