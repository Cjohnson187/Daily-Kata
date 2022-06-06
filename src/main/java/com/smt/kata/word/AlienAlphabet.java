package com.smt.kata.word;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.OptionalInt;
import java.util.Set;
import java.util.stream.IntStream;

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
		List<Node> nodes = new ArrayList<>();
		Graph graph = new Graph(words);
		
		
		return new char[0];
	}
}
class Graph {
	List<Node> nodes;
	Set<Character> chars;
	
	public Graph(String[] words) {
		this.nodes = new ArrayList<>();
		this.chars = new HashSet<>();
		for (String s : words) 
			Arrays.stream(s.toLowerCase().split("")).forEach((a) -> chars.add(Character.valueOf(a.charAt(0))));
		setEdges(words);
	}
	
	public Set<Character> getChars() {
		return this.chars;
	}
	
	public void setEdges(String[] words) {
		for(int i=0; i < words.length; i++) {
			for(int j=0; j < words.length; j++) {
				if (i ==j) continue;
				if (words[i].charAt(0) == words[j].charAt(0)) {
					//similar words
					checkLetter(Arrays.asList(words[i], words[j]));
					
				}
			}
		}
	}
	public Integer getNode(Character toFind) {
		return IntStream.range(0, nodes.size()).filter(i -> nodes.get(i).getVal() == toFind).findFirst().getAsInt();
	}
	
	public void setEdge(Character v, Character vx) {
		Node a = nodes.get(getNode(v));
		Node b = nodes.get(getNode(vx));
		a.setNext(b);
		
	}
	public void checkLetter(List<String> words) {
	words.sort((x , y) -> x.length() - y.length());
	
		for(int i=0; i < words.get(0).length(); i++) {
			if (words.get(0).charAt(i) != words.get(1).charAt(i))
				if (words.get(0).charAt(i) - words.get(1).charAt(i) > 0) {
					setEdge(words.get(0).charAt(i), words.get(1).charAt(i));
				} else {
					setEdge(words.get(1).charAt(i), words.get(0).charAt(i));
				}
				break;
		}
	}
	
	
	public List<Character>getAlphabet() {
		List<Character> alpha = new ArrayList<>();
		
		
		return alpha;
	}
}
class Node {
	Node prev;
	Node next;
	char value;
	
	public Node(char val) {
		this.value = val;
	}
	public void setVal(char val) {
		this.value = val;
	}
	public char getVal() {
		return this.value;
	}
	public void setNext(Node node) {
		this.next = node;
	}
	public Node getNext() {
		return this.next;
	}
	public char getNextVal() {
		return this.next.getVal();
	}
	public void setPrev(Node node) {
		this.prev = node;
	}
	public Node getPrev() {
		return this.prev;
	}
	public char getPrevVal() {
		return this.prev.getVal();
	}
	public int getEdgeSize() {
		int edges = 0;
		if(prev != null) edges++;
		if(next != null) edges++;
		return edges;
	}
}