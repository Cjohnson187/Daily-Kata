package com.smt.kata.game;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
// JDK 11.x
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;

/****************************************************************************
 * <b>Title</b>: VoteCounting.java
 * <b>Project</b>: Daily-Kata
 * <b>Description: </b> Vote Counting
 * 
 * On election day, a voting machine writes data in the form ot a tab delimiter 
 * (voter_id \t candidate_id) to a text file. Write a program that reads this 
 * file as a stream and returns the top 3 candidates at any given time. If you 
 * find a voter voting more than once, report this as fraud.
 * 
 * The voting files are located in the resources/data folder
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Nov 4, 2021
 * @updates:
 ****************************************************************************/
public class VoteCounting {
	/**
	 * Location of the dictionary
	 */
	public static final String RESOURCE = "/data/voting_%d.txt";
	
	/**
	 * Candidates whom votes will be counted
	 */
	public enum Candidates {
		BILL, DAVE, BECKY, JOSE, CHRIS, DANIEL, JOSEPH, MARY
	}
	
	// Members
	private List<Integer> possibleFraudVotes = new ArrayList<>();
	
	private Map<Candidates, Integer> realVotes = new HashMap();

	/**
	 * Counts the votes for a given version
	 * @param version Version of the voter file to parse.  
	 * Example value of 1 -> voting_1.txt
	 * @return Top 3 vote getters
	 * @throws IOException If votes can't be loaded
	 */
	public List<Candidates> count(int version) throws IOException {
		List<Candidates> candidates = new ArrayList<>();
		List<Integer> votes = new ArrayList<>();
	
		
		String dir = String.format(RESOURCE, version);
		System.out.println( dir );
		File initialFile = new File(dir);
		
		try(InputStreamReader isr = new InputStreamReader(  this.getClass().getResourceAsStream(String.format(RESOURCE, version)));
				BufferedReader reader = new BufferedReader(isr);) {
		
	
			
			
			while (reader.ready()) {
				String line = reader.readLine();
				String[] vote = line.split("\t");
				System.out.println(Arrays.toString(vote));
				if (votes.contains(Integer.parseInt( vote[0]))) {
					possibleFraudVotes.add(Integer.parseInt( vote[0]));
				} else {
					votes.add(Integer.parseInt(vote[0]));
					//candidates.
					//if (realVotes.containsKey(vote))
					
				}
				System.out.println("line = " +reader.readLine());
			}
			
		} catch (Exception e) {
			System.out.println("Could not read file");
			e.printStackTrace();
		}
		
		return new ArrayList<>();
	}
	

	/**
	 * @return the possibleFraudVotes
	 */
	public List<Integer> getPossibleFraudVotes() {
		return possibleFraudVotes;
	}
	
	/**
	 * Method to check whether fraud may exist in the votes
	 * @return
	 */
	public boolean hasPotentialFraud() {
		return !possibleFraudVotes.isEmpty();
	}
}
