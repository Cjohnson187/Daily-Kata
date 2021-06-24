package com.smt.kata.tree;

import java.util.ArrayList;

import java.util.LinkedList;
// JDK 11.x
import java.util.List;

/****************************************************************************
 * <b>Title</b>: KataTree.java
 * <b>Project</b>: Daily-Kata
 * <b>Description: </b> This kata helps us build a tree data structure from a collection
 *  of nodes that have ids and parent ids.  This is an important structure to understand as 
 *  we will need to convert a collection of elements form a database (ids and parent ids) 
 *  and convert the data into an actual linked data structure or tree.  
 *  
 *  In this Kata, you will be receiving a collection of node objects that have the 
 *  proper linkage, but are not linked as a tree.  You must fill out the tree properly 
 *  as well as link the children and parent nodes to each other
 *  
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Jun 13, 2021
 * @updates:
 ****************************************************************************/
public class KataTree<T> {
	// Members
	private KataNode<T> root;
	private int depth = 0;
	private int totalNodeCount= 0;
	
	/**
	 * Creates a Tree of nodes based upon a Collection of unlinked nodes.  
	 * Uses the assigned Node as the root node.  The nodeId and the prentId is included
	 * in each node in the list.  Builds the 
	 * @param data Collection of unlinked Node objects
	 * @param root Root Node object
	 */
	public KataTree(List<KataNode<T>> data,  KataNode<T> root) {
		this.root = root; 
		this.depth = 1;
		this.totalNodeCount = 1;

		addChildren(data, root, this.depth);
		//depth = calculateDepth(root);
		//print(root);
	}

	public void print(KataNode<T> root) {
		System.out.println("id = " + root.getNodeId());
		for(var v : root.getChildren()) {
			print(v);
		}

	}
	
	private void addChildren(List<KataNode<T>> data,  KataNode<T> root, int depth) {
		depth++;
		var rootChildren = new ArrayList<KataNode<T>>();

		
		for (var node : data) {
			if (node.getParentId().equals(root.getNodeId())) {
				totalNodeCount++;
				this.depth = Math.max(this.depth, depth);
				rootChildren.add(node);
				addChildren(data ,node , depth);
				//queue.add(node);
			}
			
		}
		
		
	
		root.setChildren(rootChildren);
	}


	
	/**
	 * Returns the total depth of the tree
	 * @return
	 */
	public int getDepth() { return depth; }
	
	/**
	 * Retrieves the root node, which, if the tree is built properly, would contain 
	 * the entire tree object
	 * @return Root node for this tree
	 */
	public KataNode<T> getRootNode() {
		return root;
	}
	
	/**
	 * Calculates the total number of nodes
	 * @return Total number of nodes calculated
	 */
	public int getTotalNodeCount() {
		return totalNodeCount;
	}
	
	/**
	 * Finds a node based upon its id
	 * @return node corresponding to the ID.  Null if not found
	 */
	public KataNode<T> find(String nodeData) {
		if(this.root.getData().equals(nodeData)){
			return this.root;
		}
		else {
			for (var v : root.getChildren()){
				this.root = v;
				find(nodeData);
			}
		}
		return null;
	}
	
	/**
	 * Gets a collection of nodes
	 * @return collection is provided in a preorder list formatting
	 */
	public List<KataNode<T>> getPreOrderList() {
		return new ArrayList<>();
	}
	
	/**
	 * Gets a collection of nodes
	 * @return collection is provided in a inorder list formatting
	 */
	public List<KataNode<T>> getInOrderList() {
		return new ArrayList<>();
	}
	
	/**
	 * Gets a collection of nodes
	 * @return collection is provided in a postorder list formatting
	 */
	public List<KataNode<T>> getPostOrderList() {
		return new ArrayList<>();
	}
	
	/**
	 * Gets a collection of nodes
	 * @return collection is provided in a level order list formatting
	 */
	public List<KataNode<T>> getLevelOrderList() {
		return new ArrayList<>();
	}
}
