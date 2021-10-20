package com.smt.kata.game;

import java.util.ArrayList;
import java.util.List;

import com.smt.kata.distance.bean.CoordinateVO;

/****************************************************************************
 * <b>Title</b>: KingCheck.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> King Check
 * 
 * You are presented with an 8 by 8 matrix representing the positions of pieces 
 * on a chess board. The only pieces on the board are the black king and various 
 * white pieces. Given this matrix, determine whether the king is in check.
 * 
 * For details on how each piece moves, see here.
 * 
 * For example, given the following matrix:
 * 
 * { 'O','O','O','K','O','O','O','O' },
 * { 'O','O','O','O','O','O','O','O' },
 * { 'O','B','O','O','O','O','O','O' },
 * { 'O','O','O','O','O','O','P','O' },
 * { 'O','O','O','O','O','O','O','R' },
 * { 'O','O','N','O','O','O','O','O' },
 * { 'O','O','O','O','O','O','O','O' },
 * { 'O','O','O','O','O','Q','O','O' }
 * 
 * You should return True, since the bishop is attacking the king diagonally.
 * 
 * 'K' = King
 * 'Q' = Queen
 * 'P' = Pawn
 * 'B' = Bishop
 * 'R' = Rook
 * 'N' = Knight
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Oct 6, 2021
 * @updates:
 ****************************************************************************/
public class KingCheck {
    char[][] board;
    
    List<Character> pieces = new ArrayList<>();    
    
    CoordinateVO kingPos = null;
    CoordinateVO queenPos = null;
    CoordinateVO pawnPos = null;
    CoordinateVO bishopPos = null;
    CoordinateVO rookPos = null;
    CoordinateVO knightPos = null;
    
    /**
     * Assigns the chess board to the class
     * @param board Chess board
     */
    public KingCheck(char[][] board) {
        this.board = board;
    }

    /**
     * 
     * @param board
     * @return
     */
    public boolean isKingCheck() {
        initializePieces();
        
        kingPos = locatePieces('K', pieces, board);
        queenPos = locatePieces('Q', pieces, board);
        pawnPos = locatePieces('P', pieces, board);
        bishopPos = locatePieces('B', pieces, board);
        rookPos = locatePieces('R', pieces, board);
        knightPos = locatePieces('N', pieces, board);
        
        if(kingPos.getRow() == -1 || kingPos.getColumn() == -1)
        	return false;
        
        return isKingCheckByBishop(kingPos, bishopPos) || isKingCheckByKnight(kingPos, knightPos) || isKingCheckByPawn(kingPos, pawnPos) || isKingCheckByRook(kingPos, rookPos) || isKingCheckByQueen(kingPos, queenPos);
        
//        return board == null;
    }
    
    public void initializePieces() {
        pieces.add('K');
        pieces.add('Q');
        pieces.add('P');
        pieces.add('B');
        pieces.add('R');
        pieces.add('N');
    }
    
    public CoordinateVO locatePieces(Character peice, List<Character> pieces, char[][] board) {
        CoordinateVO vo = new CoordinateVO();
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if(String.valueOf(board[i][j]).equals(String.valueOf(peice))) {
                    vo.setRow(i);
                    vo.setColumn(j);
                    
                    return vo;
                }
                    
            }
        }
        
        if(vo.getRow() < 0)
        	vo.setRow(-1);
        if(vo.getColumn() < 0)
        	vo.setRow(-1);
        return vo;
    }
    
    public boolean isKingCheckByRook(CoordinateVO kingPos, CoordinateVO rookPos) {
    	if(rookPos.getRow() == -1 || rookPos.getColumn() == -1)
    		return false;
    	
        int row = rookPos.getRow();
        int column = rookPos.getColumn();

        for (int i = 0; i < 8; i++) {
            
            for (int j = 0; j < 8; j++) {
                
                if (kingPos.equals(new CoordinateVO(row+i, column))
                || (kingPos.equals(new CoordinateVO(row, column-j)))
                || (kingPos.equals(new CoordinateVO(row, column+j)))
                || (kingPos.equals(new CoordinateVO(row-i, column)))) {

                    return true;
                }
            }
        }
        
        return false;
    }

    public boolean isKingCheckByBishop(CoordinateVO kingPos, CoordinateVO bishopPos) {
    	if(bishopPos.getRow() == -1 || bishopPos.getColumn() == -1)
    		return false;
    	
        int row = bishopPos.getRow();
        int column = bishopPos.getColumn();

        for (int i = 0; i < 8; i++) {
            
            for (int j = 0; j < 8; j++) {
                
                if (kingPos.equals(new CoordinateVO(row+i, column+j))
                || (kingPos.equals(new CoordinateVO(row+i, column-j)))
                || (kingPos.equals(new CoordinateVO(row-i, column+j)))
                || (kingPos.equals(new CoordinateVO(row-i, column-j)))) {

                    return true;
                }
            }
        }
        
        return false;
    }
    
    public boolean isKingCheckByQueen(CoordinateVO kingPos, CoordinateVO queenPos) {
    	if(queenPos.getRow() == -1 || queenPos.getColumn() == -1)
    		return false;
    	
        return isKingCheckByBishop(kingPos, queenPos) || isKingCheckByRook(kingPos, queenPos);
    }

    public boolean isKingCheckByKnight(CoordinateVO kingPos, CoordinateVO knightPos) {
    	if(knightPos.getRow() == -1 || knightPos.getColumn() == -1)
    		return false;
    	
        List<CoordinateVO> knightPositions = new ArrayList<>();
        // up right
        knightPositions.add(new CoordinateVO(knightPos.getRow()+2, knightPos.getColumn()+1)  );
        // right up
        knightPositions.add(new CoordinateVO(knightPos.getRow()+1, knightPos.getColumn()+2)  );
        
        // up left
        knightPositions.add(new CoordinateVO(knightPos.getRow()+2, knightPos.getColumn()-1)  );
        // left up
        knightPositions.add(new CoordinateVO(knightPos.getRow()+1, knightPos.getColumn()-2)  );
        
        
        // down right
        knightPositions.add(new CoordinateVO(knightPos.getRow()-2, knightPos.getColumn()+1)  );
        // right down
        knightPositions.add(new CoordinateVO(knightPos.getRow()-1, knightPos.getColumn()+2)  );
        
        // down left
        knightPositions.add(new CoordinateVO(knightPos.getRow()-2, knightPos.getColumn()-1)  );
        // left down
        knightPositions.add(new CoordinateVO(knightPos.getRow()-1, knightPos.getColumn()-2)  );
        
        for(CoordinateVO vo : knightPositions) {
            if(kingPos.getRow() == vo.getRow() &&  kingPos.getColumn() == vo.getColumn()) {
                return true;
            }
        }
    
        return false;
    }
    
    public boolean isKingCheckByPawn(CoordinateVO kingPos, CoordinateVO pawnPos) {
    	if(pawnPos.getRow() == -1 || pawnPos.getColumn() == -1)
    		return false;
    	
        int row = pawnPos.getRow();
        int col = pawnPos.getColumn();
        
        for(int i=0; i<8; i++) {
            for(int j=0; j<8; j++) {
                if (kingPos.equals(new CoordinateVO(row+1, col+1))
                        || (kingPos.equals(new CoordinateVO(row-1, col-1)))
                        || (kingPos.equals(new CoordinateVO(row+1, col-1)))
                        || (kingPos.equals(new CoordinateVO(row-1, col+1)))) {

                            return true;
                        }
            }
        }
        
        return false;
    }
}