package com.haonv.myarray;

import java.util.Arrays;
import java.util.Random;

public class MyArray {
	private int[] myArray;
	private int[] myArrayl;

	public MyArray() {
		myArray = new int[50];
		Random random = new Random();
		for (int i = 0; i < 50; i++) {
			myArray[i] = 0 + random.nextInt(101);
			System.out.print(myArray[i] + "  ");
		}
		System.out.println();
		myArrayl = new int[50];
		for (int i = 0; i < 50; i++) {
			myArrayl[i] = myArray[i];
		}
	}

	public void viTriSo() {
		int count;
		for (int i = 0; i < 49; i++) {
			StringBuilder viTritrung = new StringBuilder("");
			count = 0;
			for (int j = i + 1; j < 50; j++) {

				if (myArray[j] == myArray[i]) {
					myArray[j] = -1;
					count++;
					viTritrung = viTritrung.append(j + ",");
				}
			}
			if (count > 0) {
				viTritrung = viTritrung.insert(0, myArray[i] + ":" + i + ",");
			}

			if (myArray[i] != -1 && viTritrung.length() > 2) {
				System.out.println(viTritrung);
			}
		}

	}

	public void timSoHoanHao() {
		int[] locSo = new int[50];
		int[] soLanChiaHet = new int[50];
		for (int i = 0; i < 50; i++) {
			locSo[i] = myArrayl[i];
		}
		for (int i = 0; i < 49; i++) {
			for (int j = i + 1; j < 50; j++) {
				if (locSo[j] == locSo[i]) {
					locSo[j] = 0;
				}
			}
		}
		int count = 0;
		for (int i = 0; i < 50; i++) {
			if (myArrayl[i] == 0) {
				soLanChiaHet[i] = 0;
				continue;
			}
			for (int j = 0; j < 50; j++) {
				if (locSo[j] != 0 && locSo[i] % locSo[j] == 0) {
					count++;
				}
			}
			soLanChiaHet[i] = count;
			count = 0;
		}

		for (int i = 0; i < 50; i++) {
			locSo[i] = soLanChiaHet[i];
		}
		Arrays.sort(locSo);
		int ts = locSo[49];

		for (int i = 0; i < 50; i++) {
			if (soLanChiaHet[i] == ts) {
				System.out.println("So hoan hao la:" + myArrayl[i]
						+ "   so cac so chia het:" + ts);
			}
		}
	}
}
