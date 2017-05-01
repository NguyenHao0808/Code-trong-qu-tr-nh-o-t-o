package com.haonv.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

/**
 * Lop Server dong vai tro lam may chu trong qua trinh ket noi cac may.
 * 
 * @author Nguyen Hao
 *
 */
public class Server {
	private String ip;
	private ServerSocket serverSocket;
	private static final int PORT = 1152;
	private InputStream input;
	private OutputStream output;

	/**
	 * Phuong thuc getLocalIP dung de lay dia chi IP may dang chay chuong trinh.
	 */
	public void getLocalIP() {
		try {
			ip = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			System.out.println("Khong lay duoc ip");

		}
		System.out.println("Dia chi IP:" + ip);

	}

	/**
	 * Phuong thuc openConection mo ket noi toi cac may khach.
	 * 
	 * @param str
	 *            : noi dung thu gui di.
	 * @return: noi dung thu nhan ve tu may client.
	 */
	public String openConection(String str) {
		String thuNhan = "";
		try {
			serverSocket = new ServerSocket(PORT);
			// mo cong ra de cho client ket noi den
			Socket client = serverSocket.accept();
			String ipClient = client.getInetAddress().getHostAddress();
			String nameClient = client.getInetAddress().getHostName();
			System.out.println("Welcome: " + nameClient + "-" + ipClient);

			input = client.getInputStream();
			output = client.getOutputStream();

			send(str);
			thuNhan = receive();
		} catch (IOException e) {
			System.out.println("Loi ket noi!");
		}
		return thuNhan;
	}

	/**
	 * Phuong thuc send thuc hien gui noi dung thu tu server toi client.
	 * 
	 * @param text
	 *            : noi dung thu gui.
	 */
	public void send(String text) {
		try {
			output.write(text.getBytes());
			output.flush();
			System.out.println("->Server: " + text);
		} catch (IOException e) {
			System.out.println("loi gui tin!");
		}
	}

	/**
	 * Phuong thuc nhan thu tu may client ve may server.
	 * 
	 * @return: noi dung thu nhan duoc.
	 */
	public String receive() {
		byte[] buff = new byte[1024];
		int len;
		String text = "";
		try {
			len = input.read(buff);
			text = new String(buff, 0, len);

			System.out.println("<-Client: " + text);
		} catch (IOException e) {
			System.out.println("Loi nhan tin!");
		}
		return text;
	}

}
