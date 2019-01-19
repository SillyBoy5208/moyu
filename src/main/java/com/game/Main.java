package com.game;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static final String login = "";
    public static final String username = "";
    public static final String password = "";
    public static void main(String[] args) throws Exception{
        String cookie = GameUtil.getCookie(username,password,login);
        String[] bossList= {
                "http://mu.xyhero.com/moyu/s8/ditu/9/map6.php",
        };

    }

}
