package com.smt.kata.distance.bean;

// JDK 11.x
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/****************************************************************************
 * <b>Title</b>: Rectangle.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Value object holding the coordinates for a rectangle
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Aug 31, 2021
 * @updates:
 ****************************************************************************/
public class Rectangle implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3615572197475045115L;
	
	// Members
	CoordinateVO topLeft;
	CoordinateVO bottomRight;
	Map<Integer, Integer> locations;
	
	/**
	 * 
	 */
	public Rectangle(CoordinateVO topLeft, CoordinateVO bottomRight) {
		super();
		this.topLeft = topLeft;
		this.bottomRight = bottomRight;
		locations = new HashMap<>(); 
		

	}
	
	
	public int size(int[][] rect, Map<Integer, Integer> loc) {
		if(rect == null || rect[0].length  <= 1  || rect.length <  topLeft.getColumn()) return 0;
		int size = 0;
		
		System.out.println("tl row " + topLeft.getColumn() +"    br row  "+ bottomRight.getColumn());
		System.out.println("tl col " + topLeft.getRow() +"    br row  "+ bottomRight.getRow());
		System.out.println("rectangle string = " + loc.toString());
		for(int i = topLeft.getRow(); i< bottomRight.getRow(); i++) {
			if(i >= rect.length) continue;
			for (int j = topLeft.getColumn(); j < bottomRight.getColumn(); j++) {
				if(j >= rect[0].length) continue;
				if(loc.containsKey(i) && loc.get(i) != j) {
					loc.put(i, j);
				}
					
				
				
				size += rect[i][j];
				
				this.locations.putIfAbsent(i, j);
				//System.out.print( "i =  " + i    +" j=  "+j+ "   x= "+ rect[i][j] +  " |s  ");
				System.out.print( " adding = " + rect[i][j]);
				
				
			}
			System.out.println();
		}
		System.out.println("");
		
		
		return size;
	}

	

	public Map<Integer, Integer> getLocations() {
		return locations;
	}


	public void setLocations(Map<Integer, Integer> locations) {
		this.locations = locations;
	}


	public CoordinateVO getTopLeft() {
		return topLeft;
	}


	public void setTopLeft(CoordinateVO topLeft) {
		this.topLeft = topLeft;
	}


	public CoordinateVO getBottomRight() {
		return bottomRight;
	}


	public void setBottomRight(CoordinateVO bottomRight) {
		this.bottomRight = bottomRight;
	}
	
	
}
