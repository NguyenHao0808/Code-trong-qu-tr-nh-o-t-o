/**
 * Copyright(C) 2016  Luvina
 * QuanCo.java, Jan 04, 2017 Phạm Thành Luân
 */

package net.luvina.phamthanhluan.cocaro.common;

import javax.swing.JButton;

import net.luvina.phamthanhluan.cocaro.exception.MyException;

/**
 * QuanCo Class thực hiện tạo một đối tượng quân cờ có tọa độ và giá trị và là
 * một button để hiển thị lên màn hình
 * 
 * @author Phạm Thành Luân
 *
 */
public class QuanCo extends JButton {

	// Thuộc tính tọa độ
	private ToaDo toaDo;
	// Thuộc tính giá trị
	private char value;

	/**
	 * Phương thức khởi tạo nên một quân cờ truyền vào tham số tọa độ và giá trị
	 * 
	 * @param x
	 *            tọa độ hàng
	 * @param y
	 *            tọa độ cột
	 * @param value
	 *            giá trị quân cờ
	 * @throws MyException
	 */
	public QuanCo(int x, int y, char value) throws MyException {
		// Gán tọa độ
		this.toaDo = new ToaDo(x, y);
		// Gán giá trị
		this.value = value;
	}

	/**
	 * Phương thức khởi tạo một quân cờ truyền vào tọa độ
	 * 
	 * @param x
	 * @param y
	 * @throws MyException
	 */
	public QuanCo(int x, int y) throws MyException {
		// Gọi phương thức khởi tạo truyền vào tọa độ truyền vào và giá trị mặc
		// định
		this(x, y, 'T');
	}

	/**
	 * Phương thức khởi tạo với giá trị mặc định không truyền vào tham số
	 * 
	 * @throws MyException
	 */
	public QuanCo() throws MyException {
		// Gọi phương thức khởi tạo với giá trị truyền vào mặc định
		this(0, 0, 'T');
	}

	/**
	 * Phương thức trả về tọa độ
	 * 
	 * @return
	 */
	public ToaDo getToaDo() {
		return toaDo;
	}

	/**
	 * Phương thức gán tọa độ
	 * 
	 * @param toaDo
	 */
	public void setToaDo(ToaDo toaDo) {
		this.toaDo = toaDo;
	}

	/**
	 * Phương thức trả về giá trị
	 * 
	 * @return
	 */
	public char getValue() {
		return value;
	}

	/**
	 * Phương thức gán giá trị
	 * 
	 * @param value
	 */
	public void setValue(char value) {
		this.value = value;
	}

}
