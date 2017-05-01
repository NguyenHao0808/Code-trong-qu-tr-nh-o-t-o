package com.haonv.mahaomd5;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MaHoaMD5 {
	public String encryptMD5(String input) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] messageDigest = md.digest(input.getBytes());
			BigInteger number = new BigInteger(1, messageDigest);
			String hashtext = number.toString(16);
			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}
			return hashtext;
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}

	}

	public static void main(String[] args) {
		MaHoaMD5 maHoaMD5 = new MaHoaMD5();
		System.out.println(maHoaMD5.encryptMD5("5longth5123456"));
		
	}
}
