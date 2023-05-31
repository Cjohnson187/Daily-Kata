package com.smt.kata.html;

import java.util.ArrayList;
import java.util.Collections;
// JDK 11.x
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

import com.siliconmtn.data.text.StringUtil;

/****************************************************************************
 * <b>Title</b>: EmboldenPhrase.java
 * <b>Project</b>: Daily-Kata
 * <b>Description: </b> Embolden a Phrase Kata
 * 
 * Implement the function embolden(s, lst) which takes in a string s and list of 
 * substrings lst, and wraps all substrings in s with an HTML bold tag <b> and </b>.
 * 
 * If two bold tags overlap or are contiguous, they should be merged.
 * 
 * For example, given s = abcdefg and lst = ["bc", "ef"], return the string 
 * a<b>bc</b>d<b>ef</b>g.
 * 
 * Given s = abcdefg and lst = ["bcd", "def"], return the string 
 * a<b>bcdef</b>g, since they overlap.
 * 
 * <b>Copyright:</b> Copyright (c) 2022
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Jan 31, 2022
 * @updates:
 ****************************************************************************/
public class EmboldenPhrase {

	public static final String OPEN_TAG = "<b>";
	public static final String CLOSED_TAG = "</b>";
	
	/**
	 * HTML bold the words and combos from the provided phrase and words
	 * @param phrase Phrase to bold words
	 * @param boldWords Words in the phrase to bold
	 * @return Bolded phrase
	 */
	public String embolden(String phrase, List<String> boldWords) {
		if(StringUtil.isEmpty(phrase)) return "";
		if(boldWords == null) return phrase;

		String emboldened = phrase.toLowerCase();
		for (String s: boldWords)
			emboldened = Pattern.compile("(?i)"+s).matcher(emboldened).replaceAll(match -> match.group().toUpperCase());

		return Pattern.compile("[A-Z]+").matcher(emboldened).replaceAll(match -> "<b>"+match.group().toLowerCase() +"</b>");
	}



//	public String embolden(String phrase, List<String> boldWords) {
//
//		if(boldWords.isEmpty() || StringUtil.isEmpty(phrase)) return "";
//
//		String s = phrase;
//		List<String> words = getPerm(boldWords);
//		for(String i : words) {
//			System.out.println(s+"  "+i +"  " + s.contains(i));
//			String n = "<b>"+i+"</b>";
//			System.out.println(n);
//			s = s.replace(i, ("<b>"+i+"</b>"));
//		}
//		boolean open = false;
//		StringBuilder builder = new StringBuilder(s.replaceAll("</b><b>", ""));
//		System.out.println("builder = " +builder.toString());
//		for (int i = 0; i < builder.length(); i++) {
//			if(builder.charAt(i) == '<' &&  i < builder.length() -1 && builder.charAt(i+1) == 'b' ) {
//				if(!open) {
//
//					open = true;
//
//				}
//
//			}
//		}
//		System.out.println(s);
//		return s;
//	}
//
//	public List<String> getPerm(List<String> boldWords) {
//		 List<String> words = new ArrayList<>();
//		 for (String s: boldWords) {
//			 for(String p: boldWords) {
//				 if(s.equals(p)) continue;
//				 if(s.charAt(0) == p.charAt(p.length()-1)) {
//					 words.add(p+ s.substring(1));
//				 } else if(s.charAt(s.length()-1) == p.charAt(0)) {
//					 words.add(s+ p.substring(1));
//				 }
//			 }
//		 }
//		 words.addAll(boldWords);
//		 Collections.sort(words);
//		 words.sort((a,b) -> b.length() - a.length());
//		 System.out.println("words = "+words.toString());
//		 return words;
//	}
}
