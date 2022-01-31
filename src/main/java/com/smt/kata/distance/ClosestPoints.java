package com.smt.kata.distance;

import java.util.Arrays;

/****************************************************************************
 * <b>Title</b>: ClosestPoints.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Closest points Kata
 * 
 * Given a set of points (x, y) on a 2D cartesian plane, find the two closest points. 
 * For example, given the points [
 * 		(1, 1), 
 * 		(-1, -1), 
 * 		(3, 4), 
 * 		(6, 1), 
 * 		(-1, -6), 
 * 		(-4, -3)
 * ], 
 * 
 * return [(-1, -1), (1, 1)]
 * 
 * Constraints:
 * points length > 1
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Dec 16, 2021
 * @updates:
 ****************************************************************************/
public class ClosestPoints {

	/**
	 * Finds the two closest points and returns them
	 * @param points Points to calculate distance against
	 * @return Closest points
	 */
	public Integer[][] calculateClosestPoints(Integer[][] points) {
		if(points == null || points.length < 2) return new Integer[0][0];
	
		int a = 0;
		int b = 1;
		double dist = calcDistance(points, 0, 1);
		for(int i = 0; i < points.length; i++) {
			
			for(int j = 0; j < points.length; j++) {
				if(j == i) continue;
	
				Double d = calcDistance(points, i, j);
				if (dist > d ) {
					a = i;
					b = j;
					dist = d;
				}

			}
		

		}
		Integer[][] ret = new Integer[2][2];
		ret[0] = points[a];
		ret[1] = points[b];
		
		return ret;
	}

	public double calcDistance(Integer[][] points, int a, int b)  {
		return Math.sqrt(Math.pow((points[a][0]-points[b][0]), 2) + Math.pow((points[a][1]-points[b][1]), 2));
	}
}
