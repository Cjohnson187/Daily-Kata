package com.smt.kata.number;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
// JDK 11.x
import java.util.List;
import java.util.Map;

/****************************************************************************
 * <b>Title</b>: UniqueIntegers.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Least Number of Unique Integers after K Removals
 * 
 * Given an array of integers arr and an integer k. Find the least number of unique 
 * integers after removing exactly k elements.  Order the results such that when there
 * are duplicate number of values, the smallest values are given precedence
 * 
 * Example 1:
 * Input: arr = [5,5,4], k = 1
 * Output: 1
 * Explanation: Remove the single 4, only 5 is left.
 * 
 * Example 2:
 * Input: arr = [4,3,1,1,3,3,2], k = 3
 * Output: 2
 * Explanation: Remove 4, 2 and either one of the two 1s or three 3s. 1 and 3 will be left.
 
 * Example 3:
 * Input: arr = [1, 2, 3, 4, 5], k = 3
 * Output: 2
 * Explanation: Remove 4, 5 as we want the smallest integers kept in case of them
 * being the same
 * 
 * Constraints:
 * 
 * 1 <= arr.length <= 10^5
 * 1 <= arr[i] <= 10^9
 * 0 <= k <= arr.length
 * 
 * <b>Copyright:</b> Copyright (c) 2022
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Feb 3, 2022
 * @updates:
 ****************************************************************************/
public class UniqueIntegers {

	/**
	 * Calculates the least number of unique numbers after removing k elements
	 * @param values Values to process
	 * @param k Number of items to remove from the array
	 * @return Smallest unique list
	 */
	public List<Integer> calculate(int[] values, int k) {
		List<Integer> ret = new ArrayList();
		if(values == null || k < 1) return ret;
		Arrays.sort(values);
		Map<Integer, String> vals = new HashMap();
		

		
		for (int i: values) vals.put(i, vals.get(i) == null? i+"": vals.get(i)+i );
		
		for(Map.Entry<Integer, String> m: vals.entrySet()) {
			System.out.println("key = " + m.getValue() + " , " + m.getKey());
		}
	
		while(k > 0) {
			vals = removeVal(vals, k);
			k--;
		}
		
		for(Map.Entry<Integer, String> m: vals.entrySet()) 
			for (String s: m.getValue().split("")) ret.add(Integer.parseInt(s)); 
		
		System.out.println(ret.toString());
		return ret;
	}
	public Map<Integer, String> removeVal(Map<Integer, String> vals, int k) {
		int totalLength = 0;
		for (Map.Entry<Integer, String> m: vals.entrySet())
			totalLength += m.getValue().length();
		int removableDups = totalLength - vals.size();
		//System.out.println("tot = " + totalLength + " ,  " + removableDups + "  , " + k);
		if(removableDups > 0) {
			for (Map.Entry<Integer, String> m: vals.entrySet())
				if(m.getValue().length() > 1) 
					m.setValue( m.getValue().substring(0,m.getValue().length()-1));
		} else {
			int smallest =  200;
			Integer key = null;
			for(Map.Entry<Integer, String> m: vals.entrySet() ) {
				if(m.getValue().length() < smallest) {
					smallest = m.getValue().length();
					key = m.getKey();
				}
			}
			if(key != null) vals.remove(key); 
			
		}
		

		return vals;
	}
}
