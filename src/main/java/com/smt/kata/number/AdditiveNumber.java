package com.smt.kata.number;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

import com.siliconmtn.data.text.StringUtil;

/****************************************************************************
 * <b>Title</b>: AdditiveNumber.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Additive Number Kata
 * 
 * Additive number is a string whose digits can form additive sequence.
 * 
 * A valid additive sequence should contain at least three numbers. Except for the 
 * first two numbers, each subsequent number in the sequence must be the sum of 
 * the preceding two.
 * 
 * Given a string containing only digits '0'-'9', write a function to determine 
 * if it's an additive number.
 * 
 * Note: Numbers in the additive sequence cannot have leading zeros, so sequence 
 * 1, 2, 03 or 1, 02, 3 is invalid.
 * 
 * Example 1:
 * Input: "112358"
 * Output: true
 * Explanation: The digits can form an additive sequence: 1, 1, 2, 3, 5, 8. 
 *              1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
 * 
 * Example 2:
 * Input: "199100199"
 * Output: true
 * Explanation: The additive sequence is: 1, 99, 100, 199. 
 *              1 + 99 = 100, 99 + 100 = 199
 * 
 * Constraints:
 * num consists only of digits '0'-'9'.
 * 1 <= num.length <= 35
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Nov 18, 2021
 * @updates:
 ****************************************************************************/
public class AdditiveNumber {
	/**
	 * Determines if the provided sequence is additive
	 * @param sequence Numeric sequence to evaluate
	 * @return True if additive, false otherwise
	 */
	public boolean isAdditive(String sequence) {
		if(StringUtil.isEmpty(sequence) || sequence.length() > 35) return false;
		
		return additive(false, sequence.replaceAll("[^0-9.]", ""));
	}
	
	/**
	 * Reccurse number possibilities based on remaining string
	 * @param a
	 * @param sequence
	 * @return
	 */
	public boolean additive(boolean a, String sequence) {
		// end condition
		if(a) 
			return a;
		
		List<String> ones = getNums(sequence, 2);
		for (String n1 : ones) {
			if(n1.startsWith("0")) continue;
			
			String twoSeq = sequence.substring(n1.length(), sequence.length());
			List<String> twos = getNums(twoSeq, 1);
			for (String n2 : twos) {
				if(n2.startsWith("0")) continue;
				
				String threeSeq = twoSeq.substring(n2.length(), twoSeq.length());
				List<String> threes = getNums(threeSeq, 0);
				for (String tot : threes) {
					if(tot.startsWith("0")) continue;
					//check if addiditve
					if(Integer.parseInt(n1) + Integer.parseInt(n2) == Integer.parseInt(tot)) {
						// check if end of sequence
						if(sequence.endsWith(tot) ) {
							return additive(true, twoSeq);
						} else {
							// continue to next number
							return additive(false, twoSeq);
						}
					} else a = false;
				}
			}
		}
		
		return a;
	}
	/**
	 * Get list of number possibilities
	 * @param seq
	 * @param max
	 * @return
	 */
	public List<String> getNums(String seq, int max) {
		List<String> nums = new ArrayList<>();
		for (int i = 0; i < seq.toCharArray().length-max; i++) 
			nums.add(seq.substring(0, i+1));
		return nums;
	}
	

	
	
	
	

}







































