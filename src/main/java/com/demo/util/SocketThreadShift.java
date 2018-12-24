package com.demo.util;

import org.apache.commons.io.IOUtils;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class SocketThreadShift extends Thread{
	private InputStream isIn;
	private OutputStream osOut;
	private Socket serverSocket;
	private Socket clientSocket;
	public SocketThreadShift(InputStream isIn, OutputStream osOut, Socket serverSocket, Socket clientSocket) {
		this.isIn = isIn;
		this.osOut = osOut;
		this.serverSocket = serverSocket;
		this.clientSocket = clientSocket;
	}

	public void run() {
		byte[] buffer = new byte[4096];
		
		try {
			int len;
			while ( ( len = isIn.read(buffer)) != -1  ) {
				if (len > 0) {
					osOut.write(buffer, 0, len);
					osOut.flush();
				}
			}
		} catch (Exception e) {
			//System.out.println("SocketThreadOutput leave");
			//e.printStackTrace();
		}finally {
			IOUtils.closeQuietly(isIn);
			IOUtils.closeQuietly(osOut);
			IOUtils.closeQuietly(serverSocket);
			IOUtils.closeQuietly(clientSocket);
		}
	}
}
