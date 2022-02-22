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
	Map<Integer, String> ts = new HashMap<>();
	Map<Integer, String> tens = new HashMap<>();
	Map<Integer, String> ones = new HashMap<>();
	Map<Integer, String> numberMap = new HashMap<>();
	
	
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
		if((data+"").substring((data+"").indexOf(".")+1).length() > 2) return ""; 
		String dec = (data+"").substring((data+"").indexOf(".")+1);
		String decString = dec.equals("00")? "": (dec+"/100");
		String num = (data+"").substring(0 ,(data+"").indexOf("."));
		System.out.println("nums = "+ num);
		List<String> nums = new ArrayList<String>();
		for (int i = num.length(); i >= 0; i-=3) {
			int index = i-3 < 0 ? 0:i-3;
			nums.add(num.substring(index ,i) );
			
		}
		
		List<String> hundreds = new ArrayList<>();
		System.out.println("h =" + nums.toString());
		String all = "";
		for(int i = 0; i < nums.size(); i++) { 
			String s = nums.get(i); 
			String w = "";
			System.out.println("s = " + s) ;
			String hundred = s.length() < 3? "": ts.get(s).substring(0, 1) + " hundred";
			w+=hundred;
			if( s.length() >1 && s.charAt(1) == '1') {
				w+=tens.get(s.substring(1));
			} else if (s.length() >1 && s.charAt(1) != '0') {
				w+=ts.get(s.charAt(1));
			}
			if(s.length() >1 && s.charAt(1) != '1') {
				w+=ones.get(s.charAt(s.length()-1));
			}
			if(i == 1) w+= " thousand";
			if(i == 2) w+= " million";
			all+=w;
			
		}
		System.out.println("nums = " + nums.toString());
		
		
		return all + decString;
	}
	
	public String convertDec(String dec) {
		return dec.equals("00")? "": (dec+"/100");
	}

	/**
	 * Create a numbers map to convert ints to words
	 */
	protected void loadMap() {
		ones.put(1, "one");
		ones.put(2, "two");
		ones.put(3, "three");
		ones.put(4, "four");
		ones.put(5, "five");
		ones.put(6, "six");
		ones.put(7, "seven");
		ones.put(8, "eight");
		ones.put(9, "nine");
		
		numberMap.put(1, "one");
		numberMap.put(2, "two");
		numberMap.put(3, "three");
		numberMap.put(4, "four");
		numberMap.put(5, "five");
		numberMap.put(6, "six");
		numberMap.put(7, "seven");
		numberMap.put(8, "eight");
		numberMap.put(9, "nine");
		
		tens.put(10, "ten");
		tens.put(11, "eleven");
		tens.put(12, "twelve");
		tens.put(13, "thirteen");
		tens.put(14, "fourteen");
		tens.put(15, "fifteen");
		tens.put(16, "sixteen");
		tens.put(17, "seventeen");
		tens.put(18, "eighteen");
		tens.put(19, "nineteen");
	
		ts.put(2, "twenty");
		ts.put(3, "thirty");
		ts.put(4, "fourty");
		ts.put(5, "fifty");
		ts.put(6, "sixty");
		ts.put(7, "seventy");
		ts.put(8, "eighty");
		ts.put(9, "ninety");
		
		///TensMap.put(null, null)

		

	}

}
