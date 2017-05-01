package com.haonv.myfile;

public class Main {
	public static void main(String[] args) {
		FileManager fileManager = new FileManager();
		fileManager.pointToFile("E:\\demo.txt");
		fileManager.createFile();
		fileManager.showFileInFoder("E:\\");
	}
}
