package com.demo.game;

import antlr.StringUtils;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.jsoup.helper.StringUtil;

import java.math.BigInteger;

public class Test {
    public static void main(String[] args) throws Exception{
        String cookie = GameUtil.getCookie("netty","2672665a",GameUtil.moYu9);
        CloseableHttpClient httpClient = GameUtil.getHttpClient(GameUtil.getProxy());
        HttpGet get = new HttpGet("");
        GameUtil.getHttpGet(get,cookie,null);
    }
}
