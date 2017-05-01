/**
 * Copyright(C) 2016 Luvina
 * Pro_Javacore_NguyenVanHao, 26/12/2016 haonv
 */
package com.haonv.bai1;

/**
 * Lớp KiemTra xây dựng để thực hiện kiểm tra một chuỗi số theo yêu cầu
 * 
 * @author Nguyen Hao
 *
 */
public class KiemTra {
	private String error = "";

	/**
	 * Phương thức kiemTra thực hiện hành vi kiêm tra tham so chuyền vào theo
	 * các tiêu trí: - Khác rỗng - phải là số và lớn hơn 0 - Phải nhỏ hơn số có
	 * 5 số
	 * 
	 * @param st
	 *            : tham số để kiểm tra
	 * @return: trả về một mã lỗi theo fileProoerties
	 */
	public String kiemTra(String st) {
		int length = st.length();
		String regex = "[0-9]+|[0-9]+.[0-9]+";
		if (0 == length) {
			return "khongnhap";
		}
		if (!st.matches(regex)) {
			return "nhohon0";
		}
		float a = Float.parseFloat(st);
		if (a <= 0) {
			return "nhohon0";
		}
		if (length > 5 && st.indexOf(".") == -1) {
			return "hon5so";
		}
		if (length > 6 && st.indexOf(".") != -1) {
			return "hon5so";
		}
		return error;
	}
}
