package com.smt.kata.distance;

// JDK 11.x
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/****************************************************************************
 * <b>Title</b>: IntersectingArrays.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Intersecting Arrays Kata
 * 
 * Given two integer arrays nums1 and nums2, return an array of their intersection. 
 * Each element in the result must appear as many times as it shows in both arrays 
 * and you may return the result in any order.
 * 
 * This kata must be solved in 2 DISTINCT ways.  The intersectNoCollections method
 * must be solved using only std java with NO imports (No collections or other helpers)
 * 
 * The intersectWithCollections must be solved using collections
 * 
 * Example 1:
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2,2]
 * 
 * Example 2:
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [4,9]
 * Explanation: [9,4] is also accepted.
 * 
 * Constraints:
 * 1 <= nums1.length, nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 1000
 * elements inside the Integer array may NOT be null.  Return an empty array/collection if nulls
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Oct 26, 2021
 * @updates:
 ****************************************************************************/
public class IntersectingArrays {

	/**
	 * Intersects the 2 arrays with just the common values
	 * @param one First array to intersect
	 * @param two Second array to intersect
	 * @return Array of the intersected values
	 */
	public Integer[] intersectNoCollections(Integer[] one, Integer[] two) {
		if(one == null || one.length <1 || two == null || two.length < 1) return new Integer[0];
		if(one.length < two.length) {
			Integer[] temp = one;
			one = two;
			two = temp;
		}
		Integer[] nums = new Integer[0];
		for(Integer i: one) {
			for (int j = 0; j < two.length; j++) {
				if(i == null || two[j] == null) return new Integer[0];
				else if (i == two[j]) {
					Integer[] temp = new Integer[nums.length+1];
					for(int x = 0; x < nums.length;x++) 
						temp[x] = nums[x];
					temp[temp.length-1] = i;
					nums = temp;
					two[j] = -1;
				}
			}
			
		}
		return nums;
	}
	
	/**
	 * Intersects 2 arrays using collections
	 * @param one First array to intersect
	 * @param two Second array to intersect
	 * @return Collection of the intersected values
	 */
	public List<Integer> intersectWithCollections(Integer[] one, Integer[] two) {
		List<Integer> nums = new ArrayList<>();
		if(one == null || one.length <1 || two == null || two.length < 1) return nums;
		List<Integer> one1 = new ArrayList<>();
		List<Integer> two2 = new ArrayList<>();
		if(two.length < one.length) {
			one1 = Arrays.asList(two);
			two2 = Arrays.asList(one);
		} else {
			one1 = Arrays.asList(one);
			two2 = Arrays.asList(two);
		}
		for(Integer i : two2) {
			if(i == null ) return new ArrayList<Integer>();
		}
		for(Integer i: one1) {
			if(i == null ) return new ArrayList<Integer>();
			if(two2.contains(i))
				nums.add(i);
		}

		return nums;
	}
}
