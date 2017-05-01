package com.haonv.server;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

/**
 * Lop GUI ke thua tu JFrame tao khung de xay dung giao dien.
 * 
 * @author Nguyen Hao
 *
 */
public class GUI extends JFrame {
	public static final int WIDTH_FRAME = 500;
	public static final int HEIGHT_FRAME = 400;
	private PanelSV panelSV;

	/**
	 * Phuong thuc khoi tao cua lop GUI. Kem theo thuc thi cac phuong thuc duoc
	 * goi.
	 */
	public GUI() {
		// lay giao dien cua Nimbus de hien thi
		try {
			UIManager.setLookAndFeel(NimbusLookAndFeel.class.getName());
		} catch (Exception e) {
			System.out.println("Loi giao dien!");
		}
		initGUI();
		initComps();
		addComps();
	}

	/**
	 * Phuong thuc initGUI thuc hien xay dung nen cac dac diem cua khung.
	 */
	private void initGUI() {
		setTitle("GUI");
		setLayout(new CardLayout());
		setSize(WIDTH_FRAME, HEIGHT_FRAME);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	/**
	 * Phuong thuc initComs thuc hien khoi tao cac doi tuong thanh phan.
	 */
	private void initComps() {
		panelSV = new PanelSV();
	}

	/**
	 * Phuong thuc addComps thuc hien them doi tuong thanh phan
	 */
	private void addComps() {
		add(panelSV);
	}
}
