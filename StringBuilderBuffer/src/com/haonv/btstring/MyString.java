package com.haonv.btstring;

public class MyString {
	private String st1, st2;

	public MyString(String st1, String st2) {
		super();
		this.st1 = st1;
		this.st2 = st2;
	}

	public void tinhTong() {
		int sum = 0;
		for (int i = 0; i < st1.length(); i++) {

			if (Character.isDigit(st1.charAt(i))
					&& st2.contains(st1.charAt(i) + "") == false) {
				sum += Integer.parseInt(st1.charAt(i) + "");
			}

		}
		System.out.println(sum);
	}
}
