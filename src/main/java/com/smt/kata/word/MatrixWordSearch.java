package com.smt.kata.word;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.siliconmtn.data.text.StringUtil;

/****************************************************************************
 * <b>Title</b>: MatrixWordSearch.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Word Search
 * 
 * Given an m x n grid of characters board and a string word, return true if word 
 * exists in the grid.
 * 
 * The word can be constructed from letters of sequentially adjacent cells, 
 * where adjacent cells are horizontally or vertically neighboring. The same letter 
 * cell may not be used more than once.
 * 
 * Example 1:
 * https://assets.leetcode.com/uploads/2020/11/04/word2.jpg
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * Output: true
 * 
 * Example 2:
 * https://assets.leetcode.com/uploads/2020/11/04/word-1.jpg
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
 * Output: true
 * 
 * Example 3:
 * https://assets.leetcode.com/uploads/2020/10/15/word3.jpg
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
 * Output: false
 * 
 * Constraints:
 * m == board.length
 * n = board[i].length
 * 1 <= m, n <= 6
 * 1 <= word.length <= 15
 * board and word consists of only lowercase and uppercase English letters.
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Sep 28, 2021
 * @updates:
 ****************************************************************************/
public class MatrixWordSearch {
	String[][] board;
	/**
	 * Finds the word on the board with sequential boxes on the board
	 * @param board Word board to search
	 * @param word Word to find on the board
	 * @return True if found.  False otherwise
	 */
	public boolean find(String[][] boardVals, String word) {
		boolean exists = false;
		if(boardVals ==null || boardVals.length < 1 || boardVals[0].length <= 1 || StringUtil.isEmpty(word) ) 
			return false;
		board = boardVals;
		List<String> pos = new ArrayList<>();
		
		for (int y = 0; y < boardVals.length; y++) {
			for (int x = 0; x < boardVals[y].length; x++) {
				if( word.startsWith(board[y][x]) ) {
					pos.add(y+" "+x);
					exists = getNext(word.substring(1), y, x, pos, false);
					pos = new ArrayList<>();
					if(exists) return true;
				}
			}
		}
		
			
			
			
		return false;
	}
	
	public boolean getNext(String word, int y, int x, List<String> pos, boolean is) {
		if(StringUtil.isEmpty(word) ) return true;
		
		// check up
		if(y-1 >= 0 && word.startsWith( board[y-1][x] )  &&  !pos.contains((y-1)+" "+x)) {
			pos.add( (y-1)+" "+x );
			is =  word.length() == 1  ? true : getNext(word.substring(1),  y-1, x, pos, is);
		}
		// check down
		if(y+1 < board .length && word.startsWith( board[y+1][x] )  && !pos.contains((y+1)+" "+x) ) {
			pos.add( (y+1)+" "+x );
			is =   word.length() == 1  ? true : getNext(word.substring(1),  y+1, x, pos, is);
		}
		// check right
		if(x+1 < board.length && word.startsWith( board[y][x+1] )  && !pos.contains(y+" "+(x+1)) ) {
			pos.add( y+" "+(x+1) );
			is =  word.length() == 1  ? true : getNext(word.substring(1),  y, x+1, pos, is);
		}
		// check left
		if(x-1 >= 0 && word.startsWith( board[y][x-1] ) && !pos.contains((y)+" "+(x-1)) ) {
			pos.add( y+" "+(x-1) );
			is = word.length() == 1  ? true : getNext(word.substring(1),  y, x-1, pos, is);
		}

		return is;
	}
}
