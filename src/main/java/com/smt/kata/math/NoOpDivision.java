package com.smt.kata.math;

/****************************************************************************
 * <b>Title:</b> NoOpDivision.java
 * <b>Project:</b> SMT-Kata
 * <b>Description:</b> No Operator Division
 * 
 * Implement division of two positive and/or negative integers without using the division, 
 * multiplication, or modulus operators. Return the quotient as an integer, 
 * ignoring the remainder.  The sign of the dividend and divisor must be taken into
 * account.
 * 
 * Example:
 * 
 * 10 / 3 = 3;
 * 
 * 12 / 5 = 2;
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
public class NoOpDivision {

	/**
	 * Divide two integers and receive an integer.  Round to floor
	 * @param dividend Number to be divided
	 * @param divisor Number to be divided by
	 * @return rounded number.  Zero if dividend or divisor is zero
	 */
	public int divide(int dividend, int divisor) {
		int quotient = 0;
		int remainder = dividend;
		if (dividend > 0 ) {
			while (remainder >=divisor ) {
				remainder -= divisor;
				quotient ++;
				
			}

		} else {
			while (remainder < Math.abs(divisor) ) {
				remainder += Math.abs(divisor);
				quotient ++;
				
			}
			if (divisor > 0) {
				quotient -= quotient+ quotient -1; 
			}
			else {
				quotient-=1;
				
			}

		}
		
		
		return quotient;
	}

}
