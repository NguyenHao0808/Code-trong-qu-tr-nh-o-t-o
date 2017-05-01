/**
 * Copyright(C) 2017 Luvina
 * TestCaro.java, 06/01/2017 haonv
 */
package com.haonv.logicco;

import com.haonv.theco.DanhSachTheCo;
import com.haonv.theco.TheCo;

/**
 * chứa các hàm logic cờ
 * 
 * @author Nguyen Hao
 *
 */
public class LogicCo {
	// khai báo tham số banCo kiểu dữ liệu String[][]
	private String[][] banCo;
	// khai báo tham số dsTheCo kiểu dữ liệu DanhSachTheCo
	private DanhSachTheCo dsTheCo;

	/**
	 * phương thức khởi tạo của class
	 */
	public LogicCo() {
		// khởi tạo tham số banCo
		banCo = new String[20][20];
		// khởi tạo tham số dsTheCo
		dsTheCo = new DanhSachTheCo();
		// gọi phương thức ganGTOCo
		ganGTOCo();
	}

	/**
	 * gán giá trị cho các ô cờ
	 */
	private void ganGTOCo() {
		// duyệt hàng ô cờ
		for (int i = 0; i < 20; i++) {
			// duyệt cột ô cờ
			for (int j = 0; j < 20; j++) {
				// gán giá trị banCo[i][j]
				banCo[i][j] = "T";
			}
		}
	}

	/**
	 * lấy thế cờ từ một vị trí
	 * 
	 * @param u
	 *            : tham số hàng
	 * @param v
	 *            : tham số cột
	 * @return: thế cờ tại vị trí tham số
	 */
	private TheCo chiaBanCo(int u, int v) {
		// biến dùng cộng các giá trị ô cờ
		String text = "";
		// duyệt hàng cờ
		for (int i = u; i < (u + 5); i++) {
			// duyệt cột cờ
			for (int j = v; j < (v + 5); j++) {
				// tính tổng text với giá trị ô cờ
				text += banCo[i][j];
			}
		}
		// khởi tạo nên một thế cờ
		TheCo theCo = new TheCo(text);
		// trả về thế cờ đã tạo
		return theCo;
	}

	/**
	 * so sánh hai thế cờ
	 * 
	 * @param tcP
	 *            : thế cờ từ bàn phím
	 * @param tcF
	 *            : thế cờ từ file
	 * @return: vị trí đánh
	 */
	private int[] soSanhTheCo(TheCo tcP, TheCo tcF) {
		// tạo biến cục bộ vitri
		int[] vitri = { -1, -1 };
		// duyệt hàng cờ
		for (int i = 0; i < 5; i++) {
			// duyệt cột cờ
			for (int j = 0; j < 5; j++) {
				// kiểm tra "X" với giá trị ô cờ trong tcF
				if ("X".equals(tcF.getTheCo()[i][j])) {
					// kiểm tra "X" với giá trị ô cờ trong tcP
					if (!"X".equals(tcP.getTheCo()[i][j])) {
						// trả về biến viTri
						return vitri;
					}
				}
				// kiểm tra "O" với giá trị ô cờ trong tcF
				if ("O".equals(tcF.getTheCo()[i][j])) {
					// kiểm tra "O" với giá trị ô cờ trong tcP
					if (!"O".equals(tcP.getTheCo()[i][j])) {
						// trả về biến vị trí
						return vitri;
					}
				}
				// kiểm tra "T" với giá trị ô cờ trong tcF
				if ("T".equals(tcF.getTheCo()[i][j])) {
					// kiểm tra "T" với giá trị ô cờ trong tcP
					if (!"T".equals(tcP.getTheCo()[i][j])) {
						// trả về biến vị trí
						return vitri;
					}
				}
			}
		}
		// duyệt hàng cờ
		for (int i = 0; i < 5; i++) {
			// duyệt cột cờ
			for (int j = 0; j < 5; j++) {
				// kiểm tra "D" với giá trị ô cờ trong tcF
				if ("D".equals(tcF.getTheCo()[i][j])) {
					// kiểm tra "T" với giá trị ô cờ trong tcP
					if (!"T".equals(tcP.getTheCo()[i][j])) {
						// trả về biến viTri
						return vitri;
					} else {
						// gán giá trị cho vitri[0]
						vitri[0] = i;
						// gán giá trị cho vitri[1]
						vitri[1] = j;
					}
				}
			}
		}
		// trả về biến viTri
		return vitri;
	}

	/**
	 * tìm vị trí đánh
	 * 
	 * @return: vị trí đánh
	 */
	private int[] timViTri() {
		// khởi tạo biến cục bộ vtD, khai báo biến cục bộ kq
		int[] kq, vtD = { -1, -1 };
		// lấy số phần tử của danh sách theChay
		int size = dsTheCo.getTheChay().size();
		// duyệt sô phần tử danh sách theChay
		for (int i = 0; i < size; i++) {
			// duyệt hàng cờ
			for (int j = 0; j < 16; j++) {
				// duyệt cột cờ
				for (int k = 0; k < 16; k++) {
					// lấy kết quả của so sánh thế cở bằng cách gọi phương thức
					// soSanhTheCo chuyền vào 2 thế cờ thứ tự thế trên phím và
					// thế trong file
					kq = soSanhTheCo(chiaBanCo(j, k),
							dsTheCo.getTheChay().get(i));
					// so sánh -1 với kq[0]
					if (-1 != kq[0]) {
						// gán giá trị cho vtD[0]
						vtD[0] = kq[0] + j;
						// gán giá trị cho vtD[1]
						vtD[1] = kq[1] + k;
						// trả về biến vtD
						return vtD;
					}
				}
			}
		}
		// trả về biến tvD
		return vtD;
	}

	/**
	 * danh cờ tại vị trí chuyền vào và giá trị là giá trị chuyền vào
	 * 
	 * @param m
	 *            : vị trí hàng
	 * @param n
	 *            : vị trí cột
	 * @param st
	 *            : giá trị đánh
	 */
	public void danhCo(int m, int n, String st) {
		// gán giá trị cho ô cờ tại vị trí chuyền vào
		banCo[m][n] = st;
	}

	/**
	 * tìm vị trí đánh cho máy
	 * 
	 * @param m
	 *            : vị trí hàng
	 * @param n
	 *            : vị trí cột
	 * @return: vị trí đánh
	 */
	public int[] viTriDanh(int m, int n) {
		// lấy kết quả của phường thức timViTri
		int[] kq = timViTri();
		// so sánh -1 với kết quả
		if (-1 != kq[0]) {
			// gọi phương thức đánh cờ quân X
			danhCo(kq[0], kq[1], "X");
			// trả về vị trí đánh
			return kq;
		}

		// Khi không tìm được vị trí đánh

		// tạo biến cục bộ k
		int k = 1;
		// khai báo các biến cục bộ
		int w1, w2, h1, h2;
		// chạy vòng lập while
		while (true) {
			// gán giá trị cho w2 bằng giá trị nhỏ nhất giữa (m + k), 19
			w2 = Math.min((m + k), 19);
			// gán giá trị cho w1 bằng giá trị lớn nhất giữa (m - k), 0
			w1 = Math.max((m - k), 0);
			// gán giá trị cho h2 bằng giá trị nhỏ nhất giữa (n + k), 19
			h2 = Math.min((n + k), 19);
			// gán giá trị cho h1 bằng giá trị lớn nhất giữa (n - k), 0
			h1 = Math.max((n - k), 0);
			// duyệt hàng cờ
			for (int i = w1; i <= w2; i++) {
				// duyệt cột cờ
				for (int j = h1; j <= h2; j++) {
					// so sánh "T" với vị trí banCo[i][j])
					if ("T".equals(banCo[i][j])) {
						// gán giá trị cho kq[0]
						kq[0] = i;
						// gán giá trị cho kq[1]
						kq[1] = j;
						// đánh cờ X tại vị trí kq
						danhCo(kq[0], kq[1], "X");
						// trả về vị trí kq
						return kq;
					}
				}
			}
			// tăng k lên 1
			k++;
		}
	}

	/**
	 * kiểm tra thắng thua trên bàn cờ
	 * 
	 * @param m
	 *            : vị trí hàng
	 * @param n
	 *            : vi trí cột
	 * @return: trả về một sô: 1 máy thắng, 2 là người chơi thắng
	 */
	public int checkWin(int m, int n) {
		// lấy số phần tử của danh sách kết
		int s5 = dsTheCo.getTheKet().size();
		// khai báo biến cục bộ
		int w1, w2, h1, h2, win;
		// gán giá trị cho w2 bằng giá trị nhỏ nhất giữa (m + 5), 20
		w2 = Math.min((m + 5), 20);
		// gán giá trị cho w1 bằng giá trị lớn nhất giữa (m - 4), 0
		w1 = Math.max((m - 4), 0);
		// gán giá trị cho h2 bằng giá trị nhỏ nhất giữa (n + 5), 20
		h2 = Math.min((n + 5), 20);
		// gán giá trị cho h1 bằng giá trị nhỏ nhất giữa (n - 4), 0
		h1 = Math.max((n - 4), 0);
		// duyệt danh sách phần tử trong danh sách kết
		for (int k = 0; k < s5; k++) {
			// duyệt hàng cờ
			for (int i = w1; i < (w2 - 4); i++) {
				// duyệt cột cờ
				for (int j = h1; j < (h2 - 4); j++) {
					// gán giá trị cho win bằng trả về của phương thức soSanhWin
					win = soSanhWin(chiaBanCo(i, j), dsTheCo.getTheKet().get(k));
					// so sánh 2 với win
					if (2 == win) {
						// trả về 2
						return 2;
						// so sánh 1 với win
					} else if (1 == win) {
						// trả về 1
						return 1;
					}

				}
			}
		}
		// trả về 0
		return 0;
	}

	/**
	 * so sánh chiến thắng
	 * 
	 * @param tcP
	 *            : thế cờ bàn phím
	 * @param tcF
	 *            : thế cờ trong file
	 * @return:1 máy thắng, 2 người thắng, 0 chưa có kết quả
	 */
	private int soSanhWin(TheCo tcP, TheCo tcF) {
		// tạo biến cục bộ count
		int count = 0;
		// tạo biến cục bộ test
		int test = 0;
		// duyệt hàng cờ
		for (int i = 0; i < 5; i++) {
			// duyệt cột cờ
			for (int j = 0; j < 5; j++) {
				// so sánh O với ô cờ của tcF
				if ("O".equals(tcF.getTheCo()[i][j])) {
					// so sánh O với ô cờ của tcP
					if (!"O".equals(tcP.getTheCo()[i][j])) {
						// gán gtri count
						count = 1;
					}
					// gán gtri test
					test = 2;
				}
				// so sánh X với ô cờ của tcF
				if ("X".equals(tcF.getTheCo()[i][j])) {
					// so sánh X với ô cờ của tcP
					if (!"X".equals(tcP.getTheCo()[i][j])) {
						// gán giá trị count
						count = 1;
					}
					// gán giá trị test
					test = 1;
				}

			}
		}
		// so sánh count == 0 && test == 1
		if (count == 0 && test == 1) {
			// trả về 1
			return 1;
		}
		// so sánh count == 0 && test == 2
		if (count == 0 && test == 2) {
			// trả về 2
			return 2;
		}
		// trả về 0
		return 0;

	}

	/**
	 * kiểm tra cờ hoà
	 * 
	 * @return: true là hoà, false còn có thể đánh
	 */
	public boolean checkHoa() {
		// duyệt hàng cờ
		for (int i = 0; i < 20; i++) {
			// duyệt cột cờ
			for (int j = 0; j < 20; j++) {
				// so sánh T với banCo[i][j])
				if ("T".equals(banCo[i][j])) {
					// trả về false
					return false;
				}
			}
		}
		// trả về true
		return true;
	}
}
