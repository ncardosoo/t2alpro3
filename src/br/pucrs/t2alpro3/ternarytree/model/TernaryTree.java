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
	
	public int merge() {
		return merge(leftTree, rightTree); 		
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
		TreeUtils.incrementTreeOpsBy(2);
		TreeUtils.incrementBy(2);
		//d1
		int longestRightPathFromRoot = rightTree.getLongestCentralPathFromRoot(rightTree.getRoot());
		TreeUtils.incrementTreeOpsBy(2);
		TreeUtils.incrementBy(2);
		//e
		int longLeftPath = leftTree.getLongestCentralPath(leftTree.returnAllNodes(leftTree.getRoot()));
		TreeUtils.incrementTreeOpsBy(2);
		TreeUtils.incrementBy(2);
		//d
		int longRightPath = rightTree.getLongestCentralPath(rightTree.returnAllNodes(rightTree.getRoot()));
		TreeUtils.incrementTreeOpsBy(2);
		TreeUtils.incrementBy(2);
		if(longestLeftPathFromRoot == longestRightPathFromRoot && longestRightPathFromRoot == 1) {
			TreeUtils.incrementTreeOpsBy(6);
			TreeUtils.incrementBy(6);
			return leftTree.getNodesCount() + rightTree.getNodesCount() - 1;
		}
		
		int totalNodesCount = leftTree.getNodesCount() + rightTree.getNodesCount();
		TreeUtils.incrementTreeOpsBy(4);
		
		TreeUtils.incrementTreeOpsBy(8);
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

}
