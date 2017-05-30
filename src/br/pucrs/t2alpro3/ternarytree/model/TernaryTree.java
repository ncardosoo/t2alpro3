package br.pucrs.t2alpro3.ternarytree.model;

public class TernaryTree {

	private Node root;
	
	public TernaryTree() {
		
	}
	
	public TernaryTree(Node root) {
		this.setRoot(root);
	}
	
	public int merge(LeftTree leftTree, RightTree rightTree) {
		// TODO Auto-generated method stub
		return 3;
	}

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	public void add(Node node) {
		if(root == null) {
			root = node;						
		}
	}

}
