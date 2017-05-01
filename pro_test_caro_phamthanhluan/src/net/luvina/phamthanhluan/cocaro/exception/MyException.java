/**
 * Copyright(C) 2016  Luvina
 * MyException.java, Jan 04, 2017 Phạm Thành Luân
 */
package net.luvina.phamthanhluan.cocaro.exception;

/**
 * Class MyException dùng để xử lý các ngoại lệ
 * 
 * @author Phạm Thành Luân
 *
 */
public class MyException extends Exception {
	private int errCode; // Mã Lỗi
	private String message; // Tên Lỗi

	/**
	 * Phương thức khởi tạo nên một exception
	 * 
	 * @param errCode
	 * @param message
	 */
	public MyException(int errCode, String message) {
		this.errCode = errCode;
		this.message = message;
	}

	/**
	 * Phương thức trả về mã lỗi
	 * 
	 * @return errCode(int)
	 */
	public int getErrCode() {
		return errCode;
	}

	/**
	 * Phương thức trả về tên lỗi
	 * 
	 * @return message(String)
	 */
	public String getMessage() {
		return message;
	}

}
