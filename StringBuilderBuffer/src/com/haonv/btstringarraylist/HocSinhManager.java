package com.haonv.btstringarraylist;

import java.util.ArrayList;

public class HocSinhManager {
	private ArrayList<HocSinh> list;
	private int size;
	private int count;

	/**
	 * Phuong thuc khoi tao cua class HocSinhManager. Khoi tao mot mang list va
	 * khai bao 4 phan tu cho mang.
	 */
	public HocSinhManager() {
		list = new ArrayList<HocSinh>();
		HocSinh hs1 = new HocSinh("An", 19);
		list.add(hs1);
		HocSinh hs2 = new HocSinh("Tho", 20);
		list.add(hs2);
		HocSinh hs3 = new HocSinh("Hao", 23);
		list.add(hs3);
		HocSinh hs4 = new HocSinh("Tho", 22);
		list.add(hs4);
	}

	/**
	 * Phuong thuc them hoc sinh vao danh sach. Gom 2 tham so chuyen vao
	 * 
	 * @param ten
	 *            : ten hoc sinh.
	 * @param tuoi
	 *            : tuoi hoc sinh.
	 */
	public void themHocSinh(String ten, int tuoi) {
		HocSinh hocSinh = new HocSinh(ten, tuoi);
		list.add(hocSinh);
		System.out.println("1.Them thanh cong!");
	}

	/**
	 * Phuong thuc tinh tuoi trung binh cua cac hoc sinh co ten trong danh sach.
	 */
	public void tinhTuoiTrungBinh() {
		size = list.size();
		int tongTuoi = 0;
		for (int i = 0; i < size; i++) {
			tongTuoi += list.get(i).getTuoi();
		}
		System.out
				.println("2.Tuoi chung binh cua cac hoc sinh trong danh sach la : "
						+ (tongTuoi / size));
	}

	/**
	 * Phuong thuc tim kiem hoc sinh. Thuc hien tim kiem hoc sinh co tuoi lon
	 * nhat va nho nhat trong danh sach, dong thoi in ra danh sach tim kiem.
	 */
	public void timKiemHocSinh() {
		int min = list.get(0).getTuoi();
		int max = list.get(0).getTuoi();
		for (int i = 1; i < size; i++) {
			if (min > list.get(i).getTuoi()) {
				min = list.get(i).getTuoi();
			}
			if (max < list.get(i).getTuoi()) {
				max = list.get(i).getTuoi();
			}
		}
		for (int i = 0; i < size; i++) {
			if (list.get(i).getTuoi() == min) {
				System.out.println("3.1.Hoc sinh co tuoi nho nhat la : "
						+ list.get(i).toString());
			}
			if (list.get(i).getTuoi() == max) {
				System.out.println("3.2.Hoc sinh co tuoi lon nhat la : "
						+ list.get(i).toString());
			}
		}
	}

	/**
	 * Phuong thuc liet ke hoc sinh. Thuc hien liet ke hoc sinh sinh nam nhuan
	 * co ten trong danh sach. In ra danh sach tim kiem duoc.
	 */
	public void lietKeHocSinh() {
		System.out.print("4.Danh sach hoc sinh sinh nam nhuan : ");
		count = 0;
		for (int i = 0; i < size; i++) {
			int year = 2016 - list.get(i).getTuoi();
			if ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)) {
				System.out.println(list.get(i).toString());
				count++;
			}
		}
		if (count == 0) {
			System.out.println("Khong co hoc sinh nao sinh nam nhuan.");
		}
	}

	/**
	 * Phuong thuc liet ke hoc sinh. Gom 1 tham so chuyen vao, thuc hien liet ke
	 * danh sach cac hoc sinh co ten cung voi tham so chuyen vao.
	 * 
	 * @param ten
	 *            : ten tim kiem
	 */
	public void lietKeHocSinh(String ten) {
		System.out.println("5.Danh sach hoc sinh co ten la: " + ten);
		count = 0;
		for (int i = 0; i < size; i++) {
			if (list.get(i).getTen().equals(ten)) {
				System.out.println(list.get(i).toString());
				count++;
			}
		}
		if (count == 0) {
			System.out
					.println("Khong co hoc sinh " + ten + " trong danh sach.");
		}
	}

	public void kiemTraTonTai(String ten, int tuoi) {
		HocSinh hs = new HocSinh(ten, tuoi);
		boolean ketQua = list.contains(hs);
		if (ketQua == true) {
			System.out.println("6.Tim duoc!");
		} else {
			System.out.println("6.Khong tim duoc!");
		}
	}

	public void timViTriCuaHS(String ten, int tuoi) {
		HocSinh hocSinh = new HocSinh(ten, tuoi);
		int vitri = list.indexOf(hocSinh);
		if (vitri == -1) {
			System.out.println("7.Khong tim duoc!");
		} else {
			System.out.println("7.Vi tri hoc sinh la : " + (vitri + 1));
		}
	}
}
