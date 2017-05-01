package com.haonv.arraylist;

import java.util.ArrayList;

public class MyArraylist {
	private ArrayList<String> arrayList;

	public MyArraylist() {
		arrayList = new ArrayList<String>();
		String a = "AN";
		arrayList.add(a);
		String b = "BINH";
		arrayList.add(b);

	}

	public void remove() {
		arrayList.remove(new String("AN"));
		// Khong the xoa bo phan tu bang cach chuyen vao doi tuong, muon xoa hay
		// dung cach chuyen vao vi tri.
		System.out.println(arrayList.size());
		arrayList.remove(0);
		System.out.println(arrayList.size());
	}

	public static void main(String[] args) {
		MyArraylist arraylist = new MyArraylist();
		arraylist.remove();
	}

}
