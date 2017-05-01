package com.haonv.btstring.stringbuilder;

public class MyStringBuilder {
	private String str;

	public MyStringBuilder(String str) {
		super();
		this.str = str;
	}

	public void chuyenDoiGiuaStringVaStringBuilder() {
		// chuyen tu String sang String Builder
		StringBuilder builder = new StringBuilder(str);
		builder.deleteCharAt(0);
		System.out.println(builder);
		builder.insert(0, 'h');
		System.out.println(builder);
		// chuyen tu String Builder sang String
		str = builder.toString();
		str.substring(1, 2);
		System.out.println(str);
	}

	public static void main(String[] args) {
		MyStringBuilder builder = new MyStringBuilder("Hello");
		builder.chuyenDoiGiuaStringVaStringBuilder();
	}
}
