package br.pucrs.t2alpro3.ternarytree.model;

import java.util.ArrayList;
import java.util.List;

import br.pucrs.t2alpro3.ternarytree.enums.Position;

public class Node implements Comparable<Node>{
	
	private Node parent;
	private Node central;
	private Node left;
	private Node right;
	private int value;
	private Position position;
	
	public Node(){
		
	}
	
	public Node(int value) {
		this.value = value;
	}

	public Node getCentral() {
		return central;
	}
	public void setCentral(Node central) {
		this.central = central;
	}
	public Node getLeft() {
		return left;
	}
	public void setLeft(Node left) {
		this.left = left;
	}
	public Node getRight() {
		return right;
	}
	public void setRight(Node right) {
		this.right = right;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}
	
	@Override
	public String toString() {
		return "[node] " + ""
				+ "{value:" + this.value + "} "
				+ "{left:" + this.left + "} "
				+ "{central:" + this.central + "} "
				+ "{right:" + this.right + "}";
	}

	public List<Node> getChildren() {
		List<Node> children = new ArrayList<>();
		try {
			children.add(getLeft());
		} catch (NullPointerException e) {
		}
		
		try {
			children.add(getCentral());
		} catch (NullPointerException e) {
		}
		
		try {
			children.add(getRight());
		} catch (NullPointerException e) {
		}
		
		return children;
	}

	public Node[] getChildrenArray() {
		Node[] children = new Node[3];
		try {
			children[0] = getLeft();
		} catch (NullPointerException e) {
		}
		
		try {
			children[1] = getCentral();
		} catch (NullPointerException e) {
		} 
		
		try {
			children[2] = getRight();
		} catch (NullPointerException e) {
		}
		
		return children;
	}
	
	public int compareTo(Node other) {

		if(this.getValue() < other.getValue()) {
			return -1;
		}
        
		if (this.getValue() > other.getValue()) {
            return 1;
        }
        return 0;
    }

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}
}
