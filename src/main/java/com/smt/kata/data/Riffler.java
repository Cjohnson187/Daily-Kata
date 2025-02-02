package com.smt.kata.data;

// Spacelibs 1.x
import com.siliconmtn.data.bean.GenericVO;

/****************************************************************************
 * <b>Title:</b> Riffler.java
 * <b>Project:</b> SMT-Kata
 * <b>Description:</b> Riffler
 * 
 * Riffle takes two lists and alternately puts their elements into one list: 
 * 
 * Riffle[{a,b,c},{1,2,3}] 
 * {a,1,b,2,c,3} 
 * 
 * Write a method that implements the riffle.  Note, the source array can be equal
 * in length to the 2nd array.  It can also be one item larger.  Any other scenario 
 * doesn't work
 * 
 * Write a method Deriffle that takes a list of any length and separates it into 
 * two lists. The first list should contain all of the entries with odd indices in 
 * the original list, and the second should contain all of the entries with even indices. 
 * 
 * Deriffle[{1,2,3,4,5}] 
 * {{1,3,5},{2,4}}
 * 
 * You **MUST** use arrays for this Kata. Collections are NOT to be used
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Apr 29, 2021
 * <b>updates:</b>
 * 
 ****************************************************************************/
public class Riffler {

	/**
	 * Combines the two arrays by alternating the elements from each array
	 * @param source Source array.  Length must be greater than or equal to dest
	 * @param dest Destination array to combine.  Must be within 1 character of
	 * the source length
	 * @return Combined array.  Empty array if invalid data
	 */
	public char[] riffle(char[] source, char[] dest) {
		if (dest == null || source == null || dest.length > source.length || source.length - dest.length > 1) return new char[0];
		int len = source.length + dest.length;
		int sIndex = 0;
		int dIndex = 0;
		char[] combined = new char[len];
		for (int i = 0; i < len; i++) {
			
			if (i%2 == 0 ) {
				combined[i] = source[sIndex];
				sIndex++;
			}
			else {
				combined[i] = dest[dIndex];
				dIndex++;
			}
		}
		
		return combined;
	}
	
	/**
	 * Splits the passed array into 2 elements.  
	 * @param combined Array to deriffle
	 * @return Source array as key and the dest array as value
	 */
	public GenericVO deriffle(char[] combined) {
		if (combined.length<=0) return new GenericVO(null, null);
		GenericVO ret = new GenericVO();
		char[] source = new char[(combined.length/2) + (combined.length%2)];
		char[] dest = new char[combined.length/2];
		int sIndex = 0;
		int dIndex = 0;
		for (int i = 0; i < combined.length; i++) {
			if (i%2 == 0 ) {
				source[sIndex] = combined[i];
				sIndex++;
			}
			else {
				dest[dIndex] = combined[i];
				dIndex++;
			}
		}
		
		return new GenericVO(source, dest);
	}
}
