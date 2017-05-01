/**
 * Copyright(C) 2016  Luvina
 * TheCo.java, Jan 04, 2017 Phạm Thành Luân
 */
package net.luvina.phamthanhluan.cocaro.common;

import net.luvina.phamthanhluan.cocaro.exception.MyException;
import net.luvina.phamthanhluan.cocaro.logic.CoCaro;

/**
 * Class TheCo dùng để tạo các đối tượng thế cờ có thuộc tính: - Thế cờ lưu dưới
 * dạng một mảng char[][]. - Tọa độ nước cần đánh trong thế cờ.
 * 
 * @author Phạm Thành Luân
 *
 */
public class TheCo {

	private char[][] theCo; // thuộc tính thế cờ lưu dưới dạng
							// mảng
	// char[][].
	private int x; // Thuộc tính x - tọa độ trục thẳng đứng ( số thứ tự hàng )
	private int y;// Thuộc tính y - tọa độ trục nằm ngang ( số thứ tự cột )

	/**
	 * Phương thức khởi tạo một đối tượng thế cờ.
	 * 
	 * @param theCo
	 *            thuộc tính thế cờ lưu dưới dạng mảng String[][].
	 * @param x
	 *            Thuộc tính x (int) (-1<x<5)
	 * @param y
	 *            Thuộc tính y (int) (-1<x<5)
	 * @throws MyException
	 */
	public TheCo(char[][] theCo, int x, int y) throws MyException {

		// Kiểm tra nếu giá trị tọa độ không thỏa mãn thì throw một MyException
		// với mã lỗi 21 và tên lỗi: Tọa độ thế cờ sai
		if (x < 0 || x >= BanCo.N || y < 0 || y >= BanCo.N) {
			throw new MyException(21, "Tọa độ thế cờ sai");
		}

		// Kiểm tra nếu thế cờ không thỏa mãn thì throw một MyException
		// với mã lỗi 22 và tên lỗi: Thế cờ không đúng
		if (theCo == null) {
			throw new MyException(22, "Thế cờ không đúng");
		} else {
			if (theCo.length != 5 || theCo[0].length != 5) {
				throw new MyException(22, "Thế cờ không đúng");
			}
		}
		this.theCo = theCo; // Gán giá trị cho mảng thế cờ
		this.x = x; // Gán giá trị cho tọa độ x
		this.y = y; // Gán giá trị cho tọa độ y
	}

	/**
	 * Phương thức lấy giá trị thuộc tính thế cờ
	 * 
	 * @return mảng thế cờ (char[][])
	 */
	public char[][] getTheCo() {
		return theCo;
	}

	/**
	 * Phương thức lấy giá trị tọa độ x cần đánh trên thế cờ
	 * 
	 * @return x (int)
	 */
	public int getX() {
		return x;
	}

	/**
	 * Phương thức lấy giá trị tọa độ y cần đánh trên thế cờ
	 * 
	 * @return y (int)
	 */
	public int getY() {
		return y;
	}

}
