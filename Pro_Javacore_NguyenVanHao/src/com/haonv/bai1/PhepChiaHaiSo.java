/**
 * Copyright(C) 2016 Luvina
 * Pro_Javacore_NguyenVanHao, 26/12/2016 haonv
 */
package com.haonv.bai1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

/**
 * Lớp PhepChiaHaiSo có các phương thức nhập hai số A B và tính thương hai số đó
 * 
 * @author Nguyen Hao
 *
 */
public class PhepChiaHaiSo {
	private float soA, soB;
	private float thuong;
	private Properties pp1, pp2;

	/**
	 * Phướng thức khởi tạo của lớp PhepChiaHaiSo. Không có tham so chuyền vào .
	 * Trong phương thức khởi tạo nên hai đối thượng Properties
	 */
	public PhepChiaHaiSo() {
		pp1 = new Properties();
		pp2 = new Properties();
		try {
			pp1.load(new FileInputStream("a.properties"));
			pp2.load(new FileInputStream("b.properties"));
		} catch (FileNotFoundException e) {
			System.out.println("File không tồn tại");
		} catch (IOException e) {
			System.out.println("Lỗi luồng đọc file.");
		}
	}

	/**
	 * Phương thức nhapSoAB thực hiện nhập hai sô A B từ bàn phím. Khởi tạo nên
	 * mội đối tượng KiemTra để kiểm tra sô nhập vào có đúng yêu cầu không
	 */
	public void nhapSoAB() {
		KiemTra kiemTra = new KiemTra();
		Scanner scanner = new Scanner(System.in);
		System.out.println(pp1.getProperty("nhap"));
		String a = scanner.nextLine();
		while (!"".equals(kiemTra.kiemTra(a))) {
			System.out.println(pp1.getProperty(kiemTra.kiemTra(a)));
			System.out.println(pp1.getProperty("nhap"));
			a = scanner.nextLine();
		}
		soA = Float.parseFloat(a);

		System.out.println(pp2.getProperty("nhap"));
		String b = scanner.nextLine();
		while (!"".equals(kiemTra.kiemTra(b))) {
			System.out.println(pp2.getProperty(kiemTra.kiemTra(b)));
			System.out.println(pp2.getProperty("nhap"));
			b = scanner.nextLine();
		}
		soB = Float.parseFloat(b);
		scanner.close();
	}

	/**
	 * Phương thức tinhThuong thực hiện tính thương hai số A B
	 */
	public void tinhThuong() {
		thuong = soA / soB;
		System.out.println(pp1.getProperty("ketqua") + thuong);
		System.out.println(pp1.getProperty("ketthuc"));
	}
}
