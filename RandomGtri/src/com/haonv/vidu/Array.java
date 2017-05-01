package com.haonv.vidu;

import java.util.Random;

public class Array {
	private int[][] array;

	public Array() {
		array = new int[3][4];
		Random random = new Random();
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 4; j++) {
				array[i][j] = 5 + random.nextInt(20 + 1 - 5);
				// random gtri tu 5 den 20
				System.out.print(array[i][j] + "  ");
			}
			System.out.println();
		}
	}

}
