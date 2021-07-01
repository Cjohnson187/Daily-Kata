package com.smt.kata.distance;

/****************************************************************************
 * <b>Title</b>: PixelSwap.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Pixel Swap Kata
 * 
 * Given a 2-D matrix representing an image, a location of a pixel in the screen 
 * and a color C, replace the color of the given pixel and all adjacent same 
 * colored pixels with C.
 * 
 * For example, given the following matrix, and location pixel of (2, 2), and 'G' for green:
 * 
 * B B W
 * W W W
 * W W W
 * B B B
 * 
 * Becomes
 * 
 * B B G
 * G G G
 * G G G
 * B B B
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Jun 28, 2021
 * @updates:
 ****************************************************************************/
public class PixelSwap {
	
	/**
	 * Swaps the pixels at the given coords and contiguous coords with the same original color
	 * @param pixels Matrix of pixels
	 * @param coords Starting coords
	 * @param color New color in those 0ixels
	 * @return Updated pixel map
	 */
	public char[][] swap(char[][] pixels, int[] coords, char color) {
		if(pixels == null || coords == null || pixels.length < coords[0] || pixels[0].length < coords[1]) return new char[0][0];
		return replace(pixels,coords[0], coords[1], color, pixels[coords[0]][coords[1]] );
	}
	
	public char[][] replace(char[][] pixels, int y, int x, char r, char origin) {
		pixels[y][x] = r;
		if(y+1 < pixels.length && pixels[y+1][x] == origin) pixels = replace(pixels, y+1, x, r, origin);
		if(y-1 >= 0 && pixels[y-1][x] == origin) pixels = replace(pixels, y-1, x, r, origin);
		if( x+1 < pixels[0].length && pixels[y][x+1] == origin) pixels = replace(pixels, y+1, x+1, r, origin);
		if(x-1 >= 0 && pixels[y][x-1] == origin) pixels = replace(pixels, y, x-1, r, origin);
		
		
		return pixels;
		
	}
	
}
