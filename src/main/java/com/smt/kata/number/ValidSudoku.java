package com.smt.kata.number;

/****************************************************************************
 * <b>Title</b>: ValidSudoku.java <b>Project</b>: SMT-Kata <b>Description: </b>
 * Valid Sudoku
 * 
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be
 * validated according to the following rules:
 * 
 * - Each row must contain the digits 1-9 without repetition. - Each column must
 * contain the digits 1-9 without repetition. - Each of the nine 3 x 3 sub-boxes
 * of the grid must contain the digits 1-9 without repetition.
 * 
 * Note: A Sudoku board (partially filled) could be valid but is not necessarily
 * solvable. Only the filled cells need to be validated according to the
 * mentioned rules.
 * 
 * Example 1
 * https://upload.wikimedia.org/wikipedia/commons/thumb/f/ff/Sudoku-by-L2G-20050714.svg/250px-Sudoku-by-L2G-20050714.svg.png
 * Input: board = [["5","3",".",".","7",".",".",".","."]
 * ,["6",".",".","1","9","5",".",".","."] ,[".","9","8",".",".",".",".","6","."]
 * ,["8",".",".",".","6",".",".",".","3"] ,["4",".",".","8",".","3",".",".","1"]
 * ,["7",".",".",".","2",".",".",".","6"] ,[".","6",".",".",".",".","2","8","."]
 * ,[".",".",".","4","1","9",".",".","5"]
 * ,[".",".",".",".","8",".",".","7","9"]] Output: true
 * 
 * Example 2: Input: board = [["8","3",".",".","7",".",".",".","."]
 * ,["6",".",".","1","9","5",".",".","."] ,[".","9","8",".",".",".",".","6","."]
 * ,["8",".",".",".","6",".",".",".","3"] ,["4",".",".","8",".","3",".",".","1"]
 * ,["7",".",".",".","2",".",".",".","6"] ,[".","6",".",".",".",".","2","8","."]
 * ,[".",".",".","4","1","9",".",".","5"]
 * ,[".",".",".",".","8",".",".","7","9"]] Output: false Explanation: Same as
 * Example 1, except with the 5 in the top left corner being modified to 8.
 * Since there are two 8's in the top left 3x3 sub-box, it is invalid.
 * 
 * Constraints: board.length == 9 board[i].length == 9 board[i][j] is a digit
 * 1-9 or '.'.
 * 
 * <b>Copyright:</b> Copyright (c) 2021 <b>Company:</b> Silicon Mountain
 * Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Sep 24, 2021
 * @updates:
 ****************************************************************************/
public class ValidSudoku {

	/**
	 * Determines if the values in the Sudoku board are valid
	 * 
	 * @param board Sudoku board to evaluate
	 * @return True if the values are valid. False otherwise
	 */
	public boolean isValid(String[][] board) {
		boolean result = true;
		
		result = this.checkRow(board);
		if(!result) return false;
		
		result  = this.checkCol(board);
		if(!result) return false;
		
		for (int i = 0; i < board.length; i+=3) {
			for (int j = 0; j < board[i].length; j+=3) {
				result = this.checkBox(board, i, j);
				if(!result) return false;
			}
		}
		
		return result;
	}

	public boolean checkRow(String[][] board) {
		for (int i = 0; i < board.length; i++) {
			StringBuilder numB = new StringBuilder(128);
			for (int j = 0; j < board[i].length; j++) {
				if (!board[i][j].equals(".") && -1 == numB.indexOf(board[i][j]))
					numB.append(board[i][j]);
				else if (!board[i][j].equals(".")&& numB.indexOf(board[i][j]) >= 0)
					return false;
			}
		}
		return true;
	}

	public boolean checkCol(String[][] board) {
		for (int i = 0; i < board[0].length; i++) {
			StringBuilder numB = new StringBuilder(128);
			for (int j = 0; j < board.length; j++) {
				if (!board[j][i].equals(".") && -1 == numB.indexOf(board[j][i]))
					numB.append(board[j][i]);
				else if (!board[j][i].equals(".") && numB.indexOf(board[j][i]) >= 0)
					return false;

			}
		}
		return true;
	}
	
	
	public boolean checkBox(String[][] board, int row, int col) {
		StringBuilder numB = new StringBuilder(128);
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (!board[i+row][j+col].equals(".") && -1 == numB.indexOf(board[i+row][j+col]))
					numB.append(board[i+row][j+col]);
				else if (!board[i+row][j+col].equals(".") && numB.indexOf(board[i+row][j+col]) >= 0) {
					return false;
				}
			}
		}
		return true;
	}
}
