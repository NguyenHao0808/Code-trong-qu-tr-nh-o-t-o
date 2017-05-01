/**
 * Copyright(C) 2016  Luvina
 * ToaDo.java, Jan 04, 2017 Phạm Thành Luân
 */
package net.luvina.phamthanhluan.cocaro.common;

import net.luvina.phamthanhluan.cocaro.exception.MyException;
import net.luvina.phamthanhluan.cocaro.logic.CoCaro;

/**
 * Class ToaDo dùng để tạo các đối tượng lưu trữ tọa độ cho nước cờ có 2 thuộc
 * tính là tọa độ trên bàn cờ
 * 
 * @author Phạm Thành Luân
 *
 */
public class ToaDo {

	private int x; // Thuộc tính x - tọa độ trục thẳng đứng ( số thứ tự hàng )
	private int y; // Thuộc tính y - tọa độ trục nằm ngang ( số thứ tự cột )

	/**
	 * Phương thức khởi tạo đối tượng ToaDo không có tham số truyền vào
	 * 
	 * @throws MyException
	 */
	public ToaDo() throws MyException {
		// Gọi phương thức khởi tạo còn lại truyền vào giá trị mặc định 0, 0
		this(0, 0);
	}

	/**
	 * Phương thức khởi tạo đối tượng ToaDo có tham số truyền vào là tọa độ trên
	 * bàn cờ
	 * 
	 * @param x
	 *            tọa độ trục thẳng đứng ( số thứ tự hàng ) (int) (-1<x<20)
	 * @param y
	 *            tọa độ trục nằm ngang ( số thứ tự cột ) (int) (-1<y<20)
	 * @throws MyException
	 */
	public ToaDo(int x, int y) throws MyException {

		// Kiểm tra nếu giá trị tọa độ không thỏa mãn thì throw một MyException
		// với mã lỗi 11 và tên lỗi: Tọa độ nước cờ sai
		if (x < 0 || x >= BanCo.N || y < 0 || y >= BanCo.N) {
			throw new MyException(11, "Tọa độ nước cờ sai");
		}

		this.x = x; // Gán giá trị cho tọa độ x
		this.y = y; // Gán giá trị cho tọa độ y
	}

	/**
	 * Phương thức lấy giá trị tọa độ x
	 * 
	 * @return x (int)
	 */
	public int getX() {
		// Trả về giá trị x
		return x;
	}

	/**
	 * Phương thức set giá trị cho tọa độ x
	 * 
	 * @param x
	 *            giá trị truyền vào
	 * @throws MyException
	 */
	public void setX(int x) throws MyException {

		// Kiểm tra nếu giá trị tọa độ không thỏa mãn thì throw một MyException
		// với mã lỗi 1 và tên lỗi: Tọa độ sai
		if (x < 0 || x >= BanCo.N) {
			throw new MyException(1, "Tọa độ sai");
		}

		this.x = x; // Gán giá trị cho tọa độ x
	}

	/**
	 * Phương thức lấy giá trị tọa độ y
	 * 
	 * @return y (int)
	 */
	public int getY() {
		// Trả về giá trị x
		return y;
	}

	/**
	 * Phương thức set giá trị cho tọa độ y
	 * 
	 * @param y
	 *            giá trị truyền vào
	 * @throws MyException
	 */
	public void setY(int y) throws MyException {

		// Kiểm tra nếu giá trị tọa độ không thỏa mãn thì throw một MyException
		// với mã lỗi 1 và tên lỗi: Tọa độ sai
		if (y < 0 || y >= BanCo.N) {
			throw new MyException(1, "Tọa độ sai");
		}
		this.y = y; // Gán giá trị cho tọa độ y
	}

}
