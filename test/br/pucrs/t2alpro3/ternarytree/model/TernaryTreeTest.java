package br.pucrs.t2alpro3.ternarytree.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TernaryTreeTest {

	private TernaryTree ternaryTree;
	
	@Before
	public void init() {
		
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
	
	@Test
	public void testMergeForInput2Output11WithTreeAsEntry() {
		final String entry = "input2output11.txt";
		LeftTree leftTree = new LeftTree(entry);
		RightTree rightTree = new RightTree(entry);
		
		ternaryTree = new TernaryTree(leftTree, rightTree);
		int expected = 11;
		int actual = ternaryTree.merge(ternaryTree.getLeftTree(), ternaryTree.getRightTree());
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testMergeForInput4Output251() {
		ternaryTree = new TernaryTree("input4output251.txt");
		int expected = 251;
		int actual = ternaryTree.merge(ternaryTree.getLeftTree(), ternaryTree.getRightTree());
		
		assertEquals(expected, actual);
	}
	
}
