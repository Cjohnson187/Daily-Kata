package com.smt.kata.tree;

import static org.mockito.Mockito.RETURNS_DEEP_STUBS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import com.siliconmtn.data.tree.Node;
import com.siliconmtn.data.tree.Tree;

/****************************************************************************
 * <b>Title</b>: OpenTheLock.java <b>Project</b>: SMT-Kata <b>Description: </b>
 * Open The Lock Kata
 * 
 * You have a lock in front of you with 4 circular wheels. Each wheel has 10
 * slots: '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'. The wheels can
 * rotate freely and wrap around: for example we can turn '9' to be '0', or '0'
 * to be '9'. Each move consists of turning one wheel one slot.
 * 
 * The lock initially starts at '0000', a string representing the state of the 4
 * wheels.
 * 
 * You are given a list of deadends dead ends, meaning if the lock displays any
 * of these codes, the wheels of the lock will stop turning and you will be
 * unable to open it.
 * 
 * Given a target representing the value of the wheels that will unlock the
 * lock, return the minimum total number of turns required to open the lock, or
 * -1 if it is impossible.
 * 
 * Example 1: Input: deadends = ["0201","0101","0102","1212","2002"], target =
 * "0202" Output: 6 Explanation: A sequence of valid moves would be "0000" ->
 * "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202". Note that a
 * sequence like "0000" -> "0001" -> "0002" -> "0102" -> "0202" would be
 * invalid, because the wheels of the lock become stuck after the display
 * becomes the dead end "0102".
 * 
 * Example 2: Input: deadends = ["8888"], target = "0009" Output: 1 Explanation:
 * We can turn the last wheel in reverse to move from "0000" -> "0009".
 * 
 * Example 3: Input: deadends =
 * ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
 * Output: -1 Explanation: We can't reach the target without getting stuck.
 * 
 ************************ Hint: Breadth First Search!!
 * 
 * <b>Copyright:</b> Copyright (c) 2021 <b>Company:</b> Silicon Mountain
 * Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Aug 26, 2021
 * @updates:
 ****************************************************************************/
public class OpenTheLock {

	/**
	 * Calculates the number of moves to unlock the lock
	 * 
	 * @param deadends Numbers that are not allowed to be used
	 * @param target   Combination to target
	 * @return Number of moves. -1 if it can't be accomplished
	 */
	public int calculatePath(String[] deadends, String target) {
		Tree tree = new Tree("0000", Arrays.asList(deadends));

		// fillTree(Arrays.asList(deadends), target, tree);

		return 0;
	}

	public void fillTree(List<String> deadends, String target, Node n) {
		for (char wheel : target.toCharArray()) {

		}
	}

	/**
	 * tree class
	 * 
	 * @author chrisjohnson
	 *
	 */
	public class Tree {
		int height;
		Node root;
		int numNodes;
		List<String> deadEnds;

		/**
		 * tree constructor
		 * 
		 * @param value
		 */
		public Tree(String value, List<String> deadEnds) {
			this.height = 0;
			this.root = new Node(value);
			this.numNodes = 1;
			this.deadEnds = deadEnds;
			fillTree(this.root);
		}

		/**
		 * Fill tree
		 * 
		 * @param invalid
		 */
		public void fillTree(Node node) {
			for (int i = 0; i < node.value.length(); i++) {
			
					// incremented value
					String inc = incWheel(node.getValue(), i);
					if (!exists(this.root, inc))
						node.addChild(inc);
					
					// decremented value
					String dec = decWheel(node.getValue(), i);
					if (!exists(this.root, dec)) 
						node.addChild(dec);

			

				
			}
		}

		/**
		 * increment wheel
		 * 
		 * @param val
		 * @param index
		 * @return
		 */
		public String incWheel(String val, int index) {
			char[] nums = val.toCharArray();
			if (nums[index] == '9') {
				return "";
				// nums[index ] = '0';
			} else {
				nums[index] += 1;
			}

			return new String(nums);
		}

		/**
		 * decrement wheel
		 * 
		 * @param val
		 * @param index
		 * @return
		 */
		public String decWheel(String val, int index) {
			char[] nums = val.toCharArray();
			if (nums[index] == '0') {

				nums[index] = '9';
			} else if (nums[index] == '1') {
				return "";
			} else {
				nums[index] -= 1;
			}
			return new String(nums);
		}

		/**
		 * get all the nodes on a specified level
		 * 
		 * @param level
		 * @return
		 */
		public List<Node> searchLevel(int level) {
			List<Node> levelNodes = new ArrayList<>();
			for (int i = 1; i < getHeight(); i++) {
				for (Node n : this.root.getChildren()) {
					if (n.getDepth() == level) {
						levelNodes.add(n);
					}
				}
			}
			return levelNodes;
		}

		/**
		 * search all levels for the shortest node with the given value
		 * 
		 * @param val
		 * @return
		 */
		public Node searchLevels(String val) {
			for (int i = 1; i < getHeight(); i++) {
				for (Node n : this.root.getChildren()) {
					if (n.getDepth() == i && n.getValue().equals(val)) {
						return n;
					}
				}
			}
			return null;
		}

		/**
		 * check if value is in tree
		 * 
		 * @param node
		 * @param val
		 * @return
		 */
		public boolean exists(Node node, String val) {
			for (Node n : node.getChildren()) {
				if (n.getValue().equals(val)) {
					return true;
				} else if (!n.getChildren().isEmpty()) {
					exists(n, val);
				}
			}
			return false;
		}

		/**
		 * get height of tree
		 * 
		 * @return
		 */
		public int getHeight() {
			for (Node n : root.getChildren()) {
				int nodeDepth = n.getDepth();
				if (n.getDepth() > this.height) {
					this.height = nodeDepth;
				}
			}
			return this.height;
		}

	}

	/**
	 * node class
	 * 
	 * @author chrisjohnson
	 *
	 */
	public class Node {
		String value;
		List<Node> children;
		int depth;

		/**
		 * Node constructor
		 * 
		 * @param value
		 */
		public Node(String value) {
			this.value = value;
			this.children = new ArrayList<>();
		}

		/**
		 * add a child and set the depth
		 * 
		 * @param val
		 */
		public void addChild(String val) {
			Node newChild = new Node(val);
			newChild.setDepth(this.depth + 1);
			this.children.add(newChild);
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public List<Node> getChildren() {
			return children;
		}

		public void setChildren(List<Node> children) {
			this.children = children;
		}

		public int getDepth() {
			return depth;
		}

		public void setDepth(int depth) {
			this.depth = depth;
		}

	}

}
