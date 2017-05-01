/**
 * Copyright(C) 2016  Luvina
 * Main.java, Jan 04, 2017 Phạm Thành Luân
 */

package net.luvina.phamthanhluan.cocaro;

import javax.swing.JOptionPane;

import net.luvina.phamthanhluan.cocaro.exception.MyException;
import net.luvina.phamthanhluan.cocaro.view.GUI;
import net.luvina.phamthanhluan.cocaro.view.PanelBanCo;

/**
 * Main Class thực hiện tạo chạy chương trình
 * 
 * @author Phạm Thành Luân
 *
 */
public class Main {
	/**
	 * Phương thức chạy chương trình
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		GUI gui = new GUI();

		gui.hienThiGame();
		gui.setVisible(true);

	}
}
