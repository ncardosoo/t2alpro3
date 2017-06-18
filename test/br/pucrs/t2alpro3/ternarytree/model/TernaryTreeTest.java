package br.pucrs.t2alpro3.ternarytree.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.pucrs.t2alpro3.ternarytree.utils.TreeUtils;

public class TernaryTreeTest {

	private TernaryTree ternaryTree;
	
	@Test
	public void testAllCases() {

		int entryValue = 0;
		int expected = 0;
		int actual = 0;
		
		double initTime = System.currentTimeMillis();
		
		for(int i = 1; i < 41; i++) {
			ternaryTree = new TernaryTree("casos\\F\\input\\F_" + i);
			expected = TreeUtils.getExpectedOutput("casos\\F\\output\\F_" + i);
			actual = ternaryTree.merge();
			entryValue = ternaryTree.getLeftTree().getNodesCount() + ternaryTree.getRightTree().getNodesCount();
		
			/**
			 * Print an output with "entry;operations" format
			 */
			System.out.print(entryValue + ";");
			System.out.println(TreeUtils.count);
			
			assertEquals(expected, actual);
			
			TreeUtils.count = 0;
			entryValue = 0;
		}
		
		double endTime = System.currentTimeMillis();
		double totalTime = (endTime - initTime) / 1000;
		
		System.out.println("Total time: " + totalTime + " seconds.");
		
		assertEquals(1, 1);
	}
	
}
