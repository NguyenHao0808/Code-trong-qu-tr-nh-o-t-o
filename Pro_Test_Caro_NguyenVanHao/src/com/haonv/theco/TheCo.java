/**
 * Copyright(C) 2017 Luvina
 * TheCo.java, 06/01/2017 haonv
 */
package com.haonv.theco;
/**
 * Tạo đối tượng thế cờ
 * @author Nguyen Hao
 *
 */
public class TheCo {
	//khai báo thuộc tính thế cờ có kiểu dũ liệu String[][]
	private String[][] theCo;
/**
 * Phương thức khởi tạo của class TheCo, thực hiện khởi tạo và gán giá trị cho theCo
 * @param st: giá trị để gán vào theCo
 */
	public TheCo(String st) {
		// khởi tạo thuộc tính theCo
		theCo = new String[5][5];
		// khởi tạo biến count
		int count = 0;
		// vòng duyệt hàng
		for (int i = 0; i < 5; i++) {
			// vòng duyệt cột
			for (int j = 0; j < 5; j++) {
				// gán giá trị cho theCo[i][j]
				theCo[i][j] = st.charAt(count) + "";
				// tăng giá trị count lên 1
				count++;
			}
		}
	}
/**
 * trả về thuộc tính theCo
 * @return: trả về thuộc tính thế cờ
 */
	public String[][] getTheCo() {
		// trả về thuộc tính thế cờ
		return theCo;
	}
/**
 * 
 */
	public void inTheCo() {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(theCo[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
}
