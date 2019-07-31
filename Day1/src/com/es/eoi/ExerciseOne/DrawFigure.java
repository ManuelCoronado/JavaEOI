package com.es.eoi.ExerciseOne;

public class DrawFigure {

	public static void main(String[] args) {
		
		generateTable(6,20);
	}
	
	public static void generateTable(int a, int b) {
		
		int[][] table = new int [a][b];
		for (int i = 0; i < table.length; i++) {
			for (int j = 0; j < table[i].length; j++) {
				System.out.print(table[i][j]);
			}
			System.out.println();
		}
	}
}
