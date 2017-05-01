/**
 * Copyright(C) 2016  Luvina
 * MyPanel.java, Jan 04, 2017 Phạm Thành Luân
 */
package net.luvina.phamthanhluan.cocaro.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.luvina.phamthanhluan.cocaro.common.BanCo;
import net.luvina.phamthanhluan.cocaro.common.QuanCo;
import net.luvina.phamthanhluan.cocaro.exception.MyException;
import net.luvina.phamthanhluan.cocaro.logic.CoCaro;

/**
 * MyPanel Class thực hiện tạo giao diện chơi cờ
 * 
 * @author Phạm Thành Luân
 *
 */
public class PanelBanCo extends JPanel implements ActionListener {

	// Khai báo một mảng 2 chiều chứa các label
	private JLabel[][] lbCaro;
	// Khai báo 3 ImageIcon cho việc hiển thị trạng thái các ô cờ
	// Ô cờ trống
	private ImageIcon trongIcon;
	// Ô cờ người đánh
	private ImageIcon oIcon;
	// Ô cờ máy đánh
	private ImageIcon xIcon;
	// Khai báo đối tượng CoCaRo để xử lý logic trên bàn cờ
	private CoCaro coCaro;
	// Label hiển thị kết quả tỉ số người và máy
	private JLabel lbKetQua;
	// Khai báo một text field
	private JTextField tfName;

	// Tạo một font chữ fontBig để set cho các dòng chữ lớn
	private Font fontBig = new Font("Times New Roman", Font.BOLD, 30);
	// Tạo một đối tượng FontMetrics fmBig để lấy kích thước chuỗi có
	// font kiểu fontBig
	private FontMetrics fmBig = getFontMetrics(fontBig);

	/**
	 * Phương thức tạo ra một màn hình vào game
	 */
	public void taoManHinhVaoGame() {
		// setLayout cho Panel
		setLayout(null);
		// set màu nền là màu trắng
		setBackground(Color.WHITE);
		// Tạo một label logo có hình lưu trong file LUVINAGAME.png
		JLabel lbLogo = new JLabel(new ImageIcon("Images/LUVINAGAME.png"));
		// Set kích thước và vị trí cho label logo
		lbLogo.setBounds(120, 160, 160, 160);
		// Add label logo lên Panel
		add(lbLogo);

		// Tạo một font chữ
		Font fontBig = new Font("Times New Roman", Font.BOLD, 16);
		// Tạo một đối tượng FontMetrics để lấy kích thước chuỗi có font kiểu
		// fontBig
		FontMetrics fmBig = getFontMetrics(fontBig);

		// Tạo một label lbTitle hiển thị dòng chữ "PROJECT - TEST - CARO - PHAM
		// THANH LUAN"
		JLabel lbTitle = new JLabel("PROJECT - TEST - CARO - PHAM THANH LUAN");
		// Set kích thước và vị trí cho label lbTitle
		lbTitle.setBounds(lbLogo.getX() + lbLogo.getWidth() + 20, lbLogo.getY() + 25,
				fmBig.stringWidth("PROJECT - TEST - CARO - PHAM THANH LUAN"), fmBig.getHeight());
		// Set font cho label lbTitle
		lbTitle.setFont(fontBig);
		// Set màu chữ cho label lbTitle
		lbTitle.setForeground(Color.RED);
		// Add label lbTitle lên panel
		add(lbTitle);

		// Tạo một label lbNguoiChoi hiển thị dòng chữ "Người chơi:"
		JLabel lbNguoiChoi = new JLabel("Người chơi:");
		// Set kích thước và vị trí cho label lbNguoiChoi
		lbNguoiChoi.setBounds(lbTitle.getX(), lbTitle.getY() + lbTitle.getHeight() + 20,
				fmBig.stringWidth("Người chơi:"), fmBig.getHeight());
		// Set font cho label lbNguoiChoi
		lbNguoiChoi.setFont(fontBig);
		// Set màu chữ cho label lbNguoiChoi
		lbNguoiChoi.setForeground(Color.BLUE);
		// Add label lbNguoiChoi lên panel
		add(lbNguoiChoi);

		// Tạo một text field tfName
		tfName = new JTextField();
		// Set kích thước và vị trí cho text field tfName
		tfName.setBounds(lbNguoiChoi.getX() + lbNguoiChoi.getWidth() + 20, lbNguoiChoi.getY(), 240, 26);
		// Add text field tfName
		add(tfName);

		// Tạo một button btnVaoGame hiển thị dòng chữ "Bắt đầu" để click vào để
		// bắt đầu game
		JButton btnVaoGame = new JButton("Bắt đầu");
		// Set màu sắc cho dòng chữ hiển thị trên button btnVaoGame
		btnVaoGame.setForeground(Color.BLUE);
		// Set font cho button btnVaoGame
		btnVaoGame.setFont(fontBig);
		// Set kích thước và vị trí của button btnVaoGame
		btnVaoGame.setBounds(tfName.getX(), lbNguoiChoi.getY() + lbNguoiChoi.getHeight() + 20, 100, 30);
		// Add sự kiện click button btnVaoGame
		btnVaoGame.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// Nếu người chơi nhập tên thực hiện set tên người chơi vào game
				if (tfName.getText() != null && tfName.getText().length() != 0) {
					// Set tên người chơi cho biến BanCo.name để lưu trữ tên
					// người chơi
					BanCo.name = tfName.getText();
				}
				// Thực hiện hàm tạo bàn cờ
				taoBanCo();
				// Gọi phương thức bắt đầu chơi của panelBanCo
				batDauChoi();
			}
		});
		// Add button btnVaoGame vào panlel
		add(btnVaoGame);

	}

	/**
	 * Phương thức tạo ra một Bàn Cờ
	 */
	public void taoBanCo() {
		// Gỡ tất cả các phần tử thực hiện công việc vào game
		removeAll();
		// Set lại background về mặc định
		setBackground(null);

		try {
			// Khởi tạo ImageIcon cho ô cờ trống
			trongIcon = new ImageIcon("Images/trong.png");
			// Khởi tạo ImageIcon cho ô cờ người đánh
			oIcon = new ImageIcon("Images/tron.png");
			// Khởi tạo ImageIcon cho ô cờ máy đánh
			xIcon = new ImageIcon("Images/cheo.png");
			// Khởi tạo đối tượng bàn cờ gồm 400 quân cờ lưu trữ bằng một mảng
			// QuanCo[20][20] mỗi quân cờ là một button trên màn hình hiển thị
			BanCo.banCo = new QuanCo[BanCo.N][BanCo.N];
			// Khởi tạo một mảng 2 chiều 20x20 chứa các label để hiển thị lên
			// màn hình sau khi đánh
			lbCaro = new JLabel[BanCo.N][BanCo.N];
			// Thực hiện vòng lặp khởi tạo từng quân cờ với giá trị ban đầu cho
			// các ô cờ.
			// Duyệt theo hàng
			// Setup thuộc tính cho từng button quân cờ trong mảng, khai
			// báo và khởi tạo từng label trong mảng
			for (int i = 0; i < BanCo.N; i++) {
				// Duyệt theo cột
				for (int j = 0; j < BanCo.N; j++) {
					// Khởi tạo quân cờ ban đầu có tọa độ i, j và value = 'T'
					BanCo.banCo[i][j] = new QuanCo(i, j);
					// Set vị trí và kích thước cho button Quân Cờ
					BanCo.banCo[i][j].setBounds(j * 30, i * 30, 30, 30);
					// Set vị icon cho button Quân Cờ
					BanCo.banCo[i][j].setIcon(trongIcon);
					// Add Quân Cờ lên bàn cờ
					add(BanCo.banCo[i][j]);

					// Thực hiện add lắng nghe sự kiện cho các button
					BanCo.banCo[i][j].addActionListener(this);
					// Tạo các label
					lbCaro[i][j] = new JLabel();
					// Set vị trí và kích thước label
					lbCaro[i][j].setBounds(j * 30 + 1, i * 30, 30, 30);
					// Add các label
					add(lbCaro[i][j]);

				}
			}

			// Tạo một panel để hiển thị thông tin game
			JPanel pnThongTin = new JPanel();
			// Set Layout cho panel pnThongTin
			pnThongTin.setLayout(null);
			// Set kích thước, vị trí cho panel pnThongTin
			pnThongTin.setBounds(BanCo.W_BANCO - 8, 0, 200, BanCo.H_BANCO);
			// Set màu sắc cho panel pnThongTin
			pnThongTin.setBackground(Color.WHITE);
			// Add panel pnThongTin lên màn hình
			add(pnThongTin);

			// Tạo một ImageIcon trỏ tới hình ảnh lưu trong
			// Images/LUVINAGAME.png
			ImageIcon logoIcon = new ImageIcon("Images/LUVINAGAME.png");
			// Tạo label lbLogo để hiển thị hình ảnh logo lên màn hình
			JLabel lbLogo = new JLabel(logoIcon);
			// Set kích thước vị trí cho label lbLogo
			lbLogo.setBounds(20, BanCo.H_BANCO - 200, 160, 160);
			// Add label lbLogo lên panel pnThongTin
			pnThongTin.add(lbLogo);

			// Tạo một font chữ fontNomal để set cho các dòng chữ bình thường
			Font fontNomal = new Font("Times New Roman", Font.BOLD, 14);
			// Tạo một đối tượng FontMetrics fmNomal để lấy kích thước chuỗi có
			// font kiểu fontNomal
			FontMetrics fmNomal = getFontMetrics(fontNomal);

			// Tạo label lbTitle hiển thị dòng "Cờ Caro" lên màn hình
			JLabel lbTitle = new JLabel("Cờ Caro");
			// Set vị trí, kích thước cho label lbTitle
			lbTitle.setBounds((200 - fmBig.stringWidth("Cờ Caro")) / 2, 80, fmBig.stringWidth("Cờ Caro"),
					fmBig.getHeight());
			// Set Font cho label lbTitle
			lbTitle.setFont(fontBig);
			// Set mà chữ cho label lbTitle
			lbTitle.setForeground(new Color(10, 117, 65));
			// Add label lbTitle lên panel pnThongTin
			pnThongTin.add(lbTitle);

			// Tạo một label lbNguoiChoi để hiển thị dòng "Người chơi:"
			JLabel lbNguoiChoi = new JLabel("Người chơi:");
			// Set vị trí, kích thước cho label lbNguoiChoi
			lbNguoiChoi.setBounds((200 - fmNomal.stringWidth("Người chơi:")) / 2,
					lbTitle.getY() + lbTitle.getHeight() + 60, fmNomal.stringWidth("Người chơi:"), fmNomal.getHeight());
			// Set font cho label lbNguoiChoi
			lbNguoiChoi.setFont(fontNomal);
			// Add label lbNguoiChoi lên panel pnThongTin
			pnThongTin.add(lbNguoiChoi);

			// Tạo một label lbTen để hiển thị dòng tên người chơi
			JLabel lbTen = new JLabel(BanCo.name);
			// Set vị trí, kích thước cho label lbTen
			lbTen.setBounds((200 - fmNomal.stringWidth(BanCo.name)) / 2,
					lbNguoiChoi.getY() + lbNguoiChoi.getHeight() + 20, fmNomal.stringWidth(BanCo.name),
					fmNomal.getHeight());
			// Set Font cho label lbTen
			lbTen.setFont(fontNomal);
			// Set màu chữ cho label lbTen
			lbTen.setForeground(Color.BLUE);
			// Add label lbTen lên panel pnThongTin
			pnThongTin.add(lbTen);

			// Tạo một label lbTiSo để hiển thị dòng "Tỉ số:"
			JLabel lbTiSo = new JLabel("Tỉ số:");
			// Set vị trí, kích thước cho label lbTiSo
			lbTiSo.setBounds((200 - fmNomal.stringWidth("Tỉ số:")) / 2, lbTen.getY() + lbTen.getHeight() + 30,
					fmNomal.stringWidth("Tỉ số: "), fmNomal.getHeight());
			// Set Font cho label lbTiSo
			lbTiSo.setFont(fontNomal);
			// Add label lbTiSo lên panel pnThongTin
			pnThongTin.add(lbTiSo);

			// Tạo label lbKetQua để hiển thị giá trị tỉ số lên màn hình, giá
			// trị mặc định ban đầu là "0 : 0"
			lbKetQua = new JLabel("0 : 0");
			// Set vị trí, kích thước cho label lbKetQua
			lbKetQua.setBounds((200 - fmBig.stringWidth(BanCo.nguoiThang + " : " + BanCo.mayThang)) / 2,
					lbTiSo.getY() + lbTiSo.getHeight() + 20,
					fmBig.stringWidth(BanCo.nguoiThang + " : " + BanCo.mayThang), fmBig.getHeight());
			// Set Font cho label lbKetQua
			lbKetQua.setFont(fontBig);
			// Set màu chữ cho label lbKetQua
			lbKetQua.setForeground(Color.RED);
			// Add label lbKetQua lên panel pnThongTin
			pnThongTin.add(lbKetQua);

			// Thực hiện vẽ lại màn hình
			repaint();

		} catch (MyException e) {
			// Nếu lỗi thực hiện thông báo lỗi lên màn hình
			JOptionPane.showInternalMessageDialog(PanelBanCo.this, e.getMessage());
		}
	}

	/**
	 * Phương thức thực hiện bắt đầu chơi
	 */
	public void batDauChoi() {

		try {
			// Khởi tạo một đối tượng CoCaRo thực hiện xử lý logic
			coCaro = new CoCaro();
			// Cho máy đánh trước
			coCaro.mayDanh();
		} catch (MyException e) {
			// Nếu có lỗi hiển thị thông báo lỗi
			JOptionPane.showInternalMessageDialog(PanelBanCo.this, e.getMessage());
		}
		// Set X cho nước máy đánh
		lbCaro[BanCo.nuocMayDanhMoi.getX()][BanCo.nuocMayDanhMoi.getY()].setIcon(xIcon);
		// Button tại vị trí đã đánh không hiển thị lên màn hình
		BanCo.banCo[BanCo.nuocMayDanhMoi.getX()][BanCo.nuocMayDanhMoi.getY()].setVisible(false);
	}

	/**
	 * Phương thức thực hiện chơi tiếp game
	 * 
	 * @throws MyException
	 */
	public void choiTiep() throws MyException {
		// Set lại Text hiển thị cho label lbKetQua
		lbKetQua.setText(BanCo.nguoiThang + " : " + BanCo.mayThang);
		// Set lại kích thước cho label lbKetQua
		lbKetQua.setSize(fmBig.stringWidth(BanCo.nguoiThang + " : " + BanCo.mayThang), fmBig.getHeight());
		// Duyệt theo hàng
		for (int i = 0; i < BanCo.N; i++) {
			// Duyệt theo cột
			for (int j = 0; j < BanCo.N; j++) {
				// Đặt lại giá trị value cho các quân cờ trên bàn cờ
				BanCo.banCo[i][j].setValue('T');
				// Hiển thị các quân cờ lên bàn cờ
				BanCo.banCo[i][j].setVisible(true);
			}
		}
		// Tăng số ván đánh lên 1
		BanCo.soVan++;
		// Đặt lại giá trị số nước đi = 0
		BanCo.number = 0;
		// Đặt lại tọa độ x cho nước máy đánh mới
		BanCo.nuocMayDanhMoi.setX(0);
		// Đặt lại tọa độ y cho nước máy đánh mới
		BanCo.nuocMayDanhMoi.setY(0);
		// Đặt lại tọa độ x cho nước người đánh mới
		BanCo.nuocNguoiDanhMoi.setX(0);
		// Đặt lại tọa độ y cho nước người đánh mới
		BanCo.nuocNguoiDanhMoi.setY(0);
		// Nếu số ván là chẵn cho máy đánh trước, lẻ cho người đánh trước
		if (BanCo.soVan % 2 == 0) {
			// Gọi phương thức máy đánh trước
			batDauChoi();
		}
	}

	/**
	 * Overide phương thức lắng nghe sự kiện
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// Kiểm tra nếu thuộc tính coCaro null hiển thị thông báo lỗi
		if (coCaro == null) {
			JOptionPane.showMessageDialog(PanelBanCo.this, "Game chưa bắt đầu");
		} else {
			// Khai báo biến quanCo để lưu trữ Quân Cờ vừa thực hiện click
			QuanCo quanCo = null;
			// Lấy về button Quân Cờ vừa thực hiện sự kiện click
			if (e.getSource() instanceof QuanCo) {
				quanCo = (QuanCo) e.getSource();
			} else {
				// Nếu không lấy về được Quân Cờ thông báo "Chương trình gặp
				// lỗi!"
				JOptionPane.showInternalMessageDialog(PanelBanCo.this, "Chương trình gặp lỗi!");
				System.exit(0);
			}
			// Kiểm tra bàn cờ full nếu full thông báo "Hòa! Bạn có muốn chơi
			// tiếp?"
			// Nếu người chơi muốn chơi tiếp, nếu người chơi đồng ý thực hiện
			// đánh tiếp, nếu không thoát chương trình
			if (coCaro.isFull()) {
				int result = JOptionPane.showConfirmDialog(PanelBanCo.this, "Hòa! Bạn có muốn chơi tiếp?");
				if (result != 0) {
					System.exit(0); // Thoát chương trình
				} else {
					try {
						choiTiep(); // Thực hiện chơi tiếp để setup lại bàn cờ
						return; // Thoát khỏi phương thức để bắt đầu ván mới
					} catch (MyException e1) {
						// Nếu gặp lỗi thông báo "Không thể chơi tiếp!"
						JOptionPane.showMessageDialog(PanelBanCo.this, "Không thể chơi tiếp!");
					}
				}
			}
			// Thực hiện cho người đánh
			try {
				int x = quanCo.getToaDo().getX(); // Lấy ra tọa độ hàng
				int y = quanCo.getToaDo().getY(); // Lấy ra tọa độ cột
				// Gọi phương thức người đánh
				coCaro.nguoiDanh(x, y);
				// Set Y cho nước máy đánh
				lbCaro[x][y].setIcon(oIcon);
				// Button tại vị trí đã đánh không hiển thị lên màn hình
				BanCo.banCo[x][y].setVisible(false);

			} catch (MyException e1) {
				// Nếu gặp lỗi thông báo lỗi lên màn hình
				JOptionPane.showInternalMessageDialog(PanelBanCo.this, e1.getMessage());
			}
			// Kiểm tra thắng cho người chơi
			if (coCaro.isWin('O')) {
				// Nếu người chơi thắng in ra thông báo "Bạn thắng! Bạn có muốn
				// chơi tiếp?"
				// Nếu người chơi muốn chơi tiếp, nếu người chơi đồng ý thực
				// hiện đánh tiếp, nếu không thoát chương trình
				int result = JOptionPane.showConfirmDialog(PanelBanCo.this, "Bạn thắng! Bạn có muốn chơi tiếp?");
				if (result != 0) {
					System.exit(0); // Thoát chương trình
				} else {
					BanCo.nguoiThang++; // Tăng số ván người thắng lên 1
					try {
						choiTiep(); // Thực hiện chơi tiếp để setup lại bàn cờ
						return; // Thoát khỏi phương thức để bắt đầu ván mới
					} catch (MyException e1) {
						// Nếu gặp lỗi thông báo "Không thể chơi tiếp!"
						JOptionPane.showMessageDialog(PanelBanCo.this, "Không thể chơi tiếp!");
					}
				}
			}
			// Thực hiện cho máy đánh
			try {
				// Gọi phương thức máy đánh
				coCaro.mayDanh();
				// Set X cho nước máy đánh
				lbCaro[BanCo.nuocMayDanhMoi.getX()][BanCo.nuocMayDanhMoi.getY()].setIcon(xIcon);
				// Button tại vị trí đã đánh không hiển thị lên màn hình
				BanCo.banCo[BanCo.nuocMayDanhMoi.getX()][BanCo.nuocMayDanhMoi.getY()].setVisible(false);
			} catch (MyException e1) {
				// Nếu gặp lỗi thông báo lỗi lên màn hình
				JOptionPane.showInternalMessageDialog(PanelBanCo.this, e1.getMessage());
			}
			// Kiểm tra thắng cho máy
			if (coCaro.isWin('X')) {
				// Nếu người chơi thắng in ra thông báo "Máy thắng! Bạn có muốn
				// chơi tiếp?"
				// Nếu người chơi muốn chơi tiếp, nếu người chơi đồng ý thực
				// hiện đánh tiếp, nếu không thoát chương trình
				int result = JOptionPane.showConfirmDialog(PanelBanCo.this, "Máy thắng! Bạn có muốn chơi tiếp?");
				if (result != 0) {
					System.exit(0); // Thoát chương trình
				} else {
					BanCo.mayThang++;// Tăng số ván máy thắng lên 1
					try {
						choiTiep(); // Thực hiện chơi tiếp để setup lại bàn cờ
						return; // Thoát khỏi phương thức để bắt đầu ván mới
					} catch (MyException e1) {
						// Nếu gặp lỗi thông báo "Không thể chơi tiếp!"
						JOptionPane.showMessageDialog(PanelBanCo.this, "Không thể chơi tiếp!");
					}
				}
			}
		}
	}
}
