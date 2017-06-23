package br.pucrs.t2alpro3.ternarytree.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.pucrs.t2alpro3.ternarytree.enums.Position;
import br.pucrs.t2alpro3.ternarytree.model.Node;

public class TreeUtils {

	public static long count = 0;
	public static long countTreeOps = 0;
	
	public static void incrementTreeOpsBy(int value) {
		countTreeOps = countTreeOps + value;
	}
	
	public static void incrementBy(int value) {
		count = count + value;
	}
	
	public static int getExpectedOutput(String file) {
		
		try {
			FileReader reader = new FileReader(file);
			BufferedReader buff = new BufferedReader(reader);

			String line = buff.readLine();
			return Integer.parseInt(line);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return -1;
		
	}

	public static List<Node> loadNodesFromEntry(String entry, Position treeType) {
		List<Node> nodes = new ArrayList<>();
		List<String> lines = new ArrayList<>();

		incrementBy(3);
		readTree(entry, lines, treeType);
		buildNodesFromList(lines, nodes, treeType);
		Collections.sort(nodes);
		return nodes;
	}
	
	private static void readTree(String entry, List<String> lines, Position treeType, List<Node> nodes) {

		if (Position.LEFT.equals(treeType)) {
			try {

				FileReader reader = new FileReader(entry);
				BufferedReader buff = new BufferedReader(reader);

				String line = buff.readLine();
				int counter = Integer.parseInt(line);
				line = buff.readLine();

				incrementBy(8);
				
				while (line != null && counter != 0) {
					lines.add(line);
					buildSingleNodeFromString(line, nodes, treeType);
					line = buff.readLine();
					counter--;
					incrementBy(6);
				}
				reader.close();
			} catch (IOException e) {
				System.err.printf("Error: %s.\n", e.getMessage());
			}
		} else if (Position.RIGHT.equals(treeType)) {
			try {
				FileReader reader = new FileReader(entry);
				BufferedReader buff = new BufferedReader(reader);

				String line = buff.readLine();
				int firstCounter = Integer.parseInt(line);
				incrementBy(8);
				while (firstCounter != 0) {
					line = buff.readLine();
					firstCounter--;
					incrementBy(5);
				}

				line = buff.readLine();
				line = buff.readLine();

				while (line != null) {
					lines.add(line);
					buildSingleNodeFromString(line, nodes, treeType);
					line = buff.readLine();
//					buildSingleNodesString(line, nodes, treeType);
					incrementBy(7);
				}

				reader.close();
			} catch (IOException e) {
				System.err.printf("Error: %s.\n", e.getMessage());
			}
		}
	}

	private static void readTree(String entry, List<String> lines, Position treeType) {

		if (Position.LEFT.equals(treeType)) {
			try {
				FileReader reader = new FileReader(entry);
				BufferedReader buff = new BufferedReader(reader);

				String line = buff.readLine();
				int counter = Integer.parseInt(line);
				line = buff.readLine();

				incrementBy(8);
				
				while (line != null && counter != 0) {
					lines.add(line);
					line = buff.readLine();
					counter--;
					incrementBy(7);
				}
				reader.close();
			} catch (IOException e) {
				System.err.printf("Error: %s.\n", e.getMessage());
			}
		} else if (Position.RIGHT.equals(treeType)) {
			try {
				FileReader reader = new FileReader(entry);
				BufferedReader buff = new BufferedReader(reader);

				String line = buff.readLine();
				int firstCounter = Integer.parseInt(line);
				incrementBy(8);
				while (firstCounter != 0) {
					line = buff.readLine();
					firstCounter--;
					incrementBy(5);
				}

				line = buff.readLine();
				line = buff.readLine();

				while (line != null) {
					lines.add(line);
					line = buff.readLine();
					incrementBy(7);
				}

				reader.close();
			} catch (IOException e) {
				System.err.printf("Error: %s.\n", e.getMessage());
			}
		}
	}

	private static void readTreeWithBuilder(String entry, List<String> lines, Position treeType) {

		if (Position.LEFT.equals(treeType)) {
			try {
				FileReader reader = new FileReader(entry);
				BufferedReader buff = new BufferedReader(reader);

				StringBuilder line = new StringBuilder(buff.readLine());
				int counter = Integer.parseInt(line.toString());
				line = new StringBuilder(buff.readLine());

				incrementBy(8);
				
				while (line != null && counter != 0) {
					lines.add(line.toString());
					line = new StringBuilder(buff.readLine());
					counter--;
					incrementBy(7);
				}
				reader.close();
			} catch (IOException e) {
				System.err.printf("Error: %s.\n", e.getMessage());
			}
		} else if (Position.RIGHT.equals(treeType)) {
			try {
				FileReader reader = new FileReader(entry);
				BufferedReader buff = new BufferedReader(reader);

				StringBuilder line = new StringBuilder(buff.readLine());
				int firstCounter = Integer.parseInt(line.toString());
				incrementBy(8);
				while (firstCounter != 0) {
					line = new StringBuilder(buff.readLine());
					firstCounter--;
					incrementBy(5);
				}

				line = new StringBuilder(buff.readLine());
				line = new StringBuilder(buff.readLine());

				while (line != null) {
					lines.add(line.toString());
					try {
						line = new StringBuilder(buff.readLine());
					} catch (Exception e) {
						// TODO: handle exception
					}
					incrementBy(7);
				}

				reader.close();
			} catch (IOException e) {
				System.err.printf("Error: %s.\n", e.getMessage());
			}
		}
	}
	
	private static void buildNodesFromList(List<String> lines, List<Node> nodes, Position treeType) {
		incrementBy(1);
		if (Position.LEFT.equals(treeType)) {
			for (String s : lines) {
				String ss[] = s.split(" ");
				Node aux = new Node(Integer.parseInt(ss[0]));
				int leftValue = Integer.parseInt(ss[1]);
				incrementBy(6);
				
				if (leftValue != 0) {
					aux.setLeft(new Node(leftValue));
					aux.getLeft().setParent(aux);
					incrementBy(2);
				} else {
					aux.setLeft(null);
					incrementBy(1);
				}
				int centralValue = Integer.parseInt(ss[2]);
				incrementBy(2);
				if (centralValue != 0) {
					aux.setCentral(new Node(centralValue));
					aux.getCentral().setParent(aux);
					incrementBy(2);
				} else {
					aux.setCentral(null);
					incrementBy(1);
				}
				nodes.add(aux);
				incrementBy(1);
			}
		} else if (Position.RIGHT.equals(treeType)) {
			for (String s : lines) {
				String ss[] = s.split(" ");
				
				Node aux = new Node(Integer.parseInt(ss[0]));
				int centralValue = Integer.parseInt(ss[1]);
				incrementBy(6);
				
				if (centralValue != 0) {
					aux.setCentral(new Node(centralValue));
					aux.getCentral().setParent(aux);
					incrementBy(2);
				} else {
					aux.setCentral(null);
					incrementBy(1);
				}
				int rightValue = Integer.parseInt(ss[2]);
				if (rightValue != 0) {
					aux.setRight(new Node(rightValue));
					aux.getRight().setParent(aux);
					incrementBy(2);
				} else {
					aux.setRight(null);
					incrementBy(1);
				}
				nodes.add(aux);
				incrementBy(1);
			}
		}

	}
	
	private static void buildSingleNodeFromString(String s, List<Node> nodes, Position treeType) {
		incrementBy(1);
		if (Position.LEFT.equals(treeType)) {
				Node aux = new Node(Integer.parseInt(s.split(" ")[0]));
				int leftValue = Integer.parseInt(s.split(" ")[1]);
				incrementBy(6);
				
				if (leftValue != 0) {
					aux.setLeft(new Node(leftValue));
					aux.getLeft().setParent(aux);
					incrementBy(2);
				} else {
					aux.setLeft(null);
					incrementBy(1);
				}
				int centralValue = Integer.parseInt(s.split(" ")[2]);
				incrementBy(2);
				if (centralValue != 0) {
					aux.setCentral(new Node(centralValue));
					aux.getCentral().setParent(aux);
					incrementBy(2);
				} else {
					aux.setCentral(null);
					incrementBy(1);
				}
				nodes.add(aux);
				incrementBy(1);
		} else if (Position.RIGHT.equals(treeType)) {

				Node aux = new Node(Integer.parseInt(s.split(" ")[0]));
				int centralValue = Integer.parseInt(s.split(" ")[1]);
				incrementBy(6);
				
				if (centralValue != 0) {
					aux.setCentral(new Node(centralValue));
					aux.getCentral().setParent(aux);
					incrementBy(2);
				} 
				int rightValue = Integer.parseInt(s.split(" ")[2]);
				if (rightValue != 0) {
					aux.setRight(new Node(rightValue));
					aux.getRight().setParent(aux);
					incrementBy(2);
				} 
				nodes.add(aux);
				incrementBy(1);
		}
	}


	public static long getCountTreeOps() {
		return countTreeOps;
	}

	public static void setCountTreeOps(long countTreeOps) {
		TreeUtils.countTreeOps = countTreeOps;
	}
	
}
