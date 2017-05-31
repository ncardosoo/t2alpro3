package br.pucrs.t2alpro3.ternarytree.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.pucrs.t2alpro3.ternarytree.enums.Position;
import br.pucrs.t2alpro3.ternarytree.utils.TreeUtils;

/**
 * 
 * @author nelsoncardosoo@gmail.com
 * 
 * Class that represents a right part of a ternary tree.
 *
 */
public class RightTree {

	private Node root;

	public RightTree() {

	}

	/**
	 * Load nodes from a formatted text entry
	 * @param entry
	 */
	public void buildRightTree(String entry) {
		List<Node> nodes = new ArrayList<>();
		nodes = TreeUtils.loadNodesFromEntry(entry, Position.RIGHT);
	
		for (Node n : nodes) {
			//add root
			if(this.root == null) {
				add(n, null, null);
				continue;
			}

			//if n already exists verify its children
			if(contains(n.getValue())) {
				try {
					if(!contains(n.getRight().getValue())) {
						add(n.getRight(), find(n.getValue()), Position.RIGHT);
					}
				} catch (NullPointerException npe) {
					
				}
				
				try {
					if(!contains(n.getCentral().getValue())) {
						add(n.getCentral(), find(n.getValue()), Position.CENTRAL);
					}
				} catch (NullPointerException npe) {
					
				}
			}
		}
	}

	/**
	 * Adds a specific node to its parent
	 * @param node
	 * @param parent
	 * @param p
	 */
	public void add(Node node, Node parent, Position p) {

		if (node == null && parent == null) {
			throw new IllegalArgumentException("Invalid arguments;");
		}

		if (root == null && node != null && parent == null && node.getValue() != 1) {
			throw new IllegalArgumentException("Root value must be 1;");
		}

		if (root == null && node != null && parent == null && node.getValue() == 1) {
			root = node;
			root.setParent(null);
			return;
		}

		if (!contains(parent.getValue())) {
			throw new IllegalArgumentException("Parent node not found;");
		}

		//TODO: verificar o que deve ser adicionado, se realmente precisa do find... ou se nao rpecisa do new
		if (p.equals(Position.RIGHT)) {
			node.setParent(parent);
			parent.setRight(node);
		} else if (p.equals(Position.CENTRAL)) {
			node.setParent(parent);
			parent.setCentral(node);
		}

	}

	public boolean contains(int value) {
		return contains(root, value);
	}

	private boolean contains(Node node, int value) {
		
		if(node == null) {
			return false;
		}
		
		if(null != node && node.getValue() == value) {
			return true;
		}
		
		for(Node n : node.getChildren()) {
			if(contains(n, value)) {
				return true;
			}
		}	
		
		return false;
	}

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}
	
	public Node find(int value) {
		return find(root, value);
	}

	/**
	 * 
	 * @param node
	 * @param value
	 * @return a specific node in the tree, null if does not exists
	 */
	private Node find(Node node, int value) {
		
		if(node != null && node.getValue() == value) {
			return node;
		}
		
		Node[] nodes = new Node[0];
		
		if(node != null) {
			nodes = node.getChildrenArray();
		} 
		
		Node res = null;
		
		if(nodes.length > 0) {
			for(int i = 0; res == null && i < nodes.length; i++) {
				res = find(nodes[i], value);
				if(res != null) {
					return res;
				}
			}
		}
		
		return null;
	}

	public static void main(String[] args) {
		RightTree t = new RightTree();
//		t.load("input1output3.txt");
		t.buildRightTree("input2output11.txt");
		
		System.out.println(t);
	}

}
