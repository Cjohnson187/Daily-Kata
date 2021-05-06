package com.smt.kata.code;

import java.util.List;
import java.util.ArrayList;
// JDK 11.x
import java.util.Collection;

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
		List<Integer> in = new ArrayList<>();
		String s2 = s;
		if (StringUtil.isEmpty(s) || StringUtil.isEmpty(w))
			return in;
		int index = 0;
		while (s.contains(w)) {
			
			System.out.println("s1 = " + s +" index of w  + index"+(s.indexOf(w) + index ));
			in.add((s.indexOf(w)+index));
			
			//index = (s.indexOf(w)+ index + w.length()); 
			index = (s.indexOf(w) + w.length()); 
			
			s = s.substring(s.indexOf(w) +w.length() );
			
			
			System.out.println(index+" s = " + s +" "+(s.indexOf(w) + index));
			
		}
		StringBuilder a = new StringBuilder(s2);
		String w2 = a.reverse().toString();
		while (s.contains(w2)) {
			
			System.out.println("s1 = " + s +" index of w  + index"+(s.indexOf(w2) + index ));
			in.add((s.indexOf(w2)+index));
			
			//index = (s.indexOf(w)+ index + w.length()); 
			index = (s.indexOf(w2) + w2.length()); 
			
			s = s.substring(s.indexOf(w2) +w2.length() );
			
			
			System.out.println(index+" s = " + s +" "+(s.indexOf(w2) + index));
			
		}
		
		
		
		return in;
	}
}
