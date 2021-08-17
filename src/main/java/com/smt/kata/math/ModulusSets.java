package com.smt.kata.math;

import java.util.ArrayList;
import java.util.Arrays;
// JDK 11.x
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/****************************************************************************
 * <b>Title</b>: ModulusSets.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Modulus Sets
 * 
 * Given a set of distinct positive integers, find the largest subset such that 
 * every pair of elements in the subset (i, j) satisfies either i % j = 0 or j % i = 0.  
 * 
 * For example, given the set [3, 5, 10, 20, 21], you should return [5, 10, 20]. 
 * 
 * Given [1, 3, 6, 24], return [1, 3, 6, 24]
 * 
 * The items in the array will NOT always be in order.
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Aug 12, 2021
 * @updates:
 ****************************************************************************/
public class ModulusSets {

	/**
	 * Calculates the number of modulus sets
	 * @param sequence Numbers to calculate against
	 * @return Largest colleciton of matchin modulus values
	 */
	public Collection<Integer> calculate(int[] input) {
		
		if (input== null ||input.length < 2 ) {
			return new ArrayList<>();
		}
		List<Integer> set =  new ArrayList<>();
		List<Integer> ret =  new ArrayList<>();
		for (int i : input) {
			set.add(i);
		}
		Collections.sort(set);
		
		for (int i : input) {
			boolean add = true;
			
			for (int j : input) {
				if(i == j) break;
				System.out.println("i = " + i + "  j " + j +  "  i%j " + (i%j) );
				if(i%j != 0) {
					add = false;
				}
			}
			if(add) {
				ret.add(i);
				
			}
			add = true;
		}
	
	
		
		
		
		return ret;
	}

}
