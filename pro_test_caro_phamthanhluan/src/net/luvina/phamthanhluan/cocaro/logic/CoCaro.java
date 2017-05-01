/**
 * Copyright(C) 2016  Luvina
 * CoCaro.java, Jan 04, 2017 Phạm Thành Luân
 */

package net.luvina.phamthanhluan.cocaro.logic;

import net.luvina.phamthanhluan.cocaro.common.BanCo;
import net.luvina.phamthanhluan.cocaro.common.ToaDo;
import net.luvina.phamthanhluan.cocaro.exception.MyException;

/**
 * Class CoCaro dùng để tạo đối tượng CoCaro xử lý logic cho chương trình
 * 
 * @author Phạm Thành Luân
 *
 */
public class CoCaro {

	private QuanLyTheCo quanLyTheCo; // Biến quản lý thế cờ

	/**
	 * Phương thức khởi tạo nên đối tượng cờ ca rô để xử lý các logic trên bàn
	 * cờ
	 * 
	 * @throws MyException
	 */
	public CoCaro() throws MyException {
		// Khởi tạo nước máy mới đánh mặc định ban đầu là 0, 0
		BanCo.nuocMayDanhMoi = new ToaDo();
		// Khởi tạo nước người mới đánh mặc định ban đầu là 0, 0
		BanCo.nuocNguoiDanhMoi = new ToaDo();
		quanLyTheCo = new QuanLyTheCo(); // Tạo một đối tượng QuanLyTheCo để
											// thao tác với file thế cờ
	}

	/**
	 * Phương thức thực hiện cho máy đánh
	 * 
	 * @return Nước cờ máy đánh (NuocCo)
	 * @throws MyException
	 */
	public void mayDanh() throws MyException {
		// Tăng giá trị cho biến đếm thứ tự nước cờ
		BanCo.number++;
		// Gọi phương thức để lấy nước cờ cần đánh
		BanCo.nuocMayDanhMoi = quanLyTheCo.getNuocCo();
		// Gán giá trị cho quân cờ máy mới thực hiện đánh
		BanCo.banCo[BanCo.nuocMayDanhMoi.getX()][BanCo.nuocMayDanhMoi.getY()].setValue('X');
	}

	/**
	 * Phương thức thực hiện việc cho người chơi đánh
	 * 
	 * @param x
	 *            tọa độ x nước cờ (int)
	 * @param y
	 *            tọa độ y nước cờ (int)
	 * @throws MyException
	 */
	public void nguoiDanh(int x, int y) throws MyException {
		// Tăng giá trị cho biến đếm thứ tự nước cờ
		BanCo.number++;
		// Gán giá trị cho ô cờ người thực hiện đánh
		BanCo.banCo[x][y].setValue('O');
		// Set giá trị tọa độ x cho nước cờ Người mới đánh
		BanCo.nuocNguoiDanhMoi.setX(x);
		// Set giá trị tọa độ y cho nước cờ Người mới đánh
		BanCo.nuocNguoiDanhMoi.setY(y);

	}

	/**
	 * Phương thức kiểm tra bàn cờ full hay chưa
	 * 
	 * @return đúng: true; sai: false
	 */
	public final boolean isFull() {
		if (BanCo.number == BanCo.N * BanCo.N) {
			return true;
		}
		return false;
	}

	/**
	 * Phương thức kiểm tra thắng
	 * 
	 * @param value
	 *            giá trị cần xét 'O' với người và 'X' với máy
	 * @return thắng: true. chưa thắng: false
	 */
	public final boolean isWin(char value) {
		ToaDo nuocCoMoi; // Tạo mới một biến nước cờ mới
		// Kiểm tra giá trị truyền vào là 'X' hay 'O'
		// Nếu là 'X' là kiểm tra máy thắng
		// Ngược lại là kiểm tra người thắng
		if (value == 'X') {
			// Nếu truyền vào 'X' tức kiểm tra máy thắng gán nuocCoMoi =
			// nuocMayDanhMoi
			nuocCoMoi = BanCo.nuocMayDanhMoi;
		} else {
			// Nếu truyền vào 'O' tức kiểm trangười thắng gán nuocCoMoi
			// = nuocNguoiDanhMoi
			nuocCoMoi = BanCo.nuocNguoiDanhMoi;
		}

		// Lấy tọa độ x
		int x = nuocCoMoi.getX();
		// Lấy tọa độ y
		int y = nuocCoMoi.getY();
		// Biến tổng để lưu số lượng các ô có giá trị value liền nhau
		int sum = 0;

		// Check hàng ngang
		// Duyệt theo hàng ngang có vị trí hàng bằng hàng nước cờ vừa đánh
		for (int i = 0; i < BanCo.N; i++) {
			// Nếu giá trị ô cờ bằng value thì tăng sum lên 1.
			if (BanCo.banCo[x][i].getValue() == value) {
				sum++;
				// Nếu sum = 5 thì thắng
				if (sum == 5) {
					return true;
				}
			} else {
				// Nếu giá trị ô cờ khác value thì gán lại sum =0
				sum = 0;
			}
		}

		// Check hàng dọc
		// Duyệt theo hàng dọc có vị trí hàng bằng hàng nước cờ vừa đánh
		for (int i = 0; i < BanCo.N; i++) {
			// Nếu giá trị ô cờ bằng value thì tăng sum lên 1.
			if (BanCo.banCo[i][y].getValue() == value) {
				sum++;
				// Nếu sum = 5 thì thắng
				if (sum == 5) {
					return true;
				}
			} else {
				// Nếu giá trị ô cờ khác value thì gán lại sum =0
				sum = 0;
			}
		}

		// Check hàng chéo chính
		if (y > x) {
			// Duyệt theo hàng chéo chính đi qua nước cờ vừa đánh
			for (int i = 0; i < BanCo.N - (y - x); i++) {
				// Nếu giá trị ô cờ bằng value thì tăng sum lên 1.
				if (BanCo.banCo[i][i + (y - x)].getValue() == value) {
					sum++;
					// Nếu sum = 5 thì thắng
					if (sum == 5) {
						return true;
					}
				} else {
					// Nếu giá trị ô cờ khác value thì gán lại sum =0
					sum = 0;
				}
			}
		} else {
			// Duyệt theo hàng chéo chính đi qua nước cờ vừa đánh
			for (int i = 0; i < BanCo.N - (x - y); i++) {
				// Nếu giá trị ô cờ bằng value thì tăng sum lên 1.
				if (BanCo.banCo[i + (x - y)][i].getValue() == value) {
					sum++;
					// Nếu sum = 5 thì thắng
					if (sum == 5) {
						return true;
					}
				} else {
					// Nếu giá trị ô cờ khác value thì gán lại sum =0
					sum = 0;
				}
			}
		}

		// Check hàng chéo phụ
		if (x + y < BanCo.N) {
			// Duyệt theo hàng chéo phụ đi qua nước cờ vừa đánh
			for (int i = 0; i < (y + x + 1); i++) {
				// Nếu giá trị ô cờ bằng value thì tăng sum lên 1.
				if (BanCo.banCo[i][(y + x) - i].getValue() == value) {
					sum++;
					// Nếu sum = 5 thì thắng
					if (sum == 5) {
						return true;
					}
				} else {
					// Nếu giá trị ô cờ khác value thì gán lại sum =0
					sum = 0;
				}

			}
		} else {
			// Duyệt theo hàng chéo phụ đi qua nước cờ vừa đánh
			for (int i = 0; i < (2 * BanCo.N - 1 - (x + y)); i++) {
				// Nếu giá trị ô cờ bằng value thì tăng sum lên 1.
				if (BanCo.banCo[BanCo.N - 1 - i][(x + y) - BanCo.N + 1 + i].getValue() == value) {
					sum++;
					// Nếu sum = 5 thì thắng
					if (sum == 5) {
						return true;
					}
				} else {
					// Nếu giá trị ô cờ khác value thì gán lại sum =0
					sum = 0;
				}

			}
		}

		return false;

	}

}
