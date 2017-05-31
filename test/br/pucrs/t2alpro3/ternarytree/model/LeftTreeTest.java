package br.pucrs.t2alpro3.ternarytree.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

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
		lt.buildLeftTree("input2output11.txt");
		
		assertEquals(lt.find(1).getValue(), 1);
		assertEquals(lt.find(11), null);
		
		assertEquals(lt.find(5).getParent().getValue(), lt.find(4).getValue());
	}
}
