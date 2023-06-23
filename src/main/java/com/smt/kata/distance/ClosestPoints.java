package com.smt.kata.distance;

import java.util.function.BiFunction;

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
	BiFunction<Integer[], Integer[], Double> sqrt = (pointA, pointB) -> ( Math.sqrt(Math.pow((pointA[0]-pointB[0]), 2) + Math.pow((pointA[1]-pointB[1]), 2)) );

	public Integer[][] calculateClosestPoints(Integer[][] points) {
		if(points == null || points.length < 2) return new Integer[0][0];
		return findClosest(points, 0, 1, new Integer[][] {points[0], points[1]});
	}

	public Integer[][] findClosest(Integer[][] points, int y, int x, Integer[][] closest) {
		return (y == points.length) ? closest : findClosest(points, (x == points.length-1 && y < points.length ? y+1 : y), (x == points.length-1 ? 0 : x+1 ), (sqrt.apply(points[y], points[x]) < sqrt.apply(closest[0], closest[1])  && y != x? new Integer[][] {points[y], points[x]} : closest));
	}
}
