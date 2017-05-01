/**
 * Copyright(C) 2017 Luvina
 * DanhSachTheCo.java, 06/01/2017 haonv
 */
package com.haonv.theco;

import java.util.ArrayList;

/**
 * tạo các danh sách của thế cờ
 * 
 * @author Nguyen Hao
 *
 */
public class DanhSachTheCo {
	// khai báo danh sách thechay kiểu dữ liệu ArrayList<TheCo>
	private ArrayList<TheCo> theChay;
	// khai báo danh sách theket kiểu dữ liệu ArrayList<TheCo>
	private ArrayList<TheCo> theKet;

	/**
	 * khởi tạo của class DanhSachTheCo
	 */
	public DanhSachTheCo() {
		// khởi tạo thuộc tính thechay
		theChay = new ArrayList<TheCo>();
		// khởi tạo thuộc tính theket
		theKet = new ArrayList<TheCo>();
		// chèn một list theco vào thechay
		theChay.addAll(chenTheCo("theco\\thechay.txt"));
		// chèn một list theco vào theket
		theKet.addAll(chenTheCo("theco\\theket.txt"));

	}

	/**
	 * thực hiện tạo một list theco
	 * 
	 * @param path
	 *            : đường dẫn file thế cờ
	 * @return: trả về list theco dọc dược trong file
	 */
	private ArrayList<TheCo> chenTheCo(String path) {
		// khởi tạo list kiểu dữ liệu ArrayList<TheCo>
		ArrayList<TheCo> list = new ArrayList<TheCo>();
		// khởi tạo một đối tượng theco kiểu FileTheCo
		FileTheCo theCo = new FileTheCo(path);
		// gán giá trị cho list bằng lệnh theco thực hiên đọc file
		list = theCo.docFile();
		// theco thực hiện phương thức dongfile
		theCo.dongFile();
		// trả về list
		return list;
	}

	/**
	 * trả về thuộc tính thechay
	 * 
	 * @return: thuộc tính thechay
	 */
	public ArrayList<TheCo> getTheChay() {
		// trả về thechay
		return theChay;
	}

	/**
	 * trả về thuộc tính theket
	 * 
	 * @return: thuộc tính theket
	 */
	public ArrayList<TheCo> getTheKet() {
		// trả về theket
		return theKet;
	}

	// // so sanh the co ban va the co file
	// private int[] soSanhTheCo(TheCo tcP, TheCo tcF) {
	// int[] vitri = { -1, -1 };
	// for (int i = 0; i < 5; i++) {
	// for (int j = 0; j < 5; j++) {
	// if ("X".equals(tcF.getTheCo()[i][j])) {
	// if (!"X".equals(tcP.getTheCo()[i][j])) {
	// return vitri;
	// }
	// }
	// if ("O".equals(tcF.getTheCo()[i][j])) {
	// if (!"O".equals(tcP.getTheCo()[i][j])) {
	// return vitri;
	// }
	// }
	// if ("T".equals(tcF.getTheCo()[i][j])) {
	// if (!"T".equals(tcP.getTheCo()[i][j])) {
	// return vitri;
	// }
	// }
	// if ("D".equals(tcF.getTheCo()[i][j])) {
	// if (!"T".equals(tcP.getTheCo()[i][j])) {
	// return vitri;
	// } else {
	// vitri[0] = i;
	// vitri[1] = j;
	// }
	// }
	// }
	// }
	// return vitri;
	// }
	//
	// // public void in() {
	// // for (int i = 0; i < theChay.size(); i++) {
	// // theChay.get(i).inTheCo();
	// // }
	// // System.out.println(theChay.size());
	// // }
	// //
	// public static void main(String[] args) {
	// DanhSachTheCo co = new DanhSachTheCo();
	// TheCo co2 = new TheCo("XXXXTGGGGGGGGGGGGGGGGGGGG");
	// int[] vt = co.soSanhTheCo(co2, co.getTheChay().get(0));
	// System.out.println(vt[0] + " " + vt[1]);
	// System.out.println();
	// co.getTheChay().get(0).inTheCo();
	// System.out.println();
	// co2.inTheCo();
	// }
}
