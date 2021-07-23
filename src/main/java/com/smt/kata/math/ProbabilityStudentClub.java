package com.smt.kata.math;

// JDK 11.x
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;

/****************************************************************************
 * <b>Title</b>: ProbabilityStudentClub.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Probability Student Club
 * Alice wants to join her school's Probability Student Club. Membership dues are 
 * computed via one of two simple probabilistic games.
 * 
 * The first game: roll a die repeatedly. Stop rolling once you get a five followed 
 * by a six. Your number of rolls is the amount you pay, in dollars.
 * 
 * The second game: same, except that the stopping condition is a five followed by a five.
 * 
 * Iterate over each on at least 10 times and average the results.  Output should 
 * look similar to the following:
 * 
 * [2021-07-21 08:00:36] [INFO   ] The First Probability Took 34 rolls 
 * [2021-07-21 08:00:36] [INFO   ] The Second Probability Took 11 rolls 
 * [2021-07-21 08:00:36] [INFO   ] ************************************************** 
 * [2021-07-21 08:00:36] [INFO   ] The First Probability Took 77 rolls 
 * [2021-07-21 08:00:36] [INFO   ] The Second Probability Took 17 rolls 
 * [2021-07-21 08:00:36] [INFO   ] ************************************************** 
 * [2021-07-21 08:00:36] [INFO   ] The First Probability Took 24 rolls 
 * [2021-07-21 08:00:36] [INFO   ] The Second Probability Took 9 rolls 
 * [2021-07-21 08:00:36] [INFO   ] ************************************************** 
 * [2021-07-21 08:00:36] [INFO   ] The First Probability Took an average of 32 rolls 
 * [2021-07-21 08:00:36] [INFO   ] The Second Probability Took an average of 32 rolls 
 * 
 * Which of the two games should Alice elect to play? Does it even matter? 
 * Write a program to simulate the two games and calculate their expected value.
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Jul 20, 2021
 * @updates:
 ****************************************************************************/
/*
 * dice roll for one desired outcome 1/6
 * two desired resultes in a row 1/6 * 1/6 = 1/36 
 * 
 * initialize game
 * 
 * roll 
 * keep track of last roll
 * if desired num
 * 	- get count
 * 	- roll again
 * 	- check for desired num
 * 	- no? restart counter
 * 
 * 	* noun 
 * 		- roll number
 * 		- counter
 * 		- last roll number
 * 		- derired nums (first, second)
 *  	- number of games (at least 10)
 *  	-list of games
 * 
 * 	* verb
 * 		- roll die
 * 		- check num
 * 		- check if first or second roll
 * 		- get average
 * 
 */


public class ProbabilityStudentClub {
	
	// Members
	Logger logger = Logger.getLogger(ProbabilityStudentClub.class.getName());
	List<Game> games = new ArrayList<>();
	Random die;
	int limit;
	
	/**
	 * Constructor.  Change as needed
	 */
	public ProbabilityStudentClub(int limit) {
		super();
		System.setProperty("java.util.logging.SimpleFormatter.format","[%1$tF %1$tT] [%4$-7s] %5$s %n");
		logger.log(Level.INFO, "Starting Application");
		die = new Random();
		this.limit = limit;
	}
	
	/**
	 * play the number of games set by the limit
	 * @param first
	 * @param second
	 */
	public void play(int first, int second){
		this.games = new ArrayList<Game>();
		while(this.games.size() < this.limit) {
			this.games.add( playNewGame	(first, second) );
		}
		calcProb(); 
	}

	/**
	 * Play a singular game
	 * @param first
	 * @param second
	 * @return
	 */
	public Game playNewGame(int first, int second) {
		Game game = new Game(first,  second);
		
		
		while (true) {
			int roll = this.die.nextInt(6);
			game.incRolls();
			if (roll == game.getFirst() && !game.isFirstFound()) {
				game.setFirstFound(true);
				
			}
			else if(game.isFirstFound() && roll == game.getSecond()) {
				return game;
			}
			else if(game.isFirstFound() && game.getSecond() != roll) {
				game.resetRolls();
				game.setFirstFound(false);
			}
		}
		
		
	}
	
	/**
	 * print rolls and total prob
	 */
	public void calcProb() {
		int total = 0;
		for(Game g: this.games) {
			System.out.println("The First Probability Took "  + g.getRolls()+ " rolls ");
			total += g.getRolls();
		}
		System.out.println("The First Probability Took an average of " + (total/this.games.size()) + " rolls");
	}
	
	
	/**
	 * Calls and runs this code
	 * @param args not utilized
	 */
	public static void main(String[] args) {
		/** Entry Point Here **/
		// start prob with limit
		ProbabilityStudentClub prob = new ProbabilityStudentClub(1000);
		// play game 1
		prob.play(5, 5);
		// play game 2
		prob.play(5, 6);
	}
	
	
	/**
	 * Inner game class
	 * @author chrisjohnson
	 *
	 */
	class Game {
		int first;
		int second;
		boolean firstFound;
		boolean secondFound;
		boolean gameDone;
		int rolls;
		public Game(int first, int second) {
			super();
			this.first = first;
			this.second = second;
			this.rolls = 0;
			this.firstFound = false;
			this.secondFound = false;
		}
		public int getFirst() {
			return first;
		}

		public int getSecond() {
			return second;
		}

		public int getRolls() {
			return rolls;
		}
		public void incRolls() {
			this.rolls++;
		}
		public void resetRolls() {
			this.rolls = 0;
		}
		public boolean isFirstFound() {
			return firstFound;
		}
		public void setFirstFound(boolean firstFound) {
			this.firstFound = firstFound;
		}
		public boolean isSecondFound() {
			return secondFound;
		}
		public void setSecondFound(boolean secondFound) {
			this.secondFound = secondFound;
		}
		public boolean isGameDone() {
			return gameDone;
		}
		public void setGameDone(boolean gameDone) {
			this.gameDone = gameDone;
		}
		
		
	}
}
