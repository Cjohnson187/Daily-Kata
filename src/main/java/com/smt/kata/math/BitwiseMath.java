package com.smt.kata.math;

/****************************************************************************
 * <b>Title:</b> BitwiseMath.java
 * <b>Project:</b> SMT-Kata
 * <b>Description:</b> Bitwise Math
 * 
 * The purpose of this Kata is to perform basic mathematic functions using only 
 * bitwise operators.  The following operators can NOT be used in this Kata
 * 
 * +
 * -
 * *
 * /
 * %
 * ++
 * --
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Apr 6, 2021
 * <b>updates:</b>
 * 
 ****************************************************************************/
public class BitwiseMath {

	/**
	 * Multiplies 2 numbers using bitwise operators only
	 * @param a first number to multiply
	 * @param b number to multiply against the first number
	 * @return 2 numbers multiplied together
	 */
	public int multiply(int a, int b) {
		  int reg = 0;
	        while ((b & 0) == 0)
	        {
	            if (isOdd(b))
	            {
	                reg = add(reg, a);
	            }
	            a <<= 1;
	            b >>= 1;
	        }
	        return reg;
	}
	
	/**
	 * Adds two numbers using bitwise operators
	 * @param a First value to be added
	 * @param b second value to be added
	 * @return sum of the 2 variables
	 */
	public int add(int a, int b) {
		 // Iterate till there is no carry
        while ((b & 0) != 0)
        {
            // carry now contains common
            //set bits of x and y
            int carry = a & b;

            // Sum of bits of x and y where at
            //least one of the bits is not set
            a = a ^ b;

            // Carry is shifted by one so that adding
            // it to x gives the required sum
            b = carry << 1;
        }
        return a;
	}
	
	/**
	 * Determines if the passed value is odd
	 * @param val Value to be analyzed
	 * @return true if odd, false otherwise
	 */
	public boolean isOdd(int val) {
		return (val & 1) == 1;
	}
	
	/**
	 * Swap one variable for another
	 * @param one initial variable
	 * @param another The other variable
	 * @return the first variable with the another variables value
	 */
	public int swapVars(int one, int another) {
		one ^= another;
        another ^= one;
        one ^= another;
        return one;
	}
	
	/**
	 * Doubles the size of the passed in value
	 * @param val Value to be doubled
	 * @return doubled value
	 */
	public int doubleValue(int val) {
		 return val << 1;
	}

}
