package com.smt.kata.number;

import java.util.ArrayList;
import java.util.Arrays;
// JDK 8.x
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/****************************************************************************
 * <b>Title</b>: CheckWriter.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b>
 * Given a currency value output the English equivalent as written on a check:
 * 
 * Input: 10,985.25   Output: Ten thousand nine hundred eighty five dollars and 25/100
 * Input: 125.75      Output: One hundred twenty five dollars and 75/100
 * Input: 95.00       Output: Ninety five dollars only
 * Input: 69          Output: Sixty nine dollars only
 * Input: 217.12	  Output: Two hundred seventeen dollars and 12/100
 * 
 * Note the initial capital on the output line.
 * Note the input may be an integer or a float.
 * 
 * Collections, Strings or other java classes (other than currency specific classes) may be used.

 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Jan 5, 2021
 * @updates:
 ****************************************************************************/
public class CheckWriter {
	/**
	 * Holds the map to convert integer to words
	 */
	Map<Integer, String> numberMap = new HashMap<>();
	Map<Integer, String> TensMap = new HashMap<>();
	
	/**
	 * Initializes the Checkwriter and loads the xref map
	 */
	public CheckWriter() {
		// Load the word map
		loadMap();
	}

	/**
	 * Converts a number into a check syntax sentence
	 * @param data
	 * @return
	 */
	public String convertWords(double data) {
		String[] s = new String[2];
		String dec = "";
		String con = "";
		String ret = "";
		if((data+"").length() ==1) return numberMap.get(data);
		if( (data+"").contains(".") ) {
			s = (data+"").split("\\.");
			dec = (s[1])+ "/100";
			con = s[0];
			
			System.out.println("dec = " + con);
		} else con = data+"";
		
		List<String> sec = new ArrayList<>();
		int h = 0;
		int full =0;
		int len = con.length();
//		while (full < len) {
//			if (h == 1 && len > 2 || len > 5 ) {
//				ret = numberMap.get((con.charAt(0)+"") +  (con.charAt(1)) ) + ret;
//			}
//		}
		for (int i = 3; i >= 0; i--) {
			if (len > 2 && con.charAt(i-1) == 1 ) {
				ret = numberMap.get(  Integer.parseInt( (con.charAt(-1)+"") + (con.charAt(i)+"")) )  + ret;
			}
			
		}
			
		System.out.println("ret = " + ret);
		return data + "";
	}

	/**
	 * Create a numbers map to convert ints to words
	 */
	protected void loadMap() {
		numberMap.put(1, "one");
		numberMap.put(2, "two");
		numberMap.put(3, "three");
		numberMap.put(4, "four");
		numberMap.put(5, "five");
		numberMap.put(6, "six");
		numberMap.put(7, "seven");
		numberMap.put(8, "eight");
		numberMap.put(9, "nine");
		numberMap.put(10, "ten");
		numberMap.put(11, "eleven");
		numberMap.put(12, "twelve");
		numberMap.put(13, "thirteen");
		numberMap.put(14, "fourteen");
		numberMap.put(15, "fifteen");
		numberMap.put(16, "sixteen");
		numberMap.put(17, "seventeen");
		numberMap.put(18, "eighteen");
		numberMap.put(19, "nineteen");
	
		TensMap.put(2, "twenty");
		TensMap.put(3, "thirty");
		TensMap.put(4, "fourty");
		TensMap.put(5, "fifty");
		TensMap.put(6, "sixty");
		TensMap.put(7, "seventy");
		TensMap.put(8, "eighty");
		TensMap.put(9, "ninety");
		
		///TensMap.put(null, null)

		

	}

}
