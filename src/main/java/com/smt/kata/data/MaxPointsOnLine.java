package com.smt.kata.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/****************************************************************************
 * <b>Title</b>: MaxPointsOnLine.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Max Points on a Line Kata
 * 
 * Given an array of points where points[i] = [xi, yi] represents a point on the 
 * X-Y plane, return the maximum number of points that lie on the same straight line.
 * this check assumes vertical/horizontal and diagonal (45 degrees) as the lines
 * to evaluate
 * 
 * Example 1:
 * Input: points = [[1,1],[2,2],[3,3]]
 * https://assets.leetcode.com/uploads/2021/02/25/plane1.jpg
 * Output: 3
 * 
 * Example 2:
 * Input: points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
 * https://assets.leetcode.com/uploads/2021/02/25/plane2.jpg
 * Output: 4
 * 
 * Constraints:
 * 1 <= points.length <= 300
 * points[i].length == 2
 * -104 <= xi, yi <= 104
 * Each point is processed only once, even if it is duplicated
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Nov 12, 2021
 * @updates:
 ****************************************************************************/
public class MaxPointsOnLine {
	
	/** 
	 * Calculates the number of points on a straight line
	 * @param points Points on the graph
	 * @return Max points in any straight line (vertical, horizontal and diagonal)
	 */
	public int findMax(int[][] points) {
		//if(points == null || points.length < 1 || points[0].length < 1 || points.length <= 300) return 0;
		
		int xMax = 0;
		int yMax = 0;
		List<Integer> lens = new ArrayList<>();
		
//		for(int[] arrays : points) {
//			if(arrays == null) continue;
//			if(arrays[0]  > xMax) xMax = arrays[0];
//			if(arrays[1]  > yMax) yMax = arrays[1];
//			
//	
//		}
		
		
		
		for(int[] coords : points) {
			int[] types = new int[]{0,0,0,0};
			double slopeOg = (float)coords[1] / (float)coords[0];
			double negSlopeOg = (double)(coords[1] * -1) / (double)coords[0];
			System.out.println("og slope = " + slopeOg  + "  neg slope = " + negSlopeOg );
			System.out.println(" coord og = " + coords[0] + "," + coords[1] +  "   " + 0/2);
	
			List<List<Integer>> locations = new ArrayList<>();
			for(int[] coord : points) {
				List<Integer> co = new ArrayList<>();
				co.add(coord[0]);
				co.add(coord[1]);
				
				if(!locations.contains(co)) {
					locations.add(co);
					double slope = (double)coord[1] / (double)coord[0];
					double negSlope = (double)(coord[1] * -1) / (double)coord[0];
					System.out.println( "coord =  "+ coord[0] + "," + coord[1]  + "   slope  =  " + slope + " neg slope = " + negSlope);
					
				}
			}
			
			System.out.println("slope =  " + ( (double)coords[1]/ (double)coords[0])   );
			
			
			System.out.println("slope =  " + ( (double)coords[1]/ (double)coords[0])   );
			
		}
		
		
		System.out.println("x max = " + xMax + "   ymax = " + yMax);
		
		
		
		
		return points.length;
	}


	
	
	
}
