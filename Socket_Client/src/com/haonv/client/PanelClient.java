package com.haonv.client;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Lop PanelClient ke thus tu lop JPanel
 * 
 * @author Nguyen Hao
 *
 */
public class PanelClient extends JPanel {
	private JLabel lb1, lb2, lb3, lb4, lb5;
	private JButton bt1, bt2;
	private JTextArea ta1, ta2;
	private JTextField tf1, tf2;
	private Client client = new Client();

	/**
	 * Phuong thuc khoi tao cua lop PanelClient. Kem theo cong viec thuc thi cac
	 * phuong thuc duoc goi.
	 */
	public PanelClient() {
		initPanelClient();
		initComps();
		addComps();

	}

	/**
	 * Phuong thuc initPanelClient de dinh hinh anh cua lop.
	 */
	private void initPanelClient() {
		setLayout(null);
	}

	/**
	 * Phuong thuc initComps thuc hien khai bao va xay dung cac thanh phan tren
	 * lop.
	 */
	private void initComps() {
		Font font1 = new Font("Tahoma", Font.BOLD, 32);
		FontMetrics metrics = getFontMetrics(font1);
		lb1 = new JLabel("CLIENT");
		lb1.setFont(font1);
		lb1.setSize(metrics.stringWidth("CLIENT"), metrics.getHeight());
		lb1.setLocation((GUI.WIDTH_FRAME - lb1.getWidth()) / 2, 30);

		Font font2 = new Font("Tahoma", Font.BOLD, 20);
		metrics = getFontMetrics(font2);
		lb2 = new JLabel("IP:");
		lb2.setFont(font2);
		lb2.setSize(metrics.stringWidth("IP:"), metrics.getHeight());
		lb2.setLocation(30, lb1.getY() + lb1.getHeight() + 20);

		tf1 = new JTextField();
		tf1.setSize(200, 35);
		tf1.setLocation(lb2.getX() + lb2.getWidth() + 10, lb2.getY());

		lb5 = new JLabel("PORT:");
		lb5.setFont(font2);
		lb5.setSize(metrics.stringWidth("PORT:"), metrics.getHeight());
		lb5.setLocation(tf1.getX() + tf1.getWidth() + 20, tf1.getY());

		tf2 = new JTextField();
		tf2.setSize(100, 35);
		tf2.setLocation(lb5.getX() + lb5.getWidth() + 10, lb2.getY());

		lb3 = new JLabel("Thu Gui:");
		lb3.setFont(font2);
		lb3.setSize(metrics.stringWidth("Thu Gui:"), metrics.getHeight());
		lb3.setLocation(30, lb2.getY() + lb2.getHeight() + 30);

		ta1 = new JTextArea();
		ta1.setSize(250, 70);
		ta1.setLocation(lb3.getX() + lb3.getWidth() + 40, lb3.getY());

		lb4 = new JLabel("Thu Nhan:");
		lb4.setFont(font2);
		lb4.setSize(metrics.stringWidth("Thu Nhan:"), metrics.getHeight());
		lb4.setLocation(30, ta1.getY() + ta1.getHeight() + 10);

		ta2 = new JTextArea();
		ta2.setSize(250, 70);
		ta2.setLocation(ta1.getX(), lb4.getY());

		bt1 = new JButton("Connect To");
		bt1.setSize(100, 30);
		bt1.setLocation(ta2.getX(), ta2.getY() + ta2.getHeight() + 20);
		bt1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				client.getLocalIP();
				if ("".equals(tf1.getText()) || "".equals(tf2.getText())
						|| "".equals(ta1.getText())) {
					JOptionPane.showMessageDialog(PanelClient.this,
							"Ban chua nhap du thong tin!");
					System.exit(0);
				} else {
					String thuNhan = client.connectTo(tf1.getText(),
							Integer.parseInt(tf2.getText()), ta1.getText());
					ta2.setText(thuNhan);
				}
			}
		});

		bt2 = new JButton("Send");
		bt2.setSize(100, 30);
		bt2.setLocation(bt1.getX() + bt1.getWidth() + 20, bt1.getY());
		bt2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});
	}

	/**
	 * Phuong thuc addComps thuc hien them cac thanh phan vao lop.
	 */
	private void addComps() {
		add(lb1);
		add(lb2);
		add(tf1);
		add(bt1);
		add(lb3);
		add(lb4);
		add(ta2);
		add(ta1);
		add(bt2);
		add(lb5);
		add(tf2);
	}
}
