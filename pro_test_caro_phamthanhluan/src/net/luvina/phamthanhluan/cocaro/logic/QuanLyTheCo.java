/**
 * Copyright(C) 2016  Luvina
 * QuanLyTheCo.java, Jan 04, 2017 Phạm Thành Luân
 */

package net.luvina.phamthanhluan.cocaro.logic;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import net.luvina.phamthanhluan.cocaro.common.ToaDo;
import net.luvina.phamthanhluan.cocaro.common.BanCo;
import net.luvina.phamthanhluan.cocaro.common.TheCo;
import net.luvina.phamthanhluan.cocaro.exception.MyException;

/**
 * Class QuanLyTheCo dùng để tạo đối tượng quản lý thế cờ có thuộc tính:
 * danhSachTheCo (danh sách các thế cờ đọc từ file TheCo.txt)
 * 
 * @author Phạm Thành Luân
 *
 */
public class QuanLyTheCo {
	// Danh sách các thế cờ (ArrayList<TheCo>)
	private ArrayList<TheCo> danhSachTheCo;
	private ArrayList<TheCo> danhSachTheCoDonGian;

	/**
	 * Phương thức khởi tạo một đối tượng quản lý thế cờ
	 * 
	 * @throws MyException
	 * 
	 */
	public QuanLyTheCo() throws MyException {
		// Khởi tạo các danh sách thế cờ
		danhSachTheCo = getDanhSachTheCo("TheCo.txt");
		danhSachTheCoDonGian = getDanhSachTheCo("TheCoDonGian.txt");
	}

	/**
	 * Phương thức tìm nước cờ cần đánh.
	 * 
	 * @throws MyException
	 */
	public ToaDo getNuocCo() throws MyException {

		ToaDo nuocCo = null;// Biến lưu giá trị nước cờ cần đánh

		// Nếu số nước cờ >= 6 duyệt danh sách thế cờ.
		if (BanCo.number >= 6) {
			// Gọi phương thức duyệt thế cờ với tất cả các danh sách.
			// gán giá trị trả về cho biến nuocCo
			nuocCo = duyetTimNuocCo(danhSachTheCo);
			// Kiểm tra nếu nuocCo khác null thì trả về giá trị nuocCo
			if (nuocCo != null) {
				return nuocCo;
			}
			// Khi duyệt thế cờ trong file TheCo.txt không có thực hiện duyệt
			// sang thế cờ trong file TheCoDonGian.txt
			nuocCo = duyetTimNuocCo(danhSachTheCoDonGian);
			// Kiểm tra nếu nuocCo khác null thì trả về giá trị nuocCo
			if (nuocCo != null) {
				return nuocCo;
			}

		} else {
			// Nếu nước máy đánh là nước đầu tiên mặc định cho máy đánh vào
			// chính giữa bàn cờ
			if (BanCo.number == 1) {
				nuocCo = new ToaDo(10, 10);
				return nuocCo;
			} else {
				// Khi số nước cờ đã đánh nhỏ hơn 6 thực hiện duyệt
				// các thế cờ trong file TheCoDonGian.txt
				nuocCo = duyetTimNuocCo(danhSachTheCoDonGian);
				// Kiểm tra nếu nuocCo khác null thì trả về giá trị nuocCo
				if (nuocCo != null) {
					return nuocCo;
				}
			}
		}

		// Nếu không tìm được nước đánh sau khi duyệt thế cờ thực hiện đánh ngẫu
		// nhiên dựa
		// vào nước người chơi vừa đánh.
		nuocCo = danhNgauNhien();

		return nuocCo;

	}

	/**
	 * Phương thức duyệt bàn cờ hiện tại và so với danh sách thế cờ để tìm ra
	 * nước đánh
	 *
	 * @param danhSach
	 * @return nước cờ cần đánh nếu tìm được thế cờ trong danh sách có trên bàn
	 *         cờ. Nếu không tìm được trả về null
	 * @throws MyException
	 */
	private ToaDo duyetTimNuocCo(ArrayList<TheCo> danhSach) throws MyException {
		// Biến lưu trữ giá trị nước cờ sẽ đánh. Bằng null nếu không có thế cờ
		// nào có trên bàn cờ
		ToaDo nuocDanh = null;
		// Biến để lưu trữ thế cờ.
		TheCo theCo;
		// Biến lưu trữ số lượng thế cờ trong danh sách
		int length = danhSach.size();
		// Biến lưu trữ mảng biểu diễn thế cờ
		char[][] maTranTheCo;

		// Vòng lặp thực hiện duyệt từ thế cờ 0 đến thế cờ thứ length -1
		for (int k = 0; k < length; k++) {
			// Lấy thế cờ thứ k từ danh sách gán cho biến theCo
			theCo = danhSach.get(k);
			// Lấy mảng ký tự biểu diễn thế cờ gán cho biến maTranCo
			maTranTheCo = theCo.getTheCo();
			// Vòng lặp thực hiện duyệt bàn cờ từ xmin đến xmin+4
			for (int i = 0; i < BanCo.N - 4; i++) {
				// Vòng lặp thực hiện duyệt bàn cờ từ ymin đến ymin+4
				for (int j = 0; j < BanCo.N - 4; j++) {
					// Biến kiểm tra bàn cờ có chứa thế cờ không
					boolean check = checkTheCo(i, j, maTranTheCo);
					// Sau khi duyệt hết 1 ô cờ nếu check bằng true kiểm tra vị
					// trí giá trị cần đánh trên bàn cờ nếu trông trả về nước cờ
					// cần đánh.
					if (check) {
						// Nước cần đánh có tọa độ hàng = x điểm gốc của ô cờ
						// 5x5 trên bàn cờ + tọa độ x của thế cờ
						// Nước cần đánh có tọa độ cột = y điểm gốc của ô cờ 5x5
						// trên bàn cờ + tọa độ y của thế cờ
						nuocDanh = new ToaDo(i + theCo.getX(), j + theCo.getY());
						return nuocDanh;
					}
				}
			}
		}
		return nuocDanh;
	}

	/**
	 * Phương thức đọc thế cờ từ file và add vào danh sách TheCo
	 * 
	 * @param path
	 *            truyền vào đường dẫn tới file cần đọc (String)
	 * @throws MyException
	 * @return
	 */
	@SuppressWarnings("finally")
	private ArrayList<TheCo> getDanhSachTheCo(String path) throws MyException {
		ArrayList<TheCo> danhSachTheCo = new ArrayList<>(); // Một danh sách các
															// thế cờ
															// (ArrayList<TheCo>)

		BufferedReader bufferedReader = null; // Khai báo đối tượng
												// BufferedReader để
		// đọc file
		try {
			// Khởi tạo cho đối tượng BufferedReader để đọc file
			bufferedReader = new BufferedReader(new FileReader(path));
			int isTheCo = 0; // Khai báo và khởi tạo một biến int để xác đinh
								// đọc được một thế cờ trong file (khi isTheCo =
								// 5)
			String temp; // Khai báo một biến temp dùng để lưu trữ từng dòng đọc
							// được từ file
			String[] line = new String[5]; // Khai báo và khởi tạo một mảng gồm
											// 5 phần tử để lưu trữ 5 dòng thế
											// cờ đọc từ file

			char[][] theCo;// Mảng 2 chiều lưu trữ thuộc
							// tính
							// thế cờ của đối tượng TheCo
			int x = -1; // Biến lưu trữ thuộc tính x của đối tượng TheCo
			int y = -1; // Biến lưu trữ thuộc tính y của đối tượng TheCo

			// Vòng lặp thực hiện đọc từ đầu tới cuối file.
			while ((temp = bufferedReader.readLine()) != null) {

				// Thực hiện kiểm tra xem temp có phải là một dòng của thế cờ
				// Nếu không phải đặt giá trị isTheCo về 0, bỏ qua và thực hiện
				// vòng lặp tiếp theo

				if (!checkLine(temp)) {
					isTheCo = 0;
					continue;
				}

				line[isTheCo] = temp; // Gán giá trị dòng thế cờ đọc được vào
										// biến line[isTheCo]
				isTheCo++; // Tăng giá trị isTheCo lên 1

				// Nếu đọc đủ thế cờ gồm 5 dòng thực hiện add thế cờ vào danh
				// sách thế cờ
				if (isTheCo == 5) {
					// Vòng lặp duyệt từ line[0] đến line[4]

					theCo = new char[5][5];

					for (int i = 0; i < 5; i++) {
						// Vòng lặp duyệt từ ký tự 0 đến 4 của line[i]
						for (int j = 0; j < 5; j++) {
							theCo[i][j] = line[i].charAt(j); // Gán giá trị cho
																// mảng theCo
							// Kiểm tra nếu theCo[i][j] là 'D' gán giá trị cho
							// x, y
							if (theCo[i][j] == 'D') {
								x = i;
								y = j;
							}
						}
					}

					danhSachTheCo.add(new TheCo(theCo, x, y));// add thế cờ vào
					// danh sách
					isTheCo = 0; // đặt lại isTheCo = 0;
				}
			}

		} catch (IOException e) {

			// Khi gặp lỗi đọc file throw một MyException
			// với mã lỗi 31 và tên lỗi: "Lỗi đọc file: " + path
			throw new MyException(31, "Lỗi đọc file: " + path);

		} finally {

			// Đóng luồng đọc file
			close(bufferedReader);
			// Trả về danh sách thế cờ
			return danhSachTheCo;

		}

	}

	/**
	 * Phương thức đóng một luồng truy xuất dữ liệu nếu khác null
	 * 
	 * @param closeable
	 * @throws MyException
	 */
	private void close(Closeable closeable) throws MyException {
		if (closeable != null) {
			try {
				closeable.close(); // Thực hiện đóng luồng
			} catch (IOException e) {
				// Khi gặp lỗi đọc file throw một MyException
				// với mã lỗi 32 và tên lỗi: "Lỗi đóng luồng đọc file "
				throw new MyException(32, "Lỗi đóng luồng đọc file");
			}
		}
	}

	/**
	 * Phương thức kiểm tra xem temp có phải là một dòng của thế cờ
	 * 
	 * @param string
	 *            truyền vào một chuỗi ký tự (String)
	 * @return đúng: true , sai: false
	 */
	private boolean checkLine(String string) {
		// Kiểm tra string khác 5 ký tự return flase
		if (string.length() != 5) {
			return false;
		}
		// Thực hiện vòng lặp kiểm tra các ký tự trong string nếu khác
		// {'X','T','O','D','G'} return false
		for (int i = 0; i < 5; i++) {
			if (string.charAt(i) != 'X' && string.charAt(i) != 'T' && string.charAt(i) != 'O' && string.charAt(i) != 'D'
					&& string.charAt(i) != 'G') {
				return false;
			}
		}
		return true;
	}

	/**
	 * Phương thưc đánh ngẫu nhiên dựa vào nước mới đánh
	 * 
	 * @param banCo
	 * @param nuocCoMayMoiDanh
	 * @param nuocCoNguoiMoiDanh
	 * @return nước cờ cần đánh (NuocCo)
	 * @throws MyException
	 */
	private ToaDo danhNgauNhien() throws MyException {
		ToaDo nuocCo = null; // Biến lưu trữ nước cờ cần đánh
		Random random = new Random(); // Biến để get random 1 số

		// Nếu nước cờ là lẻ tức máy đánh trước thực hiện đánh kế bên nước cờ
		// máy đánh trước đó để phát triển nước tấn công
		// Nếu nước cờ là chẵn tức người đánh trước thực hiện đánh kế bên nước
		// cờ người đánh trước đó để chặn nước của người đánh
		if (BanCo.number % 2 == 1) {
			nuocCo = danhKeBen(BanCo.nuocMayDanhMoi);
		} else {
			nuocCo = danhKeBen(BanCo.nuocNguoiDanhMoi);
		}
		// Nếu nước cờ trả về khác null thì return nước cờ đó
		if (nuocCo != null) {
			return nuocCo;
		}

		// - Nếu nước cờ trả về là null thực hiện đánh ngẫu nhiên vào 1 ô bất kỳ
		// còn trống trên bàn cờ
		// - Tạo 1 nước cờ có tọa độ bất kỳ
		nuocCo = new ToaDo(random.nextInt(20), random.nextInt(20));
		// Kiểm tra nếu ô cờ đó không phải ô trống thì tạo lại
		while (BanCo.banCo[nuocCo.getX()][nuocCo.getY()].getValue() != 'T') {
			nuocCo = new ToaDo(random.nextInt(20), random.nextInt(20));
		}
		// Trả về nước cờ cần đánh
		return nuocCo;
	}

	/**
	 * Phương thức thực hiện đánh vào ô ngẫu nhiên trống kế bên nước cờ được
	 * truyền vào.
	 * 
	 * @param banCo
	 * @param nuocCo
	 * @return
	 * @throws MyException
	 */
	private ToaDo danhKeBen(ToaDo nuocCo) throws MyException {
		Random random = new Random(); // Biến tạo đối tượng random để get random
										// một số
		ToaDo nuocCoDanh = null; // Biến lưu nước cờ cần đánh

		// Kiểm tra tọa độ của nước cờ truyền vào nếu ko phải ở 4 cạnh của bàn
		// cờ thì thực hiện đánh ngẫu nghiên vào 1 trong 8 ô xuong quanh nếu
		// trống
		if (nuocCo.getX() > 0 && nuocCo.getX() < 19 && nuocCo.getY() > 0 && nuocCo.getY() < 19) {

			// Thực hiện 8 lần lấy một giá trị random, nếu giá trị nước cờ tương
			// ứng lấy ra trống thì thực hiện trả về nước cờ đó và kết thúc vòng
			// lặp
			for (int i = 0; i < 8; i++) {
				int option = random.nextInt(8); // Lấy random 1 giá trị từ 0 đến
												// 7
				switch (option) {
				// Thực hiện lấy ra nước cờ đánh ứng với từng trường hợp
				case 0:
					// option = 0 - nước cờ cần đánh vào ngay dưới nước đánh
					// trước
					nuocCoDanh = new ToaDo(nuocCo.getX() + 1, nuocCo.getY());
					break;
				case 1:
					// option = 1 - nước cờ cần đánh vào ngay góc phải - dưới
					// nước đánh trước
					nuocCoDanh = new ToaDo(nuocCo.getX() + 1, nuocCo.getY() + 1);
					break;
				case 2:
					// option = 2 - nước cờ cần đánh vào ngay góc trái - dưới
					// nước đánh trước
					nuocCoDanh = new ToaDo(nuocCo.getX() + 1, nuocCo.getY() - 1);
					break;
				case 3:
					// option = 3 - nước cờ cần đánh vào ngay bên phải nước đánh
					// trước
					nuocCoDanh = new ToaDo(nuocCo.getX(), nuocCo.getY() + 1);
					break;
				case 4:
					// option = 4 - nước cờ cần đánh vào ngay bên trái nước đánh
					// trước
					nuocCoDanh = new ToaDo(nuocCo.getX(), nuocCo.getY() - 1);
					break;
				case 5:
					// option = 5 - nước cờ cần đánh vào ngay góc trái - trên
					// nước đánh trước
					nuocCoDanh = new ToaDo(nuocCo.getX() - 1, nuocCo.getY() - 1);
					break;
				case 6:
					// option = 6 - nước cờ cần đánh vào ngay bên trên nước đánh
					// trước
					nuocCoDanh = new ToaDo(nuocCo.getX() - 1, nuocCo.getY());
					break;
				case 7:
					// option = 7 - nước cờ cần đánh vào ngay góc phải - trên
					// nước đánh trước
					nuocCoDanh = new ToaDo(nuocCo.getX() - 1, nuocCo.getY() + 1);
					break;
				default:
					break;
				}
				// Nếu ô cờ lấy ra trống thực hiện trả về nước cờ đánh
				if (BanCo.banCo[nuocCoDanh.getX()][nuocCoDanh.getY()].getValue() == 'T') {
					return nuocCoDanh;

				}
			}
		} else {

			// Nếu nước cờ truyền vào ko thuộc 1 trong 2 cạnh dọc của bàn cờ
			if (nuocCo.getY() > 0 && nuocCo.getY() < 19) {

				// Nếu nước cờ truyền vào thuộc 2 cạnh ngang của bàn cờ thực
				// hiện đánh ngẫu nghiên vào 1 trong 5 ô xuong quanh nếu
				// trống
				switch (nuocCo.getX()) {
				case 0: // Nếu thuộc cạnh trên

					// Thực hiện 5 lần lấy một giá trị random, nếu giá trị nước
					// cờ tương ứng lấy ra trống thì thực hiện trả về nước cờ đó
					// và kết thúc vòng lặp
					for (int i = 0; i < 5; i++) {
						int option = random.nextInt(5); // Lấy random 1 giá trị
														// từ 0 đến 4

						// Thực hiện lấy ra nước cờ đánh ứng với từng trường hợp
						switch (option) {
						case 0:
							// option = 0 - nước cờ cần đánh vào ngay bên dưới
							// nước đánh trước
							nuocCoDanh = new ToaDo(nuocCo.getX() + 1, nuocCo.getY());
							break;
						case 1:
							// option = 1 - nước cờ cần đánh vào ngay góc phải -
							// dưới nước đánh trước
							nuocCoDanh = new ToaDo(nuocCo.getX() + 1, nuocCo.getY() + 1);
							break;
						case 2:
							// option = 2 - nước cờ cần đánh vào ngay góc trái -
							// dưới nước đánh trước
							nuocCoDanh = new ToaDo(nuocCo.getX() + 1, nuocCo.getY() - 1);
							break;
						case 3:
							// option = 3 - nước cờ cần đánh vào ngay bên phải
							// nước đánh trước
							nuocCoDanh = new ToaDo(nuocCo.getX(), nuocCo.getY() + 1);
							break;
						case 4:
							// option = 4 - nước cờ cần đánh vào ngay bên trái
							// nước đánh trước
							nuocCoDanh = new ToaDo(nuocCo.getX(), nuocCo.getY() - 1);
							break;
						default:
							break;
						}

						// Nếu ô cờ lấy ra trống thực hiện trả về nước cờ đánh
						if (BanCo.banCo[nuocCo.getX()][nuocCo.getY()].getValue() == 'T') {
							return nuocCoDanh;
						}
					}
					break;

				case 19: // Nếu thuộc cạnh dưới

					// Thực hiện 5 lần lấy một giá trị random, nếu giá trị nước
					// cờ tương
					// ứng lấy ra trống thì thực hiện trả về nước cờ đó và kết
					// thúc vòng
					// lặp
					for (int i = 0; i < 5; i++) {
						int option = random.nextInt(5); // Lấy random 1 giá trị
														// từ 0 đến 4
						switch (option) {

						// Thực hiện lấy ra nước cờ đánh ứng với từng trường hợp
						case 0:
							// option = 0 - nước cờ cần đánh vào ngay bên trên
							// nước đánh trước
							nuocCoDanh = new ToaDo(nuocCo.getX() - 1, nuocCo.getY());
							break;
						case 1:
							// option = 1 - nước cờ cần đánh vào ngay góc phải -
							// trên nước đánh trước
							nuocCoDanh = new ToaDo(nuocCo.getX() - 1, nuocCo.getY() + 1);
							break;
						case 2:
							// option = 2 - nước cờ cần đánh vào ngay góc trái -
							// trên nước đánh trước
							nuocCoDanh = new ToaDo(nuocCo.getX() - 1, nuocCo.getY() - 1);
							break;
						case 3:
							// option = 3 - nước cờ cần đánh vào ngay bên phải
							// nước đánh trước
							nuocCoDanh = new ToaDo(nuocCo.getX(), nuocCo.getY() + 1);
							break;
						case 4:
							// option = 4 - nước cờ cần đánh vào ngay bên trái
							// nước đánh trước
							nuocCoDanh = new ToaDo(nuocCo.getX(), nuocCo.getY() - 1);
							break;
						default:
							break;
						}

						// Nếu ô cờ lấy ra trống thực hiện trả về nước cờ đánh
						if (BanCo.banCo[nuocCo.getX()][nuocCo.getY()].getValue() == 'T') {
							return nuocCoDanh;
						}
					}
					break;

				default:
					break;
				}
			} else {

				// Nếu nước cờ truyền vào không thuộc 2 cạnh ngang của bàn cờ
				if (nuocCo.getX() > 0 && nuocCo.getX() < 19) {

					// Nếu nước cờ truyền vào thuộc 1 trong 2 cạnh dọc của bàn
					// cờ thực
					// hiện đánh ngẫu nghiên vào 1 trong 5 ô xuong quanh nếu
					// trống
					switch (nuocCo.getY()) {

					// Nếu thuộc cạnh trái
					case 0:

						// Thực hiện 5 lần lấy một giá trị random, nếu giá trị
						// nước cờ tương ứng lấy ra trống thì thực hiện trả về
						// nước cờ đó và kết thúc vòng lặp
						for (int i = 0; i < 5; i++) {
							int option = random.nextInt(5);// Lấy random 1 giá
															// trị từ 0 đến 4
							switch (option) {

							// Thực hiện lấy ra nước cờ đánh ứng với từng trường
							// hợp
							case 0:
								// option = 0 - nước cờ cần đánh vào ngay bên
								// dưới dưới đánh trước
								nuocCoDanh = new ToaDo(nuocCo.getX() + 1, nuocCo.getY());
								break;
							case 1:
								// option = 1 - nước cờ cần đánh vào ngay bên
								// trên dưới đánh trước
								nuocCoDanh = new ToaDo(nuocCo.getX() - 1, nuocCo.getY());
								break;
							case 2:
								// option = 2 - nước cờ cần đánh vào ngay góc
								// phải - dưới dưới đánh trước
								nuocCoDanh = new ToaDo(nuocCo.getX() + 1, nuocCo.getY() + 1);
								break;
							case 3:
								// option = 3 - nước cờ cần đánh vào ngay bên
								// phải dưới đánh trước
								nuocCoDanh = new ToaDo(nuocCo.getX(), nuocCo.getY() + 1);
								break;
							case 4:
								// option = 4 - nước cờ cần đánh vào ngay góc
								// phải - trên dưới đánh trước
								nuocCoDanh = new ToaDo(nuocCo.getX() - 1, nuocCo.getY() + 1);
								break;
							default:
								break;
							}
							// Nếu ô cờ lấy ra trống thực hiện trả về nước cờ
							// đánh
							if (BanCo.banCo[nuocCo.getX()][nuocCo.getY()].getValue() == 'T') {
								return nuocCoDanh;
							}
						}
						break;
					// Nếu thuộc cạnh phải
					case 19:

						// Thực hiện 5 lần lấy một giá trị random, nếu giá trị
						// nước cờ tương ứng lấy ra trống thì thực hiện trả về
						// nước cờ đó và kết thúc vòng lặp
						for (int i = 0; i < 5; i++) {
							int option = random.nextInt(5);// Lấy random 1 giá
															// trị từ 0 đến 4
							switch (option) {

							// Thực hiện lấy ra nước cờ đánh ứng với từng trường
							// hợp
							case 0:
								// option = 0 - nước cờ cần đánh vào ngay bên
								// dưới nước vừa đánh
								nuocCoDanh = new ToaDo(nuocCo.getX() + 1, nuocCo.getY());
								break;
							case 1:
								// option = 1 - nước cờ cần đánh vào ngay bên
								// trên nước vừa đánh
								nuocCoDanh = new ToaDo(nuocCo.getX() - 1, nuocCo.getY());
								break;
							case 2:
								// option = 2 - nước cờ cần đánh vào ngay góc
								// trái - trên nước vừa đánh
								nuocCoDanh = new ToaDo(nuocCo.getX() - 1, nuocCo.getY() - 1);
								break;
							case 3:
								// option = 3 - nước cờ cần đánh vào ngay bên
								// trái nước vừa đánh
								nuocCoDanh = new ToaDo(nuocCo.getX(), nuocCo.getY() - 1);
								break;
							case 4:
								// option = 4 - nước cờ cần đánh vào ngay góc
								// trái - dưới nước vừa đánh
								nuocCoDanh = new ToaDo(nuocCo.getX() + 1, nuocCo.getY() - 1);
								break;
							default:
								break;
							}

							// Nếu ô cờ lấy ra trống thực hiện trả về nước cờ
							// đánh
							if (BanCo.banCo[nuocCo.getX()][nuocCo.getY()].getValue() == 'T') {
								return nuocCoDanh;
							}
						}
						break;
					default:
						break;
					}
				}
			}
		}

		return nuocCoDanh;
	}

	/**
	 * Phương thức kiểm tra thế cờ có trùng với ô cờ 5x5 trên bàn cờ bắt đầu từ
	 * Quân Cờ vị trí x,y
	 * 
	 * @param x
	 * @param y
	 * @param theCo
	 * @return nếu thỏa mãn trả về true, không thỏa mãn trả về false
	 */
	private boolean checkTheCo(int x, int y, char[][] theCo) {
		// Duyệt hàng
		for (int m = 0; m < 5; m++) {
			// Duyệt cột
			for (int n = 0; n < 5; n++) {
				// Kiểm tra các vị trí bàn cờ khác với vị trí tương
				// ứng trên maTranCo thì gán check = false và break
				// vòng lặp

				if (theCo[m][n] != 'D') {
					// Nếu giá trị thế cờ vị trí m,n khác'D'
					// Kiểm tra nếu vị trí trên bàn cờ khác trên thế cờ và trên
					// thế cờ khác 'G'
					// Trả về false
					if (BanCo.banCo[x + m][y + n].getValue() != theCo[m][n] && theCo[m][n] != 'G') {
						return false;
					}
				} else {
					// Nếu giá trị thế cờ vị trí m,n là 'D' và vị trí tương ứng
					// trên bàn cờ khác 'T'
					// Trả về false
					if (BanCo.banCo[x + m][y + n].getValue() != 'T') {
						return false;

					}
				}

			}

		}
		// Kiểm tra hết các vị trí không có vị trí nào không thỏa mãn trả về
		// true
		return true;
	}
}
