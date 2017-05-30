package br.pucrs.t2alpro3.ternarytree.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.pucrs.t2alpro3.ternarytree.enums.Position;
import br.pucrs.t2alpro3.ternarytree.model.LeftTree;
import br.pucrs.t2alpro3.ternarytree.model.Node;
import br.pucrs.t2alpro3.ternarytree.model.RightTree;
import br.pucrs.t2alpro3.ternarytree.model.TernaryTree;

public class LeftTreeTest {

	private LeftTree lt;
	
	@Before
	public void init() {
		lt = new LeftTree();
	}
	
	@Test
	public void insertRootSucessfulTest() {
		Node root = new Node(1);
		lt.add(root, null, null);
		
		assertEquals(root.getValue(), lt.getRoot().getValue());
	}
	
	@Test
	public void contaisTest() {
		Node root = new Node(1);
		lt.add(root, null, null);
		
		Node node = new Node(4);
		lt.getRoot().setCentral(node);
		
		assertTrue(lt.contains(1));
		assertTrue(lt.contains(4));
		assertFalse(lt.contains(5));
	}
	
	@Test
	public void testFindExistingNode() {
		
		Node root = new Node(1);
		lt.add(root, null, null);
		
		Node node = new Node(4);
		lt.getRoot().setCentral(node);
		
		assertEquals(lt.find(4).getValue(), 4);
	}

	
	@Test
	public void loadTreeFromTextInput() {
		lt.load("input2output11.txt");
		
		assertEquals(lt.find(1).getValue(), 1);
		assertEquals(lt.find(11), null);
		
	}
	
	
	
}
