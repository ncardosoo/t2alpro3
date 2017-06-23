package br.pucrs.t2alpro3.ternarytree.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.pucrs.t2alpro3.ternarytree.utils.TreeUtils;

public class TernaryTreeTest {

	private TernaryTree ternaryTree;

	@Test
	public void testAllCases() throws InterruptedException {

		LeftTree lt = new LeftTree();
		RightTree rt = new RightTree();
		ternaryTree = new TernaryTree();

		int entryValue = 0;
		int expected = 0;
		int actual = 0;

		double initTime = System.currentTimeMillis();

		int i = 17;
//		for (i = 1; i < 41; i++) {
			ternaryTree = new TernaryTree("casos\\F\\input\\F_" + i);
			String entry = "casos\\F\\input\\F_" + 17;

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
			TreeUtils.countTreeOps = 0;
			entryValue = 0;
//		}

		double endTime = System.currentTimeMillis();
		double totalTime = (endTime - initTime) / 1000;
		System.out.println("Total time: " + totalTime + " seconds.");
	}

	private void initByThreads(LeftTree lt, RightTree rt) throws InterruptedException {
		Thread thread1 = new Thread() {
			public void run() {
				lt.buildLeftTree("casos\\F\\input\\F_" + 17);
			}
		};
		Thread thread2 = new Thread() {
			public void run() {
				rt.buildRightTree("casos\\F\\input\\F_" + 17);
			}
		};

		thread1.start();
		thread2.start();

		thread1.join();
		thread2.join();

		ternaryTree.setLeftTree(lt);
		ternaryTree.setRightTree(rt);
	}

}
