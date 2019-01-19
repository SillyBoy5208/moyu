package com.demo.game;

import com.game.GameUtil;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;

public class Test {
    public static void main(String[] args) throws Exception{
        String cookie = GameUtil.getCookie("netty","2672665a",GameUtil.moYu9);
        CloseableHttpClient httpClient = GameUtil.getHttpClient(GameUtil.getProxy());
        HttpGet get = new HttpGet("");
        GameUtil.getHttpGet(get,cookie,null);
    }
}
