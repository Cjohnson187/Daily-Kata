package com.smt.kata.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/****************************************************************************
 * <b>Title</b>: WallsAndGates.java <b>Project</b>: SMT-Kata <b>Description:
 * </b> Walls and Gates Kata
 * 
 * You are given a m x n 2D grid initialized with these three possible values.
 * 
 * -1 - A wall or an obstacle. 0 - A gate. INF - Infinity means an empty room.
 * We use the value 231 - 1 = 2147483647 to r epresent INF as you may assume
 * that the distance to a gate is less than 2147483647.
 * 
 * Fill each empty room with the distance to its nearest gate. If it is
 * impossible to reach a gate, it should be filled with INF.
 * 
 * Example:
 * 
 * Given the 2D grid:
 * 
 * INF -1 0 INF INF INF INF -1 INF -1 INF -1 0 -1 INF INF
 * 
 * After running your function, the 2D grid should be:
 * 
 * 3 -1 0 1 2 2 1 -1 1 -1 2 -1 0 -1 3 4
 * 
 * **** Hint: Try using a depth first search algorithm
 * 
 * <b>Copyright:</b> Copyright (c) 2021 <b>Company:</b> Silicon Mountain
 * Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Aug 29, 2021
 * @updates:
 ****************************************************************************/
public class WallsAndGates {
	private final int INF = 99999999;

	/**
	 * Assigns the distance from each room to a gate
	 * 
	 * @param rooms Matrix of rooms, gates and walls
	 */
	public int[][] assign(int[][] rooms) {
if(rooms == null || rooms.length == 0 || rooms[0] == null || rooms[0].length == 0 ) return new int[0][];
        
        boolean update = true;
        int index = 0;
        int INF = 99999999;
        while (update) {
            update = false;
            for(int i = 0; i < rooms.length; i++) {
                for(int j = 0; j < rooms[i].length; j++) {
                    if(rooms[i][j] == index) {
                        
                        // check up
                        if(i - 1 >= 0 && rooms[i-1][j] != -1 && rooms[i-1][j] > index) {
                            rooms[i-1][j] = index + 1;
                            update = true;
                        }
                        
                        // check left
                        if(j - 1 >= 0 && rooms[i][j-1] != -1 && rooms[i][j-1] > index) {
                            rooms[i][j-1] = index + 1;
                            update = true;
                        }
                        
                        // check down
                        if(i + 1 < rooms.length && rooms[i+1][j] != - 1 && rooms[i+1][j] > index) {
                            rooms[i+1][j] = index + 1;
                            update = true;
                        }
                        
                        // check right
                        if(j + 1 < rooms[i].length && rooms[i][j+1] != -1 && rooms[i][j+1] > index) {
                            rooms[i][j+1] = index + 1;
                            update = true;
                        }
                    }
                }
            }
            index++;
        }
        return rooms;
		
	}
//		if ( rooms == null || rooms.length < 1 || rooms[0] == null||rooms[0].length < 1 )
//			return new int[0][];
//
//		for (int y = 0; y < rooms.length; y++) {
//			for (int x = 0; x < rooms[y].length; x++) {
//				if (rooms[y][x] == INF) {
//					List<Integer> moveList = new ArrayList<>();
//					List<int[]> visited = new ArrayList<>();
//					moveList = checkAround(y, x, rooms, 0, moveList, visited);
//					Collections.sort(moveList);
//					rooms[y][x] = !moveList.isEmpty() ? moveList.get(0) : INF;
//				}
//			}
//		}
//		return rooms;
//	}
//	
//	/**
//	 * check all possibilities and save successes
//	 * @param y
//	 * @param x
//	 * @param rooms
//	 * @param moves
//	 * @param moveList
//	 * @param visited
//	 * @return
//	 */
//	public List<Integer> checkAround(int y, int x, int[][] rooms, int moves, List<Integer> moveList, List<int[]> visited) {
//		// current location
//		int[] vis = new int[2];
//		vis[0] = y;
//		vis[1] = x;
//		visited.add(vis);
//		
//		// if success return list of moves
//		if (rooms[y][x] == 0) {
//			moveList.add(moves);
//			return moveList;
//		}
//		
//		// check left
//		if (x - 1 >= 0 && rooms[y][x - 1] != -1 && !contains(new int[] { y, x - 1 }, visited)) {
//			moveList = checkAround(y, x - 1, rooms, moves + 1, moveList, visited);
//		}
//		// check right
//		if (x + 1 < rooms[y].length && rooms[y][x + 1] != -1 && !contains(new int[] { y, x + 1 }, visited)) {
//			moveList = checkAround(y, x + 1, rooms, moves + 1, moveList, visited);
//		}
//		// check up
//		if (y - 1 >= 0 && rooms[y - 1][x] != -1 && !contains(new int[] { y - 1, x }, visited)) {
//			moveList = checkAround(y - 1, x, rooms, moves + 1, moveList, visited);
//		}
//		// check down
//		if (y + 1 < rooms.length && rooms[y + 1][x] != -1 && !contains(new int[] { y + 1, x }, visited)) {
//			moveList = checkAround(y + 1, x, rooms, moves + 1, moveList, visited);
//		}
//		return moveList;
//	}
//
//	/**
//	 * check if steps already taken
//	 * @param loc
//	 * @param locs
//	 * @return
//	 */
//	public boolean contains(int[] loc, List<int[]> locs) {
//		for (int[] is : locs) {
//			if (is[0] == loc[0] && is[1] == loc[1])
//				return true;
//		}
//		return false;
//	}
}
