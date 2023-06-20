package com.chris.kata.conwayGameOfLife;

/****************************************************************************<br/>
 * <b>Title:</b> ConwayLife <br/>
 * <b>Project:</b> Daily-Kata <br/>
 * <b>Description:</b> CHANGE ME!! <br/> 
 * <b>Copyright:</b> Copyright (c) 2023 <br/>
 * <b>Company:</b> Silicon Mountain Technologies <br/>
 * <br/>
 * @author Chris Johnson <br/>
 * @version 1.0 <br/>
 * @since 6/5/23  <br/>
 * @hidden
 * <b>updates:</b> 
 *
 * <br/>
 ****************************************************************************/

/**
 * Given a 2D array and a number of generations, compute n timesteps of Conway's Game of Life.
 *
 * The rules of the game are:
 *
 * Any live cell with fewer than two live neighbours dies, as if caused by underpopulation.
 * Any live cell with more than three live neighbours dies, as if by overcrowding.
 * Any live cell with two or three live neighbours lives on to the next generation.
 * Any dead cell with exactly three live neighbours becomes a live cell.
 * Each cell's neighborhood is the 8 cells immediately around it (i.e. Moore Neighborhood).
 * The universe is infinite in both the x and y dimensions and all cells are initially dead - except for those specified in the arguments.
 * The return value should be a 2d array cropped around all of the living cells. (If there are no living cells, then return [[]].)
 *
 * For illustration purposes, 0 and 1 will be represented as ░░ and ▓▓ blocks respectively (PHP, C: plain black and white squares).
 * You can take advantage of the htmlize function to get a text representation of the universe, e.g.:
 *
 * System.out.println(LifeDebug.htmlize(cells));
 */

public class ConwayLife {

    public static int[][] getGeneration(int[][] cells, int generations) {
        // if cell < 2 live neighbors = dies
        // if cell >  live neighbors = dies
        // if cell == 2 || 3 live neighbors = lives
        // if cell dead 3 live neighbors = lives
        for (int y = 0; y < cells.length; y++) {
            for (int x = 0; x < cells[y].length; x++) {
                int numlive = checkNeighbors(cells, y, x);

                if(cells[y][x] == 1 && (numlive < 2 || numlive > 3)) {
                    cells[y][x] = 0;
                } else if(cells[y][x] == 0 && numlive == 3) {
                    cells[y][x] = 1;
                }
            }
        }
        return null;
    }

    public static int checkNeighbors(int[][] cells, int y, int x) {
        int live = 0;
        for (int i = y-1; i < y+2; i++) {
            for (int j = x-1; j < x+2; j++) {
                if(i==y && j == x) continue;
                else if (cells[y][x] == 1) live++;
            }
        }
        return live;
    }

}
