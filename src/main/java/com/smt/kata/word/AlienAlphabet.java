package com.smt.kata.word;

import java.util.ArrayList;
import java.util.List;

/****************************************************************************
 * <b>Title</b>: AlienAlphabet.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Alien Alphabet Kata
 * 
 * You come across a dictionary of sorted words in a language you've never seen 
 * before. Write a program that returns the correct order of letters in this language.
 * 
 * For example, given ['xww', 'wxyz', 'wxyw', 'ywx', 'ywz'], 
 * you should return ['x', 'z', 'w', 'y'].
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Aug 23, 2021
 * @updates:
 ****************************************************************************/
public class AlienAlphabet {

	/**
	 * Finds the "Alien" alphabet in order
	 * @param words List of words in the proper order
	 * @return Order of the characters
	 */
	public char[] alphabetize(String[] words) {
		if(words == null || words.length < 2 ) return new char[0];
		// return new char[0];

		List<Character> chArr = new ArrayList<Character>();

		// Finding the length of the longest word
		int lenOfLongestWord = 0;
		for(String word : words){
			if(word.length() > lenOfLongestWord)
				lenOfLongestWord = word.length();
		}

		int i=0;
		while(i < lenOfLongestWord){
			for(String word : words){
				if(i < word.length()){
					char ch = word.charAt(i);
					if(!chArr.contains(ch)){
						// Add
						if(i == 0){
							// First char of each word
							chArr.add(ch);
						}
						else{
							// Find all the words in the list that have the same first 2 chars.
							String subString = word.substring(0, i-1);
							List<String> arrRest = findRest(words, subString, i);
							System.out.println("arrRest => " + arrRest);
							StringBuilder sb = new StringBuilder();
							// Comparing the words...
							
							char find = word.substring(i).charAt(0);
							for(int j=0; j < arrRest.size() ; j++){
								char findInList = arrRest.get(j).substring(i).charAt(0);
								System.out.println("find = " + find + "  " + findInList);
								if(find  != findInList) {
									int indexDiff= j+i;
									char ins = (arrRest.get(j).substring(i ).charAt(0) );
									System.out.println("found char = " +ins + "   index  to ins = " + indexDiff);
									if(!chArr.contains(find)) {
										chArr.add(indexDiff, ins);
									}
									//chArr.add(indexDiff, ins);
								}
								
								
								// ywx,
								// ywz
								// enter different char before existing
							}
							
						}
					}
					//else
						// ignore
				}
			}
			i++;
		}
		System.out.println("final list  = " + chArr.toString());
		return chArr.toString().toCharArray()  ;
	}
	
	public List<String> findRest(String[] words, String subString, int i) {
		List<String> found = new ArrayList<>();
		for(String word: words ) {
			if (word.startsWith(subString)) {
				found.add(word);
			}
		}
		
		return  found;
	}

			
}

// We look at first char of each word and put in order => x, w, y
// We then look at second char of each word
// if(char is already part of the list => ignore
// else(new char that is not part of the list => 
// Then we go onto the 3rd char of each word





