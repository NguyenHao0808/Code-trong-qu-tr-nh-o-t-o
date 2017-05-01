/**
 * Copyright(C) 2017 Luvina
 * TestCaro.java, 06/01/2017 haonv
 */
package com.haonv.test;

import com.haonv.giaodien.GUI;

/**
 * thực hiện test giao diện GUI
 * 
 * @author Nguyen Hao
 *
 */
public class TestCaro {
	/**
	 * khởi tạo một đối tượng gui và test các phương thức của gui
	 * 
	 * @param args
	 *            : tham số hàm main
	 */
	public static void main(String[] args) {
		// khai báo và khởi tạo gui
		GUI gui = new GUI();
		// đối tượng gui thực hiện phương thức hienthi
		gui.hienThi();
		// bắt sự kiện
		gui.suKien();
		// cho phép hiển thị gui
		gui.setVisible(true);
	}
}
