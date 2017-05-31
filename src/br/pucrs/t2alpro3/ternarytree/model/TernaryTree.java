package br.pucrs.t2alpro3.ternarytree.model;

public class TernaryTree {

	
	private LeftTree leftTree;
	private RightTree rightTree;
	
	public TernaryTree() {
		
	}
	
	public TernaryTree(String entry) {
		leftTree = new LeftTree();
		rightTree = new RightTree();
		this.getLeftTree().buildLeftTree(entry);
		this.getRightTree().buildRightTree(entry);
	}
	
	public TernaryTree(LeftTree leftTree, RightTree rightTree) {
		this.setLeftTree(leftTree);
		this.setRightTree(rightTree);
	}
	
	/**
	 * 
	 * @param leftTree
	 * @param rightTree
	 * @return an int that represents the size of the merged tree
	 * 
	 * TODO: build the merged tree
	 */
	public int merge(LeftTree leftTree, RightTree rightTree) {
		int res = -1;
		
		int longLeftPath = leftTree.getLongestCentralPath(leftTree.returnAllNodes(leftTree.getRoot()));
		int longRightPath = rightTree.getLongestCentralPath(rightTree.returnAllNodes(rightTree.getRoot()));
		
		int leftTreeSize = leftTree.returnAllNodes(leftTree.getRoot()).size();
		int rightTreeSize = rightTree.returnAllNodes(rightTree.getRoot()).size();
		
		/*
		 * When the format of both tree is a simple line, in other words, they have just
		 * central nodes, return the size of the longest tree
		 */
		if(longLeftPath == leftTreeSize && longRightPath == rightTreeSize) {
			return leftTreeSize > rightTreeSize ? leftTreeSize : rightTreeSize;
		}
		
		int maxSize = leftTreeSize + rightTreeSize;
		int maxPath = longLeftPath > longRightPath ? longLeftPath : longRightPath;
		
		res = maxSize - maxPath;		
		
		return res;
	}

	public LeftTree getLeftTree() {
		return leftTree;
	}

	public void setLeftTree(LeftTree leftTree) {
		this.leftTree = leftTree;
	}

	public RightTree getRightTree() {
		return rightTree;
	}

	public void setRightTree(RightTree rightTree) {
		this.rightTree = rightTree;
	}

}
