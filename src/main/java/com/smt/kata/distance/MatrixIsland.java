package com.smt.kata.distance;

import java.util.*;

/****************************************************************************
 * <b>Title:</b> MatrixIsland.java
 * <b>Project:</b> SMT-Kata
 * <b>Description:</b> Island Matrix
 * 
 * Given a matrix of 1s and 0s, return the number of "islands" in the matrix. 
 * A 1 represents land and 0 represents water, so an island is a group of 1s that are 
 * neighboring (horizontal or vertical or both.  Diagonal only does not count) whose 
 * perimeter is surrounded by water.  Land (1s) on the outside of the matrix are 
 * considered surrounded by water on those edges.  In other words, the matrix is 
 * surrounded by water. The smallest island has 1 node
 * 
 * For example, the largest island in this matrix is 4
 * 
 * 1 0 0 0 0
 * 0 0 1 1 0
 * 0 1 1 0 0
 * 0 0 0 0 0
 * 1 1 0 0 1
 * 1 1 0 0 1
 * 
 * Use whatever classes you want for this
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Apr 1, 2021
 * <b>updates:</b>
 * 
 ****************************************************************************/
public class MatrixIsland {
    // Members
    protected int[][] matrix;
    protected boolean hasIslands = false;
    protected int numberIslands = 0;
    protected int nodesInLargestIsland = 0;

    protected Set<String> coords = new HashSet<>();
    
    /**
     * Assigns the matrix
     */
    public MatrixIsland(int[][] matrix) throws NullPointerException {
        super();
        if(matrix == null || matrix.length < 1) throw new NullPointerException();
        this.matrix  = matrix;
        getIslands();
    }
    public void getIslands() {
        Set<String> emptyCoords = new HashSet<>();
        for (int y = 0; y < matrix.length; y++) {
            for (int x = 0; x < matrix[y].length ; x++) {
                emptyCoords.clear();
                Set<String> newCoords =  checkaround(emptyCoords, y, x);
                if (newCoords.size() > 0 ) {
                    nodesInLargestIsland = newCoords.size() > nodesInLargestIsland? newCoords.size(): nodesInLargestIsland;
                    coords.addAll(newCoords);
                    numberIslands++;
                }
            }
        }
    }
    public Set<String> checkaround(Set<String> newCoords, int y, int x) {
        if(matrix[y][x] == 1 && !coords.contains(""+y+x) && !newCoords.contains(""+y+x)) {
            newCoords.add(""+y+x);
            if(y-1 > 0 && !coords.contains(""+(y-1)+x) && !newCoords.contains(""+(y-1)+x)) newCoords.addAll(checkaround(newCoords, y-1, x));
            if(y+1 < matrix.length && !coords.contains(""+(y+1)+x) && !newCoords.contains(""+(y+1)+x)) newCoords.addAll(checkaround(newCoords, y+1, x));
            if(x-1 > 0 && !coords.contains(""+y+(x-1)) && !newCoords.contains(""+y+(x-1))) newCoords.addAll(checkaround(newCoords, y, x-1));
            if(x+1 < matrix[y].length && !coords.contains(""+y+(x+1)) && !newCoords.contains(""+y+(x+1))) newCoords.addAll(checkaround(newCoords, y, x+1));
        }
        return newCoords;
    }

    /**
     * @return the hasIslands
     */
    public boolean hasIslands() {
        for (int i = 0; i < matrix.length; i++) {
            if (Arrays.stream(matrix[i]).anyMatch(num-> num==1))
                hasIslands = true;
        }
        return hasIslands;
    }

    /**
     * @return the numberIslands
     */
    public int getNumberIslands() {
        return numberIslands;
    }

    /**
     * @return the nodesInLargestIsland
     */
    public int getNodesInLargestIsland() {
        return nodesInLargestIsland;
    }

}