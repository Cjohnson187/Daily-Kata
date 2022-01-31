package com.smt.kata.code;

import org.apache.commons.lang3.StringUtils;

/****************************************************************************
 * <b>Title</b>: SoundexConverter.java <b>Project</b>: SMT-Kata <b>Description:
 * </b> Soundex Converter Kata Soundex is an algorithm used to categorize
 * phonetically, such that two names that sound alike but are spelled
 * differently have the same representation.
 * 
 * Soundex maps every name to a string consisting of one letter and three
 * numbers, like M460.
 * 
 * One version of the algorithm is as follows:
 * 
 * Remove consecutive consonants with the same sound (for example, change ck ->
 * c). Keep the first letter. The remaining steps only apply to the rest of the
 * string. Remove all vowels, including y, w, and h. Replace all consonants with
 * the following digits:
 * 
 * b, f, p, v → 1 c, g, j, k, q, s, x, z → 2 d, t → 3 l → 4 m, n → 5 r → 6
 * 
 * If you don't have three numbers yet, append zeros until you do. Keep the
 * first three numbers. Using this scheme, Jackson and Jaxen both map to J250.
 * 
 * <b>Copyright:</b> Copyright (c) 2022 <b>Company:</b> Silicon Mountain
 * Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Jan 3, 2022
 * @updates:
 ****************************************************************************/
public class SoundexConverter {

	/**
	 * Converts the word into a soundex word
	 * 
	 * @param word Word to convert
	 * @return Soundex word. Blank word if word is empty or contains numbers
	 */
	public String convert(String word) {
		if (StringUtils.isEmpty(word) || word.matches(".*\\d.*"))
			return "";
		String first = word.charAt(0) + "";
		word = word.toLowerCase();
		word = con(word.substring(1));
		word = adj(word);
		word = first.toUpperCase() + word;
		System.out.println("word = " + word);
		if (word.length() < 4)
			word += "0".repeat(4 - word.length());
		else if (word.length() > 4)
			word = word.substring(0, 4);
		return word;
	}

	public String con(String word) {
		String c = "";
		for (char l : word.toCharArray()) {

			if (l == 'b' | l == 'f' | l == 'p' | l == 'v') {
				c += "1";
			} else if (l == 'c' | l == 'g' | l == 'j' | l == 'k' | l == 'q' | l == 's' | l == 'x' | l == 'z') {
				c += "2";
			} else if (l == 'd' | l == 't') {
				c += "3";
			} else if (l == 'l') {
				c += "4";
			} else if (l == 'm' | l == 'n') {
				c += "5";
			} else if (l == 'r') {
				c += "6";
			}

		}

		return c;
	}

	public String adj(String w) {
		String ret = w.charAt(0)+"";
		for (int i = 1; i < w.length(); i++) {
			if(w.charAt(i-1) == w.charAt(i))
				continue;
			else 
				ret += w.charAt(i)+"";
		}

		return ret.replaceAll("0", "");
	}

	public void c() {

	}

	public void d() {

	}
}
