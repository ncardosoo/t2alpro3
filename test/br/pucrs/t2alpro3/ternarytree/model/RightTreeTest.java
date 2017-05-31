package br.pucrs.t2alpro3.ternarytree.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class RightTreeTest {

	private RightTree rt;
	
	@Before
	public void init() {
		rt = new RightTree();
	}
	
	@Test
	public void insertRootSucessfulTest() {
		Node root = new Node(1);
		rt.add(root, null, null);
		
		assertEquals(root.getValue(), rt.getRoot().getValue());
	}
	
	@Test
	public void contaisTest() {
		Node root = new Node(1);
		rt.add(root, null, null);
		
		Node node = new Node(4);
		rt.getRoot().setCentral(node);
		
		assertTrue(rt.contains(1));
		assertTrue(rt.contains(4));
		assertFalse(rt.contains(5));
	}
	
	@Test
	public void testFindExistingNode() {
		
		Node root = new Node(1);
		rt.add(root, null, null);
		
		Node node = new Node(4);
		rt.getRoot().setCentral(node);
		
		assertEquals(rt.find(4).getValue(), 4);
	}
	
	@Test
	public void loadTreeFromTextInput() {
		rt.buildRightTree("input2output11.txt");
		
		assertEquals(rt.find(1).getValue(), 1);
		assertEquals(rt.find(11), null);
		
		assertEquals(rt.find(5).getParent().getValue(), rt.find(3).getValue());
	}
}
