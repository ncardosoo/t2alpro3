package br.pucrs.t2alpro3.ternarytree.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TernaryTreeUtils {

	public static void main(String[] args) {
		for(String s : read()) {
			System.out.println(s);
		}
	}

	public static List<String> read() {

		List<String> result = new ArrayList<String>();
		try {
			FileReader arq = new FileReader("input1output3.txt");
			BufferedReader lerArq = new BufferedReader(arq);

			String linha = lerArq.readLine(); // lê a primeira linha
			while (linha != null) {
				result.add(linha);
				linha = lerArq.readLine(); // lê da segunda até a última linha
			}

			arq.close();
		} catch (IOException e) {
			System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
		}
		
		return result;
	}
	

}
