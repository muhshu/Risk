package Visualitzacio;

import java.util.Scanner;

public class Visualitzacio {
	public static int demanarExercitsPosicio(int[][] tauler, int i, int maxExercits) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Actualment tens " + tauler[i][1] + " exèrcits en el territori " + territoris[i]);
		System.out.println("Indica quants exèrcits vols afegir més (mínim 0 i màxim " + maxExercits + ")");

		int nExercits = 0;
		do {
			nExercits = (scanner.hasNextInt() ? scanner.nextInt() : 0);
		} while (nExercits < 0 || nExercits > maxExercits);

		return nExercits;
	}
	

}
