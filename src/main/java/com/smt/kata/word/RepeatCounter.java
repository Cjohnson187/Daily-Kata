package com.smt.kata.word;

// JDK 11.x
import java.util.HashMap;
import java.util.Map;

/****************************************************************************
 * <b>Title</b>: RepeatCounter.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Repeat Counter
 * 
 * Given an array, create a function that returns an object detailing how many 
 * times each element was repeated. Any object type may be passed
 * 
 * calculate(["cat", "dog", "cat", "cow", "cow", "cow"]) ➞ { cow: 3, cat: 2, dog: 1 }
 * calculate([1, 5, 5, 5, 12, 12, 0, 0, 0, 0, 0, 0]) ➞ { 0: 6, 5: 3, 12: 2, 1: 1 }
 * calculate(["Infinity", "null", "Infinity", "null", "null"]) ➞ { null: 3, Infinity: 2}
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Jun 28, 2021
 * @updates:
 ****************************************************************************/
public class RepeatCounter {
	// Members
	private Map<Object, Integer> counter = new HashMap<>();
	
	/**
	 * Calculates how many duplicates for each object
	 * @param items Items to calculate
	 * @return Map with each object and it's count
	 */
	public Map<Object, Integer> calculate(Object[] items) {
		 
		Map<Object, Integer> ret = new HashMap<>();
		if(items == null) return ret;
		for (Object o: items) {
			if (ret.containsKey(o)) {
				ret.put(o, ret.get(o)+1);
			}
			else {
				ret.put(o, 1);
			}
		
		}
		
		return ret;
	}
	
	/**
	 * Simple Bean to be used to test complex objects
	 */
	class MyBean {
		// Members
		private Object key;
		private Object value;
		
		// Constructor to make life simpler
		public MyBean() { super(); }
		public MyBean(Object key, Object value) {
			super();
			this.key = key;
			this.value = value;
		}
		
		// Assign the getters and setters
		public Object getKey() { return key; }
		public Object getValue() { return value; }
		public void setKey(Object key) { this.key = key; }
		public void setValue(Object value) { this.value = value; }
		
		@Override
        public boolean equals(Object o) {
            if (!(o instanceof MyBean)) return false;
            MyBean check = (MyBean)o;

            return (getKey().equals(check.getKey()) && 
                    getValue().equals(check.getValue()));
        }
		
		@Override
        public int hashCode() {
			return 0;
          
        }
			
		
	}
}
