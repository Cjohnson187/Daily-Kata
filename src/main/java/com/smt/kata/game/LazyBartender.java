package com.smt.kata.game;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
// JDK 11.x
import java.util.List;
import java.util.Map;




/****************************************************************************
 * <b>Title</b>: LazyBartender.java <b>Project</b>: SMT-Kata <b>Description:
 * </b> Lazy Bartender Kata
 * 
 * At a popular bar, each customer has a set of favorite drinks, and will
 * happily accept any drink among this set. For example, in the following
 * situation, customer 0 will be satisfied with drinks 0, 1, 3, or 6.
 * 
 * preferences = { 0: [0, 1, 3, 6], 1: [1, 4, 7], 2: [2, 4, 7, 5], 3: [3, 2, 5],
 * 4: [5, 8] }
 * 
 * A lazy bartender working at this bar is trying to reduce his effort by
 * limiting the drink recipes he must memorize. Given a dictionary input such as
 * the one above, return the fewest number of drinks he must learn in order to
 * satisfy all customers.
 * 
 * For the input above, the answer would be 2, as drinks 1 and 5 will satisfy
 * everyone.
 * 
 * <b>Copyright:</b> Copyright (c) 2021 <b>Company:</b> Silicon Mountain
 * Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Nov 1, 2021
 * @updates:
 ****************************************************************************/
public class LazyBartender {
	List<Integer> drinkPossibilities;

	/**
	 * Finds the minimum number of drinks the bartender has to memorize to satisfy
	 * all customers
	 * 
	 * @param custDrinks Map of customers and their drink preferences
	 * @return Minimum number of drinks to memorize.
	 */
	public int minimumTypes(Map<Integer, List<Integer>> custDrinks) {
		if (custDrinks == null || custDrinks.isEmpty())
			return 0;
		else if (custDrinks.size() == 1)
			return 1;

		Map<Integer, List<Integer>> drinkRef = getDrinkefs(custDrinks);

		List<Integer> minRecipes = getDrinkbyCust(custDrinks, new ArrayList<>(), 0, drinkRef);

		minRecipes.sort(Comparator.naturalOrder());
		return minRecipes.get(0);
	}

	public List<Integer> getDrinkbyCust(Map<Integer, List<Integer>> custDrinks, List<Integer> drinkListSizes, int countingRecipes,
			 Map<Integer, List<Integer>> drinkRef) {
		if (custDrinks.isEmpty() || drinkRef.size() < 1){
			drinkListSizes.add(countingRecipes);
			return drinkListSizes;
		}
		
		for (Map.Entry<Integer, List<Integer>> entry : drinkRef.entrySet()) {
		
			Map<Integer, List<Integer>> newCustDrinks = new HashMap<>(custDrinks);
			for (Integer customer : entry.getValue()) 
				if (newCustDrinks.containsKey(customer)) 
					newCustDrinks.remove(customer);
				

			Map<Integer, List<Integer>> newDrinkRefs = new HashMap<>(drinkRef);
			newDrinkRefs.remove(entry.getKey());

			drinkListSizes = getDrinkbyCust(newCustDrinks, drinkListSizes, countingRecipes+1, newDrinkRefs);
		}

		return drinkListSizes;
	}

	public Map<Integer, List<Integer>> getDrinkefs(Map<Integer, List<Integer>> custDrinks) {
		Map<Integer, List<Integer>> drinkToCust = new HashMap<>();
		for (Map.Entry<Integer, List<Integer>> entry : custDrinks.entrySet()) {
			for (Integer drink : entry.getValue()) {

				if (drinkToCust.containsKey(drink) && !drinkToCust.get(drink).contains(entry.getKey())) {
					drinkToCust.get(drink).add(entry.getKey());
				} else {
					List<Integer> newCustomer = new ArrayList<>();
					newCustomer.add(entry.getKey());
					drinkToCust.put(drink, newCustomer);
				}
			}
		}
		return drinkToCust;
	}
}
