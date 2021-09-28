package com.smt.kata.number;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.siliconmtn.data.text.StringUtil;

/****************************************************************************
 * <b>Title</b>: OriginalDigits.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Reconstruct Original Digits from English
 * 
 * Given a string s containing an out-of-order English representation of digits 0-9, 
 * return the digits in ascending order.
 * 
 * Example 1:
 * Input: s = "owoztneoer"
 * Output: "012"
 * 
 * Example 2:
 * Input: s = "fviefuro"
 * Output: "45"
 * 
 * Constraints:
 * 1 <= s.length <= 105
 * s[i] is one of the characters ["e","g","f","i","h","o","n","s","r","u","t","w","v","x","z"].
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Sep 9, 2021
 * @updates:
 ****************************************************************************/
public class OriginalDigits {
	Map<String, String> nums;
	
	/**
	 * Initializes the class 
	 */
	public OriginalDigits() {
		super();
		nums = new HashMap<String, String>();
		nums.put("0", "zero");
		nums.put("1", "one");
		nums.put("2", "two");
		nums.put("3", "three");
		nums.put("4", "four");
		nums.put("5", "five");
		nums.put("6", "six");
		nums.put("7", "seven");
		nums.put("8", "eight");
		nums.put("9", "nine");
		
	}
	
	/**
	 * Calculates the digits in the word
	 * @param source Source to find digits
	 * @return Digits in order
	 */
	public String calculate(String source) {
		String ret = "";
		
		if (StringUtil.isEmpty(source)) return ret;
		source = source.toLowerCase();
		
		for(Entry<String, String> num: nums.entrySet() ) {
			int n = 0;
			for (char let: num.getValue().toCharArray()) {
				if(source.contains(let+"")) n++;
			}
			if(n == num.getValue().length()) {
				ret+=num.getKey();
				
			}
			n =0;
			
		}
		return ret;
	}
}
