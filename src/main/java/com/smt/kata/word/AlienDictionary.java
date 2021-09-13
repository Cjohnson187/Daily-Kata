package com.smt.kata.word;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;

import com.siliconmtn.data.text.StringUtil;




/****************************************************************************
 * <b>Title</b>: AlienDictionary.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Alien Dictionary Kata
 * 
 * In an alien language, surprisingly, they also use English lowercase letters, 
 * but possibly in a different order. The order of the alphabet is some permutation 
 * of lowercase letters.
 * 
 * Given a sequence of words written in the alien language, and the order of the alphabet, 
 * return true if and only if the given words are sorted lexicographically in this alien language.
 * 
 * Example 1:
 * Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
 * Output: true
 * Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
 * 
 * Example 2:
 * Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
 * Output: false
 * Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], 
 * hence the sequence is unsorted.
 * 
 * Example 3:
 * Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
 * Output: false
 * Explanation: The first three characters "app" match, and the second string is 
 * shorter (in size.) According to lexicographical rules "apple" > "app", 
 * because 'l' > '∅', where '∅' is defined as the blank character which is less 
 * than any other character (More info).
 * 
 * Constraints:
 * 1 <= words.length <= 100
 * 1 <= words[i].length <= 20
 * order.length == 26
 * 
 * All characters in words[i] and order are English lowercase letters.
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Sep 7, 2021
 * @updates:
 ****************************************************************************/
public class AlienDictionary {
	public static String order;
	/**
	 * Initializes the class with the new alphabet order
	 * @param order Order of the letters in the new alphabet
	 * @throws DatatypeConfigurationException If the order of letters is invalid
	 */
	public AlienDictionary(String order) throws DatatypeConfigurationException {
		super();
		if(order.length() != 26)
			throw new DatatypeConfigurationException("Don't do this");
		
		this.order = order;
	}

	/**
	 * Determines if the provided words are in order
	 * @param words Words to check
	 * @return True if the words are in order and false otherwise
	 */
	public boolean isSorted(String[] words) {
		if(words == null  ||words.length <= 1  ) {
			return false;
		}
		List<Integer> wordVals = new ArrayList<>();
		for(String word: words) {
			int val = 0;
			
			if (StringUtil.isEmpty(word)) continue;
			word = word.toLowerCase();
			for (char c: word.toCharArray()) {
				val += order.indexOf((c+"").toLowerCase());
			}
			wordVals.add(val);
			System.out.println("word = " + word );
		}
		for (int i = 1; i < wordVals.size(); i++) {
			int prev = wordVals.get(i-1);
			System.out.println("prev val = " + prev +"  " + wordVals.get(i) + "  " + (prev > wordVals.get(i)) );
		
			if(prev < wordVals.get(i)) return true;
			
		}

//		for(int x=1; x< words.length; x++) {
//			if(StringUtil.isEmpty( words[x])) {
//				String temp=words[x-1];
//				words[x-1] = words[x];
//				words[x] =temp;
//				continue;
//			}
//			words[x] = words[x].toLowerCase();
//			int prevW = 0;
//			int nextW = 0;
//			
//			for(int i=0; i< words[x-1].length() && i < words[x].length(); i++) {
//				prevW += order.indexOf( (words[x-1].charAt(i)+"") );
//				nextW += order.indexOf( (words[x].charAt(i)+"") );
//			}
//			if(prevW >= nextW) return false;
//		}

		return false;
	}
}
