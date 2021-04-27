package com.smt.kata.code;

import java.util.HashMap;
import java.util.Map;

import com.siliconmtn.data.text.StringUtil;

/****************************************************************************
 * <b>Title:</b> PhoneNumberDecoder.java
 * <b>Project:</b> Daily-Kata
 * <b>Description:</b> Phone Number Word Decoder
 * 
 * Create a program that converts a phone number with letters to one with only numbers.
 * Examples
 * 
 * textToNum("123-647-EYES") ➞  "123.647.3937"
 * textToNum("(325)444-TEST") ➞ "325.444.8378"
 * textToNum("653-TRY-THIS") ➞  "653.879.8447"
 * textToNum("435-224-7613") ➞  "435.224.7613"
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Apr 23, 2021
 * <b>updates:</b>
 * 
 ****************************************************************************/
public class PhoneNumberDecoder {
	public static Map<Character, Character> nums; 
	/**
	 * 
	 */
	public PhoneNumberDecoder() {
		super();
		nums = new HashMap<>(); 
		nums.put('A', '2');
		nums.put('B', '2');
		nums.put('C', '2');
		nums.put('d', '3');
		nums.put('e', '3');
		nums.put('f', '3');
		nums.put('g', '4');
		nums.put('h', '4');
		nums.put('i', '4');
		nums.put('j', '5');
		nums.put('k', '5');
		nums.put('l', '5');
		nums.put('m', '6');
		nums.put('n', '6');
		nums.put('o', '6');
		nums.put('p', '7');
		nums.put('q', '7');
		nums.put('r', '7');
		nums.put('s', '7');
		nums.put('t', '8');
		nums.put('u', '8');
		nums.put('v', '8');
		nums.put('w', '9');
		nums.put('x', '9');
		nums.put('y', '9');
		nums.put('z', '9');
	}

	/**
	 * Converts a phone number with text to a formatted phone number
	 * @param pn phone number to parse
	 * @return formatted phone number.
	 */
	public String textToNum(String pn) {
		
		if (StringUtil.isEmpty(pn)) return "";
		pn = pn.toLowerCase();
	    StringBuilder s = new StringBuilder();
	    
		for (int i = 0; i < pn.length(); i++) {
			if (s.length() == 3 || s.length() ==7) s.append("."); 
			if (Character.isAlphabetic(pn.charAt(i)) || Character.isDigit(pn.charAt(i))) 
				if (nums.containsKey(pn.charAt(i))){
					s.append(nums.get(pn.charAt(i)));
				}
				else {
					s.append(pn.charAt(i));
				}
		}
		if (s.length() < 12 || s.length()>12) return "";		
		return s.toString();
	}
}
