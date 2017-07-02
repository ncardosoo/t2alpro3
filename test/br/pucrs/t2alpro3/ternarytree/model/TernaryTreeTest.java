package br.pucrs.t2alpro3.ternarytree.model;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

import br.pucrs.t2alpro3.ternarytree.utils.TreeUtils;

public class TernaryTreeTest {

	private TernaryTree ternaryTree;

	@Test
	public void testAllCases() throws InterruptedException {

		ternaryTree = new TernaryTree();

		int expected = 0;
		int actual = 0;

		double initTime = System.currentTimeMillis();

		String entry = "casos\\F\\input\\F_";
		
		for (int i = 1; i < 41; i++) {
			ternaryTree = new TernaryTree(entry + i);

			try {
				expected = TreeUtils.getExpectedOutput("casos\\F\\output\\F_" + i);
			} catch (IOException e) {
				e.printStackTrace();
			}
			actual = ternaryTree.merge();
 			int entryValue = ternaryTree.getLeftTree().getNodesCount() + ternaryTree.getRightTree().getNodesCount();

			/**
			 * Print an output with "entry;operations" format
			 */
			System.out.println(entryValue+ ";" + TreeUtils.count);

			assertEquals(expected, actual);

			TreeUtils.count = 0;
			TreeUtils.countTreeOps = 0;
		}

		double endTime = System.currentTimeMillis();
		double totalTime = (endTime - initTime) / 1000;
		System.out.println("Total time: " + totalTime + " seconds.");
	}

}
