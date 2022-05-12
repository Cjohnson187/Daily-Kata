package com.smt.kata.money;

import java.math.BigDecimal;

/****************************************************************************
 * <b>Title</b>: MinimumChangeReceived.java <b>Project</b>: SMT-Kata
 * <b>Description: </b> Minimum Coins Received
 * 
 * Find the minimum number of coins required to make n cents.
 * 
 * You can use standard American denominations, that is, 1¢, 5¢, 10¢, and 25¢.
 * 
 * For example, given n = 16, return 3 since we can make it with a 10¢, a 5¢,
 * and a 1¢.
 * 
 * <b>Copyright:</b> Copyright (c) 2022 <b>Company:</b> Silicon Mountain
 * Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since May 3, 2022
 * @updates:
 ****************************************************************************/
public class MinimumChangeReceived {

	/**
	 * Calculates the smallest number of coins in the change
	 * 
	 * @param dAmt
	 * @return
	 */
	public int calculate(double dAmt) {
		if (dAmt <= 0)
			return 0;
		
		BigDecimal val = BigDecimal.valueOf(dAmt);
		
		int numCoins = 0;
		
		while (val.compareTo(BigDecimal.ZERO) > 0) {
			if (val.compareTo(BigDecimal.valueOf(.25)) > 0) {
				val = val.subtract(BigDecimal.valueOf(.25));
				numCoins++;
			} else if (val.compareTo(BigDecimal.valueOf(.10)) > 0) {
				val = val.subtract(BigDecimal.valueOf(.10));
				numCoins++;
			} else if (val.compareTo(BigDecimal.valueOf(.05)) > 0) {
				val = val.subtract(BigDecimal.valueOf(.05));
				numCoins++;
			} else {
				val = val.subtract(BigDecimal.valueOf(.01));
				numCoins++;
			}
		}

		return numCoins;
	}

}
