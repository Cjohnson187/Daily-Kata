package com.smt.kata.number;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.IntStream;

// JDK 11.x

/****************************************************************************
 * <b>Title</b>: SortIntegerByPower.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Sort Integers by The Power Value
 * 
 * The power of an integer x is defined as the number of steps needed to transform 
 * x into 1 using the following steps:
 * 
 * if x is even then x = x / 2
 * if x is odd then x = 3 * x + 1
 * For example, the power of x = 3 is 7 because 3 needs 7 steps to become 
 * 1 (3 --> 10 --> 5 --> 16 --> 8 --> 4 --> 2 --> 1).
 * 
 * Given three integers lo, hi and k. The task is to sort all integers in the 
 * interval [lo, hi] by the power value in ascending order, if two or more integers 
 * have the same power value sort them by ascending order.
 * 
 * Return the k-th integer in the range [lo, hi] sorted by the power value.
 * 
 * Notice that for any integer x (lo <= x <= hi) it is guaranteed that x will 
 * transform into 1 using these steps and that the power of x is will fit in 32 bit signed integer.
 * 
 * Example 1:
 * Input: lo = 12, hi = 15, k = 2
 * Output: 13
 * Explanation: The power of 12 is 9 (12 --> 6 --> 3 --> 10 --> 5 --> 16 --> 8 --> 4 --> 2 --> 1)
 * The power of 13 is 9
 * The power of 14 is 17
 * The power of 15 is 17
 * The interval sorted by the power value [12,13,14,15]. For k = 2 answer is the 
 * second element which is 13.
 * Notice that 12 and 13 have the same power value and we sorted them in ascending 
 * order. Same for 14 and 15.
 * 
 * Example 2:
 * Input: lo = 1, hi = 1, k = 1
 * Output: 1
 * 
 * Example 3:
 * Input: lo = 7, hi = 11, k = 4
 * Output: 7
 * Explanation: The power array corresponding to the interval [7, 8, 9, 10, 11] is [16, 3, 19, 6, 14].
 * The interval sorted by power is [8, 10, 11, 7, 9].
 * The fourth number in the sorted array is 7.
 * 
 * Example 4:
 * Input: lo = 10, hi = 20, k = 5
 * Output: 13
 * 
 * Example 5:
 * Input: lo = 1, hi = 1000, k = 777
 * Output: 570
 * 
 * Constraints:
 * 1 <= lo <= hi <= 1000
 * 1 <= k <= hi - lo + 1
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Dec 2, 2021
 * @updates:
 ****************************************************************************/
public class SortIntegerByPower {
	
	@FunctionalInterface
    interface TriFunction<T,U,V,R> {
       R apply(T t, U u, V v);
    }
	/**
	 * Finds the correct power in the range that matches "k"
	 * @param low Low value for the powers
	 * @param high High value for the powers
	 * @param k Element to return (1 based index, not 0)
	 * @return value in the high/low range, sorted that matches the kth element
	 */
	public int find(int low, int high, int k) {
		if(low < 1 || high < low || high > 1000 || k < 1 || k > high-low+1) return 0;
		if(high == low ) return low;
		// equation 
		Function<Integer, Integer> p = (i ->  i/2 == 1 ? (3 * i) +1 : i/2) ;
		// increment
		//BiFunction<Integer, Integer, Integer> f1 = (num, i) -> (num != 1 ? (f4.apply(m.apply(num) , i+1)) : i); 
		
		//BiFunction<Integer, Integer, Integer> f2 = (num, i) -> num == 1? i: num.apply(num, i+1);
		
		//Function<Integer, Integer> runner = x -> f2.apply(f2, x);  
		
		Function<Integer, Integer> fact  = x -> {
			
			TriFunction<TriFunction, Integer, Integer, Integer> factHelper = 
					(func, num, count) -> (num == 1) ? count : (Integer) func.apply(func, num, count);
					return factHelper.apply(factHelper, x, x);
		};
		
		//Function<Integer, Integer> me = ( i -> i = 1 ? )
		
		System.out.println("applied = " + fact.apply(low));
		
		
//		Function<Double, Double> fact = x -> {
//		    BiFunction<BiFunction, Double, Double> factHelper =
//		        (f, d) -> (d == 0) ? 1.0 : d*(double)f.apply(f,d-1);
//		    return factHelper.apply(factHelper, x);
//		};
		
		int[] range = IntStream.range(low, high).toArray();
//		Arrays.sort(range, Comparator.comparing({
//			
//		})
//		); 
		
		System.out.println(Arrays.toString(range));
		 
			
		return k;
	}
	
	public static int pow(int number) {
		int count = 1;
		Function<Integer, Integer> p = (i ->  i/2 == 1 ? (3 * i) +1 : i/2) ;
		while (number > 1 ) {
			p.apply(number);
			count++;
		}
		return count;
	}
	
}

