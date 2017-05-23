package br.pucrs.t2alpro3.ternarytree;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TernaryTreeTest {

	private TernaryTree ternaryTree;
	private LeftTree leftTree;
	private RightTree rightTree;
	
	@Before
	public void init() {
		ternaryTree = new TernaryTree();
		leftTree = new LeftTree();
		rightTree = new RightTree();
	}
	
	@Test // C: 3 3 0 2 2 0 0 1 0 3  D: 2 2 0 0 1 2 0 S: 3
	public void correctOutputTest() {
		leftTree.load("3 3 0 2 2 0 0 1 0 3");
		rightTree.load("2 2 0 0 1 2 0");
		int expected = 3;
		int actual = ternaryTree.merge(leftTree, rightTree);
		
		assertEquals(expected, actual);
	}
	
}
