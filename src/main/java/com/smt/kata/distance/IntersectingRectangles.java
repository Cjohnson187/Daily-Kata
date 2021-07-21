package com.smt.kata.distance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
// JDK 11.x
import java.util.List;
import java.util.Map;

/****************************************************************************
 * <b>Title</b>: IntersectingRectangles.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Intersecting Rectangles Kata
 * 
 * Given two rectangles on a 2D graph, return the list of of their intersecting 
 * coordinates. If the rectangles don't intersect, return empty List.
 * 
 * For example, given the following rectangles:
 * 
 * {
 * 		"top_left": (1, 4),
 * 		"dimensions": (3, 3) # width, height
 * }
 * 
 * and
 * 
 * {
 * 		"top_left": (0, 5),
 * 		"dimensions": (4, 3) # width, height
 * }
 * 
 * return List with 6 coordinates 
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Jul 19, 2021
 * @updates:
 ****************************************************************************/
public class IntersectingRectangles {
	
	/**
	 * Finds the overlap between 2 rectangles
	 * @param one Starting coordinate of the first rectangle
	 * @param width1 width of the first rectangle
	 * @param height1 height of the first rectangle
	 * @param two Starting coordinate of the first rectangle
	 * @param width2 width of the first rectangle
	 * @param height2 height of the first rectangle
	 * @return List of overlapping coordinates
	 */
	public List<Coord> getOverlap(Coord one, int width1,  int height1, Coord two, int width2, int height2) {
		List<Coord> co  = new ArrayList<>();
		if(one == null|| two == null )
		return null;
		List<int[]> oneM = fill(one, width1, height1);
		System.out.println("other");
		List<int[]> twoM = fill(two, width2, height2);
		for (int[] c: oneM) {
			for (int[] d: twoM) {
				if(d[0] == c[0] && d[1] == c[1]) {
					co.add(new Coord(d[0], d[1]));
					System.out.println("similar");
				}
			}
			
		}
		for (int[] c: twoM) {
			if (twoM.contains(c)) System.out.println("contains pair");
			System.out.println("d = " + c[0] + "   " + c[1]);
		}
		
		//for (int i=0, j= 0 i <  width1)
		
		return co;
		
	}
	
	public List<int[]> fill(Coord one, int width1,  int height1) {
		
		List<int[]>  a = new ArrayList<>();
		for (int i = one.top; i <= height1 + one.top; i++) {
			for (int j = one.left; j < width1 + one.left; j++) {
				int[] t = new int[2];
				t[0] = i;
				t[1] = j;
				a.add(t);

				System.out.println(" coord addded = " + i + "  " + j);
			}
			
		}
		return a;
		
		
		
	}
}

/**
 * Helper class to group the coordinates on the grid
 */
class Coord {
	int top = 0;
	int left = 0;
	
	/**
	 * Default constructor
	 */
	public Coord() {
		super();
	}
	
	/**
	 * Helper constructor
	 * @param top Top coordinate
	 * @param left Left coordinate
	 */
	public Coord(int top, int left) {
		this();
		this.top = top;
		this.left = left;
	}
}

