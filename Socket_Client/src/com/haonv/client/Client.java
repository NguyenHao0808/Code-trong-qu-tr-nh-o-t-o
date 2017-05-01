package com.haonv.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Lop client thuc hien xu ly ket noi toi server
 * 
 * @author Nguyen Hao
 *
 */
public class Client {
	private String ip;
	private Socket socket;
	private InputStream input;
	private OutputStream output;

	/**
	 * Phuong thuc getLocalIP dung de lay dia chi IP cua may
	 */
	public void getLocalIP() {
		try {
			ip = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			System.out.println("Loi lay dia chi may local!");
		}
		System.out.println("Dia chi IP: " + ip);
	}

	/**
	 * Phuong thuc connectTo khoi tao cac doi tuong socket, input, output de
	 * thuc hien ket noi voi server. Thuc hien 2 phuong thuc gui va nhan tin.
	 * 
	 * @param ip
	 *            : dia chi IP may server
	 * @param port
	 *            : cong cho cua may server
	 * @param thuGui
	 *            : noi dung thu gui di
	 * @return tra ve thu nhan duoc ti server
	 */
	public String connectTo(String ip, int port, String thuGui) {
		String thuNhan = "";
		try {
			// Cho ket noi den server
			socket = new Socket(ip, port);
			System.out.println("ket noi thanh cong!");
			input = socket.getInputStream();
			output = socket.getOutputStream();
			thuNhan = receive();
			send(thuGui);
		} catch (IOException e) {
			System.out.println("Loi ket noi!");
		}
		return thuNhan;
	}

	/**
	 * Phuong thuc send dung de gui di mot goi tin
	 * 
	 * @param text
	 *            : noi dung goi tin gui di
	 */
	public void send(String text) {
		try {
			output.write(text.getBytes());
			output.flush();
			System.out.println("->Client: " + text);

		} catch (IOException e) {
			System.out.println("Loi gui tin!");
		}
	}

	/**
	 * Phuong thuc receive dung de nhan tin tu server gui cho may client.
	 * 
	 * @return: tra ve thu nhan duoc.
	 */
	public String receive() {
		byte[] buff = new byte[1024];
		int len;
		String text = "";
		try {
			len = input.read(buff);
			text = new String(buff, 0, len);
			System.out.println("<-Server: " + text);

		} catch (IOException e) {
			System.out.println("Loi nhan tin!");
		}
		return text;

	}
}
