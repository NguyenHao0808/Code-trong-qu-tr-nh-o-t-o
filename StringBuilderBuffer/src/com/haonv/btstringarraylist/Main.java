package com.haonv.btstringarraylist;

import javax.sound.midi.SysexMessage;

public class Main {
	/**
	 * Phuong thuc main. Khoi tao nen mot doi tuong manager va cho no thuc thi
	 * cac phuong thuc.
	 * 
	 * @param args
	 *            : tham so phuong thuc main
	 */
	public static void main(String[] args) {
		// HocSinhManager manager = new HocSinhManager();
		// manager.themHocSinh("Binh", 22);
		// manager.tinhTuoiTrungBinh();
		// manager.timKiemHocSinh();
		// manager.lietKeHocSinh();
		// manager.lietKeHocSinh("Tho");
		// manager.kiemTraTonTai("Binh", 22);
		// manager.timViTriCuaHS("Binh", 22);
		int a;
		boolean isPass = false;
		try {
			a = Integer.parseInt("a");
			isPass = true;

		} catch (NumberFormatException e) {
			// xu ly loi
			System.err.println("Loi: " + e.getMessage());
			isPass = false;
			a = -1;
		}
		if (isPass == true) {
			int b = 5;
			int tong = a + b;
			System.out.println("Tong = " + tong);
		}

		try {
			String srt = null;
			char kyTu = srt.charAt(0);
			System.out.println("Ky tu :"+kyTu);
			srt = "abc";
			char c = srt.charAt(50);
			System.out.println("Ky tu : " + c);
		} catch (StringIndexOutOfBoundsException | NumberFormatException e) {
			System.err.println("Loi : " + e.getMessage());
		}

		System.out.println("Hello");
	}
}
