package com.smt.kata.code1;
import java.util.ArrayList;
import java.util.List;

/**
 * Problem Description
 * 
 * Given a letter, print a diamond starting with ‘A’ with the supplied letter at the widest point.
 * 
 * For example: generateDiamond ‘C’ prints
 *   A
 *  B B
 * C   C
 *  B B
 *   A
 * 
 * Given character should be a printable letter in the range of [A-Z]
 * Lowercase character would be promoted to uppercase.
 * Non-Printable or non-letter characters would return empty.
 * 
 * <b>Copyright:</b> Copyright (c) 2022
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author raptor
 * @version 3.0
 * @since May 17, 2022
 *
 */
public class DiamondGeneration {

	/**
	 * Generates List of Strings consisting of diamond pattern for given
	 * character 
	 * @param l
	 * @return
	 */
	public List<String> generateDiamond(Character l) {
		List<String> diamond = new ArrayList<>();
		if(l == null) return diamond;
		int space = 0;
		char start = 'A';
		
		if(l.charValue() <= 122 && l.charValue() >= 97) {
			 l = Character.toUpperCase(l);
		}

		if(l.charValue() == 'A' ) {
			diamond.add('A'+"");
			return diamond;
		}
		if (l.charValue() <= 90 && l.charValue() >= 65) {
			int offset = l-'A';
			diamond.add((" ".repeat(offset))+start+""+(" ".repeat(offset)));
			start ++;
			while (l.charValue() != start) {
				offset--;
				space = space == 0? space+1: space+2;
				diamond.add((" ".repeat(offset))+(start+"")+(" ".repeat(space)) +(start+"") +(" ".repeat(offset)));
				start ++;
				
			}
			
			diamond.add((start+"")+(" ".repeat(space+=2)) +(start+""));
			start--;
			
			while (start != 'A') {
				space = space == 2? space-1: space-2;
				diamond.add((" ".repeat(offset))+(start+"")+(" ".repeat(space)) +(start+"") +(" ".repeat(offset)));
				offset++;
				start --;
				
			}
			diamond.add((" ".repeat(offset))+'A'+""+(" ".repeat(offset)));
			
		} 
			
		return diamond;
	}
}