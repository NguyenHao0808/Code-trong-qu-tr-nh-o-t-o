package com.haonv.myfile;

import java.io.File;
import java.io.IOException;

public class FileManager {
	private File file;

	public void pointToFile(String path) {
		file = new File(path);
		System.out.println("Da tro den file co dung dan : " + path);
	}

	private boolean isExist() {
		boolean check = file.exists();
		if (check == true) {
			System.out.println("ton tai");
		} else {
			System.out.println("khong ton tai");
		}
		return check;
	}

	public void createFile() {
		if (!isExist()) {
			try {
				file.createNewFile();
				System.out.println("Tao file thanh cong!");
			} catch (IOException e) {
				System.out.println("Chua tao duoc file!");
				e.printStackTrace();
			}
		}
	}

	public void renameFile(String newName) {
		File file2 = new File(file.getParent() + newName);
		if (file.renameTo(file2)) {
			System.out.println("thanh cong");
		} else {
			System.out.println("Khong thanh cong");
		}
		pointToFile(file2.getPath());
	}

	public void showFileInfo(File file) {
		System.out.println("name: " + file.getName());
		System.out.println("path: " + file.getPath());
		System.out.println("size: " + (file.length() / 1024F) + "Kb");
	}

	public void deleteFile() {
		if (file.delete()) {
			System.out.println("xoa thanh cong!");
		} else {
			System.out.println("Khong xoa thanh cong!");
		}
	}

	public void showFileInFoder(String path) {
		File file3 = new File(path);
		if (!file3.exists()) {
			System.out.println("Khong ton tai file");
			return;
		}
		if (file3.isDirectory()) {
			File[] lisFiles = file3.listFiles();
			if (lisFiles != null && lisFiles.length > 0) {
				for (int i = 0; i < lisFiles.length; i++) {
					showFileInfo(lisFiles[i]);

				}
			}
		}

	}
}
