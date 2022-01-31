package com.smt.kata.math;

import java.util.Arrays;
import java.util.stream.Collectors;

/****************************************************************************
 * <b>Title</b>: CommonOneBits.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Common One Bits
 * 
 * Given an integer n, find the next biggest integer with the same number of 
 * 1-bits on. For example, given the number 6 (0110 in binary), return 9 (1001).
 * 
 * Constraints
 * 0 >= start <= 1024
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Dec 14, 2021
 * @updates:
 ****************************************************************************/
public class CommonOneBits {

	/**
	 * Finds the next number with the same number of '1s'
	 * @param start Starting value to calculate against
	 * @return Next number to match
	 */
	public int find(int start) {
		if(start <0 || start > 1024 ) return 0;
		String bin = Integer.toBinaryString(start) +"0";
		System.out.println("bin = " + bin + "  start = " + start);
		for(char c: bin.toCharArray()) {
			System.out.println(Integer.valueOf(""+c));
		}
		String val = Arrays.stream(bin.split("")).sorted((a, b) -> Integer.valueOf(b)  - Integer.valueOf(a)).collect(Collectors.joining());
		//String val = bin.chars().mapToObj(i -> Integer.valueOf(i+"")).sorted((a, b) -> Integer.valueOf(""+a) - Integer.valueOf(""+b)).map(c -> c+"").collect(Collectors.joining());
		// Return the value
		System.out.println("made string = " + val);
		return  Integer.parseInt(val, 2);
	}
}

