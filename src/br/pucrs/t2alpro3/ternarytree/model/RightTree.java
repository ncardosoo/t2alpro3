package br.pucrs.t2alpro3.ternarytree.model;

import java.util.ArrayList;
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
	private int nodesCount;
	public RightTree() {
		setNodesCount(0);
	}
	
	public RightTree(String entry) {
		setNodesCount(0);
		buildRightTree(entry);
	}

	/**
	 * Load nodes from a formatted text entry
	 * @param entry
	 */
	public void buildRightTree(String entry) {
		List<Node> nodes = new ArrayList<>();
		nodes = TreeUtils.loadNodesFromEntry(entry, Position.RIGHT);
		setNodesCount(nodes.size());
		TreeUtils.incrementBy(1);
		
		for (Node n : nodes) {
			TreeUtils.incrementBy(1);
			//add root
			if(this.root == null) {
				TreeUtils.incrementBy(2);
				add(n, null, null);
				continue;
			}

			//if n already exists verify its children
			if(contains(n.getValue())) {
				try {
					if(!contains(n.getRight().getValue())) {
						TreeUtils.incrementBy(2);
						add(n.getRight(), find(n.getValue()), Position.RIGHT);
					}
				} catch (NullPointerException npe) {
					
				}
				
				try {
					if(!contains(n.getCentral().getValue())) {
						TreeUtils.incrementBy(2);
						add(n.getCentral(), find(n.getValue()), Position.CENTRAL);
					}
				} catch (NullPointerException npe) {
					
				}
			}
		}
	}
	
	/**
	 * 
	 * @param nodes
	 * @return the longest path from the root
	 */
	public int getLongestCentralPathFromRoot(Node node) {
		if(node.getCentral() == null) {
			TreeUtils.incrementTreeOpsBy(2);
			TreeUtils.incrementBy(2);
			return 1;
		}

		int res = 1;
		TreeUtils.incrementTreeOpsBy(1);
		TreeUtils.incrementBy(1);
		while(node.getCentral() != null) {
			TreeUtils.incrementTreeOpsBy(2);
			TreeUtils.incrementBy(2);
			node= node.getCentral();
			res++;
			TreeUtils.incrementTreeOpsBy(4);
			TreeUtils.incrementBy(4);
		}
		
		TreeUtils.incrementTreeOpsBy(1);
		TreeUtils.incrementBy(1);
		return res ;
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
			TreeUtils.incrementBy(7);
			return;
		}

		if (!contains(parent.getValue())) {
			throw new IllegalArgumentException("Parent node not found;");
		}

		//TODO: verificar o que deve ser adicionado, se realmente precisa do find... ou se nao rpecisa do new
		if (p.equals(Position.RIGHT)) {
			node.setParent(parent);
			parent.setRight(node);
			TreeUtils.incrementBy(4);
		} else if (p.equals(Position.CENTRAL)) {
			node.setParent(parent);
			parent.setCentral(node);
			TreeUtils.incrementBy(4);
		}

	}

	public boolean contains(int value) {
		return contains(root, value);
	}

	private boolean contains(Node node, int value) {
		
		if(node == null) {
			TreeUtils.incrementBy(1);
			return false;
		}
		
		if(null != node && node.getValue() == value) {
			TreeUtils.incrementBy(3);
			return true;
		}
		
		for(Node n : node.getChildren()) {
			TreeUtils.incrementBy(2);
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
			TreeUtils.incrementBy(3);
			return node;
		}
		
		Node[] nodes = new Node[0];
		
		if(node != null) {
			nodes = node.getChildrenArray();
			TreeUtils.incrementBy(2);
		} 
		
		Node res = null;
		
		if(nodes.length > 0) {
			TreeUtils.incrementBy(3);
			for(int i = 0; res == null && i < nodes.length; i++) {
				TreeUtils.incrementBy(5);
				res = find(nodes[i], value);
				TreeUtils.incrementBy(2);
				if(res != null) {
					TreeUtils.incrementBy(1);
					return res;
				}
			}
		}
		TreeUtils.incrementBy(1);
		return null;
	}

	public int getLongestCentralPath(List<Node> nodes) {
		int res = 1;
		int aux = 1;
		
		TreeUtils.incrementTreeOpsBy(2);
		TreeUtils.incrementBy(1);
		
		for(Node n : nodes) {
			TreeUtils.incrementTreeOpsBy(1);
			TreeUtils.incrementBy(1);
			Node n1 = n;
			TreeUtils.incrementTreeOpsBy(1);
			TreeUtils.incrementBy(1);
			while(n1.getCentral() != null) {
				aux++;
				TreeUtils.incrementTreeOpsBy(4);
				TreeUtils.incrementBy(4);
				n1 = n1.getCentral();
				TreeUtils.incrementTreeOpsBy(2);
				TreeUtils.incrementBy(2);
			}
			res = aux > res ? aux : res; 
			aux = 1;
			TreeUtils.incrementTreeOpsBy(5);
			TreeUtils.incrementBy(5);
		}
		
		TreeUtils.incrementTreeOpsBy(1);
		TreeUtils.incrementBy(1);
		return res ;
	}
	
	public List<Node> returnAllNodes(Node node){
	    List<Node> listOfNodes = new ArrayList<Node>();
	    addAllNodes(node, listOfNodes);
	    return listOfNodes;
	}

	private void addAllNodes(Node node, List<Node> listOfNodes) {
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

	public int getNodesCount() {
		return nodesCount;
	}

	public void setNodesCount(int nodesCount) {
		this.nodesCount = nodesCount;
	}
	
}
