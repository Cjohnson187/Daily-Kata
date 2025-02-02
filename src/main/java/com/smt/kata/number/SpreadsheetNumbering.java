package com.smt.kata.number;

/****************************************************************************
 * <b>Title</b>: SpreadsheetNumbering.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Spreadsheet Numbering
 * Spreadsheets often use this alphabetical encoding for its columns: "A", "B", 
 * "C", ..., "AA", "AB", ..., "ZZ", "AAA", "AAB", ....
 * 
 * Given a column number, return its alphabetical column id. For example, given 1, 
 * return "A". Given 27, return "AA".
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Aug 10, 2021
 * @updates:
 ****************************************************************************/
public class SpreadsheetNumbering {

	/**
	 * Converts the number provided to the excel column labels
	 * @param col Decimal column number
	 * @return Excel column heading
	 */
	public String getColumnLabel(int col) {
		// A = 65
		//int rem = col%26;
		int div = col/26;
		char c = 65;
		int rem = 0;
		StringBuilder str = new StringBuilder();
		if(col < 26) {
			str.append((char) ((col)+64));
		}
		boolean run = true;
		while(col>0) {
			
			if (col > 26 ) {
				
				str.append( (char)((col/26)+64) );
				System.out.println("rem = " + rem);
			
			}
				
				char cur = (char) ((col/26)+64);
				rem = (col%26);
				
				str.append(cur);
				
				
				System.out.println(cur);
				col = col/26;
				if (col < 26 ) {
					str.append( (char)(rem+64) );
					System.out.println("rem = " + rem);
				
				}
				
			
		}
		
		
		
		//System.out.println(div + "  " + rem +   " " + c);
		return str.toString();
	}
}
