/**
 * Copyright(C) 2017 Luvina
 * FileTheCo.java, 06/01/2017 haonv
 */
package com.haonv.theco;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * đọc file thế cờ
 * 
 * @author Nguyen Hao
 *
 */
public class FileTheCo {
	// khai báo thuộc tính read kiểu BufferedReader
	private BufferedReader read;

	/**
	 * phương thức khởi tạo FileTheCo
	 * 
	 * @param path
	 *            : đường dẫn đến file thế cờ
	 */
	public FileTheCo(String path) {
		// gọi phương thức mở file
		moFile(path);
	}

	/**
	 * thực hiện mở file thế cờ
	 * 
	 * @param path
	 *            : đường dẫn đến file
	 */
	private void moFile(String path) {
		// mở vòng try
		try {
			// khởi tạo thuộc tính read
			read = new BufferedReader(new FileReader(path));
			// bắt ngoại lệ cho khởi tạo read
		} catch (FileNotFoundException e) {
			// in ra câu lệnh báo lỗi
			System.out.println("Khong tim thay file!");
		}
	}

	/**
	 * thực hiện đọc file thế cờ
	 * 
	 * @return: trả về danh sách thế cờ trong file đọc
	 */
	public ArrayList<TheCo> docFile() {
		// khai báo và khởi tạo list kiểu dữ liệu ArrayList<TheCo>
		ArrayList<TheCo> list = new ArrayList<TheCo>();
		// khai báo biến dong
		String dong = "";
		// khai báo biến cộng dòng
		String congDong = "";
		// mở vòng try
		try {
			// vòng lặp while, điều kiện lặp dòng được đọc từ file khác null
			while ((dong = read.readLine()) != null) {
				// câu lệnh if với điều kiện dòng khác "c"
				if (!"c".equals(dong)) {
					// thực hiện cộng biến congdong với dong
					congDong = congDong + dong;
				}
				// câu lệnh if vói điều kiện dong bằng "c" và congdong khác ""
				// và độ dài của congdong=25
				if ("c".equals(dong) && "" != congDong
						&& congDong.length() == 25) {
					// khởi tạo nên theco từ biến congdong
					TheCo theCo = new TheCo(congDong);
					// thêm theco vào list
					list.add(theCo);
					// gán congdong bằng rỗng
					congDong = "";
				}
				// // câu lệnh if vói điều kiện dong bằng "c" và congdong khác
				// "" và độ dài của congdong khác 25
				if ("c".equals(dong) && "" != congDong
						&& congDong.length() != 25) {
					// gán congdong bằng rỗng
					congDong = "";
				}
			}
			// bắt ngoại lệ cho khối lệnh bằng catch
		} catch (IOException e) {
			// in ra dong lệnh thông báo lỗi
			System.out.println("Loi doc file!");
		}
		// trả về list
		return list;
	}

	/**
	 * thực hiện đóng file
	 */
	public void dongFile() {
		// mở vòng try
		try {
			// đóng read
			read.close();
			// bắt ngoại lệ cho đóng luồng
		} catch (IOException e) {
			// in ra thông báo lỗi
			System.out.println("Loi dong file!");
		}
	}

}
