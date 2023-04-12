package com.smt.kata.number;

/****************************************************************************
 * <b>Title</b>: LargestGap.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Given an array of integers, return the largest gap between 
 * the sorted elements of the array.  For example, consider the array: 
 * [9, 4, 26, 26, 0, 0, 5, 20, 6, 25, 5] 
 * After sorting, the array becomes: [0, 0, 4, 5, 5, 6, 9, 20, 25, 26, 26] 
 * We now see that the largest gap in the array is between 9 and 20 which is 11.  
 * You must sort the arrays manually!  
 * You may not use Arrays.sort!
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Jan 5, 2021
 * @updates:
 ****************************************************************************/
public class LargestGap {
	
	/**
	 * Calls out to get the array sorted and then finds the largest gap
	 * @param arr
	 * @return
	 */
	public int largestGap(int[] arr) {
		arr = bubbleSort(arr);
		int largest = 0;
		for (int i =0; i< arr.length-1; i++){
			if(Math.abs(arr[i+1] - arr[i]) > largest){
				largest = Math.abs(arr[i] - arr[i+1]);
			}
		}

		return largest;
	}

	public int[] bubbleSort(int[] arr) {
		int[] sorted = new int[arr.length];
		for (int i =0; i< arr.length-1; i++){
			if(arr[i] > arr[i+1]){
				int temp = arr[i];
				arr[i] = arr[i+1];
				arr[i+1] = temp;
				arr = bubbleSort(arr);
			}
		}
		return arr;
	}
}
