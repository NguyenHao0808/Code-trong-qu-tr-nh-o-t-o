/**
 * Copyright(C) 2016  Luvina
 * BanCo.java, Jan 04, 2017 Phạm Thành Luân
 */
package net.luvina.phamthanhluan.cocaro.common;

import net.luvina.phamthanhluan.cocaro.logic.QuanLyTheCo;

/**
 * BanCo Class thực hiện lưu trữ các thuộc tính của một trận cờ Caro
 * 
 * @author Phạm Thành Luân
 *
 */
public class BanCo {
	// Biến lưu độ cao frame
	public static final int H_BANCO = 630;
	// Biến lưu chiều rộng frame
	public static final int W_BANCO = 610;
	// Biến lưu số lượng ô cờ 1 hàng = số hàng trên bàn cờ
	public static final int N = 20;
	// Khai báo một bàn cờ gồm một mảng 2 chiều các quân cờ trên bàn cờ
	// Giá trị value tương ứng
	// X: may danh - x
	// O: nguoi danh - o
	// T: ô trống
	public static QuanCo[][] banCo;
	// Biến lưu nước máy mới đánh gần nhất với thời điểm xét
	public static ToaDo nuocMayDanhMoi;
	// Biến lưu nước người mới đánh gần nhất với thời điểm xét
	public static ToaDo nuocNguoiDanhMoi;
	// Biến lưu số thứ tự nước cờ.
	public static int number = 0;
	// Biến lưu tên người chơi mặc định là "Anonymous"
	public static String name = "Anonymous";
	// Biến lưu số ván người thắng
	public static int nguoiThang = 0;
	// Biến lưu số ván máy thắng
	public static int mayThang = 0;
	// Biến lưu số ván chơi
	public static int soVan = 0;

}
