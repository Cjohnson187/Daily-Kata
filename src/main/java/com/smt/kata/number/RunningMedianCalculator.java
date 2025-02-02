package com.smt.kata.number;

// JDK 11.x
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/****************************************************************************
 * <b>Title</b>: RunningMedianCalculator.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Compute the running median of a sequence of numbers. 
 * That is, given a stream of numbers, print out the median of the list so far 
 * on each new element.
 * 
 * Recall that the median of an even-numbered list is the average of the two middle numbers.
 * 
 * For example, given the sequence [2, 1, 5, 7, 2, 0, 5], your algorithm should print out:
 * 2
 * 1.5
 * 2
 * 3.5
 * 2
 * 2
 * 2
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Feb 25, 2021
 * @updates:
 ****************************************************************************/
public class RunningMedianCalculator {

	/**
	 * 
	 */
	public RunningMedianCalculator() {
		super();
	}
	
	/**
	 * Takes an array of integers and returns the running median value
	 * @param values
	 * @return
	 */
	public List<Double> getMedianValues(int[] values) {
		List<Double> runningMedian = new ArrayList<>();
		if(values == null || values.length < 1) return runningMedian;

		for (int i =0; i < values.length ; i++) {
			List<Double> subArray = Arrays.stream(values).asDoubleStream().boxed().collect(Collectors.toList()).subList(0, i+1).stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
			runningMedian.add(subArray.size()%2 > 0? subArray.get(subArray.size()/2) : (subArray.get(subArray.size()/2)  + subArray.get((subArray.size()/2 )-1))/2);
		}
		return runningMedian;
	}

}
