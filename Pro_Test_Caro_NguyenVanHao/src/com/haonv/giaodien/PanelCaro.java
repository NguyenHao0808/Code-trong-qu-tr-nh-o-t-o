/**
 * Copyright(C) 2017 Luvina
 * TestCaro.java, 06/01/2017 haonv
 */
package com.haonv.giaodien;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.haonv.logicco.LogicCo;
import com.haonv.theco.DanhSachTheCo;
import com.haonv.theco.TheCo;

/**
 * xây dựng panel cho khung giao diện
 * 
 * @author Nguyen Hao
 *
 */
public class PanelCaro extends JPanel {
	// khai báo tham số oCo kiểu dữ liệu JButton[][]
	private JButton[][] oCo;
 private JLabel[][] coAn;
	// khai báo tham số caro kiểu dữ liệu JLabel
	private JLabel caro;
	// khai báo và khởi tạp tham số logicCo kiểu dữ liệu LogicCo
	private LogicCo logicCo;
	public static final int WIDTH = 30;
	public static final int HEIGHT = 30;

	public PanelCaro() {
		logicCo = new LogicCo();
	}

	/**
	 * thực hiện xây dựng các thành trong panel
	 */
	public void hienThiBanCo() {
		// gọi phương thức initFra
		initFra();
		// gọi phương thức initCom
		initCom();

	}

	/**
	 * xây dựng nên các đặc điểm của panel
	 */
	private void initFra() {
		// xây dựng kiểu xuất hiện của các thành phần
		setLayout(null);
		// tạo màu nên cho panel
		setBackground(Color.BLUE);
	}

	/**
	 * xây dựng các thành phần cho panel
	 */
	private void initCom() {
		// khai báo và khởi tạo đối tượng font
		Font font = new Font("Tahoma", Font.BOLD, 40);
		// khai báo và khởi tạo đối tượng metrics đóng vai trò như khung ngoài
		// của label
		FontMetrics metrics = getFontMetrics(font);
		// khởi tạo tham số caro
		caro = new JLabel("CỜ CARO");
		// định dạng kiểu font cho caro
		caro.setFont(font);
		// định dạng kích thước cho caro
		caro.setSize(metrics.stringWidth("CỜ CARO"), metrics.getHeight());
		// đặt vị trí cho caro
		caro.setLocation((GUI.WIDTH - caro.getWidth()) / 2, 22);
		// đặt màu chữ cho caro
		caro.setForeground(Color.RED);
		// thêm đối tượng caro vào panel
		add(caro);
		// khởi tạo tham số oCo
		oCo = new JButton[20][20];
		// // độ rộng của oCo
		// int width = 30;
		// // độ cao của oCo
		// int height = 30;
		// // duyệt các hàng
		for (int i = 0; i < 20; i++) {
			// duyệt các cột
			for (int j = 0; j < 20; j++) {
				// tạo biến hằng m,n
				final int m = i, n = j;
				coAn[m][n] = new JLabel();
				coAn[m][n].setSize(WIDTH, HEIGHT);
				coAn[m][n].setLocation(WIDTH * j, 75 + HEIGHT * i);
				add(coAn[m][n]);
				coAn[m][n].setVisible(false);
				// khởi tạo oCo[m][n]
				oCo[m][n] = new JButton();
				// đặt kích thước cho oCo[m][n]
				oCo[m][n].setSize(WIDTH, HEIGHT);
				// đặt vị trí cho oCo[m][n]
				oCo[m][n].setLocation(WIDTH * j, 75 + HEIGHT * i);

				// them oCo[m][n] vào panel
				add(oCo[i][j]);
			}
		}
	}

	/**
	 * bắt sự kiện cho các ô cờ
	 */
	public void batSuKien() {
		// duyệt các hàng
		for (int i = 0; i < 20; i++) {
			// duyệt các cột
			for (int j = 0; j < 20; j++) {
				// tạo biến hằng m,n
				final int m = i, n = j;
				// đặt sự kiện click chuột cho oCo[m][n]
				oCo[m][n].addActionListener(new ActionListener() {

					// ghi đè phương thức actionPerformed
					@Override
					public void actionPerformed(ActionEvent e) {
						// gọi phương thức event
						tienTrinh(m, n);

					}
				});
				// them oCo[m][n] vào panel
				add(oCo[i][j]);
			}
		}
	}

	/**
	 * quá trình công việc khi oCo[m][n] được click
	 * 
	 * @param m
	 *            : vị trí hàng
	 * @param n
	 *            : vị trí cột
	 */
	private void tienTrinh(int m, int n) {
		
		coAn[m][n].setIcon(new ImageIcon(getClass().getResource("/image/o.png")));
		coAn[m][n].setVisible(true);
		// // chèn icon cho oCo[m][n]
		// oCo[m][n]
		// .setIcon(new ImageIcon(getClass().getResource("/image/o.png")));
		// // đặt ẩn cho oCo[m][n], không được click tiếp vào oCo[m][n]
		// oCo[m][n].setEnabled(false);
		// thực hiện đánh O vào bàn cờ
		logicCo.danhCo(m, n, "O");
		// kiểm tra phương thức checkWin tại oCo[m][n]
		if (1 == checkWin(m, n)) {
			// kết thúc phương thức
			return;
		}
		// lấy vị trí đánh chặn của máy
		int[] viTriD = logicCo.viTriDanh(m, n);
		// // chèn icon cho oCo đánh chặn
		// oCo[viTriD[0]][viTriD[1]].setIcon(new
		// ImageIcon(getClass().getResource(
		// "/image/x.png")));
		// đặt ẩn cho oCo chặn, không được click tiếp vào oCo chặn
		
		coAn[viTriD[0]][viTriD[1]].setIcon(new ImageIcon(getClass().getResource("/image/x.png")));
		coAn[viTriD[0]][viTriD[1]].setVisible(true);
		// gọi phương thức checkWin tại oCo chặn
		checkWin(viTriD[0], viTriD[1]);
		// gọi phương thức checkHoa
		checkHoa();
	}

	/**
	 * kiểm tra thời điểm thắng thua
	 * 
	 * @param m
	 *            : vị trí hàng
	 * @param n
	 *            : vị trí cột
	 */
	private int checkWin(int m, int n) {
		// lấy kết quả kiểm tra thắng
		int win = logicCo.checkWin(m, n);
		// kiểm tra kết quả bằng 1
		if (win == 1) {
			// gọi hàm end kết thúc bàn cờ
			end();
			// thông báo máy thắng
			JOptionPane.showMessageDialog(null, "May thang!");
			// tra về 1;
			return 1;
		}
		// kiểm tra kết quả bằng 2
		if (win == 2) {
			// gọi hàm end kết thúc bàn cờ
			end();
			// thông báo người chơi thắng
			JOptionPane.showMessageDialog(null, "Nguoi thang!");
			// tra về 1;
			return 1;
		}
		return 0;
	}

	/**
	 * kiểm tra bàn cờ hoà
	 */
	private void checkHoa() {
		// lấy kết quả kiểm tra hoà, gọi phương thức logicCo.checkHoa
		boolean kq = logicCo.checkHoa();
		// kiểm tra kết quả đúng
		if (kq) {
			// thông báo kết quả hoà
			JOptionPane.showMessageDialog(null, "Hoa!");
		}
	}

	/**
	 * dừng hết hoạt động của các oCo
	 */
	private void end() {
		// duyệt hàng cờ
		for (int i = 0; i < 20; i++) {
			// duyệt cột cờ
			for (int j = 0; j < 20; j++) {
				// dừng hoạt động của oCo[i][j]
				oCo[i][j].setEnabled(false);
			}
		}
	}
}
