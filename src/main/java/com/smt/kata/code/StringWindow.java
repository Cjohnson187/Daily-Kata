package com.smt.kata.code;

import com.siliconmtn.data.text.StringUtil;

/****************************************************************************
 * <b>Title</b>: StringWindow.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> String Window Kata
 * 
 * Given a string, find the length of the smallest window that contains every 
 * distinct character. Characters may appear more than once in the window.
 * 
 * For example, given "jiujitsu", you should return 5, corresponding to the final 
 * five letters.
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Nov 30, 2021
 * @updates:
 ****************************************************************************/
public class StringWindow {

	/**
	 * Find the length of the smallest window
	 * @param word Word to find the window
	 * @return Smallest Window.  0 is returned if invalid data.
	 */
	public int find(String word) {
		if(StringUtil.isEmpty(word)) return 0;
		String unique = getUnique(word.toLowerCase());
		
		int range = word.length();
		for (int i = 0; i < word.length(); i++) {
			int len = check(word.toLowerCase().substring(i), unique, 0, word.length());
			if(len < range) range = len;
		}

		return range;
	}
	public int check(String word, String un, int len, int max) {
		boolean count = false;
		for (int i = 0; i < word.length(); i++) {
			if(!StringUtil.isEmpty(un) &&  count == true) len++;
			for (int j = 0;! StringUtil.isEmpty(un) && j < un.length(); j++) {
				if(word.charAt(i) == un.charAt(j)) {
					if(count == false) {
						count = true;
						len++;
					}
					un= un.replace(un.charAt(j)+"", "");
					break;
				}
			}
		}
		return StringUtil.isEmpty(un) ? len: max;
	}
	
	public String getUnique(String word) {
		String lets = "";
		for (int i = 0; i < word.length(); i++) 
			if (!lets.contains(word.charAt(i)+"")) 
				lets += word.charAt(i);
		return lets;
	}

}
