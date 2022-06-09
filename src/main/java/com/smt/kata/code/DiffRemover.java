package com.smt.kata.code;

import java.util.Arrays;

import java.util.List;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Given a master int array and removes diff array.  Remove all instances of
 * elements in remove from master.
 * 
 * Example
 * 
 * master: {1,2,3,3,4,5,6}, remove: {1,3,5} => {2,4,6}
 * master: {1,2,3,3,4,5,6}, remove: {} => {1,2,3,3,4,5,6}
 * master: {1,2,3,3,4,5,6}, remove: {1,2,3,3,4,5,6} => {}
 * master: {}, remove: {1,3,5} => {}
 * 
 * Notes:
 * 
 * Order is not guaranteed on incoming lists but return should be ordered low->high
 * Method always returns an array, even if it is empty or inputs are null.
 * 
 * @author raptor
 *
 */
public class DiffRemover {

	public int[] deDiff(int[] master, int[] remove) {
		if (remove == null || remove.length < 1) return master;
		if (master == null || master.length < 1) return new int[0];
		List<Integer> rem = Arrays.stream(master).boxed().collect(Collectors.toList());
		
		Predicate<Integer> predicate = s -> rem.contains(s);
		
		//List<Integer> og  = Arrays.stream(master).noneMatch(predicate).boxed().collect(Collectors.toList());
//		for (int r : remove) 
//			while(og.contains(r)) {
//				og.remove(og.indexOf(r));
//				
//			}
		//og.removeIf(s -> Arrays.asList(remove).contains(s));
//		while (og.removeIf(s -> Arrays.asList(remove).contains(s))) {
//			continue;
//		}
//		return og.stream().mapToInt(i->i).toArray();
		return null;
	} 
}
