package br.pucrs.t2alpro3.ternarytree.model;

import br.pucrs.t2alpro3.ternarytree.utils.TreeUtils;

/**
 * 
 * @author Nelson
 * 
 * This class represents a ternary tree, which is implemented using two partial trees (LeftTree and RightTree).
 * 
 * TODO: Implement, in the merge method, the process to build a ternary tree by merging the partials 
 *
 */
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
		
		//e1
		int longestLeftPathFromRoot = leftTree.getLongestCentralPathFromRoot(leftTree.getRoot());
		//d1
		int longestRightPathFromRoot = rightTree.getLongestCentralPathFromRoot(rightTree.getRoot());

		//e
		int longLeftPath = leftTree.getLongestCentralPath(leftTree.returnAllNodes(leftTree.getRoot()));
		//d
		int longRightPath = rightTree.getLongestCentralPath(rightTree.returnAllNodes(rightTree.getRoot()));
		
		if(longestLeftPathFromRoot == longestRightPathFromRoot && longestRightPathFromRoot == 1) {
			return leftTree.getNodesCount() + rightTree.getNodesCount() - 1;
		}
		
		int totalNodesCount = leftTree.getNodesCount() + rightTree.getNodesCount();
		
		return totalNodesCount - Math.max(Math.min(longestLeftPathFromRoot, longRightPath), Math.min(longestRightPathFromRoot, longLeftPath));
		
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
	
	public static void main(String[] args) {
		TernaryTree ternaryTree = new TernaryTree("input2output11.txt");
		System.out.println(ternaryTree.merge(ternaryTree.leftTree, ternaryTree.getRightTree()));
		
	}

}
