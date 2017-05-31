package br.pucrs.t2alpro3.ternarytree.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.pucrs.t2alpro3.ternarytree.model.LeftTree;
import br.pucrs.t2alpro3.ternarytree.model.Node;
import br.pucrs.t2alpro3.ternarytree.model.RightTree;
import br.pucrs.t2alpro3.ternarytree.model.TernaryTree;

public class TernaryTreeTest {

	private TernaryTree ternaryTree;
	private LeftTree leftTree;
	private RightTree rightTree;
	
	@Before
	public void init() {
		
	}
	
	@Test
	public void testMergeForInput3Output6() {
		ternaryTree = new TernaryTree("input3output6.txt");
		int expected = 6;
		int actual = ternaryTree.merge(ternaryTree.getLeftTree(), ternaryTree.getRightTree());
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testMergeForInput2Output11() {
		ternaryTree = new TernaryTree("input2output11.txt");
		int expected = 11;
		int actual = ternaryTree.merge(ternaryTree.getLeftTree(), ternaryTree.getRightTree());
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testMergeForInput1Output3() {
		ternaryTree = new TernaryTree("input1output3.txt");
		int expected = 3;
		int actual = ternaryTree.merge(ternaryTree.getLeftTree(), ternaryTree.getRightTree());
		
		assertEquals(expected, actual);
	}
	
}
