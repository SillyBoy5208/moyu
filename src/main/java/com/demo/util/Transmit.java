package com.demo.util;

import com.demo.util.SocketThreadShift;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Transmit {
    public static final String host = "127.0.0.1";
    public static final int port = 1080;
    public void start() throws Exception{
        System.out.println("启动成功");
        ServerSocket serverSocket = new ServerSocket(55566);
        while (true){
            Socket socket1 = serverSocket.accept();
            Socket socket2 = new Socket(host,port);
            System.out.println(socket1);
            InputStream in1 = socket1.getInputStream();
            OutputStream out1 = socket1.getOutputStream();
            InputStream in2 = socket2.getInputStream();
            OutputStream out2 = socket2.getOutputStream();
            new SocketThreadShift(in1,out2,socket1,socket2).start();
            new SocketThreadShift(in2,out1,socket2,socket1).start();
        }
    }

    public static void main(String[] args) throws Exception{
        new Transmit().start();

    }
}
