package com.haonv.btstringarraylist;

public class HocSinh {
	private String ten;
	private int tuoi;

	/**
	 * Phuong thuc khoi tao cua class HocSinh voi 2 tham so chuyen vao.
	 * 
	 * @param ten
	 *            : Ten hoc sinh
	 * @param tuoi
	 *            : Tuoi hoc sinh
	 */
	public HocSinh(String ten, int tuoi) {
		super();
		this.ten = ten;
		this.tuoi = tuoi;
	}

	public String getTen() {
		return ten;
	}

	public int getTuoi() {
		return tuoi;
	}

	/**
	 * Phuong thuc toString() duoc ghi de lai. Ket qua tra ve la mot chuoi ten
	 * va tuoi cua hoc sinh.
	 */
	@Override
	public String toString() {
		return ten + " so tuoi : " + tuoi;
	}

	@Override
	public boolean equals(Object obj) {
		HocSinh hs = (HocSinh) obj;
		if (ten.equals(hs.getTen()) && tuoi == hs.getTuoi()) {
			return true;
		}
		return super.equals(obj);
	}

}
