package com.smt.kata.code;

import java.util.ArrayList;
// JDK 11.x
import java.util.Collection;
import java.util.List;

import com.siliconmtn.data.text.StringUtil;

/****************************************************************************
 * <b>Title:</b> AnagramIndicese.java
 * <b>Project:</b> SMT-Kata
 * <b>Description:</b> Anagram Indicie
 * 
 * Given a word W and a string S, find all starting indices in S which are anagrams of W.
 * 
 * For example, given that W is "ab", and S is "abxaba", return 0, 3, and 4.
 * 
 * Remember, we are working with words, not characters.  The indice is the first
 * index of W in S
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Apr 28, 2021
 * <b>updates:</b>
 * 
 ****************************************************************************/
public class AnagramIndices {

	/**
	 * Finds the location of each indices of w in s
	 * @param w characters to find
	 * @param s String to locate w
	 * @return Collection of indices locations.  Empty collection if none found
	 */
	public Collection<Integer> find(String w, String s) {
		List<Integer> indexes = new ArrayList<>(); 
		if(StringUtil.isEmpty(w) || StringUtil.isEmpty(s))
			return indexes;

		for (int index = s.indexOf(w); index >= 0; index = s.indexOf(w, index + 1)) 
				indexes.add(index);
		
		String rev = new StringBuilder(w).reverse().toString();
		if(!rev.equals(w))
			for (int index = s.indexOf(rev); index >= 0; index = s.indexOf(rev, index + 1))  
				indexes.add(index);
		
		return indexes;
	}
}
