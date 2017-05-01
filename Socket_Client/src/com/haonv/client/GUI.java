package com.haonv.client;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

/**
 * Lop GUI ke thua tu lop JFrame
 * 
 * @author Nguyen Hao
 *
 */
public class GUI extends JFrame {
	public static final int WIDTH_FRAME = 500;
	public static final int HEIGHT_FRAME = 400;
	private PanelClient panelClient;

	/**
	 * Phuong thuc khoi tao cua lop GUI. Thuc hien cac phuong thuc duoc goi.
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
	 * Phuong thuc initGUI thuc hien xay dung giao dien cho lop GUI.
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
	 * Phuong thuc initComps thuc hien khoi tao doi tuong de dan nen GUI.
	 */
	private void initComps() {
		panelClient = new PanelClient();
	}

	/**
	 * Phuong thuc addComps thuc hien them cac doi tuong nen GUI.
	 */
	private void addComps() {
		add(panelClient);
	}
}
