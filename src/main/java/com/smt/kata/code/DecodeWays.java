package com.smt.kata.code;

// JDK 11.x
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.siliconmtn.data.text.StringUtil;

/****************************************************************************
 * <b>Title</b>: DecodeWays.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Decode Ways
 * 
 * A message containing letters from A-Z can be encoded into numbers using the following mapping:
 * 'A' -> "1"
 * 'B' -> "2"
 * ...
 * 'Z' -> "26"
 * To decode an encoded message, all the digits must be grouped then mapped back 
 * into letters using the reverse of the mapping above (there may be multiple ways). 
 * For example, "11106" can be mapped into:
 * 
 * "AAJF" with the grouping (1 1 10 6)
 * "KJF" with the grouping (11 10 6)
 * Note that the grouping (1 11 06) is invalid because "06" cannot be mapped 
 * into 'F' since "6" is different from "06".
 * 
 * Given a string s containing only digits, return the number of ways to decode it.
 * 
 * Example 1:
 * Input: s = "12"
 * Output: 2
 * Explanation: "12" could be decoded as "AB" (1 2) or "L" (12).
 * 
 * Example 2:
 * Input: s = "226"
 * Output: 3
 * Explanation: "226" could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 * 
 * Example 3:
 * Input: s = "0"
 * Output: 0
 * Explanation: There is no character that is mapped to a number starting with 0.
 * The only valid mappings with 0 are 'J' -> "10" and 'T' -> "20", neither of which start with 0.
 * Hence, there are no valid ways to decode this since all digits need to be mapped.
 * 
 * Example 4:
 * Input: s = "06"
 * Output: 0
 * Explanation: "06" cannot be mapped to "F" because of the leading zero ("6" is different from "06").
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Aug 18, 2021
 * @updates:
 ****************************************************************************/
public class DecodeWays {
	
	/**
	 * Encodes the provided sequence into all possible variations
	 * @param code Code to be encoded
	 * @return Collection of possible codes
	 */
	public List<String> encode(String code) {
		if(code == null || code.length() == 0 || code.contains("0"))
			return new ArrayList<String>();
		
		// Letters Found
		List<String> solutions = new ArrayList<>();
		
		// numbers to convert
		//List<String> digits = Arrays.asList(code.split(""));
		List<String> digits = getNumList(code);
		
		System.out.println("original numbers found = " + digits.toString());
		System.out.println("combos found = " );
		for (String number : digits) {
			char letter = getAsccii(number);
			if(letter != (char)0) {
				solutions.add(letter+"");
			}
		}
		
		
		
		// 226 => BZ, VF, BBF

		
		
		
		System.out.println("original numbers found = " + solutions.toString() );

		return solutions;
	}
	
	/**
	 * get char value
	 * @param numString
	 * @return
	 */
	public char getAsccii(String numString ) {
		int num = Integer.parseInt(numString);
		if( num > 0  && num < 27) {
			
			return (char)(num+64);
		}
		
		return 0;
	}


	public List<String> getNumList(String code){
		List<String> group = new ArrayList<String>();
		char[] charArray = code.toCharArray();
		for(int i=1; i<charArray.length; i++){
			String prev = String.valueOf(charArray[i-1]);		// 2
			String curr = String.valueOf(charArray[i]);		// 2
			if(!group.contains(prev))
				group.add(prev);
			if(!group.contains(curr))
				group.add(curr);
			String together = String.valueOf(prev) + String.valueOf(curr);
			if(Integer.parseInt(together) > 0 && Integer.parseInt(together) < 27 && !group.contains(together))
				group.add(together);

			// Adding to group done...
		}
		
		return group;
	}
	
	
	
}
