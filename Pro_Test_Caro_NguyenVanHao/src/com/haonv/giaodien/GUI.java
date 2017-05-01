/**
 * Copyright(C) 2017 Luvina
 * TestCaro.java, 06/01/2017 haonv
 */
package com.haonv.giaodien;

import java.awt.Color;

import javax.swing.JFrame;

/**
 * tạo khung giao diện
 * 
 * @author Nguyen Hao
 *
 */
public class GUI extends JFrame {
	// tham số chiều rộng cho khung
	public static final int WIDTH = 606;
	// tham số chiều cao cho khung
	public static final int HEIGHT = 703;
	// tham số caro kiểu PanelCaro
	private PanelCaro caro;

	/**
	 * phương thức hiển thị của khung, gọi các phương thức thành phần
	 */
	public void hienThi() {
		// gọi phương thức initGUI
		initGUI();
		// gọi phương thức initCom
		initCom();
	}

	/**
	 * xây dựng nên các đặc điểm của khung
	 */
	public void initGUI() {
		// setLayout(new CardLayout());
		// khai báo tiêu đề khung
		setTitle("Caro");
		// khai báo kích thước khung
		setSize(WIDTH, HEIGHT);
		// đặt khung ở trạng thái không thay đổi được size
		setResizable(false);
		// đặt cách đóng khung
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// đặt vị trí suất hiện của khung trên màn hình: tại giữa màn hình
		setLocationRelativeTo(null);

	}

	/**
	 * xây dựng nên các thành phần trong khung
	 */
	public void initCom() {
		// khai báo và khởi tạo đối tượng caro kiểu dữ liệu PanelCaro
		caro = new PanelCaro();
		// đối tượng caro thực hiện phương thức hienthibanco
		caro.hienThiBanCo();

		// thêm đối tượng caro vào khung
		add(caro);
	}

	/**
	 * bắt sự kiện cho o co
	 */
	public void suKien() {
		// đối tượng caro thực hiện phương thức bắt sự kiện
		caro.batSuKien();
	}
}
