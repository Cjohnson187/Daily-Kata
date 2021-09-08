package com.smt.kata.data;

import com.siliconmtn.data.text.StringUtil;

/****************************************************************************
 * <b>Title</b>: MatchingSubsequence.java <b>Project</b>: Daily-Kata
 * <b>Description: </b> Matching Subsequence Kata
 * 
 * Given a string s and an array of strings words, return the number of words[i]
 * that is a subsequence of s.
 * 
 * A subsequence of a string is a new string generated from the original string
 * with some characters (can be none) deleted without changing the relative
 * order of the remaining characters.
 * 
 * For example, "ace" is a subsequence of "abcde".
 * 
 * Example 1: Input: s = "abcde", words = ["a","bb","acd","ace"] Output: 3
 * Explanation: There are three strings in words that are a subsequence of s:
 * "a", "acd", "ace".
 * 
 * Example 2: Input: s = "dsahjpjauf", words =
 * ["ahjpjau","ja","ahbwzgqnuk","tnmlanowax"] Output: 2
 * 
 * <b>Copyright:</b> Copyright (c) 2021 <b>Company:</b> Silicon Mountain
 * Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Aug 24, 2021
 * @updates:
 ****************************************************************************/
public class MatchingSubsequence {

	/**
	 * Finds how many of the words in the array match as subsequences inside the
	 * source
	 * 
	 * @param source Source string to compare against
	 * @param words  Words to evaluate for subsequences in the source
	 * @return Number of matches
	 */
	public int match(String source, String[] words) {
		if(words == null) return 0;
		int match = 0;
		for (String s : words) {
			if(StringUtil.isEmpty(s) || StringUtil.isEmpty(source)) continue;
			int j = 0;
			int i = 0;
			while ( i < source.length() && j < s.length()) {
				if ((source.charAt(i) + "").equalsIgnoreCase(s.charAt(j) + "")) {
					j++;
				}
				i++;
			}
			if (j == s.length()) {
				match++;
				i = 0;
				j = 0;
			}
		}

		return match;
	}
}
