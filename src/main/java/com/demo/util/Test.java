package com.demo.util;

import java.net.Socket;

public class Test {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("www.baidu.com",443);
        System.out.println(socket);
    }
}
