package com.smt.kata.code;

/****************************************************************************
 * <b>Title</b>: IdenticalNeighbors.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Remove Identical Neighbors
 * 
 * Write a method that takes a list and deletes any elements that are the same 
 * as an element next to them.
 * 
 * Here are some examples:
 * {1,2,1,2} → {1,2,1,2}
 * {2,1,1,2} → {2,2}
 * {2,2,1,1} → {}
 * 
 * Except at the ends, any element has two neighbors, one on either side. In this 
 * challenge, drop runs of identical neighbors.
 * 
 * Write a function RemoveIdenticalNeighbors that takes a list and outputs a modified 
 * list in which any element next to an identical element has been removed.
 * 
 * In[1]:=RemoveIdenticalNeighbors[{1, 2, 2, 3, 4, 3, 5, 5, 6, 7, 8, 8}]
 * Out[1]={1, 3, 4, 3, 6, 7}
 * 
 * if there are an odd set of elements in a row, all are removed except one
 * In[1]:=RemoveIdenticalNeighbors[{1, 2, 2, 2, 3, 4, 3, 5, 5, 6, 7, 8, 8}]
 * Out[1]={1, 2, 3, 4, 3, 6, 7}
 * 
 * You may NOT use collections.  Standard java primitives/arrays only.
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since May 6, 2021
 * @updates:
 ****************************************************************************/
public class IdenticalNeighbors {

	/**
	 * 
	 * @param elements
	 * @return
	 */
	public int[] parse(int[] elements) {
		if (elements == null || elements.length == 0) return new int[0]; 
		if (elements.length <= 1 ) return new int[1]; 
		
		 int prev = elements[0];
		 int[] ret = new int[0];
  		 
 		 for (int i = 0; i < elements.length-1; i++) {
 			
 			 System.out.println("p "  + i + "  " + prev);

 			 if (elements[i] == elements[i+1]) {
 				 i+=1;
 			 }
 			 else ret = copy(ret, elements[i]);
		}
 		 if (elements[elements.length-1] !=  elements[elements.length-2]) {
				ret = copy(ret, elements[elements.length-1]);
			 }
		return ret;
	}
	public static int[] copy(int[] n, int j) {
		int[] copy = new  int[(n.length + 1)];
		for (int i = 0; i < n.length; i++) {
			copy[i] = n[i];
		}
		copy[copy.length-1] = j;
		return copy;
	}
	
}
