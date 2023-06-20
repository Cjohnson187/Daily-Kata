package com.smt.kata.object;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/****************************************************************************
 * <b>Title</b>: MatchstickToSquare.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Match Stick to Square Kata
 * 
 * You are given an integer array matchsticks where matchsticks[i] is the length 
 * of the ith matchstick. You want to use all the matchsticks to make one square. 
 * You should not break any stick, but you can link them up, and each matchstick 
 * must be used exactly one time.
 * 
 * Return true if you can make this square and false otherwise.
 * 
 * Example 1:
 * https://assets.leetcode.com/uploads/2021/04/09/matchsticks1-grid.jpg
 * Input: matchsticks = [1,1,2,2,2]
 * Output: true
 * Explanation: You can form a square with length 2, one side of the square came two sticks with length 1.
 * 
 * Example 2:
 * Input: matchsticks = [3,3,3,3,4]
 * Output: false
 * Explanation: You cannot find a way to form a square with all the matchsticks.
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Aug 26, 2021
 * @updates:
 ****************************************************************************/
public class MatchstickToSquare {

	/**
	 * Determines if the match sticks can form a square
	 * @param matchsticks Match sticks to evaluate
	 * @return True if they form a square, false otherwise
	 */
	public boolean canFormSquare(int[] matchsticks) {
		if(matchsticks == null || IntStream.of(matchsticks).sum()%4 >0) return false;
		int maxLen = IntStream.of(matchsticks).sum()/4;
		List<Integer> sticks = Arrays.stream(matchsticks).boxed().sorted().filter(s -> s <maxLen).collect(Collectors.toList());
		int sides  = matchsticks.length - sticks.size();
		System.out.println(sticks);

	

		return true;
	}

	public boolean checkFormSquare(List<Integer> sticks, int index, int maxLen, int sides) {

//	while (sides < 4){
//		for (int i = 0; i < sticks.size(); i++) {
//			if (sticks.get(i))
//		}
//	}



		return true;
	}

	
}
