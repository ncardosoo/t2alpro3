package br.pucrs.t2alpro3.ternarytree.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TernaryTreeTest {

	private TernaryTree ternaryTree;
	
	@Before
	public void init() {
		
	}
	
	//input8output17257
	//input10output1044
	
	@Test
	public void testF_17() {
		ternaryTree = new TernaryTree("casos\\F\\input\\F_17");
		
		int expected = 15000;
		int actual = ternaryTree.merge(ternaryTree.getLeftTree(), ternaryTree.getRightTree());

		assertEquals(expected, actual);
	}
	
//	@Test
//	public void testMergeForInput9Output1655() {
//		ternaryTree = new TernaryTree("input9output1655.txt");
//		int expected = 1655;
//		int actual = ternaryTree.merge(ternaryTree.getLeftTree(), ternaryTree.getRightTree());
//		
//		assertEquals(expected, actual);
//	}
//	@Test
//	public void testMergeForInput2Output11() {
//		ternaryTree = new TernaryTree("input2output11.txt");
//		int expected = 11;
//		int actual = ternaryTree.merge(ternaryTree.getLeftTree(), ternaryTree.getRightTree());
//		
//		assertEquals(expected, actual);
//	}
//	
//	@Test
//	public void testMergeForInput1Output3() {
//		ternaryTree = new TernaryTree("input1output3.txt");
//		int expected = 3;
//		int actual = ternaryTree.merge(ternaryTree.getLeftTree(), ternaryTree.getRightTree());
//		
//		assertEquals(expected, actual);
//	}
//	
//	@Test
//	public void testMergeForInput6Output6() {
//		ternaryTree = new TernaryTree("input6output6.txt");
//		int expected = 6;
//		int actual = ternaryTree.merge(ternaryTree.getLeftTree(), ternaryTree.getRightTree());
//		
//		assertEquals(expected, actual);
//	}
//	
//	@Test
//	public void testMergeForInput7Output3() {
//		ternaryTree = new TernaryTree("input7output3.txt");
//		int expected = 3;
//		int actual = ternaryTree.merge(ternaryTree.getLeftTree(), ternaryTree.getRightTree());
//		
//		assertEquals(expected, actual);
//	}
//	
//	@Test
//	public void testMergeForInput2Output11WithTreeAsEntry() {
//		final String entry = "input2output11.txt";
//		LeftTree leftTree = new LeftTree(entry);
//		RightTree rightTree = new RightTree(entry);
//		
//		ternaryTree = new TernaryTree(leftTree, rightTree);
//		int expected = 11;
//		int actual = ternaryTree.merge(ternaryTree.getLeftTree(), ternaryTree.getRightTree());
//		
//		assertEquals(expected, actual);
//	}
//	
//	@Test
//	public void testMergeForInput4Output251() {
//		ternaryTree = new TernaryTree("input4output251.txt");
//		int expected = 251;
//		int actual = ternaryTree.merge(ternaryTree.getLeftTree(), ternaryTree.getRightTree());
//		
//		assertEquals(expected, actual);
//	}
	
//	@Test
//	public void testMergeForInput5Output249() {
//		ternaryTree = new TernaryTree("input5output249.txt");
//		int expected = 253;
//		int actual = ternaryTree.merge(ternaryTree.getLeftTree(), ternaryTree.getRightTree());
//		
//		assertEquals(expected, actual);
//	}
	
	
	
}
