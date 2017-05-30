package br.pucrs.t2alpro3.ternarytree.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.pucrs.t2alpro3.ternarytree.model.LeftTree;
import br.pucrs.t2alpro3.ternarytree.model.Node;

public class TreeUtils {

	public static LeftTree buildLeftTree(String entry) {
		LeftTree leftTree = new LeftTree();
		
		
		return leftTree;
		
	}
	
	public static List<Node> loadNodesFromEntry(String entry) {
		List<Node> nodes = new ArrayList<>();
		List<String> lines = new ArrayList<>();
		
		readFile(entry, lines);
		buildNodesFromList(lines, nodes);
		return nodes;
	}
	
	private static void readFile(String entry, List<String> lines) {
		try {
			FileReader reader = new FileReader(entry);
			BufferedReader buff = new BufferedReader(reader);

			String line = buff.readLine();
			int counter = Integer.parseInt(line);
			line = buff.readLine();

			while (line != null && counter != 0) {
				lines.add(line);
				line = buff.readLine();
				counter--;
			}

			reader.close();
		} catch (IOException e) {
			System.err.printf("Error: %s.\n", e.getMessage());
		}
		Collections.sort(lines);
	}
	
	private static void buildNodesFromList(List<String> lines, List<Node> nodes) {
		for (String s : lines) {
			
			Node aux = new Node(Integer.parseInt(s.split(" ")[0]));
			int leftValue = Integer.parseInt(s.split(" ")[1]);
			
			if(leftValue != 0) {
				aux.setLeft(new Node(leftValue));
				aux.getLeft().setParent(aux);
			} else {
				aux.setLeft(null);
			}
			int centralValue = Integer.parseInt(s.split(" ")[2]);
			if(centralValue != 0) {
				aux.setCentral(new Node(centralValue));
				aux.getCentral().setParent(aux);
			} else {
				aux.setCentral(null);
			}
			nodes.add(aux);
		}
	}
	
}
