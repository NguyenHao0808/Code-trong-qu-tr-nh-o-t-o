/**
 * Copyright(C) 2016  Luvina
 * GUI.java, Jan 04, 2017 Phạm Thành Luân
 */

package net.luvina.phamthanhluan.cocaro.view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import net.luvina.phamthanhluan.cocaro.common.BanCo;
import net.luvina.phamthanhluan.cocaro.exception.MyException;

/**
 * GUI Class thực hiện tạo Frame giao diện chơi cờ
 * 
 * @author Phạm Thành Luân
 *
 */
public class GUI extends JFrame {
	// Khai báo 1 Panel vào game
	private PanelBanCo panelBanCo;

	/**
	 * Phương thức tạo một đối tượng GUI
	 * 
	 * @throws MyException
	 */
	public void hienThiGame() {
		try {
			// Set giao diện theo kiểu Nimbus
			UIManager.setLookAndFeel(NimbusLookAndFeel.class.getName());
		} catch (ClassNotFoundException e) {
			// Nếu gặp lỗi hiển thị thông báo lỗi ra màn hình
			JOptionPane.showMessageDialog(GUI.this, "Lỗi giao diện");
		} catch (InstantiationException e) {
			JOptionPane.showMessageDialog(GUI.this, "Lỗi giao diện");
		} catch (IllegalAccessException e) {
			JOptionPane.showMessageDialog(GUI.this, "Lỗi giao diện");
		} catch (UnsupportedLookAndFeelException e) {
			JOptionPane.showMessageDialog(GUI.this, "Lỗi giao diện");
		}
		// Đặt title cho Frame hiển thị
		setTitle("Game Cờ Caro");
		// Đặt kích thước Frame hiển thị
		setSize(BanCo.W_BANCO + 200, BanCo.H_BANCO);
		// Đặt vị trí hiển thị
		setLocationRelativeTo(null);
		// Đặt không được thay đổi kích thước
		setResizable(false);
		// Đặt hành động khi click vào nút thoát
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Khởi tạo một panel vào game
		panelBanCo = new PanelBanCo();
		// Thực hiện hàm tạo màn hình vào game
		panelBanCo.taoManHinhVaoGame();
		// add myPanel lên frame GUI
		add(panelBanCo);

	}

}
