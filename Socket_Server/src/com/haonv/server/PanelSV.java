package com.haonv.server;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Lop PanelSV ke thua lop JPanel
 * 
 * @author Nguyen Hao
 *
 */
public class PanelSV extends JPanel {
	private JLabel lb1, lb2, lb3;
	private JButton bt1, bt2;
	private JTextField tf1, tf2;
	private Server server = new Server();

	/**
	 * Phuong thuc khoi tao cua lop Panel. Kem theo thuc thi cac phuong thuc
	 * duoc goi.
	 */
	public PanelSV() {
		initPanelSV();
		initComps();
		addComps();
	}

	/**
	 * Phuong thuc initPanelSV thuc hien dinh dang lop.
	 */
	private void initPanelSV() {
		setLayout(null);
	}

	/**
	 * Phuong thuc initComps thuc hien khoi tao va xay dung nen cac thanh phan
	 * de gan vao lop.
	 */
	private void initComps() {
		Font font1 = new Font("Tahoma", Font.BOLD, 32);
		FontMetrics metrics = getFontMetrics(font1);
		lb1 = new JLabel("SERVER");
		lb1.setFont(font1);
		lb1.setSize(metrics.stringWidth("SERVER"), metrics.getHeight());
		lb1.setLocation((GUI.WIDTH_FRAME - lb1.getWidth()) / 2, 30);

		bt1 = new JButton("OpenConection");
		bt1.setSize(120, 30);
		bt1.setLocation((GUI.WIDTH_FRAME - bt1.getWidth()) / 2, lb1.getHeight()
				+ lb1.getY() + 30);
		bt1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				server.getLocalIP();
				if ("".equals(tf1.getText())) {
					JOptionPane.showMessageDialog(PanelSV.this,
							"Ban chua nhap thu gui!");
					System.exit(0);
				} else {
					String thuNhan = server.openConection(tf1.getText());
					tf2.setText(thuNhan);
				}

			}
		});

		Font font2 = new Font("Tahoma", Font.BOLD, 20);
		FontMetrics metric1 = getFontMetrics(font2);
		lb2 = new JLabel("Thu Gui:");
		lb2.setFont(font2);
		lb2.setSize(metric1.stringWidth("Thu Gui:"), metric1.getHeight());
		lb2.setLocation(40, bt1.getY() + bt1.getHeight() + 30);

		lb3 = new JLabel("Thu Nhan:");
		lb3.setFont(font2);
		lb3.setSize(metric1.stringWidth("Thu Nhan:"), metric1.getHeight());
		lb3.setLocation(40, lb2.getY() + lb2.getHeight() + 30);

		tf1 = new JTextField();
		tf1.setSize(200, 35);
		tf1.setLocation(lb2.getX() + lb2.getWidth() + 40, lb2.getY());

		tf2 = new JTextField();
		tf2.setSize(200, 35);
		tf2.setLocation(tf1.getX(), lb3.getY());

		bt2 = new JButton("Send");
		bt2.setSize(80, 30);
		bt2.setLocation((GUI.WIDTH_FRAME - bt2.getWidth()) / 2, lb3.getHeight()
				+ lb3.getY() + 30);
		bt2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});

	}

	/**
	 * Phuong thuc addComps thuc hien viec gan cac thanh phan vao lop.
	 */
	private void addComps() {
		add(lb1);
		add(bt1);
		add(lb2);
		add(lb3);
		add(tf1);
		add(tf2);
		add(bt2);

	}
}
