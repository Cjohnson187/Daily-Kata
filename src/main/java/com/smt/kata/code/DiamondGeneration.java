package com.smt.kata.code;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
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
		if (l == null) {
			return new ArrayList<String>();
		} else if (l == 'A' || l == 'a') {
			return  Arrays.asList(Character.toUpperCase(l) + "");
		} else {
			List<String> diamond = new ArrayList<String>(((l-'A')*2) + 1);
			for (int i=0; i<=((l-'A')*2) + 1; i++) {
				diamond.add(i,"");
			}
			l = Character.toUpperCase(l);
			System.out.println( "l = " + l);
			int space = l - '@';
			System.out.println("space = " + space +"  " +(l-'A'));
			diamond.add(l-'A', (l+"") + " ".repeat(space) + (l-'A'+""));
			for (int i = l-'A'-1, j = ((l+'A') - '@') +1 ; i >= 0 ; i--, j++) {
				diamond.add(i, (l-- +"") + " ".repeat(space) + (l--+""));
				diamond.add(j, (l-- +"") + " ".repeat(space) + (l--+""));
			}
			
			System.out.println(diamond.toString());
			return diamond;
		}
	
	}
}
