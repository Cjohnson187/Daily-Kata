package com.smt.kata.word;

// JDK 11.x
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/****************************************************************************
 * <b>Title</b>: CircularArray.java <b>Project</b>: Daily-Kata <b>Description:
 * </b> Circular Array Kata
 * 
 * Given a list of words, determine whether the words can be chained to form a
 * circle. A word X can be placed in front of another word Y in a circle if the
 * last character of X is same as the first character of Y.
 * 
 * For example, the words ['chair', 'height', 'racket', touch', 'tunic'] can
 * form the following circle: chair --> racket --> touch --> height --> tunic
 * --> chair.
 * 
 * <b>Copyright:</b> Copyright (c) 2021 <b>Company:</b> Silicon Mountain
 * Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Sep 13, 2021
 * @updates:
 ****************************************************************************/
public class CircularArray {

	/**
	 * Creates the circular array from the array of words
	 * 
	 * @param words Words to reorder in a circular pattern
	 * @return Collection of words reordered. Empty list if not possible
	 */
	public List<String> create(String[] words) {
		if (words == null || words.length <= 1) 
			return new ArrayList<>();
		
		for (int i = 0; i < words.length; i++) {
			List<String> ret = new ArrayList<>();
			ret.add(words[i]);
			List<String> rem = new ArrayList<>();
			for (int j = 0; j < words.length; j++) 
				if(j!=i)
					rem.add(words[j]);
			
			ret = getNext(0, rem, ret);
			
			String last = ret.get(ret.size()-1);
			
			if(ret.size() == words.length 
					&& ret.get(0).startsWith(last.charAt(last.length()-1)+"")) {
				ret.add(ret.get(0));
				return ret;
			}
		}
		
		return new ArrayList<>();
	}
	
	public List<String> getNext(int index, List<String> rem,  List<String> ret) {
		if(!rem.isEmpty() && ret.get(ret.size()-1).endsWith(rem.get(index).charAt(0)+"")) {
			ret.add(rem.get(index));
			List<String> rem1 = new ArrayList<>();
			for (int j = 0; j < rem.size(); j++) 
				if(j!=index) 
					rem1.add(rem.get(j));
				
			ret = getNext(0, rem1, ret);	
		}
		else if (!rem.isEmpty() && index < rem.size()-1) 
			ret = getNext((index+1), rem, ret);
		
		return ret;
	}
	

}


