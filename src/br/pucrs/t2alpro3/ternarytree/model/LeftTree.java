package br.pucrs.t2alpro3.ternarytree.model;

import java.util.ArrayList;
import java.util.List;

import br.pucrs.t2alpro3.ternarytree.enums.Position;
import br.pucrs.t2alpro3.ternarytree.utils.TreeUtils;

/**
 * 
 * @author nelsoncardosoo@gmail.com
 * 
 * Class that represents a left part of a ternary tree.
 *
 */
public class LeftTree {

	private Node root;

	public LeftTree() {
	}
	
	public LeftTree(String entry) {
		buildLeftTree(entry);
	}

	/**
	 * Load nodes from a formatted text entry
	 * @param entry
	 */
	public void buildLeftTree(String entry) {
		List<Node> nodes = new ArrayList<>();
		nodes = TreeUtils.loadNodesFromEntry(entry, Position.LEFT);
	
		for (Node n : nodes) {
			//add root
			if(this.root == null) {
				add(n, null, null);
				continue;
			}

			//if n already exists verify its children
			if(contains(n.getValue())) {
				try {
					if(!contains(n.getLeft().getValue())) {
						add(n.getLeft(), find(n.getValue()), Position.LEFT);
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
	 * 
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
		if (p.equals(Position.LEFT)) {
			node.setParent(parent);
			parent.setLeft(node);
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
	

	/**
	 * 
	 * @param nodes
	 * @return the longest path from the node passed per parameter
	 */
	public int getLongestCentralPath(List<Node> nodes) {
		int res = 1;
		int aux = 1;
		
		for(Node n : nodes) {
			Node n1 = n;
			while(n1.getCentral() != null) {
				aux++;
				n1 = n1.getCentral();
			}
			res = aux > res ? aux : res; 
			aux = 1;
		}
		
		return res ;
	}
	
	public List<Node> returnAllNodes(Node node){
	    List<Node> listOfNodes = new ArrayList<Node>();
	    addAllNodes(node, listOfNodes);
	    return listOfNodes;
	}

	private static void addAllNodes(Node node, List<Node> listOfNodes) {
	    if (node != null) {
	        listOfNodes.add(node);
	        List<Node> children = node.getChildren();
	        if (children != null) {
	            for (Node child: children) {
	                addAllNodes(child, listOfNodes);
	            }
	        }
	    }
	}
	
}
